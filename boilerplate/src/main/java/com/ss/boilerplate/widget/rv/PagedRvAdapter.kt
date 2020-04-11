package com.ss.boilerplate.widget.rv

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.ss.boilerplate.RequiresLayoutResId

abstract class PagedRvAdapter<ItemType : Any, BindingType : ViewDataBinding>(diffCallback: DiffUtil.ItemCallback<ItemType>) : PagedListAdapter<ItemType, BaseVh<BindingType>>(diffCallback), RequiresLayoutResId {
    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseVh.inflate<BindingType>(parent, getLayoutRes())
}