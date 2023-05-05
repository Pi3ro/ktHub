package me.pi3ro.hub.utils.tab.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.pi3ro.hub.utils.tab.skin.Skin;

@Setter
@Accessors(chain = true)
@Getter
@AllArgsConstructor
public class TabEntry {

    public TabEntry(int column, int row, String text) {
        this(column, row, text, 0, Skin.DEFAULT_SKIN);
    }

    private final int column;
    private final int row;

    private final String text;

    private int ping = 0;
    private Skin skin = Skin.DEFAULT_SKIN;
}
