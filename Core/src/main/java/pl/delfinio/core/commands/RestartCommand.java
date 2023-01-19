package pl.delfinio.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.delfinio.core.utils.ChatUtil;

import java.util.concurrent.TimeUnit;

public class RestartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender.hasPermission("core.cmd.restart") && sender instanceof Player)) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &cNie masz uprawnień. &8(&7core.cmd.restart&8)"));
            return false;
        }
        for(Player all : Bukkit.getOnlinePlayers()) {
            all.sendTitle(ChatUtil.fixColor("&c&lZATRZYMANIE SERWERA"), ChatUtil.fixColor("Serwer zostanie wyłączony za 10 sekund. Przepraszamy za utrudnienia :("));
        }

        try { TimeUnit.SECONDS.sleep(10); } catch (InterruptedException e) {throw new RuntimeException(e);}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
        return false;
    }
}
