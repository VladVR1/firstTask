
package com.onix.internship.ui.canvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.core.content.res.ResourcesCompat
import com.onix.internship.R


private const val STROKE_WIDTH = 20f

class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var filForGame = FilForGame()
    set(value) {
        field = value
        invalidate()
        requestLayout()
    }
    private var path = Path()
    private val drawColor = ResourcesCompat.getColor(resources, R.color.colorPaint, null)
    private val backgroundColor = ResourcesCompat.getColor(resources, R.color.white, null)
    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap
    init {
        if(isInEditMode){
            filForGame = FilForGame()
        }
    }
    private val paint = Paint().apply {
        color = drawColor
        isAntiAlias = true
        isDither = true
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = STROKE_WIDTH
    }

    private val touchTolerance = ViewConfiguration.get(context).scaledTouchSlop

    private var currentX = 0f
    private var currentY = 0f

    private var motionTouchEventX = 0f
    private var motionTouchEventY = 0f

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)

        if (::extraBitmap.isInitialized) extraBitmap.recycle()
        extraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor)

        }

    override fun onDraw(canvas: Canvas) {
        drawVerticalLines(canvas)
        drawHorizontalLines(canvas)
    }

    private fun drawVerticalLines(canvas: Canvas) {
        canvas.drawLine(width * 1 / 3F, 0F, width * 1 / 3F, height.toFloat(), paint)
        canvas.drawLine(width * (2 / 3F), 0F, width * (2 / 3F), height.toFloat(), paint)

    }

    private fun drawHorizontalLines(canvas: Canvas) {
        canvas.drawLine(0f, height * 1/3F, width.toFloat(), height * 1/3F, paint)
        canvas.drawLine(0f, height * (2 * 1/3F), width.toFloat(), height * (2 * 1/3F), paint)

    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        motionTouchEventX = event.x
        motionTouchEventY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchStart()
            MotionEvent.ACTION_MOVE -> touchMove()
            MotionEvent.ACTION_UP -> touchUp()
        }
        return true
    }

    private fun touchStart() {
        path.reset()
        path.moveTo(motionTouchEventX, motionTouchEventY)
        currentX = motionTouchEventX
        currentY = motionTouchEventY
    }

    private fun touchMove() {
        val dx = Math.abs(motionTouchEventX - currentX)
        val dy = Math.abs(motionTouchEventY - currentY)
        if (dx >= touchTolerance || dy >= touchTolerance) {
            path.quadTo(currentX, currentY, (motionTouchEventX + currentX) / 2, (motionTouchEventY + currentY) / 2)
            currentX = motionTouchEventX
            currentY = motionTouchEventY
            extraCanvas.drawPath(path, paint)
        }
        invalidate()
    }

    private fun touchUp() {
        path.reset()
    }

}