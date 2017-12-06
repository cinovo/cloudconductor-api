package de.cinovo.cloudconductor.api.interfaces;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.enums.ServiceState;
import de.cinovo.cloudconductor.api.model.Host;

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
	List<Host> getHosts();
	
	/**
	 * @param hostName the host name
	 * @return the Host
	 */
	@GET
	@Path("/{host}")
	@RolesAllowed({"VIEW_HOST", "EDIT_HOST"})
	Host getHost(@PathParam("host") String hostName);
	
	/**
	 * @param hostName the host name
	 */
	@DELETE
	@Path("/{host}")
	@RolesAllowed({"EDIT_HOST"})
	void deleteHost(@PathParam("host") String hostName);
	
	/**
	 * @param hostName the host name
	 * @param serviceName the service name
	 * @param newState the new state
	 */
	@PUT
	@Path("/{host}/{service}")
	@RolesAllowed({"EDIT_HOST"})
	void setServiceState(@PathParam("host") String hostName, @PathParam("service") String serviceName, ServiceState newState);
}
