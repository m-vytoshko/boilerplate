package com.ss.boilerplate.platform

import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.ss.boilerplate.BR
import com.ss.boilerplate.RequiresLayoutResId
import com.ss.boilerplate.RequiresViewId
import com.ss.boilerplate.RequiresWindowInsets
import com.ss.boilerplate.extensions.makeStatusBarTransparent

abstract class BaseActivity : AppCompatActivity(), RequiresLayoutResId {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
    }
}

abstract class MvvmActivity<BindingType : ViewDataBinding, NavState : BaseVm.NavState, Vm : BaseVm<NavState>> : AppCompatActivity(), RequiresLayoutResId, Observer<NavState> {
    protected abstract val vm: Vm
    protected lateinit var binding: BindingType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
        vm.navState.observe(this, this)
    }
}

abstract class NoStatusBarActivity : BaseActivity(), RequiresViewId, RequiresWindowInsets {
    private var windowInsets: WindowInsets? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.makeStatusBarTransparent()
        findViewById<View>(getViewId()).setOnApplyWindowInsetsListener { _, newWindowInsets ->
            this.windowInsets = newWindowInsets
            return@setOnApplyWindowInsetsListener newWindowInsets
        }
    }

    override fun getWindowInsets() = windowInsets
}