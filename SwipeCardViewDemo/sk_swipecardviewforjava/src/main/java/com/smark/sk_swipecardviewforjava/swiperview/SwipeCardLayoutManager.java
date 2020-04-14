package com.smark.sk_swipecardviewforjava.swiperview;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.smark.sk_swipecardviewforjava.util.CardConfig;


/**
 * Created by smark on 2020/4/13.
 * 邮箱：smarkwzp@163.com
 */
public class SwipeCardLayoutManager extends RecyclerView.LayoutManager {

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        //回收 复用
        detachAndScrapAttachedViews(recycler);

        int itemCount = getItemCount();
        int bottomPosition;

        //定位显示在最上面item的坐标
        if (itemCount < CardConfig.MAX_SHOW_COUNT) {
            bottomPosition = 0;
        } else {
            bottomPosition = itemCount - CardConfig.MAX_SHOW_COUNT;
        }

        for (int i = bottomPosition; i < itemCount; i++) {
            View view = recycler.getViewForPosition(i);
            addView(view);

            measureChildWithMargins(view, 0, 0);

            //求padding的总大小
            int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
            int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);

            //布局
            layoutDecoratedWithMargins(view,
                    widthSpace / 2,
                    heightSpace / 2,
                    widthSpace / 2 + getDecoratedMeasuredWidth(view),
                    heightSpace / 2 + getDecoratedMeasuredHeight(view));

            int level = itemCount - i - 1;

            if (level > 0) {
                if (level < CardConfig.MAX_SHOW_COUNT - 1) {
                    view.setTranslationY(CardConfig.TRANS_Y_GAP * level);
                    view.setScaleX(1 - CardConfig.SCALE_GAP * level);
                    view.setScaleY(1 - CardConfig.SCALE_GAP * level);
                }else{
                    view.setTranslationY(CardConfig.TRANS_Y_GAP * (level-1));
                    view.setScaleX(1 - CardConfig.SCALE_GAP * (level-1));
                    view.setScaleY(1 - CardConfig.SCALE_GAP * (level-1));
                }
            }


        }
    }
}
