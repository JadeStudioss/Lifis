package org.jadestudios.plugins.lifis;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jadestudios.plugins.lifis.Commands.ReloadConfig;
import org.jadestudios.plugins.lifis.Commands.ResetHearts;
import org.jadestudios.plugins.lifis.Commands.ReviveCommand;
import org.jadestudios.plugins.lifis.Events.LifisDeathHandler;
import org.jadestudios.plugins.lifis.Events.LifisExtraHeartHandler;
import org.jadestudios.plugins.lifis.Events.LifisPackHandler;
import org.jadestudios.plugins.lifis.Recipes.HeartRecipe;

public class Lifis extends JavaPlugin {

    HeartRecipe heartRecipe = new HeartRecipe();

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        if (getConfig().getBoolean("use-texture-pack")) {
            getServer().getPluginManager().registerEvents(new LifisPackHandler(this), this);
        }

        getServer().getPluginManager().registerEvents(new LifisDeathHandler(), this);
        getServer().getPluginManager().registerEvents(new LifisExtraHeartHandler(), this);

        getCommand("reloadconfig").setExecutor(new ReloadConfig(this));
        getCommand("reset").setExecutor(new ResetHearts());
        if (getConfig().getBoolean("enable-revive")) getCommand("revive").setExecutor(new ReviveCommand());

        Bukkit.addRecipe(heartRecipe.heartRecipe(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
