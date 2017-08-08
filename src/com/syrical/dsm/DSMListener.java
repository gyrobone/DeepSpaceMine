package com.syrical.dsm;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class DSMListener implements Listener {

	//Constructor
	public DSMListener(Main plugin) {
		
		
		
	}
	
	//EventHandler
	@EventHandler
	public void onPlayerJoin (PlayerJoinEvent event) {
		
		event.getPlayer().sendMessage("Welcome Back!");
		
	}
	
}
