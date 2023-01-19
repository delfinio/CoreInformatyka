package pl.delfinio.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.delfinio.core.commands.*;
import pl.delfinio.core.listeners.PlayerChatListener;
import pl.delfinio.core.listeners.PlayerJoinListener;
import pl.delfinio.core.listeners.PlayerQuitListener;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("-----( Core )-----");
        getLogger().info(">> Autor: delfinio");
        getLogger().info(">> Wersja:" + getDescription().getVersion());
        getLogger().info("");
        getLogger().info(">> UWAGA: WTYCZKA JEST DEDYKOWANA DLA SERWERA MAREKBURAK.MAXCRAFT.PL UZYWANIE JEJ GDZIEKOLWIEK INDZIEJ JEST SUROWO ZABRONIONE");
        getLogger().info("");
        getLogger().info("Pomyślnie załadowano Core....");
        getLogger().info("-----( Core )-----");

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerChatListener(), this);

        getCommand("invsee").setExecutor(new InvseeCommand());
        getCommand("whois").setExecutor(new WhoisCommand());
        getCommand("restart").setExecutor(new RestartCommand());
        getCommand("msg").setExecutor(new MsgCommand());
        getCommand("tpa").setExecutor(new TpaCommand());
        getCommand("bc").setExecutor(new BroadcastCommand());
        getCommand("rl").setExecutor(new RlCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
