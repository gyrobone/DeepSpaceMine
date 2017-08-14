package com.syrical.dsm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;



public class GateWarp implements Listener {

	public GateWarp(Main plugin) {
		
		
		
	}
	
	@EventHandler
	public void onClickedBlock (PlayerInteractEvent e) {
		
		Player p = (Player) e.getPlayer();
		Block b = e.getClickedBlock();
		World Carinus = Bukkit.getWorld("world_carinus");
		World Opia3 = Bukkit.getWorld("world_opia3");
		World Damara = Bukkit.getWorld("world_damara");
		World Sirona = Bukkit.getWorld("world_sirona");
		
				
		
		if (b.getType() == Material.WALL_SIGN) {
				
			Sign s = (Sign) b.getState();
			
			if (s.getLine(2).toLowerCase().equalsIgnoreCase(ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active")) {
				if (s.getLine(0).toLowerCase().equalsIgnoreCase("[Tier 1]")) {	
					if (s.getLine(1).toLowerCase().equalsIgnoreCase("Carinus")) {
						if (Carinus == null) {
							WorldCreator creator = new WorldCreator("world_carinus");
							creator.environment(World.Environment.NORMAL);
							creator.generateStructures(false);
							Carinus = creator.createWorld();
						}
						p.teleport(Carinus.getSpawnLocation());
						p.sendMessage("Welcome to: " + ChatColor.GREEN + "Carinus");
						HandlerList.unregisterAll(Main.gwarp);
					} else if (s.getLine(1).toLowerCase().equalsIgnoreCase("Opia 3")) {
						if (Opia3 == null) {
							WorldCreator creator = new WorldCreator("world_opia3");
							creator.environment(World.Environment.NORMAL);
							creator.generateStructures(false);
							Opia3 = creator.createWorld();
						}
						p.teleport(Opia3.getSpawnLocation());
						p.sendMessage("Welcome to: " + ChatColor.DARK_GREEN + "Opia 3");
						HandlerList.unregisterAll(Main.gwarp);
					} else if (s.getLine(1).toLowerCase().equalsIgnoreCase("Damara")) {
						if (Damara == null) {
							WorldCreator creator = new WorldCreator("world_damara");
							creator.environment(World.Environment.NORMAL);
							creator.generateStructures(false);
							Damara = creator.createWorld();
						}
						p.teleport(Damara.getSpawnLocation());
						p.sendMessage("Welcome to: " + ChatColor.GOLD + "Damara");
						HandlerList.unregisterAll(Main.gwarp);
					} else if (s.getLine(1).toLowerCase().equalsIgnoreCase("Sirona")) {
						if (Sirona == null) {
							WorldCreator creator = new WorldCreator("world_sirona");
							creator.environment(World.Environment.NORMAL);
							creator.generateStructures(false);
							Sirona = creator.createWorld();
						}
						p.teleport(Sirona.getSpawnLocation());
						p.sendMessage("Welcome to: " + ChatColor.YELLOW + "Sirona");
						HandlerList.unregisterAll(Main.gwarp);
					}
				}		
			} else if (b.getType() != Material.WALL_SIGN) {
					
				p.sendMessage(ChatColor.RED + "Invalid Warp");
				HandlerList.unregisterAll(Main.gwarp);
					
			}
			
		}
		
	}
	
}
