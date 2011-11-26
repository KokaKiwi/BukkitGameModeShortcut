package com.kokakiwi.bukkit.plugins.gamemode;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class GameModeShortcut extends JavaPlugin
{
    private final static Logger logger = Logger.getLogger("BukkitGameModeShortcut");
    
    public void onEnable()
    {
        getCommand("gm").setExecutor(new GameModeShortcutCommandExecutor());
        
        logger.info(getDescription().getFullName() + " enabled.");
    }
    
    public void onDisable()
    {
        logger.info(getDescription().getFullName() + " disabled.");
    }
    
}
