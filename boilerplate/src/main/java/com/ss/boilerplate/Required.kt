package com.ss.boilerplate

import android.view.WindowInsets
import androidx.annotation.ArrayRes
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes

interface RequiresLayoutResId {
    @LayoutRes
    fun getLayoutRes(): Int
}

interface RequiresVhLayoutResId {
    @LayoutRes
    fun getLayoutRes(viewType: Int): Int
}

interface RequiresStringResId {
    @StringRes
    fun getStringRes(): Int
}

interface RequiresArrayResId {
    @ArrayRes
    fun getArrayRes(): Int
}

interface RequiresViewId {
    @IdRes
    fun getViewId(): Int
}

interface RequiresWindowInsets {
    fun getWindowInsets(): WindowInsets?
}