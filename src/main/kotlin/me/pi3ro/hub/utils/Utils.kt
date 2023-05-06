package me.pi3ro.hub.utils

import me.pi3ro.hub.Hub

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-05 @ 09:24
 **/
object Utils {
    @JvmStatic
    fun run(runnable: Runnable){
        Hub.getInstance().server?.scheduler?.runTask(Hub.getInstance(), runnable)
    }
}