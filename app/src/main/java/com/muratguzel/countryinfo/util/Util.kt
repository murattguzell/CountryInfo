package com.muratguzel.countryinfo.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muratguzel.countryinfo.R


fun ImageView.imageDownload(url: String?) {
    val options = RequestOptions().error(R.drawable.error)
    Glide.with(context).setDefaultRequestOptions(options).load(url).into(this)
}




