package de.cinovo.cloudconductor.api.interfaces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.ChangeServiceState;
import de.cinovo.cloudconductor.api.model.Host;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path("/host")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IHost {

	/**
	 * @return list of hosts
	 */
	@GET
	@RolesAllowed({"VIEW_HOST", "EDIT_HOST"})
	Host[] getHosts();

	/**
	 * @param hostUuid the host uuid
	 * @return the Host
	 */
	@GET
	@Path("/{host}")
	@RolesAllowed({"VIEW_HOST", "EDIT_HOST"})
	Host getHost(@PathParam("host") String hostUuid);

	/**
	 * @param hostUuid the host uuid
	 */
	@DELETE
	@Path("/{host}")
	@RolesAllowed({"EDIT_HOST"})
	void deleteHost(@PathParam("host") String hostUuid);

	/**
	 * @param changeServiceState the change service state object
	 */
	@PUT
	@Path("/changeservicestate")
	@RolesAllowed({"EDIT_HOST"})
	void setServiceState(ChangeServiceState changeServiceState);
}
