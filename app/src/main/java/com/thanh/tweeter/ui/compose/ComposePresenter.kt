package com.thanh.tweeter.ui.compose

import com.thanh.tweeter.model.ComposeEvent
import com.thanh.tweeter.model.Tweet

import org.greenrobot.eventbus.EventBus


class ComposePresenter(private val composeView: ComposeView) {

    fun postTweet(tweetContent: String) {
        if (Tweet.checkInvalidData(tweetContent)) {
            saveTweet(tweetContent)
        } else {
            composeView.showError()
        }
    }

    private fun saveTweet(tweetContent: String) {
        composeView.finishCompose()
        EventBus.getDefault().post(ComposeEvent(Tweet.getListComment(Tweet.splitMessage(tweetContent))))
    }
}
