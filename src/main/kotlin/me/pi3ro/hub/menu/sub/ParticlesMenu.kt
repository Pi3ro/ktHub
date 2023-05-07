package me.pi3ro.hub.menu.sub

import me.pi3ro.hub.Hub
import me.pi3ro.hub.cosmetics.particles.EnchantmentParticle
import me.pi3ro.hub.menu.CosmeticsMenu
import me.pi3ro.hub.menu.ServerSelectorMenu
import me.pi3ro.hub.utils.CC
import me.pi3ro.hub.utils.ItemBuilder
import me.pi3ro.hub.utils.menu.Button
import me.pi3ro.hub.utils.menu.pagination.PaginatedMenu
import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-07 @ 10:14
 **/
class ParticlesMenu : PaginatedMenu() {

    val BLACK_PANE: Button = Button.placeholder(Material.STAINED_GLASS_PANE, DyeColor.BLACK.data, CC.translate("&7"))
    override fun getPrePaginatedTitle(player: Player?): String {
        return CC.translate("&8Particles")
    }

    override fun getAllPagesButtons(player: Player?): MutableMap<Int, Button>? {
        val buttons: MutableMap<Int, Button> = HashMap()
        buttons[getSlot(1,0)] = BasicButton()
        buttons[getSlot(2,0)] = MasterButton()
        buttons[getSlot(3,0)] = LegendButton()
        buttons[getSlot(4,0)] = EpicButton()
        buttons[getSlot(5,0)] = KingButton()
        buttons[getSlot(6,0)] = StaffButton()
        buttons[getSlot(8,1)] = BackButton()
        for (i in 0 until 18){
            buttons.putIfAbsent(i, BLACK_PANE)
        }
        return buttons
    }

    class BasicButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add(" ")
            lore.add("&eEnchantment particle spawn around your player.")
            lore.add("&eUnlock this particle with &7Basic &erank.")
            lore.add(" ")
            if (player!!.hasPermission("hub.particle.basic"))
                lore.add("&aApply this effect.")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.ENCHANTED_BOOK)
                .setDisplayName("&b&lBasic Particle")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            player?.sendMessage("&aParticle: Enchantment")
        }
    }

    class MasterButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add(" ")
            lore.add("&eHappy Villager particle spawn around your player.")
            lore.add("&eUnlock this particle with &6Master &erank.")
            lore.add(" ")
            if (player!!.hasPermission("hub.particle.master"))
                lore.add("&aApply this effect.")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.HAY_BLOCK)
                .setDisplayName("&b&lMaster Particle")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            player?.sendMessage("&aParticle: Happy Villager")
        }
    }

    class LegendButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add(" ")
            lore.add("&eLava Droplets particle spawn around your player.")
            lore.add("&eUnlock this particle with &3Legend &erank.")
            lore.add(" ")
            if (player!!.hasPermission("hub.particle.legend"))
                lore.add("&aApply this effect.")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.LAVA_BUCKET)
                .setDisplayName("&b&lLegend Particle")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            player?.sendMessage("&aParticle: Lava Droplets")
        }
    }

    class EpicButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add(" ")
            lore.add("&eWater Droplets particle spawn around your player.")
            lore.add("&eUnlock this particle with &9Epic &erank.")
            lore.add(" ")
            if (player!!.hasPermission("hub.particle.epic"))
                lore.add("&aApply this effect.")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.WATER_BUCKET)
                .setDisplayName("&b&lEpic Particle")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            player?.sendMessage("&aParticle: Water Droplets")
        }
    }

    class KingButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add(" ")
            lore.add("&eRainbow Double Helix particle spawn around your player.")
            lore.add("&eUnlock this particle with &2King &erank.")
            lore.add(" ")
            if (player!!.hasPermission("hub.particle.king"))
                lore.add("&aApply this effect.")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.NETHER_STAR)
                .setDisplayName("&b&lEpic Particle")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            player?.sendMessage("&aParticle: Rainbow Double Helix")
        }
    }

    class StaffButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add(" ")
            lore.add("&eUnlock this particle by becoming Staff.")
            lore.add(" ")
            if (player!!.hasPermission("hub.particle.staff"))
                lore.add("&aApply this effect.")
            else
                lore.add("&cYou don't own this effect.")
            return ItemBuilder(Material.EMERALD)
                .setDisplayName("&b&lStaff Particle")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            player?.sendMessage("&aParticle: Staff")
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