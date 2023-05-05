package me.pi3ro.hub.hotbar

import org.bukkit.Material
import org.bukkit.entity.Player
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
    fun onEnderButt(event: PlayerInteractEvent) {
        if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
            val player: Player = event.player
            if (player.itemInHand.type == Material.ENDER_PEARL) {
                event.isCancelled = true
                event.setUseInteractedBlock(Event.Result.DENY)
                event.setUseItemInHand(Event.Result.DENY)
                player.velocity = player.location.direction.normalize().multiply(2.5)
                player.updateInventory()
            }
        }
    }
}