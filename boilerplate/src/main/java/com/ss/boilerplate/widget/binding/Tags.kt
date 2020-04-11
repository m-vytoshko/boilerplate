package com.ss.boilerplate.widget.binding

import androidx.annotation.StringDef

@StringDef(
    Tags.bindRvAdapter,
    Tags.bindRvData,
    Tags.bindPagedRvData,
    Tags.bindVisibleGone,
    Tags.bindVisibleInvisible,
    Tags.bindItemDecoration,
    Tags.bindSpanCount,
    Tags.bindIntAsText
)
@Retention(AnnotationRetention.SOURCE)
annotation class Tags {
    companion object {
        const val bindRvAdapter = "bindRvAdapter"
        const val bindRvData = "bindRvData"
        const val bindPagedRvData = "bindPagedRvData"
        const val bindVisibleGone = "bindVisibleGone"
        const val bindVisibleInvisible = "bindVisibleInvisible"
        const val bindItemDecoration = "bindItemDecoration"
        const val bindSpanCount = "bindSpanCount"
        const val bindIntAsText = "bindIntAsText"
    }
}