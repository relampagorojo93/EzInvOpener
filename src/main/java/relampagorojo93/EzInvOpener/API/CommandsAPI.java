package relampagorojo93.EzInvOpener.API;

import relampagorojo93.EzInvOpener.CommandsPckg.CommandsModule;
import relampagorojo93.EzInvOpener.CommandsPckg.Commands.EIOCommand;

public class CommandsAPI {
	private CommandsModule commands;

	public CommandsAPI(CommandsModule commands) {
		this.commands = commands;
	}

	public EIOCommand getEIOCommand() {
		return commands.getEIOCommand();
	}
}
