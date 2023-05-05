package me.pi3ro.hub.utils

import org.bukkit.ChatColor

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-04 @ 12:42
 **/
object CC {
    fun translate(msg: String?): String{
        return ChatColor.translateAlternateColorCodes('&', msg)
    }
}