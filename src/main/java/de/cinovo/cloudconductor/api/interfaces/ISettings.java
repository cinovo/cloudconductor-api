package de.cinovo.cloudconductor.api.interfaces;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.Settings;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path(IRestPath.SETTINGS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ISettings {
	
	/**
	 * @return set of service objects
	 */
	@GET
	Settings get();
	
	/**
	 * @param settings the settings to save
	 */
	@PUT
	@RolesAllowed({"EDIT_CONFIGURATIONS"})
	void save(Settings settings);
}
