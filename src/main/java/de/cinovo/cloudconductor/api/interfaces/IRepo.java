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
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.Repo;

/**
 * Copyright 2013 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path(IRestPath.REPO)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IRepo {
	
	/**
	 * @return set of api objects
	 */
	@GET
	Repo[] get();
	
	/**
	 * @param name the {@link Repo} name
	 * @return the {@link Repo}
	 */
	@GET
	@Path(IRestPath.REPO_DETAIL)
	Repo get(@PathParam(IRestPath.VAR_NAME) String name);
	
	/**
	 * @param repo the {@link Repo}
	 * @return the new id
	 */
	@POST
	Long newRepo(Repo repo);
	
	/**
	 * @param repo the {@link Repo}
	 */
	@PUT
	void edit(Repo repo);
	
	/**
	 * @param name the name of the the {@link Repo} to delete
	 */
	@DELETE
	@Path(IRestPath.REPO_DETAIL)
	void delete(@PathParam(IRestPath.VAR_NAME) String name);
}