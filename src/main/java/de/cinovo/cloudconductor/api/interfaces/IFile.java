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

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.ConfigFile;

/**
 * Copyright 2013 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 *
 */
@Path(IRestPath.FILE)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IFile {
	
	/**
	 * @return set of api objects
	 */
	@GET
	public ConfigFile[] get();
	
	/**
	 * @param apiObject the api object
	 */
	@PUT
	public void save(ConfigFile apiObject);
	
	/**
	 * @param name the name of the api object
	 * @return the api object
	 */
	@GET
	@Path(IRestPath.FILE_DETAILS)
	public ConfigFile get(@PathParam(IRestPath.VAR_NAME) String name);
	
	/**
	 * @param name the name of the api object
	 */
	@DELETE
	@Path(IRestPath.FILE_DETAILS)
	public void delete(@PathParam(IRestPath.VAR_NAME) String name);
	
	/**
	 * @param name the file name
	 * @return the data
	 */
	@GET
	@Path(IRestPath.FILE_DATA)
	public String getData(@PathParam(IRestPath.VAR_NAME) String name);
	
	/**
	 * @param name the file name
	 * @param data the data to save
	 */
	@PUT
	@Path(IRestPath.FILE_DATA)
	public void saveData(@PathParam(IRestPath.VAR_NAME) String name, String data);
	
	/**
	 * @param template the template name
	 * @return the config files for the template
	 */
	@GET
	@Path(IRestPath.FILE_TEMPLATE)
	public ConfigFile[] getConfigFiles(@PathParam(IRestPath.VAR_TEMPLATE) String template);
}
