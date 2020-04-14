package com.smark.sk_swipecardviewforjava.swiperview;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by smark on 2020/4/13.
 * 邮箱：smarkwzp@163.com
 * 滑动监听，可以处理滑动移除后续事件
 */
public interface OnSwipedListener {

    void onSwipedListener(RecyclerView.ViewHolder viewHolder, int direction);
}
