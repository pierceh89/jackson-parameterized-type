package io.github.pierceh89

import io.github.pierceh89.type.Foo
import org.junit.Assert
import org.junit.Test

class GenericDataConverterTest {

    // does not work
    @Test
    fun testGenericDataConverter() {
        val fooJson = """
            {
              "a": "abc",
              "b": "abc"
            }  
        """.trimIndent()

        val converter = FooDataConverter()
        val ret = converter.convert(fooJson)

        // java.lang.ClassCastException: class java.util.LinkedHashMap cannot be cast to class io.github.pierceh89.type.Foo
        Assert.assertEquals(ret, Foo("abc", "abc"))
    }

    @Test
    fun testGenericDataTypeConverter() {
        val fooJson = """
            {
              "a": "abc",
              "b": "abc"
            }  
        """.trimIndent()

        val converter = FooDataTypeConverter()
        val ret = converter.convert(fooJson)

        Assert.assertEquals(ret, Foo("abc", "abc"))
        converter.run(fooJson)
    }

    @Test
    fun testSimpleDataTypeConverter() {
        val fooJson = """
            {
              "a": "abc",
              "b": "abc"
            }  
        """.trimIndent()

        val ret = convert<Foo>(fooJson)
        Assert.assertEquals(ret, Foo("abc", "abc"))

    }
}
