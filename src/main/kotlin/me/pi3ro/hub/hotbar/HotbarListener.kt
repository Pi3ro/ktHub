package me.pi3ro.hub.hotbar

import me.pi3ro.hub.menu.CosmeticsMenu
import me.pi3ro.hub.menu.ServerSelectorMenu
import me.pi3ro.hub.utils.CC
import org.bukkit.Material
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-04 @ 20:19
 **/
class HotbarListener : Listener {
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player = event.player
        val item = player.itemInHand

        if (event.action != Action.RIGHT_CLICK_AIR && event.action != Action.RIGHT_CLICK_BLOCK) {
            return
        }

        when (item.type) {
            Material.ENDER_PEARL -> {
                event.isCancelled = true
                event.setUseInteractedBlock(Event.Result.DENY)
                event.setUseItemInHand(Event.Result.DENY)
                player.velocity = player.location.direction.normalize().multiply(2.5)
                player.updateInventory()
            }
            Material.COMPASS -> {
                if (item.hasItemMeta() && item.itemMeta.hasDisplayName() && item.itemMeta.displayName.equals(CC.translate("&bServer Selector &7(Right Click)"), ignoreCase = true)) {
                    ServerSelectorMenu().openMenu(player)
                }
            }
            Material.NETHER_STAR -> {
                if (item.hasItemMeta() && item.itemMeta.hasDisplayName() && item.itemMeta.displayName.equals(CC.translate("&bCosmetics &7(Right Click)"), ignoreCase = true)) {
                    CosmeticsMenu().openMenu(player)
                }
            }
            else -> return
        }
    }
}