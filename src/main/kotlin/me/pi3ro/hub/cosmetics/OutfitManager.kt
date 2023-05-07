package me.pi3ro.hub.cosmetics

import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.LeatherArmorMeta

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-07 @ 15:46
 **/
class OutfitManager {

    fun createOutfitArmor(material: Material, color: Color, name: String) : ItemStack {
        val itemStack: ItemStack = ItemStack(material)
        val outfitArmorMeta: LeatherArmorMeta = itemStack.itemMeta as LeatherArmorMeta
        outfitArmorMeta.color = color
        outfitArmorMeta.displayName = name
        itemStack.itemMeta = outfitArmorMeta
        return itemStack
    }

    fun setArmor(player: Player, color: Color, name: String){
        val helmet: ItemStack = createOutfitArmor(Material.LEATHER_HELMET, color, name)
        val chestplate: ItemStack = createOutfitArmor(Material.LEATHER_CHESTPLATE, color, name)
        val leggings: ItemStack = createOutfitArmor(Material.LEATHER_LEGGINGS, color, name)
        val boots: ItemStack = createOutfitArmor(Material.LEATHER_BOOTS, color, name)

        player.inventory.helmet = helmet
        player.inventory.chestplate = chestplate
        player.inventory.leggings = leggings
        player.inventory.boots = boots
    }
}