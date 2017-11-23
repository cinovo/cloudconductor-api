package de.cinovo.cloudconductor.api.interfaces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.AgentOption;
import de.cinovo.cloudconductor.api.model.PackageState;
import de.cinovo.cloudconductor.api.model.PackageStateChanges;
import de.cinovo.cloudconductor.api.model.ServiceStates;
import de.cinovo.cloudconductor.api.model.ServiceStatesChanges;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * 
 * Copyright 2017 Cinovo AG<br>
 * <br>
 * 
 * @author mweise
 *
 */
@Path(IRestPath.AGENT)
public interface IAgent {
	
	/**
	 * @param template the template name
	 * @param host the host name
	 * @param rpmState the rpm state
	 * @param uuid the UUID of the agent
	 * @return list of instructions with changes to match the template
	 */
	@PUT
	@Path(IRestPath.AGENT_PACKAGE_STATE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"USE_AGENT_API"})
	PackageStateChanges notifyPackageState(@PathParam(IRestPath.VAR_TEMPLATE) String template, @PathParam(IRestPath.VAR_HOST) String host, PackageState rpmState, @PathParam(IRestPath.VAR_UUID) String uuid);
	
	/**
	 * @param template the template name
	 * @param host the host name
	 * @param serviceState the service state
	 * @param uuid the UUID of the agent
	 * @return list of instructions with changes to match the template
	 */
	@PUT
	@Path(IRestPath.AGENT_SERVICE_STATE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"USE_AGENT_API"})
	ServiceStatesChanges notifyServiceState(@PathParam(IRestPath.VAR_TEMPLATE) String template, @PathParam(IRestPath.VAR_HOST) String host, ServiceStates serviceState, @PathParam(IRestPath.VAR_UUID) String uuid);
	
	/**
	 * @param template the template name
	 * @param host the host name
	 * @param agent the agent name
	 * @param uuidString the UUID of the agent
	 * @return the current agent options
	 */
	@GET
	@Path(IRestPath.AGENT_HEART_BEAT)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"USE_AGENT_API"})
	AgentOption heartBeat(@PathParam(IRestPath.VAR_TEMPLATE) String template, @PathParam(IRestPath.VAR_HOST) String host, @PathParam(IRestPath.VAR_AGENT) String agent, @PathParam(IRestPath.VAR_UUID) String uuidString);
	
}
