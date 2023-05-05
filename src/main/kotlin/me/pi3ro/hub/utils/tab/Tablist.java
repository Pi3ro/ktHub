package me.pi3ro.hub.utils.tab;

import lombok.Getter;
import me.pi3ro.hub.utils.tab.adapter.TabAdapter;
import me.pi3ro.hub.utils.tab.listener.TabListener;
import me.pi3ro.hub.utils.tab.packet.TabPacket;
import me.pi3ro.hub.utils.tab.runnable.TabRunnable;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class Tablist {

    @Getter private static Tablist instance;

    private final TabAdapter adapter;

    public Tablist(TabAdapter adapter, JavaPlugin plugin, long time) {
        instance = this;
        this.adapter = adapter;

        new TabPacket(plugin);

        Bukkit.getServer().getPluginManager().registerEvents(new TabListener(this), plugin);
        Bukkit.getServer().getScheduler().runTaskTimerAsynchronously(plugin, new TabRunnable(adapter), 60L, time); //TODO: async to run 1 millis
    }
}
