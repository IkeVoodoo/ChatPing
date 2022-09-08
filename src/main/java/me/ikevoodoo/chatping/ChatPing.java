package me.ikevoodoo.chatping;

import me.ikevoodoo.chatping.listeners.AsyncPlayerChatListener;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class ChatPing extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
    }
}
