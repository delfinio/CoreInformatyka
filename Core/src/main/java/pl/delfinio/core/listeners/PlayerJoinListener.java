package pl.delfinio.core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.delfinio.core.utils.ChatUtil;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatUtil.fixColor("&8[&a+&8] &7" + e.getPlayer().getName()));
    }
}
