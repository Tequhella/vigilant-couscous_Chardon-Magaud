package com.example.myrecipes_chardon_magaud.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class NutriScoreView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {

    private var score: Int = 0
    private val paint = Paint()

    fun setScore(value: Int) {
        score = value.coerceIn(0, 100)
        invalidate() // Redessine la vue
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val barWidth = width * score / 100f
        val barHeight = height.toFloat()

        val color = when {
            score >= 85 -> Color.parseColor("#4CAF50") // Green
            score >= 50 -> Color.parseColor("#FF9800") // Orange
            else -> Color.parseColor("#F44336") // Red
        }

        paint.color = color
        canvas.drawRect(0f, 0f, barWidth, barHeight, paint)

        // Optional: draw score % text
        paint.color = Color.BLACK
        paint.textSize = barHeight * 0.6f
        paint.isFakeBoldText = true
        canvas.drawText("$score%", 10f, barHeight * 0.75f, paint)
    }
}