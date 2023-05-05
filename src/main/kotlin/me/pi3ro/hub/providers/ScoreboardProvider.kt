package me.pi3ro.hub.providers

import me.pi3ro.hub.utils.CC
import me.pi3ro.plib.scoreboard.ScoreboardAdapter
import me.pi3ro.plib.scoreboard.ScoreboardStyle
import org.bukkit.Bukkit
import org.bukkit.entity.Player

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-05 @ 08:50
 **/
class ScoreboardProvider : ScoreboardAdapter {
    override fun getTitle(player: Player?): String {
        return CC.translate("&3&lServer Network")
    }

    override fun getLines(player: Player?): MutableList<String> {
        val lines = mutableListOf<String>()
        lines.add("&7&m-------------------")
        lines.add("&bOnline:")
        lines.add("&f" + Bukkit.getOnlinePlayers().size)
        lines.add(" ")
        lines.add("&bRank: ")
        lines.add("&aDefault")
        lines.add(" ")
        lines.add("&bserver.gg")
        lines.add("&7&m-------------------")
        return lines
    }

    override fun getBoardStyle(player: Player?): ScoreboardStyle {
        return ScoreboardStyle.KOHI
    }
}