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



public class GateWarpListen implements Listener {

	public GateWarpListen(Main plugin) {
		
		
		
	}
	
	@EventHandler
	public void onClickedBlock (PlayerInteractEvent e) {
		
		Player p = (Player) e.getPlayer();
		Block b = e.getClickedBlock();
		Material block = b.getType();
		
		if (block.equals(Material.SIGN_POST) || block.equals(Material.WALL_SIGN)|| block.equals(Material.SIGN)) {
			
			Sign s = (Sign) b.getState();
			String[] ln = s.getLines();

			if (ln[0].toLowerCase().equalsIgnoreCase("[Nether]")) {
					
				p.sendMessage("poop");
				HandlerList.unregisterAll(Main.GWListen);
					
			} else {
				
				p.sendMessage(ChatColor.RED + "Invalid Warp");
				HandlerList.unregisterAll(Main.GWListen);
				
			}
			
		} else {
			
			p.sendMessage(ChatColor.RED + "Invalid Block");
			HandlerList.unregisterAll(Main.GWListen);
			
		}
	}
	
}
