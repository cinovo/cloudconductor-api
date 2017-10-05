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

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.Service;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path(IRestPath.SERVICE)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IService {
	
	/**
	 * @return set of service objects
	 */
	@GET
	Service[] get();
	
	/**
	 * @param service the service name
	 * @return the api object
	 */
	@GET
	@Path(IRestPath.SERVICE_DETAIL)
	Service get(@PathParam(IRestPath.VAR_SERVICE) String service);
	
	/**
	 * @param apiObject the service object
	 */
	@PUT
	void save(Service apiObject);
	
	/**
	 * @param service the service name
	 */
	@DELETE
	@Path(IRestPath.SERVICE_DETAIL)
	void delete(@PathParam(IRestPath.VAR_SERVICE) String service);
	
	/**
	 * @param service the service name
	 * @return map of template-package pairs
	 */
	@GET
	@Path(IRestPath.SERVICE_USAGE)
	@Produces(MediaType.APPLICATION_JSON)
	Map<String, String> getUsage(@PathParam(IRestPath.VAR_SERVICE) String service);
}
