package com.syrical.dsm;

import org.bukkit.ChatColor;
import org.bukkit.Material;
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
					
					Player player = (Player) sender; 
					
					int length = args.length;
					
					switch (length) {
					
						case 1:
							if ( args[0].equalsIgnoreCase("2") ) {
								ItemStack sword = new ItemStack(Material.IRON_SWORD, 2);
								player.getInventory().addItem(sword);
								player.sendMessage("Here are your swords.");
								return true;
							} else {
								player.sendMessage("Invalid arguments.");
								return true;
							}
						case 0:
							ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
							player.getInventory().addItem(sword);
							player.sendMessage("Here is your sword.");
							return true;
						default:
							player.sendMessage("Your command was not recognized");
							return true;
							
					}
					
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
