package com.example.mylibrary

import androidx.fragment.app.FragmentActivity

/**
 *
 * -----------------------------------------------------------------
 * Copyright (C) 2021, by Sumpay, All rights reserved.
 * -----------------------------------------------------------------
 * desc: PermissionHelper
 * Author: wangjp
 * Email: wangjp1@fosun.com
 * Version: Vx.x.x
 * Create: 2021/6/7 4:26 下午
 *
 *
 */
object PermissionHelper {
    private const val TAG = "InvisibleFragment"

    fun request(
        activity: FragmentActivity,
        vararg permissions: String,
        callback: PermissionCallback
    ) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null) {
            existedFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment.newInstance("", "")
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestPermission(callback, *permissions)
    }
}