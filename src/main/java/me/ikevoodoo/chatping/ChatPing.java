package me.ikevoodoo.chatping;

import me.ikevoodoo.chatping.listeners.AsyncPlayerChatListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatPing extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
