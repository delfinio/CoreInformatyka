package pl.delfinio.core.utils;

import org.bukkit.ChatColor;

public class ChatUtil {
    public static String fixColor(String message) {
        return ChatColor.translateAlternateColorCodes('&', message.replace(">>", "»").replace("&u", "&3"));

    }

    public static String stringBuilder(String[] args, int arg) {
        String msg = "";
        for (int i = arg; i < args.length; i++) {
            msg = msg + args[i];
            if (i <= args.length - 2)
                msg = msg + " ";
        }
        return msg;
    }
}
