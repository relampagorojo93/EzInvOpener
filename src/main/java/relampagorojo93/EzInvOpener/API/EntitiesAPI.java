package relampagorojo93.EzInvOpener.API;

import java.util.List;
import java.util.UUID;

import relampagorojo93.EzInvOpener.EntitiesPckg.EntitiesModule;

public class EntitiesAPI {
	private EntitiesModule entities;

	public EntitiesAPI(EntitiesModule entities) {
		this.entities = entities;
	}

	public void registerEntity(UUID uuid, String invpath) {
		entities.registerEntity(uuid, invpath);
	}

	public void unregisterEntity(UUID uuid) {
		entities.unregisterEntity(uuid);
	}

	public String getEntityAttach(UUID uuid) {
		return entities.getEntityAttach(uuid);
	}

	public List<UUID> getEntities() {
		return entities.getEntities();
	}


	public void startRegistering(UUID uuid, String invpath) {
		entities.startRegistering(uuid, invpath);
	}

	public void stopRegistering(UUID uuid) {
		entities.stopRegistering(uuid);
	}

	public String getRegistering(UUID uuid) {
		return entities.getRegistering(uuid);
	}
}
