package com.thanh.tweeter.ui.feed.adapter

import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.View

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thanh.tweeter.R
import kotlinx.android.synthetic.main.item_tweet.*


import com.thanh.tweeter.model.Tweet
import kotlinx.android.extensions.LayoutContainer


class TweetViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView), LayoutContainer {



    init {

        // define standard attributes
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivProfileImage.clipToOutline = true
            tvBody.letterSpacing = 0.005.toFloat()
            tvUserScreenname.letterSpacing = (-0.025).toFloat()

        }
    }

    fun bind(tweet: Tweet) {
        // populate the views according to this data
        tvUserName.text = tweet.user.name
        tvUserScreenname.text = String.format("%s%s", tvUserScreenname.context.getString(R.string.alpha), tweet.user.screenName)
        tvBody.text = tweet.body
        Glide.with(tvUserName.context).load(R.drawable.ic_avatar).apply(RequestOptions.circleCropTransform()).into(ivProfileImage)
        Glide.with(tvUserName.context).load(R.drawable.ic_vector_retweet_stroke).into(buttonRetweet)
        Glide.with(tvUserName.context).load(R.drawable.ic_verified_badge).into(ivVerifiedBadge)
        Glide.with(tvUserName.context).load(R.drawable.ic_vector_heart_stroke).into(buttonFavorite)
        Glide.with(tvUserName.context).load(R.drawable.ic_vector_messages_stroke).into(buttonMessage)
        Glide.with(tvUserName.context).load(R.drawable.vector_compose_dm_fab).into(buttonReply)
    }

}
