package relampagorojo93.EzInvOpener;

import org.bukkit.Bukkit;

import relampagorojo93.EzInvOpener.API.EIOAPI;
import relampagorojo93.EzInvOpener.Bukkit.Events.PlayerEvents;
import relampagorojo93.EzInvOpener.CommandsPckg.CommandsModule;
import relampagorojo93.EzInvOpener.EntitiesPckg.EntitiesModule;
import relampagorojo93.EzInvOpener.FilePckg.FileModule;
import relampagorojo93.EzInvOpener.FilePckg.Messages.MessageString;
import relampagorojo93.EzInvOpener.InvPckg.InvModule;
import relampagorojo93.EzInvOpener.MiscModules.UtilsModule;
import relampagorojo93.LibsCollection.SpigotPlugin.MainClass;

public class EIOpener extends MainClass {

	//---------------------------------------------------------------//
	//MainClass methods
	//---------------------------------------------------------------//
	
	public EIOpener() {
		super(
				new UtilsModule(),
				new FileModule(),
				new InvModule(),
				new EntitiesModule(),
				new CommandsModule()
				);
	}

	@Override
	public String getPrefix() {
		return MessageString.PREFIX.toString();
	}

	@Override
	public boolean canLoad() {
		return true;
	}

	@Override
	public boolean canEnable() {
		return true;
	}

	@Override
	public boolean load() {
		return true;
	}

	@Override
	public boolean enable() {
		Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
		new MetricsLite(this, 10083);
		Bukkit.getLogger().info(getPrefix() + "");
		Bukkit.getLogger().info(getPrefix() + "                                     __                    ");
		Bukkit.getLogger().info(getPrefix() + "                       _            |  |                   ");
		Bukkit.getLogger().info(getPrefix() + "                     _| |___ ___ ___|  |                   ");
		Bukkit.getLogger().info(getPrefix() + "                    | . | . |   | -_|__|                   ");
		Bukkit.getLogger().info(getPrefix() + "                    |___|___|_|_|___|__|                   ");
		Bukkit.getLogger().info(getPrefix() + "");
		return true;
	}

	@Override
	public boolean disable() {
		Bukkit.getLogger().info(getPrefix() + "");
		Bukkit.getLogger().info(getPrefix() + "                                            __             ");
		Bukkit.getLogger().info(getPrefix() + "                      _           _       _|  |            ");
		Bukkit.getLogger().info(getPrefix() + "              _ _ ___| |___ ___ _| |___ _| |  |            ");
		Bukkit.getLogger().info(getPrefix() + "             | | |   | | . | .'| . | -_| . |__|            ");
		Bukkit.getLogger().info(getPrefix() + "             |___|_|_|_|___|__,|___|___|___|__|            ");
		Bukkit.getLogger().info(getPrefix() + "");
		return true;
	}

	@Override
	public boolean beforeLoad() {
		new EIOAPI(this);
		return true;
	}

	@Override
	public boolean beforeEnable() {
		Bukkit.getLogger().info(getPrefix() + "");
		Bukkit.getLogger().info(getPrefix() + "      _____     _____         _____                         ");
		Bukkit.getLogger().info(getPrefix() + "     |   __|___|     |___ _ _|     |___ ___ ___ ___ ___     ");
		Bukkit.getLogger().info(getPrefix() + "     |   __|- _|-   -|   | | |  |  | . | -_|   | -_|  _|    ");
		Bukkit.getLogger().info(getPrefix() + "     |_____|___|_____|_|_|\\_/|_____|  _|___|_|_|___|_|      ");
		Bukkit.getLogger().info(getPrefix() + "                                   |_|                      ");
		Bukkit.getLogger().info(getPrefix() + "                                                            ");
		Bukkit.getLogger().info(getPrefix() + "               By relampagorojo93/DarkPanda73               ");
		Bukkit.getLogger().info(getPrefix() + "                                                            ");
		Bukkit.getLogger().info(getPrefix() + "                 _           _ _                            ");
		Bukkit.getLogger().info(getPrefix() + "                | |___ ___ _| |_|___ ___                    ");
		Bukkit.getLogger().info(getPrefix() + "                | | . | .'| . | |   | . |_ _ _              ");
		Bukkit.getLogger().info(getPrefix() + "                |_|___|__,|___|_|_|_|_  |_|_|_|             ");
		Bukkit.getLogger().info(getPrefix() + "                                    |___|                   ");
		Bukkit.getLogger().info(getPrefix() + "");
		return true;
	}

	@Override
	public boolean beforeDisable() {
		return true;
	}

	//---------------------------------------------------------------//
	//Modules
	//---------------------------------------------------------------//
	
	public FileModule getFileModule() {
		return (FileModule) getModule(FileModule.class);
	}
	
	public UtilsModule getUtilsModule() {
		return (UtilsModule) getModule(UtilsModule.class);
	}
	
	public InvModule getInvModule() {
		return (InvModule) getModule(InvModule.class);
	}
	
	public EntitiesModule getEntitiesModule() {
		return (EntitiesModule) getModule(EntitiesModule.class);
	}

	public CommandsModule getCommandsModule() {
		return (CommandsModule) getModule(CommandsModule.class);
	}
	
}
