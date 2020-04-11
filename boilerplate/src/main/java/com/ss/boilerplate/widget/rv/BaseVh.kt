package com.ss.boilerplate.widget.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseVh<BindingType : ViewDataBinding>(var binding: BindingType) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun <BindingType : ViewDataBinding> inflate(parent: ViewGroup, @LayoutRes layoutRes: Int): BaseVh<BindingType> {
            return BaseVh(DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutRes, parent, false))
        }
    }
}