package me.ikevoodoo.chatping.listeners;

import me.ikevoodoo.chatping.utils.ChatProcessingUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Set;

public class AsyncPlayerChatListener implements Listener {

    @EventHandler
    public void on(AsyncPlayerChatEvent event) {
        Pair<String, Set<Player>> parsed = ChatProcessingUtils.parse(event.getMessage());
        event.setMessage(parsed.getLeft());

        parsed.getRight().forEach(player -> {
            if (player != null) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1, 1);
            }
        });
    }
}