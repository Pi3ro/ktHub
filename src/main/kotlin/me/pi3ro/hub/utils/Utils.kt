package me.pi3ro.hub.utils

import me.clip.placeholderapi.PlaceholderAPI
import me.pi3ro.hub.Hub
import org.bukkit.entity.Player

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

    fun parsePapi(player: Player, string: String) : String{
        return PlaceholderAPI.setPlaceholders(player, string);
    }
}