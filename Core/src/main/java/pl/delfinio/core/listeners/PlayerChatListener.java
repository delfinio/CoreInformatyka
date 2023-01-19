package pl.delfinio.core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import pl.delfinio.core.utils.ChatUtil;

public class PlayerChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        e.setFormat(ChatUtil.fixColor("&7" + e.getPlayer().getName() + ": ") + e.getMessage());
    }
}
