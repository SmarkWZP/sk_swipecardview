package com.sk.swipecardview.swipeview

import android.graphics.Canvas
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.sk.swipecardview.util.CardConfig

/**
 * Created by smark on 2020/4/14.
 * 邮箱：smarkwzp@163.com
 * item滑动回调
 */
class SwipeTouchCallBack : ItemTouchHelper.SimpleCallback {
     var mListener: OnSwipeListener
    var mAnimationDuration: Long = 300//移除动画时长
    var mSwipeDis = 0.5f//滑动消失距离

    constructor(listener: OnSwipeListener, animationDuration: Long, swipeDis: Float) : super(
        0,
        15
    ) {
        this.mListener = listener
        if (animationDuration != 0L)
            this.mAnimationDuration = animationDuration
        if (swipeDis != 0f)
            mSwipeDis = swipeDis

    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (this.mListener != null) {
            this.mListener.onSwipedListener(viewHolder, direction)
        }

    }

    /**
     * 触摸绘制
     */
    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        var masDistance = recyclerView.width * 0.5f
        var distance = Math.sqrt((dX * dX + dY * dY).toDouble())
        var fraction = distance / masDistance
        if (fraction > 0) {
            fraction = 0.0
        }
        var childCount = recyclerView.childCount
        for (i in 0 until childCount) {
            var childView = recyclerView.getChildAt(i)
            var level = childCount - i - 1;
            if (level > 0) {
                if (level < CardConfig.MAX_SHOW_COUNT - 1) {
                    childView.translationY =
                        (CardConfig.TRANS_Y_GAP * level - fraction * CardConfig.TRANS_Y_GAP).toFloat()
                    childView.scaleX =
                        ((1 - CardConfig.SCALE_GAP * level + fraction * CardConfig.SCALE_GAP).toFloat())
                    childView.scaleY =
                        (1 - CardConfig.SCALE_GAP * level + fraction * CardConfig.SCALE_GAP).toFloat()
                }
            }
        }
    }


    /**
     *设置回弹时间
     */
    override fun getAnimationDuration(
        recyclerView: RecyclerView,
        animationType: Int,
        animateDx: Float,
        animateDy: Float
    ): Long {
        return mAnimationDuration
    }

    /**
     * 设置回弹距离
     */
    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return mSwipeDis
    }
}