package pl.delfinio.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.delfinio.core.utils.ChatUtil;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("core.cmd.broadcast")) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &cNie masz uprawnień. &8(&7core.cmd.broadcast&8)"));
            return false;
        }
        if(args.length<1) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &7Poprawne użycie: &u/bc <wiadomosc>"));
            return false;
        }

        String msg = ChatUtil.stringBuilder(args, 0);

        Bukkit.broadcastMessage(ChatUtil.fixColor("&c&lUWAGA! &7" + msg));

        return false;
    }
}
