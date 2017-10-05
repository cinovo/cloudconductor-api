package de.cinovo.cloudconductor.api.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.enums.ServiceState;
import de.cinovo.cloudconductor.api.model.Host;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path(IRestPath.HOST)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IHost {
	
	/**
	 * @return list of hosts
	 */
	@GET
	List<Host> getHosts();
	
	/**
	 * @param hostName the host name
	 * @return the Host
	 */
	@GET
	@Path(IRestPath.HOST_DETAIL)
	Host getHost(@PathParam(IRestPath.VAR_HOST) String hostName);
	
	/**
	 * @param hostName the host name
	 */
	@DELETE
	@Path(IRestPath.HOST_DETAIL)
	void deleteHost(@PathParam(IRestPath.VAR_HOST) String hostName);
	
	/**
	 * @param hostName the host name
	 * @param serviceName the service name
	 * @param newState the new state
	 */
	@PUT
	@Path(IRestPath.HOST_SERVICE_SVC)
	void setServiceState(@PathParam(IRestPath.VAR_HOST) String hostName, @PathParam(IRestPath.VAR_SERVICE) String serviceName, ServiceState newState);
}
