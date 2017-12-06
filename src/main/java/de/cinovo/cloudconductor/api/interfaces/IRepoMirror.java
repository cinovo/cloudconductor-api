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
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.RepoMirror;

/**
 * Copyright 2013 Cinovo AG<br>
 * <br>
 * 
 * @author psigloch
 * 
 */
@Path("/repomirror")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IRepoMirror {
	
	/**
	 * @param id the id
	 * @return the mirror
	 */
	@GET
	@Path("/{rmId}")
	@RolesAllowed({"VIEW_CONFIGURATIONS", "EDIT_CONFIGURATIONS"})
	RepoMirror get(@PathParam("rmId") Long id);
	
	/**
	 * @param id the server id
	 */
	@DELETE
	@Path("/{rmId}")
	@RolesAllowed({"EDIT_CONFIGURATIONS"})
	void delete(@PathParam("rmId") Long id);
	
	/**
	 * @param mirror the mirror
	 * @return the new id
	 */
	@POST
	@RolesAllowed({"EDIT_CONFIGURATIONS"})
	Long newMirror(RepoMirror mirror);
	
	/**
	 * @param mirror the mirror
	 */
	@PUT
	@RolesAllowed({"EDIT_CONFIGURATIONS"})
	void editMirror(RepoMirror mirror);
}
