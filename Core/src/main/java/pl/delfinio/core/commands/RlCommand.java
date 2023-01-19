package pl.delfinio.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.delfinio.core.utils.ChatUtil;

import java.util.concurrent.TimeUnit;

public class RlCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender.hasPermission("core.cmd.reload") && sender instanceof Player)) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &cNie masz uprawnień. &8(&7core.cmd.reload&8)"));
            return false;
        }
        for(Player all : Bukkit.getOnlinePlayers()) {
            all.sendTitle(ChatUtil.fixColor("&a&lRELOAD"), ChatUtil.fixColor("Za 10 sekund nastąpi reload. Serwer może zlagować!"));
        }

        try { TimeUnit.SECONDS.sleep(10); } catch (InterruptedException e) {throw new RuntimeException(e);}

        for(Player all : Bukkit.getOnlinePlayers()) {
            all.sendTitle(ChatUtil.fixColor("&a&lRELOAD"), ChatUtil.fixColor("Serwer zostanie przeładowany. Potrwa to ok. 10 sekund"));
        }

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "reload confirm");
        return false;
    }
}
