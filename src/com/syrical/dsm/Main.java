package com.syrical.dsm;

import java.util.WeakHashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	WeakHashMap<Location, String> selections = new WeakHashMap<Location, String>();
	PluginManager pm = getServer().getPluginManager();
	DSMListener listener = new DSMListener(this);
	public static GateCheck gcheck = new GateCheck(null);
	public static GateCalibrationListen GCListen = new GateCalibrationListen(null);
	public static GateWarp gwarp = new GateWarp(null, null);
	
	@Override
	public void onEnable() {
		
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "DeepSpaceMine has been enabled");
		pm.registerEvents(listener, this);
		saveDefaultConfig();
		
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
			
				case "wtp":
					Player p15 = (Player) sender;
					String pName = p15.getName();
					World Carinus = Bukkit.getWorld("world_carinus");
					World Damara = Bukkit.getWorld("world_damara");
					World Opia3 = Bukkit.getWorld("world_opia3");
					World Sirona = Bukkit.getWorld("world_sirona");
			
					if(Bukkit.getServer().getPlayer(pName).isOp() == true) {
						if(args[0].equalsIgnoreCase("Carinus")) {
							if (Carinus == null) {
								WorldCreator creator = new WorldCreator("world_carinus");
								creator.environment(World.Environment.NORMAL);
								creator.generateStructures(false);
								Carinus = creator.createWorld();
							}
							p15.teleport(Carinus.getSpawnLocation());
						} else if(args[0].equalsIgnoreCase("Damara")) {
							if (Damara == null) {
								WorldCreator creator = new WorldCreator("world_damara");
								creator.environment(World.Environment.NORMAL);
								creator.generateStructures(false);
								Damara = creator.createWorld();
							}
							p15.teleport(Damara.getSpawnLocation());
						} else if(args[0].equalsIgnoreCase("Opia3")) {
							if (Opia3 == null) {
								WorldCreator creator = new WorldCreator("world_opia3");
								creator.environment(World.Environment.NORMAL);
								creator.generateStructures(false);
								Opia3 = creator.createWorld();
							}
							p15.teleport(Opia3.getSpawnLocation());
						} else if(args[0].equalsIgnoreCase("Sirona")) {
							if (Sirona == null) {
								WorldCreator creator = new WorldCreator("world_sirona");
								creator.environment(World.Environment.NORMAL);
								creator.generateStructures(false);
								Sirona = creator.createWorld();
							}
							p15.teleport(Sirona.getSpawnLocation());
						}
					}
					return true;
					
				case "gatewarp":
				
					Player p13 = (Player) sender;
					if(args.length == 0) {
						p13.sendMessage(ChatColor.RED + "Invalid Planet");
						return true;
					} else {
						String planet = args[0].toLowerCase();
						
						p13.sendMessage(ChatColor.GREEN + "Click sign to warp");
						GateWarp gwarp = new GateWarp(null, planet);
						pm.registerEvents(gwarp, this);
						return true;
					}
			
				case "gatecalibration":
					
					Player p1 = (Player) sender;
					
					p1.sendMessage(ChatColor.GREEN + "Click sign that you want to calibrate");
					pm.registerEvents(gcheck, this);
					return true;
				
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
					//Location loc2 = new Location(world, 80, 76, 248);
					
					p4.teleport(world.getSpawnLocation());
					p4.sendMessage(ChatColor.GREEN + "Teleported Successfully!");
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
