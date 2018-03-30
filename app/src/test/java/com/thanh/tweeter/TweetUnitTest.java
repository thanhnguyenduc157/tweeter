package com.thanh.tweeter;

import com.thanh.tweeter.model.Tweet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TweetUnitTest {


    @Test
    public void splitMessage_isCorrect() {
        assertEquals(Tweet.Companion.splitMessage("Example local unit test, which will execute on the development machine (host)").get(0),
                "1/2 Example local unit test, which will execute on");
        assertEquals(Tweet.Companion.splitMessage("Example local unit test, which will execute on the development machine (host)").get(1),
                "2/2 the development machine");
    }
}