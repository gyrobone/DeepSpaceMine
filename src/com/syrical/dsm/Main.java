package com.syrical.dsm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		getLogger().info("DeepSpaceMine has been enabled");
		PluginManager pm = getServer().getPluginManager();
		DSMListener listener = new DSMListener(this);
		pm.registerEvents(listener, this);
		
	}
	
	@Override
	public void onDisable() {
		
		getLogger().info("DeepSpaceMine has been disabled");
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (sender instanceof Player) {
			
			String lowerCmd = cmd.getName().toLowerCase();
			
			switch (lowerCmd) {
			
				//test command, remove later
				case "givesword":
					
					Player p2 = (Player) sender; 
					int length = args.length;
					
					switch (length) {
					
						case 1:
							if ( args[0].equalsIgnoreCase("2") ) {
								ItemStack sword = new ItemStack(Material.IRON_SWORD, 2);
								p2.getInventory().addItem(sword);
								p2.sendMessage("Here are your swords.");
								return true;
							} else {
								p2.sendMessage(ChatColor.RED + "Invalid arguments.");
								return true;
							}
						case 0:
							ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
							p2.getInventory().addItem(sword);
							p2.sendMessage("Here is your sword.");
							return true;
						default:
							p2.sendMessage("Your command was not recognized");
							return true;		
							
					}
				
				case "netherportal":
					
					Player p3 = (Player) sender;
					World nether = Bukkit.getServer().getWorld("world_nether");
					Location loc = new Location(nether, 3, 73, 34);
					
					p3.teleport(loc);
					return true;
				
				case "spawn":
					
					Player p4 =(Player) sender;
					World world = Bukkit.getServer().getWorld("world");
					Location loc2 = new Location(world, 80, 76, 248);
					
					p4.teleport(loc2);
					
				default:
					
					return true;
			
			}
			
		} else if (sender instanceof ConsoleCommandSender) {
			
			getServer().getConsoleSender().sendMessage(ChatColor.RED + "You can't use player commands in the console");
			return true;
			
		}
		
		return true;
		
	}
	
}
