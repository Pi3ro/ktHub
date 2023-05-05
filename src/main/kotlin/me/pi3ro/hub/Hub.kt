package me.pi3ro.hub

import me.pi3ro.hub.commands.HubCommand
import me.pi3ro.hub.hotbar.Hotbar
import me.pi3ro.hub.hotbar.HotbarListener
import me.pi3ro.hub.listeners.PlayerListener
import me.pi3ro.hub.utils.CC
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-04 @ 12:24
 **/
class Hub : JavaPlugin() {

    override fun onEnable() {
        instance = this
        val config = File(dataFolder, "config.yml")
        if (!config.exists()){
            getConfig().options().copyDefaults(true)
            saveConfig()
        }
        log("===================================")
        log("&b&lHub &7(Kotlin)")
        log(" ")
        log("&bAuthor: &f" + description.authors)
        log("&bVersion: &f" + description.version)
        log("===================================")

        getCommand("kthub").executor = HubCommand()
        server.pluginManager.registerEvents(Hotbar(), this)
        server.pluginManager.registerEvents(HotbarListener(), this)
        server.pluginManager.registerEvents(PlayerListener(), this)
    }

    override fun onDisable() {
        instance = null
    }

    fun log(msg: String){
        server.consoleSender.sendMessage(CC.translate(msg))
    }

    companion object {
        @JvmStatic
        var instance: Hub? = null
            private set
    }
}