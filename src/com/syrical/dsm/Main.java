package com.syrical.dsm;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		getLogger().info("DSM has been enabled");
		
	}
	
	@Override
	public void onDisable() {
		
		getLogger().info("DSM has been disabled");
		
	}
	
}
