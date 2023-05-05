package me.pi3ro.hub.menu

import me.pi3ro.hub.utils.CC
import me.pi3ro.hub.utils.ItemBuilder
import me.pi3ro.plib.menu.Button
import me.pi3ro.plib.menu.Menu
import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-05 @ 10:03
 **/
class ServerSelectorMenu : Menu() {

    val BLACK_PANE: Button = Button.placeholder(Material.STAINED_GLASS_PANE, DyeColor.BLACK.data, CC.translate("&7"))
    override fun getTitle(player: Player?): String {
        return CC.translate("&8Select a server to join")
    }

    override fun getButtons(player: Player?): MutableMap<Int, Button> {
        val buttons: MutableMap<Int, Button> = HashMap()
        buttons[getSlot(2,1)] = PracticeButton()
        buttons[getSlot(4,1)] = SoupButton()
        buttons[getSlot(6,1)] = TeamsButton()

        for (i in 0 until 27){
            buttons.putIfAbsent(i, BLACK_PANE)
        }

        return buttons
    }

    class PracticeButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add("&710 players")
            lore.add(" ")
            lore.add("&f● &bSeason X &fstarted &bJune 25th, 2022")
            lore.add("&f● &bMulti-Gamemode Arena PvP")
            lore.add("&f● &bServers all around the World")
            lore.add(" ")
            lore.add("&eJoin queue!")
            return ItemBuilder(Material.POTION)
                .setDisplayName("&b&lPractice")
                .setDurability(16421)
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {

        }
    }

    class SoupButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add("&715 players")
            lore.add(" ")
            lore.add("&f● &bSeason 5 &fstarted &bMarch 4th, 2022")
            lore.add("&f● &bOpen PvP Arena!")
            lore.add(" ")
            lore.add("&eJoin queue!")
            return ItemBuilder(Material.MUSHROOM_SOUP)
                .setDisplayName("&b&lSoupPvP")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {

        }
    }

    class TeamsButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add("&720 players")
            lore.add(" ")
            lore.add("&f● &aLite &bMap 3 &fbegins &bMarch 4th")
            lore.add("&f● &bOpen World Survival")
            lore.add("&f● &bTracking and Raiding")
            lore.add("&f● &bGold Economy")
            lore.add("&f● &bKits: &aEnabled")
            lore.add(" ")
            lore.add("&eJoin queue!")
            return ItemBuilder(Material.GOLD_INGOT)
                .setDisplayName("&b&lHCFTeams")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {

        }
    }
}