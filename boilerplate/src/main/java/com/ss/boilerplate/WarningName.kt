package com.ss.boilerplate

import androidx.annotation.StringDef

@StringDef(
        WarningName.UNCHECKED_CAST,
        WarningName.CLICKABLE_VIEW_ACCESSIBILITY
)
@Retention(AnnotationRetention.SOURCE)
annotation class WarningName {
    companion object {
        const val UNCHECKED_CAST = "UNCHECKED_CAST"
        const val CLICKABLE_VIEW_ACCESSIBILITY = "ClickableViewAccessibility"
    }
}