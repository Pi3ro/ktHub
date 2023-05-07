package me.pi3ro.hub.menu.sub

import me.pi3ro.hub.Hub
import me.pi3ro.hub.cosmetics.particles.EnchantmentParticle
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
                .setDisplayName("&b&lEnchantment Particle")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            player?.sendMessage("&aParticle: Enchantment")
        }
    }
}