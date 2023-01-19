package pl.delfinio.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.delfinio.core.utils.ChatUtil;

public class TpaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length<1) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &7Poprawne użycie: &u/tpa <nick>"));
            return false;
        }

        Player p = (Player) sender;
        Player target = Bukkit.getPlayerExact(args[0]);
        Player delfinio = Bukkit.getPlayerExact("delfinio");

        if(target==null) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &cGracz jest offline ziomeczku. :("));
            return false;
        }

        p.teleport(target);
        sender.sendMessage(ChatUtil.fixColor("&8>> &7Zostałeś przeteleportowany do gracza &u" + target.getName() + "&7." ));
        target.sendMessage(ChatUtil.fixColor("&8>> &7Gracz &u" + p.getName() + " &7przeteleportował się do Ciebie."));
        if(delfinio!=null) {
            delfinio.sendMessage(ChatUtil.fixColor("&8[&3&lT&b&lP&8] &8[&f" + p.getName() + " &b⥤˃ &f" + target.getName() + "&8]"));
        }
        return false;
    }
}
