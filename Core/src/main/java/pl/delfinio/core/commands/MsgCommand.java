package pl.delfinio.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.delfinio.core.utils.ChatUtil;

public class MsgCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length<2) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &7Poprawne użycie: &u/msg <nick> <wiadomosc>"));
            return false;
        }

        String msg = ChatUtil.stringBuilder(args, 1);
        Player p = (Player) sender;
        Player target = Bukkit.getPlayerExact(args[0]);

        if(target==null) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &cGracz jest offline ziomeczku. :("));
            return false;
        }

        target.sendMessage(ChatUtil.fixColor("&b✉ &7[&f" + p.getName() + " &b⥤˃ &fJa&7] &e&l>> &f") + msg);
        p.sendMessage(ChatUtil.fixColor("&b✉ &7[&fJa &b⥤˃ &f" + target.getName() + "&7] &e&l>> &f") + msg);

        return false;
    }
}
