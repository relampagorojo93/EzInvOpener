package relampagorojo93.EzInvOpener.Bukkit.Events;

import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;

import relampagorojo93.EzInvOpener.API.EIOAPI;
import relampagorojo93.EzInvOpener.API.Objects.EzInventory;
import relampagorojo93.EzInvOpener.Bukkit.Events.Custom.PlayerOpenEzInventory;
import relampagorojo93.EzInvOpener.FilePckg.Messages.MessageString;
import relampagorojo93.LibsCollection.SpigotMessages.MessagesUtils;
import relampagorojo93.LibsCollection.SpigotMessages.Instances.ClickEvent;
import relampagorojo93.LibsCollection.SpigotMessages.Instances.TextReplacement;
import relampagorojo93.LibsCollection.SpigotMessages.Instances.ClickEvent.Action;

public class PlayerEvents implements Listener {

	public Method getHand;

	public PlayerEvents() {
		try {
			getHand = PlayerInteractEntityEvent.class.getMethod("getHand");
		} catch (Exception e) {
			getHand = null;
		}
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		EIOAPI.getEntitiesAPI().stopRegistering(e.getPlayer().getUniqueId());
	}
	
	@EventHandler
	public void onEntityDeath(EntityDamageEvent e) {
		if (e.getEntity() != null && EIOAPI.getEntitiesAPI().getEntityAttach(e.getEntity().getUniqueId()) != null)
			e.setCancelled(true);
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerInteract(PlayerInteractAtEntityEvent e) {
		try {
			if (getHand != null && getHand.invoke(e) != EquipmentSlot.HAND)
				return;
		} catch (Exception ex) {
		}
		if (!e.isCancelled() && e.getRightClicked() != null && !(e.getRightClicked() instanceof Player)) {
			String registering = EIOAPI.getEntitiesAPI().getRegistering(e.getPlayer().getUniqueId());
			if (registering != null) {
				e.setCancelled(true);
				EIOAPI.getEntitiesAPI().stopRegistering(e.getPlayer().getUniqueId());
				EIOAPI.getEntitiesAPI().registerEntity(e.getRightClicked().getUniqueId(), registering);
				MessagesUtils.getMessageBuilder().createMessage(EIOAPI.getUtils().applyPrefix(MessageString.ENTITYATTACHED)).sendMessage(e.getPlayer());;
			} else {
				String name = EIOAPI.getEntitiesAPI().getEntityAttach(e.getRightClicked().getUniqueId());
				if (name != null) {
					e.setCancelled(true);
					if (!e.getPlayer().isSneaking() || !e.getPlayer().hasPermission("EzInvOpener.Staff")) {
						EzInventory inv = EIOAPI.getInvAPI().getInventory(name);
						if (inv != null) {
							PlayerOpenEzInventory event = new PlayerOpenEzInventory(e.getPlayer(), inv);
							Bukkit.getPluginManager().callEvent(event);
							if (!event.isCancelled()) {
								Inventory binv = event.getEzInventory().getInventoryMaker().getInventory(event.getPlayer());
								if (binv != null) e.getPlayer().openInventory(binv);
							}
						}
					} else
						MessagesUtils.getMessageBuilder().createMessage(new TextReplacement[] {
								new TextReplacement("{button}", () -> "§a§l[✓]", new ClickEvent(Action.RUN_COMMAND, 
										"/ezinvopener unattach " + e.getRightClicked().getUniqueId()))
						}, true, "§eAre you sure you want to unattach the inventory from the entity? {button}").sendMessage(e.getPlayer());
				}
			}
		}
	}
}
