package com.ss.boilerplate.timber

import timber.log.Timber

class PowerfulDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement) = String.format("%s::%s:", super.createStackElementTag(element), element.methodName)
}