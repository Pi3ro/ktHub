package me.pi3ro.hub.hotbar

import me.pi3ro.hub.utils.CC
import me.pi3ro.hub.utils.ItemBuilder
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-04 @ 20:01
 **/
class Hotbar : Listener {

    @EventHandler
    fun setHotbar(event: PlayerJoinEvent){
        val player: Player = event.player
        /* Server Selector */
        val selector = ItemBuilder(Material.WATCH)
            .setDisplayName(CC.translate("&bServer Selector &7(Right Click)"))
            .setLore("&7Opens the Server Selector menu.")
            .build()

        /* Ender Butt */
        val enderButt = ItemBuilder(Material.ENDER_PEARL)
            .setDisplayName(CC.translate("&bEnder Butt &7(Right Click)"))
            .setLore("&7")
            .build()

        val inv = player.inventory
        inv.setItem(3, selector)
        inv.setItem(5, enderButt)
    }
}