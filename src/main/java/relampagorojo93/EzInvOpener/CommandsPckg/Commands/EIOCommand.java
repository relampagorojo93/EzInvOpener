package relampagorojo93.EzInvOpener.CommandsPckg.Commands;

import java.util.Arrays;

import relampagorojo93.LibsCollection.SpigotCommands.Objects.Command;

public class EIOCommand extends Command {
	public EIOCommand() {
		super("caketwitch", "ezinvopener", "EzInvOpener.Staff",
				"Get all the EzInvOpener commands", "[help|command]",
				Arrays.asList("eio"));
		addCommand(new AttachSubCommand(this));
		addCommand(new UnattachSubCommand(this));
		sortCommands();
		addCommand(new HelpSubCommand(this), 0);
	}
}