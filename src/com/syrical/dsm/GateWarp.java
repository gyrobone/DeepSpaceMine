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
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;



public class GateWarp implements Listener {

	public String planet;
	public String defaultPlanet = "world";
	
	public GateWarp(Main plugin, String planet) {
		
		this.planet = planet;
	}
	
	@EventHandler
	public void onClickedBlock (PlayerInteractEvent e) {
		
		Player p = (Player) e.getPlayer();
		Block b = e.getClickedBlock();
		World Carinus = Bukkit.getWorld("world_carinus");
		World Opia3 = Bukkit.getWorld("world_opia3");
		World Damara = Bukkit.getWorld("world_damara");
		World Sirona = Bukkit.getWorld("world_sirona");
		
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;		
		
		if (b.getType() == Material.WALL_SIGN) {
				
			Sign s = (Sign) b.getState();
			
			if (s.getLine(2).toLowerCase().equalsIgnoreCase(ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active")) {
				if (s.getLine(0).toLowerCase().equalsIgnoreCase("[Tier 1]")) {	
					if (planet.equalsIgnoreCase("Carinus")) {
						if (Carinus == null) {
							WorldCreator creator = new WorldCreator("world_carinus");
							creator.environment(World.Environment.NORMAL);
							creator.generateStructures(false);
							Carinus = creator.createWorld();
						}
						p.teleport(Carinus.getSpawnLocation());
						p.sendMessage("Welcome to: " + ChatColor.GREEN + "Carinus");
						HandlerList.unregisterAll(Main.gwarp);
					} else if (planet.equalsIgnoreCase("Opia3")) {
						if (Opia3 == null) {
							WorldCreator creator = new WorldCreator("world_opia3");
							creator.environment(World.Environment.NORMAL);
							creator.generateStructures(false);
							Opia3 = creator.createWorld();
						}
						p.teleport(Opia3.getSpawnLocation());
						p.sendMessage("Welcome to: " + ChatColor.DARK_GREEN + "Opia 3");
						HandlerList.unregisterAll(Main.gwarp);
					} else if (planet.equalsIgnoreCase("Damara")) {
						if (Damara == null) {
							WorldCreator creator = new WorldCreator("world_damara");
							creator.environment(World.Environment.NORMAL);
							creator.generateStructures(false);
							Damara = creator.createWorld();
						}
						p.teleport(Damara.getSpawnLocation());
						p.sendMessage("Welcome to: " + ChatColor.GOLD + "Damara");
						HandlerList.unregisterAll(Main.gwarp);
					} else if (planet.equalsIgnoreCase("Sirona")) {
						if (Sirona == null) {
							WorldCreator creator = new WorldCreator("world_sirona");
							creator.environment(World.Environment.NORMAL);
							creator.generateStructures(false);
							Sirona = creator.createWorld();
						}
						p.teleport(Sirona.getSpawnLocation());
						p.sendMessage("Welcome to: " + ChatColor.YELLOW + "Sirona");
						HandlerList.unregisterAll(Main.gwarp);
					} else if (planet.equalsIgnoreCase("world")) {
						return;
					}
					planet = defaultPlanet;
				}		
			} else {
					
				p.sendMessage(ChatColor.RED + "Invalid Warp");
				HandlerList.unregisterAll(Main.gwarp);
					
			}
			
		} else  if (b.getType() != Material.WALL_SIGN) {
			p.sendMessage(ChatColor.RED + "Invalid Warp");
			HandlerList.unregisterAll(Main.gwarp);
		}
		
	}
	
}
