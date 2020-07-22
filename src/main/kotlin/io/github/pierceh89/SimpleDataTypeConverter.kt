package io.github.pierceh89

import com.fasterxml.jackson.core.type.TypeReference
import io.github.pierceh89.type.Bar
import io.github.pierceh89.type.Foo

abstract class AbstractDataTypeConverter<T> {

    abstract fun type(): TypeReference<T>

    fun convert(jsonStr: String): T {
        return om.readValue(jsonStr, type())
    }
}

class FooDataTypeConverter : AbstractDataTypeConverter<Foo>() {
    private val typeReference = object : TypeReference<Foo>() {}

    override fun type(): TypeReference<Foo> {
        return typeReference
    }
}

class BarDataTypeConverter : AbstractDataTypeConverter<Bar>() {
    private val typeReference = object : TypeReference<Bar>() {}

    override fun type(): TypeReference<Bar> {
        return typeReference
    }
}
