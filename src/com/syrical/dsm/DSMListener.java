package com.syrical.dsm;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
		
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 600, 1));
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (!player.hasPermission("dsm.build")) {
			
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You can't build here");
			
		}
		
	}
	
	@EventHandler
	public void onBlockDestroy(BlockBreakEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (!player.hasPermission("dsm.destroy")) {
			
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You can't break blocks here");
			
		}
		
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getInventory();
		
		if (inventory.getName().equals("DSM GUI") && event.getSlotType() != SlotType.OUTSIDE) {
			ItemStack clicked = event.getCurrentItem();
			Material clickedType = clicked.getType();
			
			if (clickedType == Material.STONE_PICKAXE) {
				
				player.sendMessage("You've been given the Noob's Pickaxe!");
				
			} else if (clickedType == Material.IRON_SWORD) {
				
				player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
				player.sendMessage("You've been given an Iron Sword!");
				
			} else if (clickedType == Material.IRON_AXE) {
				
				player.getInventory().addItem(new ItemStack(Material.IRON_AXE, 1));
				player.sendMessage("You've been given and Iron Axe!");
				
			}
			
			event.setCancelled(true);
			player.closeInventory();
			
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
