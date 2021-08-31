package org.jadestudios.plugins.lifis;

import org.bukkit.plugin.java.JavaPlugin;
import org.jadestudios.plugins.lifis.Commands.ResetHearts;
import org.jadestudios.plugins.lifis.Events.LifisDeathHandler;

public class Lifis extends JavaPlugin {



    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new LifisDeathHandler(), this);
        getCommand("reset").setExecutor(new ResetHearts());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
