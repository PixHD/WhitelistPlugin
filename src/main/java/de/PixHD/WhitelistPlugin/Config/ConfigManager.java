package de.PixHD.WhitelistPlugin.Config;

import de.PixHD.WhitelistPlugin.WhitelistPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private final String TOKEN_VALUE = "discordBotToken";
    private final String CHANNEL_ID = "channelID";

    private String name;
    private File file;
    private FileConfiguration fileConfiguration;


    public ConfigManager(String name) {
        this.name = name;
        this.file = new File("plugins/" + WhitelistPlugin.getPluginName() + "/", name);
        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public boolean isTokenSet() throws Exception {
        if(file.exists()) {
            String token = fileConfiguration.getString(TOKEN_VALUE);
            if(token != null) {
                return true;
            }
        }else {
            fileConfiguration.set(TOKEN_VALUE, "exampleToken");
            fileConfiguration.set(CHANNEL_ID, "exampleID");
            saveFile();
            return false;
        }
        throw new Exception("The Discord Bot Token is not set in the Config File - Located in /plugins/" + WhitelistPlugin.getPluginName() + "/config.yml");
    }

    public String getChannelID() throws Exception {
        if(isTokenSet()) {
            String token = fileConfiguration.getString(CHANNEL_ID);
            assert token != null;
            if(token.equalsIgnoreCase("exampleID")) {
                throw new Exception("The Discord ChannelID is not set in the Config File - Located in /plugins/" + WhitelistPlugin.getPluginName() + "/config.yml");
            }else {
                return token;
            }
        }else {
            throw new Exception("The Discord ChannelID is not set in the Config File - Located in /plugins/" + WhitelistPlugin.getPluginName() + "/config.yml");
        }
    }

    public String getToken() throws Exception {
        if(isTokenSet()) {
            String token = fileConfiguration.getString(TOKEN_VALUE);
            assert token != null;
            if(token.equalsIgnoreCase("exampleToken")) {
                throw new Exception("The Discord Bot Token is not set in the Config File - Located in /plugins/" + WhitelistPlugin.getPluginName() + "/config.yml");
            }else {
                return token;
            }
        }else {
            throw new Exception("The Discord Bot Token is not set in the Config File - Located in /plugins/" + WhitelistPlugin.getPluginName() + "/config.yml");
        }
    }

    public void saveFile() {
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadConfigFile() {
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }
}
