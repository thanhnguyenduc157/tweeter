package com.thanh.tweeter.model

import java.util.*
import java.util.regex.Pattern


class Tweet(// list out the attributes
        var body: String) {
    var user: User = User()

    companion object {

        /**
         * @param tweet comment of user
         * @return list string split by rule (max 50 characters)
         */
        fun splitMessage(tweet: String): ArrayList<String> {
            val strings = ArrayList<String>()
            if (tweet.length <= 50) {
                strings.add(tweet)
                return strings
            } else {
                val splitPattern = Pattern.compile("(.{1,46})\\b( |$)")
                val m = splitPattern.matcher(tweet)
                while (m.find()) {
                    strings.add(m.group(1))
                }
                for (i in strings.indices) {
                    strings[i] ="${i + 1}/${strings.size} ${strings[i]}"
                }
            }

            return strings
        }

        /**
         * @param stringArrayList list string of comment
         * @return list tweet to post
         */
        fun getListComment(stringArrayList: ArrayList<String>): ArrayList<Tweet> {
            val tweets = ArrayList<Tweet>()
            for (i in stringArrayList.indices) {
                tweets.add(Tweet(stringArrayList[i]))
            }
            return tweets
        }

        /**
         *
         * @param comment is input of user
         * @return data valid or invalid
         */
        fun checkInvalidData(comment: String): Boolean {

            val pattern = Pattern.compile("\\s{51}")
            val matcher = pattern.matcher(comment)
            val check = matcher.find()

            return !check
        }
    }

}
