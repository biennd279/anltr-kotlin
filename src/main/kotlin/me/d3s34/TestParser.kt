package me.d3s34

import me.d3s34.parser.CalcLexer
import me.d3s34.parser.CalcParser
import me.d3s34.parser.CalculationVisitor
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun main() {
    val input = CharStreams.fromString("1 + 2 * (3 - 10) + 20 / 2 + 1000")
    val lexer = CalcLexer(input)
    val tokens = CommonTokenStream(lexer)
    val parser = CalcParser(tokens)
    val visitor = CalculationVisitor()

    try {
        val value = visitor.visit(parser.start())
        println(value)
    } catch (t: Throwable) {
        t.printStackTrace()
    }
}