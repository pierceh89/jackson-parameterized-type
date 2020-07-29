package io.github.pierceh89

inline fun <reified T> convert(jsonStr: String): T {
    return om.readValue(jsonStr, T::class.java)
}

