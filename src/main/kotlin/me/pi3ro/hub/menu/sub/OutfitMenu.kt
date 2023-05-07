package me.pi3ro.hub.menu.sub

import me.pi3ro.hub.utils.CC
import me.pi3ro.hub.utils.menu.Button
import me.pi3ro.hub.utils.menu.Menu
import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.entity.Player

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
        for (i in 0 until 36){
            buttons.putIfAbsent(i, BLACK_PANE)
        }
        return buttons
    }
}