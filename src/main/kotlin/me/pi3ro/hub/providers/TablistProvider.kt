package me.pi3ro.hub.providers

import me.pi3ro.plib.tab.adapter.TabAdapter
import me.pi3ro.plib.tab.entry.TabEntry
import org.bukkit.entity.Player

/**
 * Created by: Pi3ro
 * Project: ktHub
 * Date: 2023-05-05 @ 09:16
 **/
class TablistProvider : TabAdapter {
    override fun getHeader(player: Player?): String {
        return " "
    }

    override fun getFooter(player: Player?): String {
        return " "
    }

    override fun getLines(player: Player?): MutableList<TabEntry> {
        val lines = mutableListOf<TabEntry>()
        lines.add(TabEntry(1,0,"&3&lServer Network"))
        lines.add(TabEntry(1,1,"&7Connect @ server.gg"))

        lines.add(TabEntry(0,3,"&b&lPractice"))
        lines.add(TabEntry(1,3,"&bSoupPvP"))
        lines.add(TabEntry(2,3,"&b&lMCTeams"))

        lines.add(TabEntry(0,4,"&fSeason: &b10"))
        lines.add(TabEntry(1,4,"&fSeason: &b5"))
        lines.add(TabEntry(2,4,"&fMap: &b9"))

        lines.add(TabEntry(0,5,"&fPlayers: &b5"))
        lines.add(TabEntry(1,5,"&fPlayers: &b10"))
        lines.add(TabEntry(2,5,"&fPlayers: &b35"))
        return lines
    }
}