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

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.ConfigFile;
import de.cinovo.cloudconductor.api.model.Directory;

import javax.ws.rs.*;

/**
 * Copyright 2013 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 *
 */
@Path(IRestPath.FILE)
public interface IDirectory extends IDefaultApi<Directory> {

	///**
	// * @param name the file name
	// * @return the data
	// */
	//@GET
	//@Path(IRestPath.FILE_DATA)
	//@Produces(MediaType.APPLICATION_JSON)
	//public String getData(@PathParam(IRestPath.VAR_NAME) String name);
	//
	///**
	// * @param name the file name
	// * @param data the data to save
	// */
	//@PUT
	//@Path(IRestPath.FILE_DATA)
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	//public void saveData(@PathParam(IRestPath.VAR_NAME) String name, String data);

	/**
	 * @param template the template name
	 * @return the config files for the template
	 */
	@GET
	@Path(IRestPath.FILE_CONFIG_FILES)
	@Produces(MediaType.APPLICATION_JSON)
	public Directory[] getDirectories(@PathParam(IRestPath.VAR_TEMPLATE) String template);
}
