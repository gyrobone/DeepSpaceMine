package com.syrical.dsm;

import java.util.WeakHashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin {
	
	String color = "red";
	WeakHashMap<Location, String> selections = new WeakHashMap<Location, String>();
	
	@Override
	public void onEnable() {
		
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "DeepSpaceMine has been enabled");
		PluginManager pm = getServer().getPluginManager();
		DSMListener listener = new DSMListener(this);
		pm.registerEvents(listener, this);
		
		if (getConfig().getString("color") == null) {
			
			getConfig().set("color", "red");
			
		}
		
	}
	
	@Override
	public void onDisable() {
		
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "DeepSpaceMine has been disabled");
		
	}
	
	@SuppressWarnings("deprecation")
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
								p2.sendMessage(ChatColor.GREEN + "Here are your swords.");
								return true;
							} else {
								p2.sendMessage(ChatColor.RED + "Invalid arguments.");
								return true;
							}
						case 0:
							ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
							p2.getInventory().addItem(sword);
							p2.sendMessage(ChatColor.GREEN + "Here is your sword.");
							return true;
						default:
							p2.sendMessage(ChatColor.RED + "Your command was not recognized");
							return true;		
							
					}
				
				case "netherportal":
					
					Player p3 = (Player) sender;
					World nether = Bukkit.getServer().getWorld("world_nether");
					Location loc = new Location(nether, 3, 73, 34);
					
					p3.teleport(loc);
					p3.sendMessage(ChatColor.GREEN + "Teleported Successfully!");
					return true;
				
				case "spawn":
					
					Player p4 =(Player) sender;
					World world = Bukkit.getServer().getWorld("world");
					Location loc2 = new Location(world, 80, 76, 248);
					
					p4.teleport(loc2);
					p4.sendMessage(ChatColor.GREEN + "Teleported Successfully!");
					return true;
				
				case "glow":
					
					Player p5 =(Player) sender;
					Location blockLoc = p5.getLocation().add(0, 2, 0);
					
					if (blockLoc.getBlock().getType().equals(Material.AIR)) {
						
						blockLoc.getBlock().setType(Material.GLOWSTONE);
						p5.sendMessage(ChatColor.GREEN + "Successfully placed glowstone.");
						return true;
						
					} else {
						
						p5.sendMessage(ChatColor.RED + "Cannot place block above you.");
						return true;
						
					}
				
				case "jungle":
					
					Player p6 =(Player) sender;
					Location blockLoc2 = p6.getLocation().add(2, 0, 0);
					
					if (blockLoc2.getBlock().getType().equals(Material.AIR)) {
						
						Block jungle = blockLoc2.getBlock();
						jungle.setType(Material.LOG);
						jungle.setData((byte) 3);
						return true;
						
					} else {
						
						p6.sendMessage(ChatColor.RED + "You can't place wood.");
						return true;
						
					}
				
				case "jockey":
					
					Player p7 = (Player) sender;
					Location spawnLoc = p7.getLocation().add(2,0,0);
					World world2 = p7.getWorld();
					
					Spider spider = (Spider) world2.spawnEntity(spawnLoc, EntityType.SPIDER);
					Skeleton skeleton = (Skeleton) world2.spawnEntity(spawnLoc, EntityType.SKELETON);
					spider.setPassenger(skeleton);
					
					return true;
				
				case "nv":
					
					Player p8 = (Player) sender;
					
					p8.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 60000, 1));

				
				case "color":
					
					Player p9 = (Player) sender;
					
					if (args.length == 1) {
						
						switch (args[0].toLowerCase()) {
						
							case "blue":
								color = "blue";
								getConfig().set("color", "blue");
								saveConfig();
								p9.sendMessage(ChatColor.BLUE + "You've selected blue");
								return true;
							
							case "red":
								color = "red";
								getConfig().set("color", "red");
								saveConfig();
								p9.sendMessage(ChatColor.RED + "You've selected red");
								return true;
							
							case "yellow":
								color = "yellow";
								getConfig().set("color", "yellow");
								saveConfig();
								p9.sendMessage(ChatColor.YELLOW + "You've selected yellow");
								return true;
							
							default:
								p9.sendMessage(ChatColor.RED + "Invalid color");
								return true;
						
						}
						
					} else if (args.length == 0) {
						
						p9.sendMessage("Your color is: " + getConfig().getString("color"));
						return true;
						
					} else {
						
						p9.sendMessage(ChatColor.RED + "I'm not sure what color you chose");
						return true;
						
					}
				
				case "tag":
					
					Player p10 = (Player) sender;
					
					if (args.length == 0) {
						
						p10.sendMessage(ChatColor.RED + "Try adding a color");
						return true;
						
					} else {
						
						switch (args[0].toLowerCase()) {
						
							case "blue":
								selections.put(p10.getLocation().add(0, -1, 0), "blue");
								p10.sendMessage(ChatColor.BLUE + "This block has been tagged as blue");
								return true;
							case "red":
								selections.put(p10.getLocation().add(0, -1, 0), "red");
								p10.sendMessage(ChatColor.RED + "This block has been tagged as red");
								return true;
							case "yellow":
								selections.put(p10.getLocation().add(0, -1, 0), "yellow");
								p10.sendMessage(ChatColor.YELLOW + "This block has been tagged as yellow");
								return true;
							default:
								p10.sendMessage(ChatColor.RED + "Color not recognized");
								return true;
								
						}
						
					}
				
				case "colorify":
					
					Player p11 = (Player) sender;
					
					for ( Location loc3 : selections.keySet() ) {
						
						String color = selections.get(loc3);
						Block block = loc3.getBlock();
						
						switch (color.toLowerCase()) {
						
							case "blue":
								block.setType(Material.WOOL);
								block.setData((byte) 11);
								break;
							case "red":
								block.setType(Material.WOOL);
								block.setData((byte) 14);
								break;
							case "yellow":
								block.setType(Material.WOOL);
								block.setData((byte) 4);
								break;
								
						}
						
					}
					
					p11.sendMessage("Your blocks have been colorified");
					return true;
				
				case "gui":
					
					Player p12 = (Player) sender;
					boolean success = DSMGUI.openGUI(p12);
					
					if (!success) {
						
						p12.sendMessage(ChatColor.RED + "Could not open GUI");
						
					}
					
					return true;
					
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
