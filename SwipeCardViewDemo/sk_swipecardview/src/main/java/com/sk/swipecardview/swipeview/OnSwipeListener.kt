package com.sk.swipecardview.swipeview

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by smark on 2020/4/14.
 * 邮箱：smarkwzp@163.com
 * 滑动回调接口
 */
interface OnSwipeListener {
    fun onSwipedListener(viewHolder: RecyclerView.ViewHolder, direction: Int);
}