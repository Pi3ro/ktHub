package me.pi3ro.hub.listeners

import me.pi3ro.hub.Hub
import me.pi3ro.hub.cosmetics.particles.EnchantmentParticle
import me.pi3ro.hub.utils.CC
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPhysicsEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.FoodLevelChangeEvent
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.player.PlayerPickupItemEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.weather.WeatherChangeEvent
import java.util.*

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-04 @ 20:18
 **/
class PlayerListener : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent){
        val player: Player = event.player

        for (toHide: Player in Bukkit.getServer().onlinePlayers) {
            for (player: Player in Bukkit.getServer().onlinePlayers) {
                if (player != toHide) {
                    player.hidePlayer(toHide)
                }
            }
        }

        val messages = listOf(
            "&7&m-----------------------------------------------------",
            " ",
            "&fWelcome to the &3Server Network&f!",
            " ",
            "&f● &bWebsite: &fserver.gg",
            "&f● &bStore: &fserver.gg/store",
            "&f● &bTeamSpeak: &fts.server.gg",
            "&f● &bDiscord: &fserver.gg/discord",
            "&f● &bTwitter: &ftwitter.com/server",
            " ",
            "&7&m-----------------------------------------------------")
        event.joinMessage = null
        player.gameMode = GameMode.SURVIVAL
        player.health = 20.0
        player.foodLevel = 20
        toSpawn(player)
        messages.forEach { player.sendMessage(CC.translate(it)) }
        player.updateInventory()
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent){
        val player:Player = event.player
        event.quitMessage = null
        player.inventory.clear()
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
    fun onWeather(event: WeatherChangeEvent){
        event.isCancelled = true
    }

    @EventHandler
    fun onDrop(event: PlayerDropItemEvent){
        val player: Player = event.player
        event.isCancelled = !(player.isOp && player.gameMode == GameMode.CREATIVE)
    }

    @EventHandler
    fun onPickup(event: PlayerPickupItemEvent){
        val player: Player = event.player
        event.isCancelled = !(player.isOp && player.gameMode == GameMode.CREATIVE)
    }

    @EventHandler
    fun onBreak(event: BlockBreakEvent){
        val player: Player = event.player
        event.isCancelled = !(player.isOp && player.gameMode == GameMode.CREATIVE)
    }

    @EventHandler
    fun onPlace(event: BlockPlaceEvent){
        val player: Player = event.player
        event.isCancelled = !(player.isOp && player.gameMode == GameMode.CREATIVE)
    }

    @EventHandler
    fun onPhysicsBlocks(event: BlockPhysicsEvent){
        event.isCancelled = true
    }

    @EventHandler
    fun onMobSpawn(event: CreatureSpawnEvent){
        event.isCancelled = true
    }

    @EventHandler
    fun onClickInventory(event: InventoryClickEvent){
        if (event.slot < 9) event.isCancelled = true
    }

    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent){
        val player: Player = event.player
        if (player.location.y < 0 && event.to.y != event.from.y){
            toSpawn(player)
        }
    }

    fun toSpawn(player: Player){
        val location = player.location
        val config = Hub.getInstance().config
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