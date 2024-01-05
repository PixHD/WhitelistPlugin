package de.PixHD.WhitelistPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class WhitelistPlugin extends JavaPlugin {

    private final String PREFIX = ChatColor.GRAY + "[" + ChatColor.BLUE + "WhitelistPlugin" + ChatColor.GRAY + "] ";

    private ConsoleCommandSender console;



    @Override
    public void onEnable() {
        console = Bukkit.getConsoleSender();
        sendMessage(ChatColor.GREEN + "The Plugin was enabled successfully!");
    }

    @Override
    public void onDisable() {
        sendMessage(ChatColor.GREEN + "The Plugin was disabled successfully!");
    }

    public void sendMessage(String message) {
        console.sendMessage(PREFIX + message);
    }


}
