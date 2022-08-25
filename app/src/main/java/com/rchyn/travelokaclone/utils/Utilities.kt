package com.rchyn.travelokaclone.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.concurrent.TimeUnit

fun Long.longToTime(): String {
    if (this < 0) throw IllegalArgumentException("Duration must be getter than zero!")
    var millis = this
    val hours = TimeUnit.MILLISECONDS.toHours(millis)
    millis -= TimeUnit.HOURS.toMillis(hours)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
    millis -= TimeUnit.MINUTES.toMillis(minutes)
    val seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, length).show()

fun Fragment.showToast(message: String, length: Int = Toast.LENGTH_SHORT) =
    requireContext().showToast(message, length)

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}