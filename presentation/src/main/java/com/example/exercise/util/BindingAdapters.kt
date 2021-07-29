package com.example.exercise.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter(value = ["adapter"])
fun RecyclerView.setAdapter(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
}

@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view.context)
            .load(it)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(android.R.color.holo_purple)
            .into(view)
    }
}
