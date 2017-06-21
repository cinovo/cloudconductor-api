package de.cinovo.cloudconductor.api.interfaces;

/*
 * #%L
 * cloudconductor-api
 * %%
 * Copyright (C) 2013 - 2014 Cinovo AG
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 * #L%
 */

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.AgentOptions;
import de.cinovo.cloudconductor.api.model.PackageState;
import de.cinovo.cloudconductor.api.model.PackageStateChanges;
import de.cinovo.cloudconductor.api.model.ServiceStates;
import de.cinovo.cloudconductor.api.model.ServiceStatesChanges;

/**
 * Rest API for usage with node agent.
 * 
 * Copyright 2013 Cinovo AG<br>
 * <br>
 * 
 * @author psigloch
 * 
 */
@Path(IRestPath.AGENT)
public interface IAgent {
	
	/**
	 * @return list of living agents listed within the cloudconductor.
	 */
	@GET
	@Path(IRestPath.ROOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Set<String> getAliveAgents();
	
	/**
	 * @param template the template name
	 * @param host the host name
	 * @param rpmState the rpm state
	 * @return list of instructions with changes to match the template
	 */
	@PUT
	@Path(IRestPath.AGENT_PACKAGE_STATE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PackageStateChanges notifyPackageState(@PathParam(IRestPath.VAR_TEMPLATE) String template, @PathParam(IRestPath.VAR_HOST) String host, PackageState rpmState, @PathParam(IRestPath.VAR_UUID) String uuid);
	
	/**
	 * @param template the template name
	 * @param host the host name
	 * @param serviceState the service state
	 * @return list of instructions with changes to match the template
	 */
	@PUT
	@Path(IRestPath.AGENT_SERVICE_STATE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceStatesChanges notifyServiceState(@PathParam(IRestPath.VAR_TEMPLATE) String template, @PathParam(IRestPath.VAR_HOST) String host, ServiceStates serviceState, @PathParam(IRestPath.VAR_UUID) String uuid);
	
	/**
	 * @param template the template name
	 * @param host the host name
	 * @param agent the agent name
	 * @return the current agent options
	 */
	@GET
	@Path(IRestPath.AGENT_HEART_BEAT)
	@Produces(MediaType.APPLICATION_JSON)
	public AgentOptions heartBeat(@PathParam(IRestPath.VAR_TEMPLATE) String template, @PathParam(IRestPath.VAR_HOST) String host, @PathParam(IRestPath.VAR_AGENT) String agent, @PathParam(IRestPath.VAR_UUID) String uuid);
	
	/**
	 * @return check if server is alive
	 */
	@GET
	@Path(IRestPath.AGENT_PING)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean isServerAlive();
}
