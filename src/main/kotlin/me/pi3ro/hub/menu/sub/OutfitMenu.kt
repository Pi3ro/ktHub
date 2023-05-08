package me.pi3ro.hub.menu.sub

import me.pi3ro.hub.cosmetics.OutfitManager
import me.pi3ro.hub.menu.ServerSelectorMenu
import me.pi3ro.hub.utils.CC
import me.pi3ro.hub.utils.ItemBuilder
import me.pi3ro.hub.utils.menu.Button
import me.pi3ro.hub.utils.menu.Menu
import org.bukkit.ChatColor
import org.bukkit.Color
import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-07 @ 15:53
 **/
class OutfitMenu : Menu() {

    val BLACK_PANE: Button = Button.placeholder(Material.STAINED_GLASS_PANE, DyeColor.BLACK.data, CC.translate("&7"))
    override fun getTitle(player: Player?): String {
        return CC.translate("&8Outfits")
    }

    override fun getButtons(player: Player?): MutableMap<Int, Button> {
        val buttons: MutableMap<Int, Button> = HashMap()
        buttons[getSlot(1,1)] = DarkRed()
        buttons[getSlot(2,1)] = Red()
        buttons[getSlot(3,1)] = Gold()
        buttons[getSlot(4,1)] = Yellow()
        buttons[getSlot(5,1)] = DarkGreen()
        for (i in 0 until 36){
            buttons.putIfAbsent(i, BLACK_PANE)
        }
        return buttons
    }

    class DarkRed : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.darkred"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.MAROON)
                .setDisplayName("&4&lDark Red Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.darkred")){
                OutfitManager.setArmor(player, Color.MAROON, "&4Dark Red Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class Red : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.red"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.RED)
                .setDisplayName("&c&lRed Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.red")){
                OutfitManager.setArmor(player, Color.ORANGE, "&4Red Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class Gold : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.gold"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.ORANGE)
                .setDisplayName("&6&lGold Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.gold")){
                OutfitManager.setArmor(player, Color.RED, "&6Gold Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class Yellow : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.yellow"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.YELLOW)
                .setDisplayName("&e&lYellow Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.yellow")){
                OutfitManager.setArmor(player, Color.YELLOW, "&eYellow Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class DarkGreen : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.darkgreen"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.OLIVE)
                .setDisplayName("&2&lDark Green Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.darkgreen")){
                OutfitManager.setArmor(player, Color.OLIVE, "&2&lDark Green Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }
}