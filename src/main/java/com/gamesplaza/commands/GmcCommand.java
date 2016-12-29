package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GmcCommand implements CommandExecutor {



    GamesPlaza pluin;

    public GmcCommand(GamesPlaza plugin){

        this.pluin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;


        //Comando gmc
        if (command.getName().equalsIgnoreCase("gmc")) {
            if (!(sender instanceof Player)) {
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Apenas players podem mudar de Gamemode");
                return true;
            }
            if (p.hasPermission("gamemode.use.gmc")) {

                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.GREEN + "Seu gamemode foi alterado com sucesso!");
            } else {
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Voce nao tem permissao para mudar seu gamemode");
                return true;
            }

        }



        return false;
    }
}
