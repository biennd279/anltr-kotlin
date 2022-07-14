package me.d3s34.parser

class CalculationVisitor: CalcBaseVisitor<Int>() {
    override fun visitNumber(ctx: CalcParser.NumberContext): Int {
        return ctx.text.toIntOrNull() ?: 0
    }

    override fun visitAddOrSub(ctx: CalcParser.AddOrSubContext): Int {
        val leftValue = visit(ctx.left)
        val rightValue = visit(ctx.right)

        return when (ctx.operator.type) {
            CalcParser.SUB -> leftValue - rightValue
            CalcParser.ADD -> leftValue + rightValue
            else -> 0
        }
    }

    override fun visitMulOrDiv(ctx: CalcParser.MulOrDivContext): Int {
        val leftValue = visit(ctx.left)
        val rightValue = visit(ctx.right)

        return when (ctx.operator.type) {
            CalcParser.MUL -> leftValue * rightValue
            CalcParser.DIV -> leftValue / rightValue
            else -> 0
        }
    }

    override fun visitParenthese(ctx: CalcParser.ParentheseContext): Int {
        return visit(ctx.innerExpression)
    }

    override fun visitStart(ctx: CalcParser.StartContext): Int {
        return visit(ctx.expression())
    }
}