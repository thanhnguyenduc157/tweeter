package com.thanh.tweeter.ui.feed

import com.thanh.tweeter.model.Tweet

import java.util.ArrayList

interface TimeLineView {

    fun setDataTimeLine(tweets: ArrayList<Tweet>)
}
