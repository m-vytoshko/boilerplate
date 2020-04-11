package com.ss.boilerplate.extensions

import android.content.Context
import android.graphics.Color
import android.view.*
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.ss.boilerplate.RequiresWindowInsets

@Suppress("UNCHECKED_CAST")
fun <ViewType : View> Context.inflateTypedView(@LayoutRes layoutRes: Int): ViewType {
    return LayoutInflater.from(this).inflate(layoutRes, null) as ViewType
}

fun Window.makeStatusBarTransparent() {
    clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    statusBarColor = Color.TRANSPARENT
}

fun Fragment.applyInsets(listener: (insets: WindowInsets) -> Unit) {
    (requireActivity() as RequiresWindowInsets?)?.getWindowInsets()?.let {
        listener(it)
    }
}

fun View.margin(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) {
    layoutParams<ViewGroup.MarginLayoutParams> {
        left?.run { leftMargin = this }
        top?.run { topMargin = this }
        right?.run { rightMargin = this }
        bottom?.run { bottomMargin = this }
    }
}

inline fun <reified T : ViewGroup.LayoutParams> View.layoutParams(block: T.() -> Unit) {
    if (layoutParams is T) block(layoutParams as T)
}