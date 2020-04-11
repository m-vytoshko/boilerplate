package com.ss.boilerplate.widget.binding

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.ss.boilerplate.widget.rv.BaseRvAdapter
import com.ss.boilerplate.WarningName
import com.ss.boilerplate.widget.rv.BaseVh

object Adapters {
    @JvmStatic
    @BindingAdapter(Tags.bindRvAdapter)
    fun bindRvAdapter(rv: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        rv.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter(Tags.bindRvAdapter)
    fun bindRvAdapter(vp: ViewPager2, adapter: RecyclerView.Adapter<*>) {
        vp.adapter = adapter
    }

    @Suppress(WarningName.UNCHECKED_CAST)
    @JvmStatic
    @BindingAdapter(Tags.bindPagedRvData)
    fun bindPagedRvData(rv: RecyclerView, data: PagedList<*>?) {
        (rv.adapter as PagedListAdapter<Any, BaseVh<*>>?)?.submitList(data as PagedList<Any>?)
    }

    @Suppress(WarningName.UNCHECKED_CAST)
    @JvmStatic
    @BindingAdapter(Tags.bindRvData)
    fun bindRvData(rv: RecyclerView, data: List<*>?) {
        (rv.adapter as BaseRvAdapter<Any, ViewDataBinding>?)?.setItems(
            data as List<Any>? ?: listOf()
        )
    }

    @Suppress(WarningName.UNCHECKED_CAST)
    @JvmStatic
    @BindingAdapter(Tags.bindRvData)
    fun bindRvData(vp: ViewPager2, data: List<*>?) {
        (vp.adapter as BaseRvAdapter<Any, ViewDataBinding>?)?.setItems(
            data as List<Any>?
                ?: listOf()
        )
    }

    @JvmStatic
    @BindingAdapter(Tags.bindVisibleGone)
    fun bindVisibleGone(v: View, isVisible: Boolean?) {
        v.visibility = if (isVisible == true) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter(Tags.bindVisibleInvisible)
    fun bindVisibleInvisible(v: View, isVisible: Boolean?) {
        v.visibility = if (isVisible == true) View.VISIBLE else View.INVISIBLE
    }

    @JvmStatic
    @BindingAdapter(Tags.bindItemDecoration)
    fun bindItemDecoration(rv: RecyclerView, itemDecoration: RecyclerView.ItemDecoration?) {
        itemDecoration?.let { rv.addItemDecoration(it) }
    }

    @JvmStatic
    @BindingAdapter(Tags.bindSpanCount)
    fun bindSpanCount(rv: RecyclerView, newSpanCount: Int?) {
        (rv.layoutManager as? GridLayoutManager)?.spanCount = newSpanCount ?: 1
    }

    @JvmStatic
    @BindingAdapter(Tags.bindIntAsText)
    fun bindIntAsText(tv: TextView, int: Int?) {
        int?.let { tv.text = it.toString() }
    }
}