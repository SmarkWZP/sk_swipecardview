package com.smark.swipecardviewdemo.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sk.rvadapter.adapter.SkAdapter
import com.sk.rvadapter.holder.SViewHolder
import com.smark.swipecardviewdemo.R
import com.smark.swipecardviewdemo.bean.SwipeBean

/**
 * Created by smark on 2020/4/14.
 * 邮箱：smarkwzp@163.com
 */
class MyAdapter : SkAdapter<SwipeBean> {

    constructor(context: Context, data: List<SwipeBean>, layoutId: Int) : super(
        context,
        data,
        layoutId
    ) {

    }

    override fun convert(holder: SViewHolder?, data: SwipeBean) {
        Glide.with(mContext).load(data.url)
            .into(holder!!.getView<View>(R.id.iv) as ImageView)
        holder.setText(R.id.tvName, data.name)
        holder.setText(R.id.tvPrecent, data.position.toString() + "/" + mDatas.size)
    }
}