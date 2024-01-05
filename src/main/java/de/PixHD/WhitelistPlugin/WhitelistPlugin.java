package de.PixHD.WhitelistPlugin;

import de.PixHD.WhitelistPlugin.Config.ConfigManager;
import de.PixHD.WhitelistPlugin.DiscordBot.EventListener.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class WhitelistPlugin extends JavaPlugin {

    private static final String PREFIX = ChatColor.GRAY + "[" + ChatColor.BLUE + "WhitelistPlugin" + ChatColor.GRAY + "] ";


    private static final String PLUGIN_NAME = "WhitelistPlugin";
    private ConfigManager config;
    private String botToken;
    private static ConsoleCommandSender console;

    private JDA bot;



    @Override
    public void onEnable() {
        console = Bukkit.getConsoleSender();
        config = new ConfigManager("config.yml");
        try {
            if(config.isTokenSet()) {
                botToken = config.getToken();
                sendMessage(ChatColor.GREEN + "The Plugin was enabled successfully! - Starting now the DiscordBot");

                JDABuilder builder = JDABuilder.createDefault(botToken);

                // Disable parts of the cache
                builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
                // Enable the bulk delete event
                builder.setBulkDeleteSplittingEnabled(false);
                // Set activity (like "playing Something")
                builder.setActivity(Activity.playing("Minecraft"));
                builder.addEventListeners(new MessageListener());
                bot = builder.build();

            }else {
                reloadConfig();
                saveConfig();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        saveConfig();
        sendMessage(ChatColor.GREEN + "The Plugin was disabled successfully!");
    }

    public static void sendMessage(String message) {
        console.sendMessage(PREFIX + message);
    }

    public static String getPluginName() {
        return PLUGIN_NAME;
    }



}
