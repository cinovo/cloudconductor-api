package de.cinovo.cloudconductor.api.interfaces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.AdditionalLink;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

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
@Path("/links")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ILinks {

	/**
	 * @return list of additional links
	 */
	@GET
	List<AdditionalLink> getLinks();

	@POST
	Response createLink(AdditionalLink link);

	@PUT
	AdditionalLink updateLink(AdditionalLink link);

	@Path("/{id}")
	@DELETE
	void deleteLink(@PathParam("id") long id);

}
