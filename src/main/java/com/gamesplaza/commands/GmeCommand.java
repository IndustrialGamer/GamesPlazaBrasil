package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by enzob on 23/12/2016.
 */
public class GmeCommand implements CommandExecutor {




    GamesPlaza pluin;

    public GmeCommand(GamesPlaza plugin){

        this.pluin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        //Comando gme
        if (command.getName().equalsIgnoreCase("gme")) {
            if (!(sender instanceof Player)) {
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Apenas players podem mudar de Gamemode");
                return true;
            }
            if (p.hasPermission("gamemode.use.gme")) {

                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.GREEN + "Seu gamemode foi alterado com sucesso!");
            } else {
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Voce nao tem permissao para mudar seu gamemode");

                return true;
            }
        }


        return false;
    }
}
