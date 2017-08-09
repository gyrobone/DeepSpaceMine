package com.syrical.dsm;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemSmith {

	public ItemStack makeItem(Material m, String name, String desc, int amount) {
		
		ItemStack item= new ItemStack (m, amount);
		
		//Create Item's Meta Data
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		//Create Lore
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(desc);
		im.setLore(lore);
		//Hide Vanilla Tool Tip
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		//Sets Item Meta Data
		item.setItemMeta(im);
		
		return item;
		
	}
	
	public ItemStack noobspick(int amount) {
		
		Material m = Material.STONE_PICKAXE;
		String name = (ChatColor.GRAY + "Noob's Pickaxe");
		String desc = ("Pickaxe for losers.");
		
		return makeItem(m, name, desc, amount);
		
	}
}
