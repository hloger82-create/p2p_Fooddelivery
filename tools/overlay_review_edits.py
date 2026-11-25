#!/usr/bin/env python3
"""Ueberlagert lokale Review-Aenderungen auf eine neuere restaurants.json.

Szenario: Du hast Eintraege lokal reviewed (status/lastVerified/cuisineSource/... geaendert),
aber main hat sich weiterbewegt (QS-Runden haben Eintraege entfernt/korrigiert) und git pull
scheitert mit "local changes would be overwritten".

Vorgehen: lokale Datei sichern, checkout, pull, dann dieses Tool laufen lassen.

Usage:
  python3 tools/overlay_review_edits.py \
      --local C:\\Temp\\restaurants-lokal.json \
      --base c3e94c9 \
      --file data/regions/hannover/restaurants.json

Regeln pro Eintrag (match ueber id):
  - id nur lokal (in main geloescht, z. B. QS-Ausschluss) -> wird NICHT uebernommen, wird gelistet
  - id in beiden, main hat orderTypes/delivers/pickup gegen --base geaendert (QS-Korrektur)
    -> diese Felder bleiben von main; alle anderen lokal geaenderten Felder (status, lastVerified,
       cuisineSource, cuisines, notes ...) werden uebernommen; notes werden aneinandergehaengt
  - sonst -> alle lokal geaenderten Felder werden uebernommen
"""

import argparse
import json
import subprocess
import sys

FIELDS_QS = ("orderTypes", "delivers", "pickup")


def load_json(path):
    with open(path, encoding="utf-8") as f:
        return json.load(f)


def git_show_entry(rev: str, rel_path: str, rid: str):
    out = subprocess.run(
        ["git", "show", f"{rev}:{rel_path}"], capture_output=True, text=True, check=True
    ).stdout
    ds = json.loads(out)
    for r in ds.get("restaurants", []):
        if r.get("id") == rid:
            return r
    return None


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--local", required=True, help="deine lokal editierte restaurants.json (Backup)")
    ap.add_argument("--base", required=True, help="git-Revision, auf der die lokale Datei basiert (z. B. c3e94c9)")
    ap.add_argument("--file", required=True, help="Ziel-restaurants.json im Repo (wird ueberschrieben)")
    args = ap.parse_args()

    local = load_json(args.local)
    ziel = load_json(args.file)
    rel = args.file.replace("\\", "/")

    ziel_ids = {r["id"]: r for r in ziel.get("restaurants", [])}
    applied, skipped_gone, qs_kept = [], [], []

    for lr in local.get("restaurants", []):
        rid = lr.get("id")
        zr = ziel_ids.get(rid)
        if zr is None:
            skipped_gone.append(rid)
            continue
        base = git_show_entry(args.base, rel, rid)
        changed = {k: v for k, v in lr.items() if base is None or base.get(k) != v}
        if not changed:
            continue
        qs_touched = base is not None and any(zr.get(k) != base.get(k) for k in FIELDS_QS)
        if qs_touched:
            # main hat QS-Korrekturen an diesem Eintrag -> diese Felder behalten, Rest uebernehmen
            for k, v in changed.items():
                if k not in FIELDS_QS:
                    zr[k] = v
            if "notes" in changed and base is not None:
                user_note = lr.get("notes") or ""
                base_note = base.get("notes") or ""
                extra = user_note.replace(base_note, "").strip(" |")
                if extra and extra not in (zr.get("notes") or ""):
                    zr["notes"] = ((zr.get("notes") or "") + " | " + extra).strip(" |")
            qs_kept.append(rid)
        else:
            zr.update(changed)
            applied.append(rid)

    with open(args.file, "w", encoding="utf-8") as f:
        f.write(json.dumps(ziel, ensure_ascii=False, indent=2) + "\n")

    print(f"uebernommen: {len(applied)} Eintraege -> {applied[:10]}{' ...' if len(applied) > 10 else ''}")
    print(f"QS-Felder von main behalten, Rest uebernommen: {len(qs_kept)} -> {qs_kept[:10]}{' ...' if len(qs_kept) > 10 else ''}")
    print(f"in main geloescht (nicht uebernommen): {len(skipped_gone)} -> {skipped_gone[:10]}{' ...' if len(skipped_gone) > 10 else ''}")
    print(f"geschrieben: {args.file}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
