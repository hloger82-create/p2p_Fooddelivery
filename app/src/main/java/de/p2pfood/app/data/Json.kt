package de.p2pfood.app.data

import kotlinx.serialization.json.Json

object AppJson {
    val instance: Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        encodeDefaults = true
    }
}
