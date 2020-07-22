package io.github.pierceh89

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.github.pierceh89.type.Bar
import io.github.pierceh89.type.Foo

// does not work
abstract class AbstractDataConverter<T> {

    fun convert(jsonStr: String): T {
        return om.readValue(jsonStr, object : TypeReference<T>() {})
    }
}

class FooDataConverter : AbstractDataConverter<Foo>()

class BarDataConverter : AbstractDataConverter<Bar>()

val om = jacksonObjectMapper()