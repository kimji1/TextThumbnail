package com.example.textthumbnail

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.thumbnail.view.*

class Thumbnail(context: Context, attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet) {

    companion object {
        const val DEFAULT_TEXT_SIZE = 25f
        const val DEFAULT_TEXT_COLOR = Color.WHITE
    }

    private var view: View = View.inflate(context, R.layout.thumbnail, this)

    init {
        background = ContextCompat.getDrawable(context, R.drawable.circle)
        context.theme.obtainStyledAttributes(attributeSet, R.styleable.Thumbnail, 0, 0).run {
            try {
                val iconDrawable = getDrawable(R.styleable.Thumbnail_iconDrawable)
                if (iconDrawable == null) {
                    view.image_thumbnail.visibility = View.GONE

                    val thumbnailText = getString(R.styleable.Thumbnail_text)
                    val textColor = getInteger(R.styleable.Thumbnail_textColor, DEFAULT_TEXT_COLOR)
                    val textSize = getFloat(R.styleable.Thumbnail_textSize, DEFAULT_TEXT_SIZE)

                    view.text_thumbnail.run {
                        visibility = View.VISIBLE
                        text = thumbnailText?.first().toString()
                        setTextSize(textSize)
                        setTextColor(textColor)
                    }
                } else {
                    view.text_thumbnail.visibility = View.GONE

                    view.image_thumbnail.run {
                        visibility = View.VISIBLE
                        setImageDrawable(iconDrawable)
                    }
                }
            } finally {
                recycle()
            }
        }
    }

    fun setText(text: String) {
        view.text_thumbnail.text = text.first().toString()
    }

    fun setTextColor(@ColorInt color: Int) {
        view.text_thumbnail.setTextColor(color)
    }

    fun setCircleColor(@ColorInt color: Int) {
        background.setTint(color)
    }

    fun setIcon(@DrawableRes drawableRes: Int) {
        view.text_thumbnail.visibility = View.GONE
        view.image_thumbnail.visibility = View.VISIBLE
        view.image_thumbnail.setImageResource(drawableRes)
    }
}