package com.thanh.tweeter.ui.feed


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.thanh.tweeter.R
import com.thanh.tweeter.model.ComposeEvent
import com.thanh.tweeter.model.Tweet
import com.thanh.tweeter.ui.compose.ComposeActivity
import com.thanh.tweeter.ui.feed.adapter.TweetAdapter
import kotlinx.android.synthetic.main.activity_timeline.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*


class TimeLineActivity : Activity(), TimeLineView {

    private lateinit var tweetAdapter: TweetAdapter

    private lateinit var timeLinePresenter: TimeLinePresenter

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timeline)
        EventBus.getDefault().register(this)
        timeLinePresenter = TimeLinePresenter(this)
        timeLinePresenter.getDataTimeLine()
        onViewClicked()
    }


    override fun setDataTimeLine(tweets: ArrayList<Tweet>) {

        tweetAdapter = TweetAdapter(tweets)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        rvTweet.layoutManager = linearLayoutManager
        rvTweet.adapter = tweetAdapter
        val mDividerItemDecoration = DividerItemDecoration(rvTweet.context,
                linearLayoutManager.orientation)
        rvTweet.addItemDecoration(mDividerItemDecoration)

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: ComposeEvent) {
        tweetAdapter.addAll(event.tweets)
        rvTweet.layoutManager.scrollToPosition(0)
        Toast.makeText(applicationContext, "Posted New Tweet!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    private fun onComposeAction() {
        val i = Intent(this@TimeLineActivity, ComposeActivity::class.java)
        startActivity(i)
    }


    fun onViewClicked() {
        fabCompose.setOnClickListener {
            onComposeAction()
        }
    }


}

