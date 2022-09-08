package me.ikevoodoo.chatping.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import org.apache.commons.lang3.tuple.Pair;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChatProcessingUtils {

    private static final char PING_PREFIX = '@';
    private static final String PING_COLOR = "§e";
    private static final String PING_RESET = "§r";

    public static Pair<String, Set<Player>> parse(String message) {
        Set<Player> pingedPlayers = new HashSet<>();

        if (!message.contains(String.valueOf(PING_PREFIX)))
            return Pair.of(message, pingedPlayers);

        String msg = message;
        for (int i = msg.length() - 2; i >= 0; i--) {
            char curr = msg.charAt(i);
            char prev = msg.charAt(i + 1);
            if (curr == PING_PREFIX) {
                List<Player> matches = Bukkit.matchPlayer(String.valueOf(prev));
                if (matches.isEmpty()) continue;
                matches = matches.stream().sorted((plrA, plrB) -> Integer.compare(plrB.getName().length(), plrA.getName().length())).toList();
                for (Player player : matches) {
                    if (msg.startsWith(PING_PREFIX + player.getName(), i)) {
                        pingedPlayers.add(player);
                        msg = msg.substring(0, i) + PING_COLOR + PING_PREFIX + player.getName() + PING_RESET + msg.substring(i + player.getName().length() + 1);
                        break;
                    }
                }
            }
        }

        return Pair.of(msg, pingedPlayers);
    }

}
