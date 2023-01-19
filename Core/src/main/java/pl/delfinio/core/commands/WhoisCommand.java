package pl.delfinio.core.commands;

import net.skinsrestorer.api.SkinsRestorerAPI;
import net.skinsrestorer.api.exception.SkinRequestException;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.delfinio.core.utils.ChatUtil;

public class WhoisCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("core.cmd.whois")) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &cNie masz uprawnień. &8(&7core.cmd.broadcast&8)"));
            return false;
        }
        if(args.length<1) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &7Poprawne użycie: &u/whois <nick>"));
            return false;
        }
        Player target = Bukkit.getPlayerExact(args[0]);
        if(target==null) {
            sender.sendMessage(ChatUtil.fixColor("&8>> &cGracz jest offline."));
            return false;
        }

        String ip = String.valueOf(target.getAddress().getAddress()).replace("/", "");
        int hp = (int) target.getHealth();

        sender.sendMessage(ChatUtil.fixColor("&8&m----------&8( &u&lWHOIS &8)&8&m----------"));
        sender.sendMessage(ChatUtil.fixColor("&8>> &7Informacje o graczu: &u" + args[0]));
        sender.sendMessage(ChatUtil.fixColor(""));
        sender.sendMessage(ChatUtil.fixColor("&7IP&8: &u" + ip));
        sender.sendMessage(ChatUtil.fixColor("&7UUID&8: &u" + target.getUniqueId().toString()));
        sender.sendMessage(ChatUtil.fixColor("&7Tryb gry&8: &u" + target.getGameMode().toString()));
        sender.sendMessage(ChatUtil.fixColor("&7Exp&8: &u" + target.getExpToLevel() + " LVL &8(" + target.getExp()));
        sender.sendMessage(ChatUtil.fixColor("&7Hp&8: &u" + hp));
        sender.sendMessage(ChatUtil.fixColor("&8&m----------&8( &u&lWHOIS &8)&8&m----------"));

        return false;
    }
}