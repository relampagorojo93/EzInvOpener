package relampagorojo93.EzInvOpener.API.Objects;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class EzInventory {
	
	private Plugin plugin;
	private String name, fullpath;
	private InventoryMaker inventorymaker;
	
	public EzInventory(Plugin plugin, String name, InventoryMaker inventorymaker) {
		this.plugin = plugin;
		this.name = name;
		this.inventorymaker = inventorymaker;
		this.fullpath = (plugin.getName() + "." + name).toLowerCase();
	}
	
	public Plugin getPlugin()  {
		return plugin;
	}
	
	public String getName() {
		return name;
	}
	
	public InventoryMaker getInventoryMaker() {
		return inventorymaker;
	}
	
	public String getFullPath() {
		return fullpath;
	}
	
	public static interface InventoryMaker {
		Inventory getInventory(Player pl);
	}
}
