package relampagorojo93.EzInvOpener.CommandsPckg.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import relampagorojo93.EzInvOpener.API.EIOAPI;
import relampagorojo93.EzInvOpener.API.Objects.EzInventory;
import relampagorojo93.EzInvOpener.FilePckg.Messages.MessageString;
import relampagorojo93.LibsCollection.SpigotCommands.Objects.Command;
import relampagorojo93.LibsCollection.SpigotCommands.Objects.SubCommand;
import relampagorojo93.LibsCollection.SpigotMessages.MessagesUtils;

public class AttachSubCommand extends SubCommand {

	public AttachSubCommand(Command parent) {
		super(parent, "attach", "attach", "", "Attach an inventory to an entity", "[inventory]",
				Arrays.asList("a"));
	}

	@Override
	public List<String> tabComplete(Command cmd, CommandSender sender, String[] args) {
		List<String> list = new ArrayList<>();
		for (EzInventory inventory : EIOAPI.getInvAPI().getInventories())
			list.add((inventory.getPlugin().getName() + "." + inventory.getName()).toLowerCase());
		return list;
	}

	@Override
	public boolean execute(Command cmd, CommandSender sender, String[] args, boolean useids) {
		Player pl = sender instanceof Player ? (Player) sender : null;
		if (pl != null) {
			if (EIOAPI.getEntitiesAPI().getRegistering(pl.getUniqueId()) == null) {
				if (args.length > 1) {
					EzInventory inv = EIOAPI.getInvAPI().getInventory(args[1]);
					if (inv != null) {
						EIOAPI.getEntitiesAPI().startRegistering(pl.getUniqueId(), args[1]);
						MessagesUtils.getMessageBuilder().createMessage(EIOAPI.getUtils().applyPrefix(MessageString.ENTITYATTACHING)).sendMessage(sender);
					} else {
						String msg = "Available inventories:";
						for (EzInventory inventory : EIOAPI.getInvAPI().getInventories())
							msg += (msg.endsWith(":") ? " " : ", ")
									+ (inventory.getPlugin().getName() + "." + inventory.getName()).toLowerCase();
						MessagesUtils.getMessageBuilder().createMessage(EIOAPI.getUtils().applyPrefix(msg)).sendMessage(sender);
					}
				} else
					MessagesUtils.getMessageBuilder().createMessage(EIOAPI.getUtils().applyPrefix(getUsage())).sendMessage(sender);
			} else {
				EIOAPI.getEntitiesAPI().stopRegistering(pl.getUniqueId());
				MessagesUtils.getMessageBuilder().createMessage(EIOAPI.getUtils().applyPrefix(MessageString.ENTITYATTACHCANCELLED)).sendMessage(sender);
			}
		} else
			MessagesUtils.getMessageBuilder().createMessage(EIOAPI.getUtils().applyPrefix(MessageString.CONSOLEDENIED)).sendMessage(sender);
		return true;
	}
}
