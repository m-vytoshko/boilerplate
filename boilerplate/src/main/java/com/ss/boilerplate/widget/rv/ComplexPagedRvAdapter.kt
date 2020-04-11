package com.ss.boilerplate.widget.rv

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

abstract class ComplexPagedRvAdapter<ItemType : Any>(diffCallback: DiffUtil.ItemCallback<ItemType>) : PagedListAdapter<ItemType, BaseVh<*>>(diffCallback)