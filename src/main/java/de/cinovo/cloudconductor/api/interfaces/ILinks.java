package de.cinovo.cloudconductor.api.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.AdditionalLink;

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
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/**
 * Copyright 2015 Taimos GmbH<br>
 * <br>
 *
 * @author thoeger
 */
@Path(IRestPath.LINK)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ILinks {
	
	/**
	 * @return list of additional links
	 */
	@GET
	List<AdditionalLink> getLinks();
	
	/**
	 * @param link the new link to be saved
	 * @return the response
	 */
	@POST
	Response createLink(AdditionalLink link);
	
	/**
	 * @param link the link to be updated
	 * @return the updated link
	 */
	@PUT
	AdditionalLink updateLink(AdditionalLink link);
	
	/**
	 * @param id the id of the link to be deleted
	 */
	@Path(IRestPath.LINK_DETAIL)
	@DELETE
	void deleteLink(@PathParam(IRestPath.VAR_LINKID) long id);
	
}
