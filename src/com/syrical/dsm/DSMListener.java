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
	
	//When player gets hit by other entity
	/* @EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent event) {
		
		Entity entity = event.getEntity();
		
		if (entity instanceof Player) {
			
			Player player = (Player) entity;
			
			Location playerLoc = player.getLocation();
			Location loc = playerLoc.add(10, 0, 0);
			
			player.teleport(loc);
			
		} 
		
	}
	*/
	
	//When zombie gets hit by player
	/* @EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) {
		
		Entity entity = event.getEntity();
		
		if (entity instanceof Zombie) {
			
			World world = entity.getWorld();
			Location loc = new Location(world, 10, 10, 10);
			
			entity.teleport(loc);
			
		}
		
	}
	*/
	
}
