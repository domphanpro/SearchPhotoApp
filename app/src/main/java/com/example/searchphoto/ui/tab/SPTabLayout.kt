package com.example.searchphoto.ui.tab

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.example.searchphoto.databinding.SpTabLayoutBinding
import com.google.android.material.tabs.TabLayout

class SPTabLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var searchTab: SPTabItem
    private lateinit var favoriteTab: SPTabItem

    private val binding: SpTabLayoutBinding = SpTabLayoutBinding.inflate(
        LayoutInflater.from(context),
        this
    )

    init {
        gravity = Gravity.CENTER
        orientation = VERTICAL
        (binding.spTabLayout).setupWithViewPager(binding.spTabLayoutViewpager)
    }

    fun setup(adapter: SPPagerAdapter) {
        (binding.spTabLayoutViewpager).adapter = adapter
        displayTabLayout()
        searchTab = initTab(SPTabItem.Type.SEARCH)
        favoriteTab = initTab(SPTabItem.Type.FAVORITE)
        (binding.spTabLayout).addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Nothing to do
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Nothing to do
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    SPTabItem.Type.SEARCH.position -> setSearchSelected()
                    SPTabItem.Type.FAVORITE.position -> setFavoriteSelected()
                }
            }
        })
    }

    private fun setSearchSelected() {
        searchTab.displaySelected(true)
        favoriteTab.displaySelected(false)
        (binding.spTabLayoutViewpager).currentItem = 0
    }

    private fun setFavoriteSelected() {
        searchTab.displaySelected(false)
        favoriteTab.displaySelected(true)
        (binding.spTabLayoutViewpager).currentItem = 1
    }

    private fun displayTabLayout() {
        binding.apply {
            spTabLayout.isVisible = true
            spTabLayoutSeparator.isVisible = true
        }
    }

    private fun initTab(type: SPTabItem.Type): SPTabItem {
        val view = SPTabItem(context)
        val tab = (binding.spTabLayout).getTabAt(type.position)
        tab?.customView = view
        view.initTab(type)
        return view
    }


}