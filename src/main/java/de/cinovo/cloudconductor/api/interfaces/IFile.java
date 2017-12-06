package de.cinovo.cloudconductor.api.interfaces;

/*
 * #%L
 * cloudconductor-api
 * %%
 * Copyright (C) 2013 - 2014 Cinovo AG
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.ConfigFile;

/**
 * Copyright 2013 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path("/file")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IFile {
	
	/**
	 * @return all configuration files
	 */
	@GET
	@RolesAllowed({"VIEW_CONFIGURATIONS", "EDIT_CONFIGURATIONS", "USE_AGENT_API"})
	ConfigFile[] get();
	
	/**
	 * @param fileToSave the file to be saved
	 */
	@PUT
	@RolesAllowed({"EDIT_CONFIGURATIONS"})
	void save(ConfigFile fileToSave);
	
	/**
	 * @param name the name of the file
	 * @return the configuration file with the given name
	 */
	@GET
	@Path("/{name}")
	@RolesAllowed({"VIEW_CONFIGURATIONS", "EDIT_CONFIGURATIONS", "USE_AGENT_API"})
	ConfigFile get(@PathParam("name") String name);
	
	/**
	 * @param name the name of the file to be deleted
	 */
	@DELETE
	@Path("/{name}")
	@RolesAllowed({"EDIT_CONFIGURATIONS"})
	void delete(@PathParam("name") String name);
	
	/**
	 * @param name the file name
	 * @return the data of the file
	 */
	@GET
	@Path("/{name}/data")
	@RolesAllowed({"VIEW_CONFIGURATIONS", "EDIT_CONFIGURATIONS", "USE_AGENT_API"})
	String getData(@PathParam("name") String name);
	
	/**
	 * @param name the file name
	 * @param data the file data to save
	 */
	@PUT
	@Path("/{name}/data")
	@RolesAllowed({"EDIT_CONFIGURATIONS"})
	@Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	void saveData(@PathParam("name") String name, String data);
	
	/**
	 * @param template the name of the template
	 * @return the configuration files for the given template
	 */
	@GET
	@Path("/template/{template}")
	@RolesAllowed({"VIEW_CONFIGURATIONS", "EDIT_CONFIGURATIONS", "USE_AGENT_API"})
	ConfigFile[] getConfigFiles(@PathParam("template") String template);
}
