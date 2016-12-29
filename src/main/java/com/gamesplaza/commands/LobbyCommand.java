package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LobbyCommand implements CommandExecutor {


    GamesPlaza plugin;

    public LobbyCommand(GamesPlaza plugin) {

        this.plugin = plugin;
    }




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        //Comando lobby
        if (command.getName().equalsIgnoreCase("lobby")) {
            if (!(sender instanceof Player)) {
                p.sendMessage(ChatColor.BLUE + "Lobby> " + ChatColor.RED + "Apenas players podem se teleportar para o Lobby!");
                return true;
            }
               String lobby =  plugin.getConfig().getString("lobby");

            p.teleport(Bukkit.getWorld("lobby").getSpawnLocation());
            p.sendMessage(ChatColor.BLUE + "Lobby> " + ChatColor.GREEN + "Voce foi teleportado para o lobby principal!");

        }
            //Comando hub
            if (command.getName().equalsIgnoreCase("hub")) {
                if (!(sender instanceof Player)) {
                    p.sendMessage(ChatColor.BLUE + "Hub> " + ChatColor.RED + "Apenas players podem se teleportar para o Hub");
                    return true;
                }
                String lobby =  plugin.getConfig().getString("lobby");
                    p.teleport(Bukkit.getWorld("lobby").getSpawnLocation());
                    p.sendMessage(ChatColor.BLUE + "Hub> " + ChatColor.GREEN + "Voce foi teleportado para o hub principal!");

                }





        return false;
    }

}