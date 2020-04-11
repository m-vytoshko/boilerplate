package com.ss.boilerplate.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ss.boilerplate.BR
import com.ss.boilerplate.RequiresLayoutResId

abstract class BaseFragment : Fragment(), RequiresLayoutResId {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutRes(), container, false)
    }
}

abstract class MvvmFragment<BindingType : ViewDataBinding, Vm : BaseVm<*>> : BaseFragment() {
    protected abstract val vm: Vm
    protected lateinit var binding: BindingType

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
        return binding.root
    }
}

abstract class MvvmNavFragment<BindingType : ViewDataBinding, NavState : BaseVm.NavState, Vm : BaseVm<NavState>> :
    MvvmFragment<BindingType, Vm>(), Observer<NavState> {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = super.onCreateView(inflater, container, savedInstanceState)
        vm.navState.observe(viewLifecycleOwner, this)
        return v
    }
}