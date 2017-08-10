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
	
	@EventHandler
	public void onBlockPlace (BlockPlaceEvent e) {
		
		Player p = (Player) e.getPlayer();
		Block b = e.getBlock();
		Material blockN = b.getRelative(BlockFace.NORTH).getType();
		Material blockS = b.getRelative(BlockFace.SOUTH).getType();
		Material blockE = b.getRelative(BlockFace.EAST).getType();
		Material blockW = b.getRelative(BlockFace.WEST).getType();
		Location spongelocN = b.getLocation().add(0,0,-1);
		Location spongelocS = b.getLocation().add(0,0,1);
		Location spongelocE = b.getLocation().add(1,0,0);
		Location spongelocW = b.getLocation().add(-1,0,0);
		Block spongeblockN = spongelocN.getBlock();
		Block spongeblockS = spongelocS.getBlock();
		Block spongeblockE = spongelocE.getBlock();
		Block spongeblockW = spongelocW.getBlock();
		Material sponge = Material.SPONGE;
		
		if (b.getType() == Material.WALL_SIGN) {
		
			if (blockN == sponge ) {
		
			}
			
		} else {
			
			p.sendMessage(ChatColor.RED + "MultiBlock Failed!");
			HandlerList.unregisterAll(Main.GCListen);
			
		}
		
	}
	
}
