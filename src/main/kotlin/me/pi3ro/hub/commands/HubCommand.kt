package me.pi3ro.hub.commands

import me.pi3ro.hub.Hub
import me.pi3ro.hub.utils.CC
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-04 @ 12:56
 **/
class HubCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        return when {
            args.isEmpty() -> {
                sender.sendMessage(CC.translate("&cCorrect usage: /kthub <args>"))
                false
            }
            args.size == 1 && args[0].equals("setspawn", ignoreCase = true) -> {
                if (sender is Player) {
                    val config = Hub.instance?.config
                    val playerLocation = sender.location
                    config?.set("SPAWN.X", playerLocation.x)
                    config?.set("SPAWN.Y", playerLocation.y)
                    config?.set("SPAWN.Z", playerLocation.z)
                    config?.set("SPAWN.YAW", playerLocation.yaw)
                    config?.set("SPAWN.PITCH", playerLocation.pitch)
                    Hub.instance?.saveConfig()
                    sender.sendMessage(CC.translate("&b[Hub] &aSuccessfully setting up."))
                } else {
                    sender.sendMessage(CC.translate("&cThis command can only be executed by a player"))
                }
                true
            }
            else -> {
                false
            }
        }
    }
}