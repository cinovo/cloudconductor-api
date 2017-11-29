package de.cinovo.cloudconductor.api.interfaces;

import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.enums.UserPermissions;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author mweise
 */
@Path("/permission")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IPermission {
	
	/**
	 * @return set of all possible permissions
	 */
	@GET
	@RolesAllowed({"VIEW_USERS", "EDIT_USERS"})
	Set<UserPermissions> getPermissions();

}
