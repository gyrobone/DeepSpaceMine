package com.syrical.dsm;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class GateCheck implements Listener {
	
	public GateCheck(Main plugin) {

	}
	
	@EventHandler
	public GateCalibrationListen onSignClick (PlayerInteractEvent e) {
		
		Player p = (Player) e.getPlayer();
		Block b = e.getClickedBlock();
	
		if (b.getType() == Material.WALL_SIGN) {
			
			org.bukkit.material.Sign sign = (org.bukkit.material.Sign) b.getState().getData();
			BlockFace facing = sign.getFacing();
			Sign s = (Sign) b.getState();
			String[] ln = s.getLines();
			
			if (ln[0].toLowerCase().equalsIgnoreCase("[Tier 1]")) {
				
				if (facing == BlockFace.NORTH) {
					return checkT1("South", p, b.getLocation().add(0,0,1), true);
				} else if (facing == BlockFace.SOUTH) {
					return checkT1("North", p, b.getLocation().add(0,0,-1), true);
				} else if (facing == BlockFace.EAST) {
					return checkT1("West", p, b.getLocation().add(-1,0,0), true);
				} else if (facing == BlockFace.WEST) {
					return checkT1("East", p, b.getLocation().add(1,0,0), true);
				}
	
			} else if (ln[0].toLowerCase().equalsIgnoreCase("[Tier 2]")) {
				
				if (facing == BlockFace.NORTH) {
					return checkT2("South", p, b.getLocation().add(0,0,1), true);
				} else if (facing == BlockFace.SOUTH) {
					return checkT2("North", p, b.getLocation().add(0,0,-1), true);
				} else if (facing == BlockFace.EAST) {
					return checkT2("West", p, b.getLocation().add(-1,0,0), true);
				} else if (facing == BlockFace.WEST) {
					return checkT2("East", p, b.getLocation().add(1,0,0), true);
				}
	
			} else if (ln[0].toLowerCase().equalsIgnoreCase("[Tier 3]")) {
				
				if (facing == BlockFace.NORTH) {
					return checkT3("South", p, b.getLocation().add(0,0,1), true);
				} else if (facing == BlockFace.SOUTH) {
					return checkT3("North", p, b.getLocation().add(0,0,-1), true);
				} else if (facing == BlockFace.EAST) {
					return checkT3("West", p, b.getLocation().add(-1,0,0), true);
				} else if (facing == BlockFace.WEST) {
					return checkT3("East", p, b.getLocation().add(1,0,0), true);
				}
	
			} else if (ln[0].toLowerCase().equalsIgnoreCase("[Tier 4]")) {
				
				if (facing == BlockFace.NORTH) {
					return checkT4("South", p, b.getLocation().add(0,0,1), true);
				} else if (facing == BlockFace.SOUTH) {
					return checkT4("North", p, b.getLocation().add(0,0,-1), true);
				} else if (facing == BlockFace.EAST) {
					return checkT4("West", p, b.getLocation().add(-1,0,0), true);
				} else if (facing == BlockFace.WEST) {
					return checkT4("East", p, b.getLocation().add(1,0,0), true);
				}
	
			} 
			
		} else if (b.getType() != Material.WALL_SIGN) {
			p.sendMessage(ChatColor.RED + "Not a sign");
			HandlerList.unregisterAll(Main.gcheck);
			
		}
		
		return null;
		
	}
	
	public GateCalibrationListen checkT1 (String playerface, Player p, Location loc, Boolean active) {
		
		Block b = loc.getBlock();
		
		if (active == true) {
				if (b.getType() == Material.STAINED_GLASS_PANE) {	
					if ((playerface == "North")) {
						if ((b.getLocation().add(-1,0,0).getBlock().getType() == Material.IRON_BLOCK) && (b.getLocation().add(1,0,0).getBlock().getType() == Material.IRON_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.IRON_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.IRON_BLOCK)) {
								Block newSign = b.getLocation().add(0,0,1).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
								s2.setLine(3, "§kWorking");
								s2.update();
								p.sendMessage(ChatColor.GREEN + "Tier 1 Gate built successfully!");
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else if(playerface == "South") {
						if ((b.getLocation().add(-1,0,0).getBlock().getType() == Material.IRON_BLOCK) && (b.getLocation().add(1,0,0).getBlock().getType() == Material.IRON_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.IRON_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.IRON_BLOCK)) {
								Block newSign = b.getLocation().add(0,0,-1).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
								s2.setLine(3, "§kWorking");
								s2.update();
								p.sendMessage(ChatColor.GREEN + "Tier 1 Gate built successfully!");
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else if ((playerface == "East")) {
						if ((b.getLocation().add(0,0,1).getBlock().getType() == Material.IRON_BLOCK) && (b.getLocation().add(0,0,-1).getBlock().getType() == Material.IRON_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.IRON_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.IRON_BLOCK)) {
								Block newSign = b.getLocation().add(-1,0,0).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
								s2.setLine(3, "§kWorking");
								s2.update();
								p.sendMessage(ChatColor.GREEN + "Tier 1 Gate built successfully!");
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else if(playerface == "West") {
						if ((b.getLocation().add(0,0,1).getBlock().getType() == Material.IRON_BLOCK) && (b.getLocation().add(0,0,-1).getBlock().getType() == Material.IRON_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.IRON_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.IRON_BLOCK)) {
								Block newSign = b.getLocation().add(1,0,0).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
								s2.setLine(3, "§kWorking");
								s2.update();
								p.sendMessage(ChatColor.GREEN + "Tier 1 Gate built successfully!");
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else {
						HandlerList.unregisterAll(Main.gcheck);
					}
			} else {
				p.sendMessage(ChatColor.RED + "Missing Glass");
				HandlerList.unregisterAll(Main.gcheck);
			}
		} else {
			HandlerList.unregisterAll(Main.gcheck);
		}
		return null;
	}
	
	public GateCalibrationListen checkT2 (String playerface, Player p, Location loc, Boolean active) {
	
		Block b = loc.getBlock();
	
		if (active == true) {
	
			if (b.getType() == Material.STAINED_GLASS_PANE) {
		
				if ((playerface == "North")) {
					if ((b.getLocation().add(-1,0,0).getBlock().getType() == Material.REDSTONE_BLOCK) && (b.getLocation().add(1,0,0).getBlock().getType() == Material.REDSTONE_BLOCK)) {
						if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.REDSTONE_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.REDSTONE_BLOCK)) {
							Block newSign = b.getLocation().add(0,0,1).getBlock();
							Sign s2 = (Sign) newSign.getState();
							s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
							s2.setLine(3, "§kWorking");
							s2.update();
							p.sendMessage(ChatColor.GREEN + "Tier 2 Gate built successfully!");
							HandlerList.unregisterAll(Main.gcheck);
						}
					}
				} else if(playerface == "South") {
					if ((b.getLocation().add(-1,0,0).getBlock().getType() == Material.REDSTONE_BLOCK) && (b.getLocation().add(1,0,0).getBlock().getType() == Material.REDSTONE_BLOCK)) {
						if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.REDSTONE_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.REDSTONE_BLOCK)) {
							Block newSign = b.getLocation().add(0,0,-1).getBlock();
							Sign s2 = (Sign) newSign.getState();
							s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
							s2.setLine(3, "§kWorking");
							s2.update();
							p.sendMessage(ChatColor.GREEN + "Tier 2 Gate built successfully!");
							HandlerList.unregisterAll(Main.gcheck);
						}
					}
				} else if ((playerface == "East")) {
					if ((b.getLocation().add(0,0,1).getBlock().getType() == Material.REDSTONE_BLOCK) && (b.getLocation().add(0,0,-1).getBlock().getType() == Material.REDSTONE_BLOCK)) {
						if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.REDSTONE_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.REDSTONE_BLOCK)) {
							Block newSign = b.getLocation().add(-1,0,0).getBlock();
							Sign s2 = (Sign) newSign.getState();
							s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
							s2.setLine(3, "§kWorking");
							s2.update();
							p.sendMessage(ChatColor.GREEN + "Tier 2 Gate built successfully!");
							HandlerList.unregisterAll(Main.gcheck);
						}
					}
				} else if(playerface == "West") {
					if ((b.getLocation().add(0,0,1).getBlock().getType() == Material.REDSTONE_BLOCK) && (b.getLocation().add(0,0,-1).getBlock().getType() == Material.REDSTONE_BLOCK)) {
						if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.REDSTONE_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.REDSTONE_BLOCK)) {
							Block newSign = b.getLocation().add(1,0,0).getBlock();
							Sign s2 = (Sign) newSign.getState();
							s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
							s2.setLine(3, "§kWorking");
							s2.update();
							p.sendMessage(ChatColor.GREEN + "Tier 2 Gate built successfully!");
							HandlerList.unregisterAll(Main.gcheck);
						}
					}
				} else {
					HandlerList.unregisterAll(Main.gcheck);
				}
			} else {
				p.sendMessage(ChatColor.RED + "Missing Glass");
				HandlerList.unregisterAll(Main.gcheck);
			}
		} else {
			HandlerList.unregisterAll(Main.gcheck);
		}
		return null;
	}
	
	public GateCalibrationListen checkT3 (String playerface, Player p, Location loc, Boolean active) {
		
		Block b = loc.getBlock();
		
		if (active == true) {
				if (b.getType() == Material.STAINED_GLASS_PANE) {	
					if ((playerface == "North")) {
						if ((b.getLocation().add(-1,0,0).getBlock().getType() == Material.GOLD_BLOCK) && (b.getLocation().add(1,0,0).getBlock().getType() == Material.GOLD_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.GOLD_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.GOLD_BLOCK)) {
								Block newSign = b.getLocation().add(0,0,1).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
								s2.setLine(3, "§kWorking");
								s2.update();
								p.sendMessage(ChatColor.GREEN + "Tier 3 Gate built successfully!");
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else if(playerface == "South") {
						if ((b.getLocation().add(-1,0,0).getBlock().getType() == Material.GOLD_BLOCK) && (b.getLocation().add(1,0,0).getBlock().getType() == Material.GOLD_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.GOLD_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.GOLD_BLOCK)) {
								Block newSign = b.getLocation().add(0,0,-1).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
								s2.setLine(3, "§kWorking");
								s2.update();
								p.sendMessage(ChatColor.GREEN + "Tier 3 Gate built successfully!");
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else if ((playerface == "East")) {
						if ((b.getLocation().add(0,0,1).getBlock().getType() == Material.GOLD_BLOCK) && (b.getLocation().add(0,0,-1).getBlock().getType() == Material.GOLD_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.GOLD_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.GOLD_BLOCK)) {
								Block newSign = b.getLocation().add(-1,0,0).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
								s2.setLine(3, "§kWorking");
								s2.update();
								p.sendMessage(ChatColor.GREEN + "Tier 3 Gate built successfully!");
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else if(playerface == "West") {
						if ((b.getLocation().add(0,0,1).getBlock().getType() == Material.GOLD_BLOCK) && (b.getLocation().add(0,0,-1).getBlock().getType() == Material.GOLD_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.GOLD_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.GOLD_BLOCK)) {
								Block newSign = b.getLocation().add(1,0,0).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
								s2.setLine(3, "§kWorking");
								s2.update();
								p.sendMessage(ChatColor.GREEN + "Tier 3 Gate built successfully!");
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else {
						HandlerList.unregisterAll(Main.gcheck);
					}
			} else {
				p.sendMessage(ChatColor.RED + "Missing Glass");
				HandlerList.unregisterAll(Main.gcheck);
			}
		} else {
			HandlerList.unregisterAll(Main.gcheck);
		}
		return null;
	}
	
	public GateCalibrationListen checkT4 (String playerface, Player p, Location loc, Boolean active) {
		
		Block b = loc.getBlock();
		
		if (active == true) {
				if (b.getType() == Material.STAINED_GLASS_PANE) {	
					if ((playerface == "North")) {
						if ((b.getLocation().add(-1,0,0).getBlock().getType() == Material.DIAMOND_BLOCK) && (b.getLocation().add(1,0,0).getBlock().getType() == Material.DIAMOND_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.DIAMOND_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.DIAMOND_BLOCK)) {
								Block newSign = b.getLocation().add(0,0,1).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
								s2.setLine(3, "§kWorking");
								s2.update();
								p.sendMessage(ChatColor.GREEN + "Tier 4 Gate built successfully!");
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else if(playerface == "South") {
						if ((b.getLocation().add(-1,0,0).getBlock().getType() == Material.DIAMOND_BLOCK) && (b.getLocation().add(1,0,0).getBlock().getType() == Material.DIAMOND_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.DIAMOND_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.DIAMOND_BLOCK)) {
								Block newSign = b.getLocation().add(0,0,-1).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
								s2.setLine(3, "§kWorking");
								s2.update();
								p.sendMessage(ChatColor.GREEN + "Tier 4 Gate built successfully!");
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else if ((playerface == "East")) {
						if ((b.getLocation().add(0,0,1).getBlock().getType() == Material.DIAMOND_BLOCK) && (b.getLocation().add(0,0,-1).getBlock().getType() == Material.DIAMOND_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.DIAMOND_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.DIAMOND_BLOCK)) {
								Block newSign = b.getLocation().add(-1,0,0).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
								s2.setLine(3, "§kWorking");
								s2.update();
								p.sendMessage(ChatColor.GREEN + "Tier 4 Gate built successfully!");
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else if(playerface == "West") {
						if ((b.getLocation().add(0,0,1).getBlock().getType() == Material.DIAMOND_BLOCK) && (b.getLocation().add(0,0,-1).getBlock().getType() == Material.DIAMOND_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.DIAMOND_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.DIAMOND_BLOCK)) {
								Block newSign = b.getLocation().add(1,0,0).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(2, ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active");
								s2.setLine(3, "§kWorking");
								s2.update();
								p.sendMessage(ChatColor.GREEN + "Tier 4 Gate built successfully!");
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else {
						HandlerList.unregisterAll(Main.gcheck);
					}
			} else {
				p.sendMessage(ChatColor.RED + "Missing Glass");
				HandlerList.unregisterAll(Main.gcheck);
			}
		} else {
			HandlerList.unregisterAll(Main.gcheck);
		}
		return null;
	}
	
}
