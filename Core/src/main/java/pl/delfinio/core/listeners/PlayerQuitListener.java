package pl.delfinio.core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.delfinio.core.utils.ChatUtil;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(ChatUtil.fixColor("&8[&c-&8] &7" + e.getPlayer().getName()));
    }
}
