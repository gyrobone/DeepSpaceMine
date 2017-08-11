package com.syrical.dsm;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class GateCalibrationListen implements Listener {
	
	public GateCalibrationListen(Main plugin) {
		
		
		
	}
	
	public GateCalibrationListen  onCheck (String playerface, Player p, Location loc) {
		
		Block b = loc.getBlock();
		Location bLoc = b.getLocation();
		
		if (b.getType() == Material.STONE) {
			
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
		
		
		
		HandlerList.unregisterAll(Main.GCListen);
		return null;
		
	}
	
	@EventHandler
	public GateCalibrationListen onSignPlace (BlockPlaceEvent event) {
		
		Player player = (Player) event.getPlayer();
		Block block = event.getBlock();
		
		if (block.getType() == Material.WALL_SIGN || block.getType() == Material.SIGN_POST) {
			
			org.bukkit.material.Sign sign = (org.bukkit.material.Sign) block.getState().getData();
			BlockFace facing = sign.getFacing();
			
			if (facing == BlockFace.NORTH) {
				return onCheck("South", player, block.getLocation().add(0,0,1));
			} else if (facing == BlockFace.SOUTH) {
				return onCheck("North", player, block.getLocation().add(0,0,-1));
			} else if (facing == BlockFace.EAST) {
				return onCheck("West", player, block.getLocation().add(-1,0,0));
			} else if (facing == BlockFace.WEST) {
				return onCheck("East", player, block.getLocation().add(1,0,0));
			}
			
		} else {
			
			player.sendMessage(ChatColor.RED + "Wrong Block");
			
		}

		return null;
		
	}
	
}
