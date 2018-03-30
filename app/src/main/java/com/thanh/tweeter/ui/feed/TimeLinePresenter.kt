package com.thanh.tweeter.ui.feed


import java.util.*

class TimeLinePresenter(private var timeLineView: TimeLineView) {

    fun getDataTimeLine() {
        timeLineView.setDataTimeLine(ArrayList())
    }
}
