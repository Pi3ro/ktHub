package me.pi3ro.hub.listeners

import me.pi3ro.hub.Hub
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.FoodLevelChangeEvent
import org.bukkit.event.player.PlayerJoinEvent

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-04 @ 20:18
 **/
class PlayerListener : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent){
        val player: Player = event.player
        player.health = 20.0
        player.foodLevel = 20
        //player.inventory.clear()
        toSpawn(player)
    }

    @EventHandler
    fun onDamage(event: EntityDamageEvent){
        if (event.entity is Player){
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onChangeFood(event: FoodLevelChangeEvent){
        event.isCancelled = true
    }

    @EventHandler
    fun onBreak(event: BlockBreakEvent){
        event.isCancelled = true
    }

    fun toSpawn(player: Player){
        val location = player.location
        val config = Hub.instance?.config
        val x = config?.getDouble("SPAWN.X")
        val y = config?.getDouble("SPAWN.Y")
        val z = config?.getDouble("SPAWN.Z")
        val yaw = config?.getDouble("SPAWN.YAW")?.toFloat()
        val pitch = config?.getDouble("SPAWN.PITCH")?.toFloat()
        location.x = x!!
        location.y = y!!
        location.z = z!!
        location.yaw = yaw!!
        location.pitch = pitch!!
        player.teleport(location)
    }
}