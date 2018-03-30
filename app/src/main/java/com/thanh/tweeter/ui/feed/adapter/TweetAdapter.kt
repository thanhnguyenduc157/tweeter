package com.thanh.tweeter.ui.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.thanh.tweeter.R
import com.thanh.tweeter.model.Tweet


class TweetAdapter// pass in the Tweets array in the constructor
(private val mTweets: MutableList<Tweet>) : RecyclerView.Adapter<TweetViewHolder>() {


    // for each row, inflate the layout and cache references into ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val tweetView = inflater.inflate(R.layout.item_tweet, parent, false)

        return TweetViewHolder(tweetView)
    }

    // bind the values based on the position of the element
    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        // get the data according to position
        val tweet = mTweets[position]
        holder.bind(tweet)
    }

    override fun getItemCount(): Int {
        return mTweets.size
    }

    // Add a list of items
    fun addAll(list: List<Tweet>) {
        this.mTweets.addAll(0, list)
        notifyDataSetChanged()
    }

}

