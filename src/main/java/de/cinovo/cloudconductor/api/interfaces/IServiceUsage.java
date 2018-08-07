package de.cinovo.cloudconductor.api.interfaces;

import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.MediaType;

/**
 * 
 * Copyright 2018 Cinovo AG<br>
 * <br>
 * 
 * @author mweise
 *
 */
@Path("/serviceusages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IServiceUsage {
	
	/**
	 * @return map service -> serviceUsage (template -> package)
	 */
	@GET
	@Path("/")
	@RolesAllowed({"VIEW_CONFIGURATIONS", "EDIT_CONFIGURATIONS"})
	Map<String, Map<String, String>> getServiceUsages();
	
}
