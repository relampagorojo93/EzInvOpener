package relampagorojo93.EzInvOpener.FilePckg;

import java.io.File;

import relampagorojo93.LibsCollection.SpigotPlugin.LoadOn;
import relampagorojo93.LibsCollection.SpigotPlugin.PluginModule;

public class FileModule extends PluginModule {
	
	public boolean load() {
		// File creation
		if (!PLUGIN_FOLDER.exists())
			PLUGIN_FOLDER.mkdir();
		return true;
	}

	@Override
	public boolean unload() {
		return true;
	}

	@Override
	public LoadOn loadOn() {
		return LoadOn.BEFORE_LOAD;
	}

	@Override
	public boolean optional() {
		return false;
	}

	@Override
	public boolean allowReload() {
		return true;
	}
	
	public final File PLUGIN_FOLDER = new File("plugins/EzInvOpener");
	public final File ENTITIES_FILE = new File(PLUGIN_FOLDER.getPath() + "/Entities.yml");
	
	public final File MMOHORSES_PLUGIN_FOLDER = new File("plugins/MMOHorses");
	public final File MMOHORSES_NPCS_FILE = new File(MMOHORSES_PLUGIN_FOLDER.getPath() + "/NPCs.yml");
}
