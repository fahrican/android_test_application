package com.revolut.androidtestapplication.internal

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {

    val requestBuilder = GlideToVectorYou
        .init()
        .with(imageView.context)
        .requestBuilder

    requestBuilder
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .apply(RequestOptions().centerCrop())
        .into(imageView)

}