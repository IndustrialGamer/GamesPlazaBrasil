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
public class VipCommand implements CommandExecutor {

    GamesPlaza pluin;

    public VipCommand(GamesPlaza plugin){

        this.pluin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        //Comando vip
        if (command.getName().equalsIgnoreCase("vip")) {
            p.sendMessage(ChatColor.BLUE + "Vip> " + ChatColor.GOLD + "Obrigado pelo interesse em ajudar o servidor!" + ChatColor.GREEN + " Voce pode comprar vip no site http://www.gamesplazabrasil.enjin.com/shop");

        }

        return false;
    }
}
