package com.smark.swipecardviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.sk.swipecardview.swipeview.OnSwipeListener
import com.sk.swipecardview.swipeview.SwipeLayoutManager
import com.sk.swipecardview.swipeview.SwipeTouchCallBack
import com.sk.swipecardview.util.CardConfig
import com.smark.swipecardviewdemo.adapter.MyAdapter
import com.smark.swipecardviewdemo.bean.DataUtil
import com.smark.swipecardviewdemo.bean.SwipeBean

class MainActivity : AppCompatActivity() {
    lateinit var mRecyclerView: RecyclerView
    var mData: ArrayList<SwipeBean> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recycle_view)
        CardConfig.initCardConfig(this)
        getData()
        println(mData.size)
        var adapter = MyAdapter(this, mData, R.layout.item_swipe_card)
        mRecyclerView.layoutManager = SwipeLayoutManager()
        mRecyclerView.adapter = adapter

        val callback: ItemTouchHelper.Callback = SwipeTouchCallBack(object : OnSwipeListener {
                override fun onSwipedListener(
                    viewHolder: RecyclerView.ViewHolder,
                    direction: Int
                ) {
                    val remove: SwipeBean = mData.removeAt(viewHolder.adapterPosition)
                    mData.add(0, remove)
                    adapter.notifyDataSetChanged()
                }
            }, 0, 0f)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(mRecyclerView)
    }

    private fun getData() {
        mData.addAll(DataUtil.getData())
    }
}
