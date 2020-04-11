package com.ss.boilerplate.platform

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.ss.boilerplate.BR
import com.ss.boilerplate.RequiresLayoutResId

abstract class BaseDialog : DialogFragment(), RequiresLayoutResId {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutRes(), container, false)
    }
}

abstract class MvvmDialog<BindingType : ViewDataBinding, NavState : BaseVm.NavState, Vm : BaseVm<NavState>> : BaseDialog(),
    Observer<NavState> {
    protected abstract val vm: Vm
    protected lateinit var binding: BindingType

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
        vm.navState.observe(this, this)
        return binding.root
    }
}

abstract class FullScreenMvvmDialog<BindingType : ViewDataBinding, NavState : BaseVm.NavState, Vm : BaseVm<NavState>> :
    MvvmDialog<BindingType, NavState, Vm>() {

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }
}