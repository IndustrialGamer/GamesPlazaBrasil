package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by enzob on 23/12/2016.
 */
public class GamesplazaCommand implements CommandExecutor {

    GamesPlaza pluin;

    public GamesplazaCommand(GamesPlaza plugin){

        this.pluin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

     Player p = (Player) sender;

        //Comando gamesplaza
        if (command.getName().equalsIgnoreCase("gamesplaza")) {
            p.sendMessage(ChatColor.BLUE + "GamesPlaza> " + ChatColor.GREEN + "Bem-Vindo ao GamesPlaza! Aqui você podera se divertir com nossos minigames. Se voce gostar compre vip no site http://www.gamesplazabrasil.enjin.com/shop");

        }

        return false;
    }
}
