package me.pi3ro.hub.utils.scoreboard.events;

import me.pi3ro.hub.utils.scoreboard.ScoreboardManager;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@Setter
public class ScoreboardCreatedEvent extends Event {

    @Getter public static HandlerList handlerList = new HandlerList();

    private boolean cancelled = false;
    private ScoreboardManager board;

    public ScoreboardCreatedEvent(ScoreboardManager board) {
        this.board = board;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
