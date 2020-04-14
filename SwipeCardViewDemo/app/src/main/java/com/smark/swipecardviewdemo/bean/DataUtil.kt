package com.smark.swipecardviewdemo.bean


/**
 * Created by smark on 2020/4/14.
 * 邮箱：smarkwzp@163.com
 */
object DataUtil {

    fun getData(): ArrayList<SwipeBean> {
        val datas = arrayListOf<SwipeBean>()
        datas.add(
            SwipeBean(
                1,
                "http://img2.imgtn.bdimg.com/it/u=3852882952,1903915436&fm=26&gp=0.jpg",
                "美女1"
            )
        )
        datas.add(
            SwipeBean(
                2,
                "http://img4.imgtn.bdimg.com/it/u=2228414292,135257764&fm=26&gp=0.jpg",
                "美女2"
            )
        )
        datas.add(
            SwipeBean(
                3,
                "http://img5.imgtn.bdimg.com/it/u=3547192257,2226731634&fm=26&gp=0.jpg",
                "美女3"
            )
        )
        datas.add(
            SwipeBean(
                4,
                "http://img4.imgtn.bdimg.com/it/u=1387635405,2660249575&fm=26&gp=0.jpg",
                "美女4"
            )
        )
        datas.add(
            SwipeBean(
                5,
                "http://img5.imgtn.bdimg.com/it/u=3797033443,1286698196&fm=26&gp=0.jpg",
                "美女5"
            )
        )
        datas.add(
            SwipeBean(
                6,
                "http://img5.imgtn.bdimg.com/it/u=325441115,656002524&fm=26&gp=0.jpg",
                "美女6"
            )
        )
        datas.add(
            SwipeBean(
                7,
                "http://img4.imgtn.bdimg.com/it/u=3095771832,4259211458&fm=26&gp=0.jpg",
                "美女7"
            )
        )
        datas.add(
            SwipeBean(
                8,
                "http://img1.imgtn.bdimg.com/it/u=685626818,2332076363&fm=11&gp=0.jpg",
                "美女8"
            )
        )
        return datas
    }
}