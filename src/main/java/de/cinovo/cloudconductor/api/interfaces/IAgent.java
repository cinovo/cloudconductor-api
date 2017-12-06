package de.cinovo.cloudconductor.api.interfaces;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.AgentOption;
import de.cinovo.cloudconductor.api.model.PackageState;
import de.cinovo.cloudconductor.api.model.PackageStateChanges;
import de.cinovo.cloudconductor.api.model.ServiceStates;
import de.cinovo.cloudconductor.api.model.ServiceStatesChanges;

/**
 * 
 * Copyright 2017 Cinovo AG<br>
 * <br>
 * 
 * @author mweise
 *
 */
@Path("/agent")
public interface IAgent {
	
	/**
	 * @param template the template name
	 * @param host the host name
	 * @param rpmState the rpm state
	 * @param uuid the UUID of the agent
	 * @return list of instructions with changes to match the template
	 */
	@PUT
	@Path("/{template}/{host}/{uuid}/package")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"USE_AGENT_API"})
	PackageStateChanges notifyPackageState(@PathParam("template") String template, @PathParam("host") String host, PackageState rpmState, @PathParam("uuid") String uuid);
	
	/**
	 * @param template the template name
	 * @param host the host name
	 * @param serviceState the service state
	 * @param uuid the UUID of the agent
	 * @return list of instructions with changes to match the template
	 */
	@PUT
	@Path("/{template}/{host}/{uuid}/service")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"USE_AGENT_API"})
	ServiceStatesChanges notifyServiceState(@PathParam("template") String template, @PathParam("host") String host, ServiceStates serviceState, @PathParam("uuid") String uuid);
	
	/**
	 * @param template the template name
	 * @param host the host name
	 * @param agent the agent name
	 * @param uuidString the UUID of the agent
	 * @return the current agent options
	 */
	@GET
	@Path("/{template}/{host}/{agent}/{uuid}/heartbeat")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"USE_AGENT_API"})
	AgentOption heartBeat(@PathParam("template") String template, @PathParam("host") String host, @PathParam("agent") String agent, @PathParam("uuid") String uuidString);
	
}
