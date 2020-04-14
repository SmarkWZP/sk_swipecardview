package com.sk.swipecardview.util

import android.content.Context
import android.util.TypedValue

/**
 * Created by smark on 2020/4/14.
 * 邮箱：smarkwzp@163.com
 * 常量配置类
 */
object CardConfig {
    //屏幕上同时最大显示view数量
     val MAX_SHOW_COUNT = 4;
    //每一级view的缩放大小
    val SCALE_GAP = 0.05f
    var TRANS_Y_GAP: Float = 0f;

     fun initCardConfig(context: Context) {
        TRANS_Y_GAP = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            16f,
            context.resources.displayMetrics
        )
    }

}