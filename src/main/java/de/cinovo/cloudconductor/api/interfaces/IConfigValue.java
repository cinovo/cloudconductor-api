package de.cinovo.cloudconductor.api.interfaces;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.ConfigValue;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path(IRestPath.CONFIG)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IConfigValue {
	
	/**
	 * @return a collection of known templates
	 */
	@GET
	Collection<String> getAvailableTemplates();
	
	/**
	 * Returns configuration of the given template as Key-Value Pairs
	 *
	 * @param template the template name
	 * @return set of stacked config values
	 */
	@GET
	@Path(IRestPath.CONFIG_TEMPLATE)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	Collection<ConfigValue> get(@PathParam(IRestPath.VAR_TEMPLATE) String template);
	
	/**
	 * Returns all configuration key of a template in a non stacked variant
	 *
	 * @param template the template name
	 * @return set of config values
	 */
	@GET
	@Path(IRestPath.CONFIG_TEMPLATE_UNSTACKED)
	Collection<ConfigValue> getUnstacked(@PathParam(IRestPath.VAR_TEMPLATE) String template);
	
	/**
	 * Returns configuration of the given service within the template as Key-Value Pairs
	 *
	 * @param template the template name
	 * @param service the name of the service
	 * @return map of key value pairs representing the configuration of the service within the template
	 */
	@GET
	@Path(IRestPath.CONFIG_TEMPLATE_SERVICE)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	Collection<ConfigValue> get(@PathParam(IRestPath.VAR_TEMPLATE) String template, @PathParam(IRestPath.VAR_SERVICE) String service);
	
	/**
	 * Returns the value for a key of the given service within the template as Key-Value Pairs
	 *
	 * @param template the template name
	 * @param service the name of the service
	 * @param key the name of the key
	 * @return the value of the key of the service within the template
	 */
	@GET
	@Path(IRestPath.CONFIG_TEMPLATE_SERVICE_KEY)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	String get(@PathParam(IRestPath.VAR_TEMPLATE) String template, @PathParam(IRestPath.VAR_SERVICE) String service, @PathParam(IRestPath.VAR_KEY) String key);
	
	/**
	 * Adds a new key-value pair to the configuration of a service within a template
	 *
	 * @param config the config value
	 */
	@PUT
	void save(ConfigValue config);
	
	/**
	 * Delete a ConfigValue
	 *
	 * @param template the template name
	 * @param service the name of the service
	 * @param key the name of the key
	 */
	@DELETE
	@Path(IRestPath.CONFIG_TEMPLATE_SERVICE_KEY)
	void delete(@PathParam(IRestPath.VAR_TEMPLATE) String template, @PathParam(IRestPath.VAR_SERVICE) String service, @PathParam(IRestPath.VAR_KEY) String key);
	
}
