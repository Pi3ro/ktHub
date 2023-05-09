package me.pi3ro.hub.utils

import com.google.common.io.ByteArrayDataOutput
import com.google.common.io.ByteStreams
import me.clip.placeholderapi.PlaceholderAPI
import me.pi3ro.hub.Hub
import org.bukkit.entity.Player
import java.lang.Exception

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

    fun sendServer(player: Player, server: String){
        val out: ByteArrayDataOutput = ByteStreams.newDataOutput()
        try {
            out.writeUTF("Connect")
            out.writeUTF(server)
        } catch (e: Exception){
            e.printStackTrace()
        }
        player.sendPluginMessage(Hub.getInstance(), "BungeeCord", out.toByteArray())
    }
}