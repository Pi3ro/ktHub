package me.pi3ro.hub.hotbar

import me.pi3ro.hub.menu.ServerSelectorMenu
import me.pi3ro.hub.utils.CC
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

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

    @EventHandler
    fun onInteract(event: PlayerInteractEvent){
        val player: Player = event.player
        if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK){
            val itemStack: ItemStack? = event.item
            if (itemStack == null || itemStack.type == Material.AIR) return;
            if (!itemStack.hasItemMeta() || !itemStack.itemMeta.hasDisplayName()) return;

            if (itemStack.type == Material.WATCH && itemStack.itemMeta.displayName.equals(CC.translate("&bServer Selector &7(Right Click)"))){
                ServerSelectorMenu().openMenu(player)
            }
        }
    }
}