package me.pi3ro.hub.menu

import me.pi3ro.hub.menu.sub.OutfitMenu
import me.pi3ro.hub.menu.sub.ParticlesMenu
import me.pi3ro.hub.utils.CC
import me.pi3ro.hub.utils.ItemBuilder
import me.pi3ro.hub.utils.menu.Button
import me.pi3ro.hub.utils.menu.Menu
import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-06 @ 06:49
 **/
class CosmeticsMenu : Menu() {

    val BLACK_PANE: Button = Button.placeholder(Material.STAINED_GLASS_PANE, DyeColor.BLACK.data, CC.translate("&7"))
    override fun getTitle(player: Player?): String {
        return CC.translate("&8Cosmetics")
    }

    override fun getButtons(player: Player?): MutableMap<Int, Button> {
        val buttons: MutableMap<Int, Button> = HashMap()
        buttons[getSlot(2,1)] = OutfitButton()
        buttons[getSlot(4,1)] = ParticlesButton()
        buttons[getSlot(6,1)] = TagsButton()

        for (i in 0 until 27){
            buttons.putIfAbsent(i, BLACK_PANE)
        }

        return buttons
    }

    class OutfitButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add(" ")
            lore.add("&7Select the outfit you want to wear.")
            lore.add(" ")
            lore.add("&bSelected Outfit&7: &fDefault")
            lore.add(" ")
            lore.add("&eClick to view Outfit Designs.")
            return ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setDisplayName("&b&lOutfit")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
                .clearFlags()
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            player?.closeInventory()
            OutfitMenu().openMenu(player)
        }
    }

    class ParticlesButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add(" ")
            lore.add("&7Have particles spawn around")
            lore.add("&7or behind you as you move.")
            lore.add(" ")
            lore.add("&bUnlocked Particles&7: &f0/6 &7(0%)")
            lore.add("&bSelected Particle&7: &fNone")
            lore.add(" ")
            lore.add("&eClick to view list of Particles.")
            return ItemBuilder(Material.NETHER_STAR)
                .setDisplayName("&b&lParticles")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, slot: Int, clickType: ClickType?, hotbarSlot: Int) {
            player?.closeInventory()
            ParticlesMenu().openMenu(player)
        }
    }

    class TagsButton : Button(){
        override fun getButtonItem(player: Player?): ItemStack {
            val lore = mutableListOf<String>()
            lore.add(" ")
            lore.add("&7Select a chat tag to be")
            lore.add("&7displayed next your name.")
            lore.add(" ")
            lore.add("&bUnlocked Tags&7: &f0/50 &7(0%)")
            lore.add("&bSelected Tag&7: &fNone")
            lore.add(" ")
            lore.add("&eClick to view list of Tags.")
            return ItemBuilder(Material.ITEM_FRAME)
                .setDisplayName("&b&lTags")
                .setLore(lore)
                .build()
        }

        override fun clicked(player: Player?, clickType: ClickType?) {
            player?.closeInventory()
            player?.chat("/tags")
        }
    }
}