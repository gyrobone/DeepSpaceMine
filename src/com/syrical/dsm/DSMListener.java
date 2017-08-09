package com.syrical.dsm;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class DSMListener implements Listener {

	//Constructor
	public DSMListener(Main plugin) {
		
		
		
	}
	
	//EventHandler
	@EventHandler
	public void onPlayerJoin (PlayerJoinEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if(!player.hasPlayedBefore()) {
			
			player.sendMessage("Welcome to the server! Have fun!");
			
			ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
			ItemStack pick = new ItemStack(Material.IRON_PICKAXE, 1);
			ItemStack axe = new ItemStack(Material.IRON_AXE, 1);
			ItemStack spade = new ItemStack(Material.IRON_SPADE, 1);
			player.getInventory().addItem(sword);
			player.getInventory().addItem(pick);
			player.getInventory().addItem(axe);
			player.getInventory().addItem(spade);
			
		} else {
			
			player.sendMessage("Welcome back to the server!");
			
		}
		
	}
	
}
