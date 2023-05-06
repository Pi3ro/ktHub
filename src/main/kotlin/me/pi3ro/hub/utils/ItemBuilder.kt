package me.pi3ro.hub.utils

import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.inventory.meta.LeatherArmorMeta
import java.util.*

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-04 @ 19:49
 **/
class ItemBuilder {

    private val itemStack: ItemStack

    constructor(material: Material, n2: Int, n3: Int) {
        itemStack = if (n2 == 0) ItemStack(material, 1, n3.toShort()) else ItemStack(material, n2, n3.toShort())
    }

    constructor(material: Material) {
        itemStack = ItemStack(material)
    }

    constructor(itemStack: ItemStack, n2: Int) {
        this.itemStack = if (n2 == 0) itemStack else itemStack
    }

    fun setLeatherArmorColor(color: Color): ItemBuilder {
        val leatherArmorMeta = itemStack.itemMeta as LeatherArmorMeta
        leatherArmorMeta.color = color
        itemStack.itemMeta = leatherArmorMeta
        return this
    }

    fun setLeatherUnbreakable(): ItemBuilder {
        val leatherArmorMeta = itemStack.itemMeta as LeatherArmorMeta
        leatherArmorMeta.spigot().isUnbreakable = true
        itemStack.itemMeta = leatherArmorMeta
        return this
    }

    fun addEnchant(enchantment: Enchantment, n2: Int): ItemBuilder {
        val itemMeta = itemStack.itemMeta
        itemMeta.addEnchant(enchantment, n2, true)
        itemStack.itemMeta = itemMeta
        return this
    }

    fun addEnchant(enchantment: Enchantment, n2: Int, bl2: Boolean): ItemBuilder {
        if (bl2) {
            val itemMeta = itemStack.itemMeta
            itemMeta.addEnchant(enchantment, n2, true)
            itemStack.itemMeta = itemMeta
        }
        return this
    }

    fun addEnchantLeather(enchantment: Enchantment, n2: Int, bl2: Boolean): ItemBuilder {
        if (bl2) {
            val leatherArmorMeta = itemStack.itemMeta as LeatherArmorMeta
            leatherArmorMeta.addEnchant(enchantment, n2, true)
            itemStack.itemMeta = leatherArmorMeta
        }
        return this
    }

    fun setUnbreakableLeather(): ItemBuilder {
        val leatherArmorMeta = itemStack.itemMeta as LeatherArmorMeta
        leatherArmorMeta.spigot().isUnbreakable = true
        itemStack.itemMeta = leatherArmorMeta
        return this
    }

    fun setColorLeather(color: Color): ItemBuilder {
        val leatherArmorMeta = itemStack.itemMeta as LeatherArmorMeta
        leatherArmorMeta.color = color
        itemStack.itemMeta = leatherArmorMeta
        return this
    }

    fun addUnsafeEnchant(enchantment: Enchantment, n2: Int): ItemBuilder {
        itemStack.addUnsafeEnchantment(enchantment, n2)
        return this
    }

    fun setDisplayName(string: String): ItemBuilder {
        val itemMeta = itemStack.itemMeta
        itemMeta.displayName = CC.translate(string)
        itemStack.itemMeta = itemMeta
        return this
    }

    fun setLore(vararg arrstring: String): ItemBuilder {
        val itemMeta = itemStack.itemMeta
        itemMeta.lore = Arrays.asList(*arrstring)
        itemStack.itemMeta = itemMeta
        return this
    }

    fun setDurability(int: Int): ItemBuilder{
        itemStack.durability = int.toShort()
        return this
    }

    fun setLore(list: List<String>): ItemBuilder {
        if (list.isEmpty()) {
            return this
        }
        val itemMeta: ItemMeta = itemStack.itemMeta
        val modifiedList = mutableListOf<String>()
        for (i in list.indices) {
            val string: String = list[i].replace("&", "§")
            modifiedList.add(string)
        }
        itemMeta.lore = modifiedList
        itemStack.itemMeta = itemMeta
        return this
    }

    fun setUnbreakable(): ItemBuilder{
        val itemMeta = itemStack.itemMeta
        itemMeta.spigot().isUnbreakable = true
        itemStack.itemMeta = itemMeta
        return this
    }

    fun clearFlags(): ItemBuilder{
        val itemMeta = itemStack.itemMeta
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_PLACED_ON)
        itemStack.itemMeta = itemMeta
        return this
    }

    fun build(): ItemStack {
        return this.itemStack
    }
}