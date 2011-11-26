package com.kokakiwi.bukkit.plugins.gamemode;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class GameModeShortcutCommandExecutor implements CommandExecutor
{
    
    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args)
    {
        if (args.length > 0 && args[0].equalsIgnoreCase("help"))
        {
            return true;
        }
        
        if (args.length == 1)
        {
            if (sender instanceof ConsoleCommandSender)
            {
                return true;
            }
            
            Player player = (Player) sender;
            if (!player.isOp())
            {
                return true;
            }
            int mode = Integer.parseInt(args[0]);
            
            setGameMode(player, mode);
            
            return true;
        }
        else if (args.length == 2)
        {
            if (sender instanceof Player)
            {
                Player source = (Player) sender;
                if (!source.isOp())
                {
                    return true;
                }
            }
            
            Player player = sender.getServer().getPlayer(args[0]);
            if (player == null)
            {
                sender.sendMessage(ChatColor.RED + "Player doesn't exists!");
            }
            else
            {
                setGameMode(player, Integer.parseInt(args[1]));
            }
            
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void setGameMode(Player player, int mode)
    {
        player.setGameMode(GameMode.getByValue(mode));
        player.sendMessage(ChatColor.GOLD + "You are now in "
                + player.getGameMode().name() + " Game Mode!");
    }
    
}
