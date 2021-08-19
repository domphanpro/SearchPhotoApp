package com.example.searchphoto.ui.tab

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.searchphoto.R
import com.example.searchphoto.databinding.SpTabItemBinding

class SPTabItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = SpTabItemBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    enum class Type(val position: Int) {
        SEARCH(0),
        FAVORITE(1)
    }

    fun initTab(type: Type) {
        when (type) {
            Type.SEARCH -> {
                displaySelected(true)
                (binding.spTabItemTitle).text = context.getString(R.string.sp_search_photo_tab)
            }
            Type.FAVORITE -> {
                displaySelected(false)
                (binding.spTabItemTitle).text = context.getString(R.string.sp_favorite_tab)
            }
        }
    }

    fun displaySelected(displayed: Boolean) {
        val color = if (displayed) {
            R.color.purple_200
        } else {
            R.color.black
        }
        (binding.spTabItemTitle).setTextColor(ContextCompat.getColor(context, color))
    }


}