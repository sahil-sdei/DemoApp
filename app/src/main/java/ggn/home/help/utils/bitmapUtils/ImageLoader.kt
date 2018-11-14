package ggn.home.help.utils.bitmapUtils

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import ggn.home.help.R

class ImageLoader {

    @BindingAdapter("bind:urlSquare")
    fun loadImageSmall(imageView: View, url: String?) {
        if (url == null || url.isEmpty()) {
            return
        }
        if (!url.contains("http")) {
            val id = imageView.context.resources.getIdentifier(url, "drawable", imageView.context.packageName)
            (imageView as ImageView).setImageResource(id)
        } else {

            GlideApp
                    .with(imageView.context)
                    .load(url)
                    .thumbnail(0.1f)
                    .apply(RequestOptions().centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).override(100, 100))
                    .into(imageView as ImageView)
        }
    }

    @BindingAdapter("bind:small")
    fun loadImageVerySmall(imageView: View, url: String?) {
        if (url == null || url.isEmpty()) {
            return
        }
        GlideApp
                .with(imageView.context)
                .load(url)
                .thumbnail(0.1f)
                .apply(RequestOptions().centerInside().diskCacheStrategy(DiskCacheStrategy.ALL).override(200, 200))
                .into(imageView as ImageView)

    }

    companion object {
        @BindingAdapter("bind:urlHome")
        fun loadHomeImage(imageView: View, url: String?) {

            if (url == null || url.isEmpty()) {
                return
            }
            if (!url.contains("http")) {
                val id = imageView.context.resources.getIdentifier(url, "drawable", imageView.context.packageName)
                (imageView as ImageView).setImageResource(id)
            } else {
                val requestOptions = RequestOptions()
                requestOptions.override(200, 200)
                requestOptions.transforms(CenterCrop(), RoundedCorners(5))
                GlideApp
                        .with(imageView.context)
                        .load(url)
                        .thumbnail(0.1f)
                        .apply(requestOptions)
                        .into(imageView as ImageView)
            }

        }

        fun loadProfileImage(imageView: View, url: String?) {

            if (url == null || url.isEmpty()) {
                return
            }
            if (!url.contains("http")) {
                val id = imageView.context.resources.getIdentifier(url, "drawable", imageView.context.packageName)
                (imageView as ImageView).setImageResource(id)
            } else {
                val requestOptions = RequestOptions()
                requestOptions.override(200, 200)
                requestOptions.transforms(CenterCrop(), RoundedCorners(5))
                requestOptions.placeholder(R.drawable.user)
                GlideApp
                        .with(imageView.context)
                        .load(url)
                        .thumbnail(0.1f)
                        .apply(requestOptions)
                        .into(imageView as ImageView)
            }

        }

        fun loadImageSmall(imageView: View, url: String?) {
            if (url == null || url.isEmpty()) {
                return
            }
            if (!url.contains("http")) {
                val id = imageView.context.resources.getIdentifier(url, "drawable", imageView.context.packageName)
                (imageView as ImageView).setImageResource(id)
            } else {

                GlideApp
                        .with(imageView.context)
                        .load(url)
                        .thumbnail(0.1f)
                        .apply(RequestOptions().centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).override(100, 100).placeholder(R.drawable.placeholder_image).error(R.drawable.placeholder_image))
                        .into(imageView as ImageView)
            }
        }

        @BindingAdapter("bind:urlFullWidth")
        fun loadFullWidthImage(imageView: View, url: String?) {

            if (url == null || url.isEmpty()) {
                return
            }
            if (!url.contains("http")) {
                val id = imageView.context.resources.getIdentifier(url, "drawable", imageView.context.packageName)
                (imageView as ImageView).setImageResource(id)
            } else {

                GlideApp
                        .with(imageView.context)
                        .load(url)
                        .thumbnail(0.1f)
                        .apply(RequestOptions().centerInside().diskCacheStrategy(DiskCacheStrategy.ALL))
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(imageView as ImageView)
            }

        }
    }

    @BindingAdapter("bind:songArtSmall")
    fun songArtSmall(imageView: View, url: String?) {

        if (url == null || url.isEmpty()) {
            return
        }
        if (!url.contains("http")) {
            val id = imageView.context.resources.getIdentifier(url, "drawable", imageView.context.packageName)
            val requestOptions = RequestOptions()
            requestOptions.override(100, 100)
            requestOptions.transforms(CenterCrop(), RoundedCorners(10))
            GlideApp.with(imageView.context).load(id).apply(requestOptions).into(imageView as ImageView)
        } else {
            val requestOptions = RequestOptions()
            requestOptions.override(100, 100)
            requestOptions.transforms(CenterCrop(), RoundedCorners(10))
            GlideApp
                    .with(imageView.context)
                    .load(url)
                    .thumbnail(0.1f)
                    .apply(requestOptions)
                    .into(imageView as ImageView)
        }

    }

    @BindingAdapter("bind:urlFullWidth")
    fun loadFullWidthImage(imageView: View, url: String?) {

        if (url == null || url.isEmpty()) {
            return
        }
        if (!url.contains("http")) {
            val id = imageView.context.resources.getIdentifier(url, "drawable", imageView.context.packageName)
            (imageView as ImageView).setImageResource(id)
        } else {

            GlideApp
                    .with(imageView.context)
                    .load(url)
                    .thumbnail(0.1f)
                    .apply(RequestOptions().centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL))
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imageView as ImageView)
        }

    }

    @BindingAdapter("bind:fullWidthBG")
    fun loadFullWidthImageBG(background: View, image: String?) {

        if (image == null || image.isEmpty()) {
            return
        }
        val id = background.context.resources.getIdentifier(image, "drawable", background.context.packageName)
        background.setBackgroundResource(id)
    }


    @BindingAdapter("android:src")
    fun loadResImage(view: ImageView, resDrawable: Drawable) {
        view.setImageDrawable(resDrawable)
    }

    @BindingAdapter("android:src")
    fun loadResImage(view: ImageView, resDrawable: Int) {
        view.setImageResource(resDrawable)
    }
}
