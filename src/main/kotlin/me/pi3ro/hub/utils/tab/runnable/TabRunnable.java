package me.pi3ro.hub.utils.tab.runnable;

import lombok.AllArgsConstructor;
import me.pi3ro.hub.utils.tab.TablistException;
import me.pi3ro.hub.utils.tab.adapter.TabAdapter;
import me.pi3ro.hub.utils.tab.entry.TabEntry;
import me.pi3ro.hub.utils.tab.layout.TabLayout;
import me.pi3ro.hub.utils.tab.skin.Skin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class TabRunnable implements Runnable {

    private TabAdapter adapter;

    @Override
    public void run() {
        try {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player != null && player.isOnline()) {
                    TabLayout layout = TabLayout.getLayoutMapping().get(player.getUniqueId());

                    if (layout == null) continue;

                    try {
                        for (TabEntry entry : adapter.getLines(player)) {
                            layout.setHeaderAndFooter();
                            layout.update(entry.getColumn(), entry.getRow(), entry.getText(), entry.getPing(), entry.getSkin());
                        }

                        for (int row = 0; row < 20; row++) {
                            for (int column = 0; column < 4; column++) {
                                if (layout.getByLocation(adapter.getLines(player), column, row) == null) {
                                    layout.update(column, row, "", 0, Skin.DEFAULT_SKIN);
                                }
                            }
                        }
                    } catch (Exception ex) {
                        if (layout.getExceptions().incrementAndGet() > 3) {
                            TabLayout.getLayoutMapping().remove(player.getUniqueId());
                        }

                        ex.printStackTrace();
                        throw new TablistException("There was an error updating " + player.getName() + "'s tablist.");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
