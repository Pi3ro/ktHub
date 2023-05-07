package me.pi3ro.hub

import me.pi3ro.hub.commands.HubCommand
import me.pi3ro.hub.hotbar.Hotbar
import me.pi3ro.hub.hotbar.HotbarListener
import me.pi3ro.hub.listeners.PlayerListener
import me.pi3ro.hub.providers.ScoreboardProvider
import me.pi3ro.hub.providers.TablistProvider
import me.pi3ro.hub.utils.CC
import me.pi3ro.hub.utils.menu.MenuListener
import me.pi3ro.plib.scoreboard.Scoreboard
import me.pi3ro.plib.tab.Tablist
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-04 @ 12:24
 **/
class Hub : JavaPlugin() {

    override fun onEnable() {
        val config = File(dataFolder, "config.yml")
        val papi = if(server.pluginManager.getPlugin("PlaceholderAPI") != null) "&aEnabled" else "&cDisabled"
        if (!config.exists()){
            getConfig().options().copyDefaults(true)
            saveConfig()
        }
        log("===================================")
        log("&b&lHub &7(Kotlin)")
        log(" ")
        log("&bAuthor: &f" + description.authors)
        log("&bVersion: &f" + description.version)
        log("&bPlaceholderAPI: $papi")
        log("===================================")

        scoreboard = Scoreboard(this, ScoreboardProvider())
        scoreboard!!.ticks = 1

        Tablist(TablistProvider(), this, 20)

        getCommand("kthub").executor = HubCommand()
        getCommand("kthub").permission = "kthub.admin"
        server.pluginManager.registerEvents(Hotbar(), this)
        server.pluginManager.registerEvents(HotbarListener(), this)
        server.pluginManager.registerEvents(PlayerListener(), this)
        server.pluginManager.registerEvents(MenuListener(), this)
    }

    override fun onDisable() {
    }

    private fun log(msg: String){
        server.consoleSender.sendMessage(CC.translate(msg))
    }

    companion object {
        @JvmStatic
        var scoreboard: Scoreboard?= null
        fun getInstance() : Hub {
            return getPlugin(Hub::class.java)
        }
    }
}