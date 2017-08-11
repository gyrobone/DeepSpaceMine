package com.syrical.dsm;

import org.bukkit.ChatColor;
import org.bukkit.Material;
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
		Material block = b.getType();
		
		if (block.equals(Material.WALL_SIGN)) {
				
			Sign s = (Sign) b.getState();
			String[] ln = s.getLines();
				
			if (ln[1].toLowerCase().equalsIgnoreCase(ChatColor.DARK_GREEN + ""+ ChatColor.BOLD + "Active")) {
					
				p.sendMessage("poop");
				HandlerList.unregisterAll(Main.gwarp);
						
			} else {
					
				p.sendMessage(ChatColor.RED + "Invalid Warp");
				HandlerList.unregisterAll(Main.gwarp);
					
			}
			
		}
		
	}
	
}
