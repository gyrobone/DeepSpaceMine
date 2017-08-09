package com.syrical.dsm;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DSMGUI {
	
	public static ItemSmith smithy = new ItemSmith();
	public static Inventory dsmGUI = Bukkit.createInventory(null, 27, "DSM GUI");
	
	public DSMGUI() {
		
	}
	
	public static boolean openGUI(Player player) {
		
		dsmGUI.setItem(0, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(1, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(2, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(3, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(4, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(5, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(6, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(7, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(8, new ItemStack(Material.AIR, 1));
		
		dsmGUI.setItem(9, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(10, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(11, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(12, smithy.noobspick(1));
		dsmGUI.setItem(13, new ItemStack(Material.IRON_SWORD, 1));
		dsmGUI.setItem(14, new ItemStack(Material.IRON_AXE, 1));
		dsmGUI.setItem(15, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(16, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(17, new ItemStack(Material.AIR, 1));
		
		dsmGUI.setItem(18, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(19, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(20, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(21, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(22, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(23, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(24, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(25, new ItemStack(Material.AIR, 1));
		dsmGUI.setItem(26, new ItemStack(Material.AIR, 1));
		
		player.openInventory(dsmGUI);
		return true;
		
	}
	
}
