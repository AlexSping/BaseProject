package com.sping.baseproject.utils.bindings

import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

/**
 * [BindingAdapter] that loads a remote image to an [AppCompatImageView] using [Glide]
 *
 * @param remoteImageUrl the url of the image we want to load
 * @param remoteImagePlaceholder the [DrawableRes] we want to load as placeholder
 * @param cornerRadius the corner radius we want to apply to our loaded image
 */
@BindingAdapter(value = ["glideUrl", "glidePlaceholder", "glideCornerRadius"], requireAll = false)
fun setGlideProperties(
    view: AppCompatImageView,
    remoteImageUrl: String?,
    @DrawableRes remoteImagePlaceholder: Int?,
    cornerRadius: Int?
) {
    remoteImageUrl?.apply {
        when {
            remoteImagePlaceholder != null && cornerRadius != null ->
                Glide
                    .with(view.context)
                    .load(this)
                    .placeholder(remoteImagePlaceholder)
                    .transform((RoundedCorners(cornerRadius.toInt())))
                    .into(view)

            remoteImagePlaceholder != null ->
                Glide
                    .with(view.context)
                    .load(this)
                    .placeholder(remoteImagePlaceholder)
                    .into(view)

            else ->
                Glide
                    .with(view.context)
                    .load(remoteImageUrl)
                    .into(view)
        }
    }
}