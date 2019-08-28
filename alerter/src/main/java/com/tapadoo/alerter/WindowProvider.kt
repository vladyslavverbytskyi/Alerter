package com.tapadoo.alerter

import android.view.Window

interface WindowProvider {

    fun provideWindow(): Window
}