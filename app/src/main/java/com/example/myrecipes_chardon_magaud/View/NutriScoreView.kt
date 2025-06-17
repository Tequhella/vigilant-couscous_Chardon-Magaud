package com.example.myrecipes_chardon_magaud.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.myrecipes_chardon_magaud.R

class NutriScoreView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {

    private var score: Int = 0
    private val paint = Paint()

    fun setScore(value: Int) {
        score = value.coerceIn(0, 100)
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val barWidth = width * score / 100f
        val barHeight = height.toFloat()

        val color = when {
            score >= 85 -> ContextCompat.getColor(context, R.color.green)
            score >= 50 -> ContextCompat.getColor(context, R.color.orange)
            else -> ContextCompat.getColor(context, R.color.red)
        }

        paint.color = color
        canvas.drawRect(0f, 0f, barWidth, barHeight, paint)

        paint.color = Color.BLACK
        paint.textSize = barHeight * 0.6f
        paint.isFakeBoldText = true
        canvas.drawText("$score%", 10f, barHeight * 0.75f, paint)
    }
}