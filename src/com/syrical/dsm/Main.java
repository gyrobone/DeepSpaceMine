package com.syrical.dsm;

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
	
}
