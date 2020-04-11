package com.ss.boilerplate.widget.rv

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ss.boilerplate.RequiresVhLayoutResId

abstract class BaseRvAdapter<ItemType, BindingType : ViewDataBinding> : RecyclerView.Adapter<BaseVh<BindingType>>(),
    RequiresVhLayoutResId {
    protected val dataSet = ArrayList<ItemType>()

    override fun getItemCount() = dataSet.size
    fun getItem(position: Int) = dataSet[position]

    open fun setItems(newData: List<ItemType>) {
        dataSet.clear()
        dataSet.addAll(newData)
        notifyDataSetChanged()
    }

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseVh.inflate<BindingType>(parent, getLayoutRes(viewType))
}

abstract class DiffCapableRvAdapter<ItemType, BindingType : ViewDataBinding> : BaseRvAdapter<ItemType, BindingType>() {
    override fun setItems(newData: List<ItemType>) {
        val diffResult = DiffUtil.calculateDiff(getDiffCallback(dataSet, newData))
        dataSet.clear()
        dataSet.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }

    protected abstract fun areItemsTheSame(oldItem: ItemType, newItem: ItemType): Boolean
    protected abstract fun areContentsTheSame(oldItem: ItemType, newItem: ItemType): Boolean

    private fun getDiffCallback(oldData: List<ItemType>, newData: List<ItemType>): DiffUtil.Callback {
        return object : DiffUtil.Callback() {
            override fun getOldListSize() = oldData.size
            override fun getNewListSize() = newData.size
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = areItemsTheSame(oldData[oldItemPosition], newData[newItemPosition])

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = areContentsTheSame(oldData[oldItemPosition], newData[newItemPosition])
        }
    }
}