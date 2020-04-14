package com.sk.swipecardview.swipeview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sk.swipecardview.util.CardConfig

/**
 * Created by smark on 2020/4/14.
 * 邮箱：smarkwzp@163.com
 */
class SwipeLayoutManager : RecyclerView.LayoutManager() {
    /**
     * 必须重写，在linearLayoutManager源码中拷贝一份就行
     */
    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    /**
     * 重写此方法负责子view的显示位置及效果
     */
    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State) {
        detachAndScrapAttachedViews(recycler)
        var itemCount = itemCount
        var bottomPos = 0;
        if (itemCount < CardConfig.MAX_SHOW_COUNT) {
            bottomPos = 0
        } else {
            bottomPos = itemCount - CardConfig.MAX_SHOW_COUNT
        }

        println("onLayoutChildren"+itemCount)
        for (i in bottomPos until itemCount) {
            var childView = recycler.getViewForPosition(i)
            childView?.let {
                println("hhhhh")
                addView(it)
                measureChildWithMargins(it, 0, 0)

                var widthSpace = width - getDecoratedMeasuredWidth(it)
                var heightSpace = height - getDecoratedMeasuredHeight(it)

                //开始布局
                layoutDecoratedWithMargins(
                    it, widthSpace / 2, heightSpace / 2,
                    widthSpace / 2 + getDecoratedMeasuredWidth(it),
                    heightSpace / 2 + getDecoratedMeasuredHeight(it)
                )

                var level = itemCount - i - 1;
                if (level > 0) {
                    if (level < CardConfig.MAX_SHOW_COUNT - 1) {
                        it.translationY = CardConfig.TRANS_Y_GAP * level
                        it.scaleX = 1 - CardConfig.SCALE_GAP * level
                        it.scaleY = 1 - CardConfig.SCALE_GAP * level
                    } else {
                        it.translationY = CardConfig.TRANS_Y_GAP * (level - 1)
                        it.scaleX = 1 - CardConfig.SCALE_GAP * (level - 1)
                        it.scaleY = 1 - CardConfig.SCALE_GAP * (level - 1)
                    }
                }

            }

        }

    }
}