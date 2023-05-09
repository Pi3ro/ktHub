package me.pi3ro.hub.menu.sub

import me.pi3ro.hub.cosmetics.OutfitManager
import me.pi3ro.hub.menu.CosmeticsMenu
import me.pi3ro.hub.utils.CC
import me.pi3ro.hub.utils.ItemBuilder
import me.pi3ro.hub.utils.menu.Button
import me.pi3ro.hub.utils.menu.pagination.PaginatedMenu
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
class OutfitMenu : PaginatedMenu() {

    val BLACK_PANE: Button = Button.placeholder(Material.STAINED_GLASS_PANE, DyeColor.BLACK.data, CC.translate("&7"))
    override fun getPrePaginatedTitle(player: Player?): String {
        return CC.translate("&8Outfits")
    }

    override fun getAllPagesButtons(player: Player?): MutableMap<Int, Button> {
        val buttons: MutableMap<Int, Button> = HashMap()
        buttons[getSlot(1,0)] = DarkRed()
        buttons[getSlot(2,0)] = Red()
        buttons[getSlot(3,0)] = Gold()
        buttons[getSlot(4,0)] = Yellow()
        buttons[getSlot(5,0)] = DarkGreen()
        buttons[getSlot(6,0)] = Green()
        buttons[getSlot(7,0)] = Aqua()
        buttons[getSlot(1,1)] = DarkAqua()
        buttons[getSlot(2,1)] = DarkBlue()
        buttons[getSlot(3,1)] = Blue()
        buttons[getSlot(4,1)] = Pink()
        buttons[getSlot(5,1)] = Purple()
        buttons[getSlot(6,1)] = Gray()
        buttons[getSlot(7,1)] = DarkGray()
        buttons[getSlot(8,2)] = BackButton()
        for (i in 0 until 27){
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
                .setLeatherArmorColor(Color.GREEN)
                .setDisplayName("&2&lDark Green Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.darkgreen")){
                OutfitManager.setArmor(player, Color.GREEN, "&2&lDark Green Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class Green : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.green"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.LIME)
                .setDisplayName("&a&lGreen Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.green")){
                OutfitManager.setArmor(player, Color.LIME, "&a&lGreen Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class Aqua : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.aqua"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.AQUA)
                .setDisplayName("&b&lAqua Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.aqua")){
                OutfitManager.setArmor(player, Color.AQUA, "&b&lAqua Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class DarkAqua : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.darkaqua"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.TEAL)
                .setDisplayName("&3&lDark Aqua Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.darkaqua")){
                OutfitManager.setArmor(player, Color.TEAL, "&3&lDark Aqua Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class DarkBlue : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.darkblue"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.NAVY)
                .setDisplayName("&1&lDark Blue Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.darkblue")){
                OutfitManager.setArmor(player, Color.NAVY, "&1&lDark Blue Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class Blue : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.blue"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.BLUE)
                .setDisplayName("&9&lBlue Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.blue")){
                OutfitManager.setArmor(player, Color.BLUE, "&9&lBlue Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class Pink : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.pink"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.FUCHSIA)
                .setDisplayName("&d&lPink Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.pink")){
                OutfitManager.setArmor(player, Color.FUCHSIA, "&d&lPink Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class Purple : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.purple"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.PURPLE)
                .setDisplayName("&5&lPurple Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.purple")){
                OutfitManager.setArmor(player, Color.PURPLE, "&5&lPurple Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class Gray : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.gray"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.SILVER)
                .setDisplayName("&7&lGray Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.gray")){
                OutfitManager.setArmor(player, Color.SILVER, "&7&lGray Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class DarkGray : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            if (player!!.hasPermission("hub.outfit.darkgray"))
                lore.add("&aClick to update your armor!")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setLeatherArmorColor(Color.GRAY)
                .setDisplayName("&8&lDark Gray Outfit")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            if (player!!.hasPermission("hub.outfit.darkgray")){
                OutfitManager.setArmor(player, Color.GRAY, "&8&lDark Gray Armor")
                player.sendMessage(CC.translate("&aYour armor has been updated."))
            } else {
                player.sendMessage(CC.translate("&cYou don't have this outfit, you can purchase them at &fserver.gg/store&c."));
            }
        }
    }

    class BackButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add(" ")
            lore.add("&cClick here to return to")
            lore.add("&cthe previous menu.")
            return ItemBuilder(Material.REDSTONE)
                .setDisplayName("&c&lBack")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            CosmeticsMenu().openMenu(player)
        }
    }
}