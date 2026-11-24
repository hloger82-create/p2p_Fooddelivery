package de.p2pfood.app.util

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

object OpeningHours {

    private val dayMap = mapOf(
        "mo" to DayOfWeek.MONDAY,
        "tu" to DayOfWeek.TUESDAY,
        "we" to DayOfWeek.WEDNESDAY,
        "th" to DayOfWeek.THURSDAY,
        "fr" to DayOfWeek.FRIDAY,
        "sa" to DayOfWeek.SATURDAY,
        "su" to DayOfWeek.SUNDAY,
    )

    private val ruleRegex = Regex("""([a-z]{2})(?:-([a-z]{2}))?\s+(\d{1,2}:\d{2})-(\d{1,2}:\d{2})""")

    fun isOpen(openingHours: String?, now: LocalDateTime = LocalDateTime.now()): Boolean? {
        if (openingHours.isNullOrBlank()) return null
        val text = openingHours.trim().lowercase()
        if ("24/7" in text) return true
        val timeNow = now.toLocalTime()
        val today = now.dayOfWeek
        var anyRule = false
        for (rule in text.split(";", ",")) {
            val m = ruleRegex.find(rule.trim()) ?: continue
            val startDay = dayMap[m.groupValues[1]] ?: continue
            val endDay = m.groupValues[2].takeIf { it.isNotEmpty() }?.let { dayMap[it] } ?: startDay
            val open = LocalTime.parse(m.groupValues[3].padStart(5, '0'))
            val close = LocalTime.parse(m.groupValues[4].padStart(5, '0'))
            anyRule = true
            if (today !in daysBetween(startDay, endDay)) continue
            if (close > open) {
                if (timeNow >= open && timeNow < close) return true
            } else {
                if (timeNow >= open || timeNow < close) return true
            }
        }
        return if (anyRule) false else null
    }

    private fun daysBetween(start: DayOfWeek, end: DayOfWeek): Set<DayOfWeek> {
        val out = mutableSetOf<DayOfWeek>()
        var d = start
        while (out.size <= 7) {
            out.add(d)
            if (d == end) break
            d = d.plus(1)
        }
        return out
    }
}
