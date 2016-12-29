package com.enjin.gamesplazabrasil;

import com.gamesplaza.commands.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class GamesPlaza extends JavaPlugin  {




    @Override
    public void onEnable() {
        //Inicia Servidor
        getLogger().info(ChatColor.GREEN + "Agora esse servidor se chama Games Plaza");

        //Registra eventos
        getServer().getPluginManager().registerEvents(new GamesPlazaEventos(), this);


        //Registra Config
        registerConfig();


        //CommandExecutors
        this.getCommand("gamesplaza").setExecutor(new GamesplazaCommand(this));
        this.getCommand("vip").setExecutor(new VipCommand(this));
        this.getCommand("hub").setExecutor(new LobbyCommand(this));
        this.getCommand("lobby").setExecutor(new LobbyCommand(this));
        this.getCommand("gmc").setExecutor(new GmcCommand(this));
        this.getCommand("gms").setExecutor(new GmsCommand(this));
        this.getCommand("gma").setExecutor(new GmaCommand(this));
        this.getCommand("gme").setExecutor(new GmeCommand(this));
        this.getCommand("op").setExecutor(new OPCommand(this));
        this.getCommand("deop").setExecutor(new DEOPCommand(this));
        this.getCommand("ban").setExecutor(new BanCommand(this));
        this.getCommand("desbanir").setExecutor(new DesbanirCommand(this));
        this.getCommand("kick").setExecutor(new KickCommand(this));
        this.getCommand("vida").setExecutor(new VidaCommand(this));
        this.getCommand("fome").setExecutor(new FomeCommand(this));
        this.getCommand("tempo").setExecutor(new TimeCommand(this));
        this.getCommand("ADM").setExecutor(new ADMCommand(this));


    }



       private void registerConfig () {
           getConfig().addDefault("lobby: ", "LobbyDone");
            getConfig().options().copyDefaults(true);
            saveConfig();
        }


        @Override
        public void onDisable () {
            getLogger().info("Agora esse servidor não se chama mais GamesPlaza");
            HandlerList.unregisterAll(this);
        }






}