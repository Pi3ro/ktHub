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
        player.inventory.clear()

        /* Server Selector */
        val selector = ItemBuilder(Material.COMPASS)
            .setDisplayName(CC.translate("&bServer Selector &7(Right Click)"))
            .setLore(CC.translate("&7Opens the Server Selector menu."))
            .build()

        /* Cosmetics */
        val cosmetics = ItemBuilder(Material.NETHER_STAR)
            .setDisplayName(CC.translate("&bCosmetics &7(Right Click)"))
            .build()

        /* Ender Butt */
        val enderButt = ItemBuilder(Material.ENDER_PEARL)
            .setDisplayName(CC.translate("&bEnder Butt &7(Right Click)"))
            .build()

        val inv = player.inventory
        inv.setItem(0, selector)
        inv.setItem(4, cosmetics)
        inv.setItem(8, enderButt)
    }
}