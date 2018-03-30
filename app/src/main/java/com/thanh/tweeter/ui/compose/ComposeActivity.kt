package com.thanh.tweeter.ui.compose


import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thanh.tweeter.R
import kotlinx.android.synthetic.main.activity_main.*


class ComposeActivity : Activity(), ComposeView {



    private lateinit var composePresenter: ComposePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        composePresenter = ComposePresenter(this)
        initView()
        onViewClicked()
    }

    private fun initView() {

        Glide.with(applicationContext).load(R.drawable.ic_vector_photo_stroke).into(buttonPhoto)
        Glide.with(applicationContext).load(R.drawable.ic_vector_close).into(ibCancel)
        Glide.with(applicationContext).load(R.drawable.ic_vector_gif_pill_stroke).into(buttonGIF)
        Glide.with(applicationContext).load(R.drawable.ic_vector_location_stroke).into(buttonLocation)
        Glide.with(applicationContext).load(R.drawable.ic_avatar).apply(RequestOptions.circleCropTransform()).into(ivProfileImage)


        etBody.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setTweetButtonEnabled(etBody.length() > 0 && etBody.text.toString().trim { it <= ' ' }.isNotEmpty())
            }
        })

        setTweetButtonEnabled(false)
    }

    private fun setTweetButtonEnabled(enabled: Boolean) {
        buttonTweet.isEnabled = enabled
        buttonTweet.alpha = (if (enabled) 1F else 0.6F)
    }


    fun onViewClicked() {
        ibCancel.setOnClickListener {
            finish()
        }
        buttonTweet.setOnClickListener {
            composePresenter.postTweet(etBody!!.text.toString())
        }

    }

    override fun showError() {
        Toast.makeText(applicationContext, applicationContext.getString(R.string.error_compose), Toast.LENGTH_SHORT).show()
    }

    override fun finishCompose() {
        finish()
    }

}



