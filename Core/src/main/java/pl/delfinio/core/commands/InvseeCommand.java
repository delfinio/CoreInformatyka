package pl.delfinio.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.delfinio.core.utils.ChatUtil;

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender.hasPermission("core.cmd.invsee") && sender instanceof Player)) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &cNie masz uprawnień. &8(&7core.cmd.invsee&8)"));
            return false;
        }
        if(args.length<1) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &7Poprawne użycie: &u/invsee <nick>"));
            return false;
        }
        Player p = (Player) sender;
        Player target = Bukkit.getPlayerExact(args[0]);
        p.openInventory(target.getInventory());
        return false;
    }
}
