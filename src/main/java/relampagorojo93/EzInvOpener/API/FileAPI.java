package relampagorojo93.EzInvOpener.API;

import java.io.File;

import relampagorojo93.EzInvOpener.FilePckg.FileModule;

public class FileAPI {
	private FileModule file;

	public FileAPI(FileModule file) {
		this.file = file;
	}

	public File getEntitiesFile() {
		return file.ENTITIES_FILE;
	}

	public File getPluginFolder() {
		return file.PLUGIN_FOLDER;
	}

	public File getMMOHorsesNPCsFile() {
		return file.MMOHORSES_NPCS_FILE;
	}

	public File getMMOHorsesFolder() {
		return file.MMOHORSES_PLUGIN_FOLDER;
	}
}
