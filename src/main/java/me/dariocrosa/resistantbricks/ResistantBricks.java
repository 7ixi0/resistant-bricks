package me.dariocrosa.resistantbricks;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ResistantBricks extends JavaPlugin {
    public void onEnable() {
        createConfigIfNotExists();

        PluginManager pluginManager = getServer().getPluginManager();
        FileConfiguration config = getConfig();

        if (config.getBoolean("players"))
            pluginManager.registerEvents(new BlockBreakListener(config.getBoolean("disableIfCreative")), this);

        if (config.getBoolean("explosions"))
            pluginManager.registerEvents(new ExplosionListener(), this);
    }

    private void createConfigIfNotExists() {
        if (!getDataFolder().exists()) {
            //noinspection ResultOfMethodCallIgnored
            getDataFolder().mkdirs();
        }

        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            saveDefaultConfig();
        }
    }
}
