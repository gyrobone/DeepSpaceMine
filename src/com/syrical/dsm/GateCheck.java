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
	
			} /* else if (ln[0].toLowerCase().equalsIgnoreCase("[Tier 2]")) {
				
				p.sendMessage(ChatColor.GREEN + "Tier 2");
				
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
				
				p.sendMessage(ChatColor.GREEN + "Tier 3");
				
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
				
				p.sendMessage(ChatColor.GREEN + "Tier 4");
				
				if (facing == BlockFace.NORTH) {
					return checkT4("South", p, b.getLocation().add(0,0,1), true);
				} else if (facing == BlockFace.SOUTH) {
					return checkT4("North", p, b.getLocation().add(0,0,-1), true);
				} else if (facing == BlockFace.EAST) {
					return checkT4("West", p, b.getLocation().add(-1,0,0), true);
				} else if (facing == BlockFace.WEST) {
					return checkT4("East", p, b.getLocation().add(1,0,0), true);
				}
	
			} else {
				
			} */
			
		} else if (b.getType() != Material.WALL_SIGN) {
			p.sendMessage(ChatColor.RED + "Not a sign");
			HandlerList.unregisterAll(Main.gcheck);
			
		}
		
		return null;
		
	}
	
	public GateCalibrationListen checkT1 (String playerface, Player p, Location loc, Boolean active) {
		
		Block b = loc.getBlock();
		
		if (active == true) {
		
				p.sendMessage(ChatColor.GREEN + "Tier 1");
			
				if (b.getType() == Material.STAINED_GLASS_PANE) {	
						
					
					if ((playerface == "North") || (playerface == "South")) {
						if ((b.getLocation().add(-1,0,0).getBlock().getType() == Material.IRON_BLOCK) && (b.getLocation().add(1,0,0).getBlock().getType() == Material.IRON_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.IRON_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.IRON_BLOCK)) {
								Block newSign = b.getLocation().add(0,0,1).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(1, ChatColor.GREEN + "Active");
								s2.update();
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else if ((playerface == "East") || (playerface == "West")) {
						if ((b.getLocation().add(0,0,1).getBlock().getType() == Material.IRON_BLOCK) && (b.getLocation().add(0,0,-1).getBlock().getType() == Material.IRON_BLOCK)) {
							if ((b.getLocation().add(0,1,0).getBlock().getType() == Material.IRON_BLOCK) && (b.getLocation().add(0,-1,0).getBlock().getType() == Material.IRON_BLOCK)) {
								Block newSign = b.getLocation().add(-1,0,0).getBlock();
								Sign s2 = (Sign) newSign.getState();
								s2.setLine(1, ChatColor.GREEN + "Active");
								s2.update();
								HandlerList.unregisterAll(Main.gcheck);
							}
						}
					} else {
			
					p.sendMessage(ChatColor.RED + "Missing Glass");
					HandlerList.unregisterAll(Main.gcheck);
			
					}
		
			} else {
				HandlerList.unregisterAll(Main.gcheck);
			}
		
		} else {
			HandlerList.unregisterAll(Main.gcheck);
		}
		
		return null;
	}
	
	/* public GateCalibrationListen checkT2 (String playerface, Player p, Location loc, Boolean active) {
	
	Block b = loc.getBlock();
	Location bLoc = b.getLocation();
	
	if (active == true) {
	
	if (b.getType() == Material.SMOOTH_BRICK) {
		
		if (playerface == "North") {
			
			if (bLoc.add(0,0,-1).getBlock().getType() == Material.SPONGE) {
				
				Location bLoc2 = bLoc.add(0,0,-1);
				Block b2 = bLoc2.getBlock();
				p.sendMessage(ChatColor.GREEN + "Sponge is North");
				
				if (b2.getType() == Material.ANVIL) {
					p.sendMessage(ChatColor.GREEN + "Anvil is North");
				} else {
					p.sendMessage(ChatColor.RED + "Missing Anvil");
				}
				
			} else if (!(bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE)) {
				p.sendMessage(ChatColor.RED + "Missing Sponge");
			}
			
		} else if (playerface == "South") {
			
			
			if (bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE) {
				
				Location bLoc2 = bLoc.add(0,0,1);
				Block b2 = bLoc2.getBlock();
				p.sendMessage(ChatColor.GREEN + "Sponge is South");
				
				if (b2.getType() == Material.ANVIL) {
					p.sendMessage(ChatColor.GREEN + "Anvil is South");
				} else {
					p.sendMessage(ChatColor.RED + "Missing Anvil");
				}
				
			} else if (!(bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE)) {
				p.sendMessage(ChatColor.RED + "Missing Sponge");
			}
			
		} else if (playerface == "East") {
			
			if (bLoc.add(1,0,0).getBlock().getType() == Material.SPONGE) {
				
				Location bLoc2 = bLoc.add(1,0,0);
				Block b2 = bLoc2.getBlock();
				p.sendMessage(ChatColor.GREEN + "Sponge is East");
				
				if (b2.getType() == Material.ANVIL) {
					p.sendMessage(ChatColor.GREEN + "Anvil is East");
				} else {
					p.sendMessage(ChatColor.RED + "Missing Anvil");
				}
				
			} else if (!(bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE)) {
				p.sendMessage(ChatColor.RED + "Missing Sponge");
			}
			
		} else if (playerface == "West") {
			
			if (bLoc.add(-1,0,0).getBlock().getType() == Material.SPONGE) {
				
				Location bLoc2 = bLoc.add(-1,0,0);
				Block b2 = bLoc2.getBlock();
				p.sendMessage(ChatColor.GREEN + "Sponge is West");
				
				if (b2.getType() == Material.ANVIL) {
					p.sendMessage(ChatColor.GREEN + "Anvil is West");
				} else {
					p.sendMessage(ChatColor.RED + "Missing Anvil");
				}
				
			} else if (!(bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE)) {
				p.sendMessage(ChatColor.RED + "Missing Sponge");
			}
			
		} 
		
	} else {
		
		p.sendMessage(ChatColor.RED + "Missing Stone");
		
	}
	
	}
	
	HandlerList.unregisterAll(Main.GCListen);
	return null;
	
	}

	public GateCalibrationListen checkT3 (String playerface, Player p, Location loc, Boolean active) {
	
	Block b = loc.getBlock();
	Location bLoc = b.getLocation();
	
	if (active == true) {
	
	if (b.getType() == Material.SMOOTH_BRICK) {
		
		if (playerface == "North") {
			
			if (bLoc.add(0,0,-1).getBlock().getType() == Material.SPONGE) {
				
				Location bLoc2 = bLoc.add(0,0,-1);
				Block b2 = bLoc2.getBlock();
				p.sendMessage(ChatColor.GREEN + "Sponge is North");
				
				if (b2.getType() == Material.ANVIL) {
					p.sendMessage(ChatColor.GREEN + "Anvil is North");
				} else {
					p.sendMessage(ChatColor.RED + "Missing Anvil");
				}
				
			} else if (!(bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE)) {
				p.sendMessage(ChatColor.RED + "Missing Sponge");
			}
			
		} else if (playerface == "South") {
			
			
			if (bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE) {
				
				Location bLoc2 = bLoc.add(0,0,1);
				Block b2 = bLoc2.getBlock();
				p.sendMessage(ChatColor.GREEN + "Sponge is South");
				
				if (b2.getType() == Material.ANVIL) {
					p.sendMessage(ChatColor.GREEN + "Anvil is South");
				} else {
					p.sendMessage(ChatColor.RED + "Missing Anvil");
				}
				
			} else if (!(bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE)) {
				p.sendMessage(ChatColor.RED + "Missing Sponge");
			}
			
		} else if (playerface == "East") {
			
			if (bLoc.add(1,0,0).getBlock().getType() == Material.SPONGE) {
				
				Location bLoc2 = bLoc.add(1,0,0);
				Block b2 = bLoc2.getBlock();
				p.sendMessage(ChatColor.GREEN + "Sponge is East");
				
				if (b2.getType() == Material.ANVIL) {
					p.sendMessage(ChatColor.GREEN + "Anvil is East");
				} else {
					p.sendMessage(ChatColor.RED + "Missing Anvil");
				}
				
			} else if (!(bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE)) {
				p.sendMessage(ChatColor.RED + "Missing Sponge");
			}
			
		} else if (playerface == "West") {
			
			if (bLoc.add(-1,0,0).getBlock().getType() == Material.SPONGE) {
				
				Location bLoc2 = bLoc.add(-1,0,0);
				Block b2 = bLoc2.getBlock();
				p.sendMessage(ChatColor.GREEN + "Sponge is West");
				
				if (b2.getType() == Material.ANVIL) {
					p.sendMessage(ChatColor.GREEN + "Anvil is West");
				} else {
					p.sendMessage(ChatColor.RED + "Missing Anvil");
				}
				
			} else if (!(bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE)) {
				p.sendMessage(ChatColor.RED + "Missing Sponge");
			}
			
		} 
		
	} else {
		
		p.sendMessage(ChatColor.RED + "Missing Stone");
		
	}
	
	}
	
	HandlerList.unregisterAll(Main.GCListen);
	return null;
	
	}

	public GateCalibrationListen checkT4 (String playerface, Player p, Location loc, Boolean active) {
	
	Block b = loc.getBlock();
	Location bLoc = b.getLocation();
	
	if (active == true) {
	
	if (b.getType() == Material.SMOOTH_BRICK) {
		
		if (playerface == "North") {
			
			if (bLoc.add(0,0,-1).getBlock().getType() == Material.SPONGE) {
				
				Location bLoc2 = bLoc.add(0,0,-1);
				Block b2 = bLoc2.getBlock();
				p.sendMessage(ChatColor.GREEN + "Sponge is North");
				
				if (b2.getType() == Material.ANVIL) {
					p.sendMessage(ChatColor.GREEN + "Anvil is North");
				} else {
					p.sendMessage(ChatColor.RED + "Missing Anvil");
				}
				
			} else if (!(bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE)) {
				p.sendMessage(ChatColor.RED + "Missing Sponge");
			}
			
		} else if (playerface == "South") {
			
			
			if (bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE) {
				
				Location bLoc2 = bLoc.add(0,0,1);
				Block b2 = bLoc2.getBlock();
				p.sendMessage(ChatColor.GREEN + "Sponge is South");
				
				if (b2.getType() == Material.ANVIL) {
					p.sendMessage(ChatColor.GREEN + "Anvil is South");
				} else {
					p.sendMessage(ChatColor.RED + "Missing Anvil");
				}
				
			} else if (!(bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE)) {
				p.sendMessage(ChatColor.RED + "Missing Sponge");
			}
			
		} else if (playerface == "East") {
			
			if (bLoc.add(1,0,0).getBlock().getType() == Material.SPONGE) {
				
				Location bLoc2 = bLoc.add(1,0,0);
				Block b2 = bLoc2.getBlock();
				p.sendMessage(ChatColor.GREEN + "Sponge is East");
				
				if (b2.getType() == Material.ANVIL) {
					p.sendMessage(ChatColor.GREEN + "Anvil is East");
				} else {
					p.sendMessage(ChatColor.RED + "Missing Anvil");
				}
				
			} else if (!(bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE)) {
				p.sendMessage(ChatColor.RED + "Missing Sponge");
			}
			
		} else if (playerface == "West") {
			
			if (bLoc.add(-1,0,0).getBlock().getType() == Material.SPONGE) {
				
				Location bLoc2 = bLoc.add(-1,0,0);
				Block b2 = bLoc2.getBlock();
				p.sendMessage(ChatColor.GREEN + "Sponge is West");
				
				if (b2.getType() == Material.ANVIL) {
					p.sendMessage(ChatColor.GREEN + "Anvil is West");
				} else {
					p.sendMessage(ChatColor.RED + "Missing Anvil");
				}
				
			} else if (!(bLoc.add(0,0,1).getBlock().getType() == Material.SPONGE)) {
				p.sendMessage(ChatColor.RED + "Missing Sponge");
			}
			
		} 
		
	} else {
		
		p.sendMessage(ChatColor.RED + "Missing Stone");
		
	}
	
	}
	
	HandlerList.unregisterAll(Main.GCListen);
	return null;
	
	}
	*/
}
