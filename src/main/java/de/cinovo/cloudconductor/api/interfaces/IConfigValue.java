package de.cinovo.cloudconductor.api.interfaces;

import java.util.Collection;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.ConfigValue;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path("/config")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IConfigValue {
	
	/**
	 * @return a collection of known templates
	 */
	@GET
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES"})
	Collection<String> getAvailableTemplates();
	
	/**
	 * Returns configuration of the given template as Key-Value Pairs
	 *
	 * @param template the template name
	 * @return set of stacked config values
	 */
	@GET
	@Path("/{template}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	ConfigValue[] get(@PathParam("template") String template);
	
	/**
	 * Returns all configuration key of a template in a non stacked variant
	 *
	 * @param template the template name
	 * @return array of configuration values
	 */
	@GET
	@Path("/{template}/unstacked")
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	ConfigValue[] getUnstacked(@PathParam("template") String template);
	
	/**
	 * Returns configuration of the given service within the template as Key-Value Pairs
	 *
	 * @param template the template name
	 * @param service the name of the service
	 * @return array of key value pairs representing the configuration of the service within the template
	 */
	@GET
	@Path("/{template}/{service}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	ConfigValue[] get(@PathParam("template") String template, @PathParam("service") String service);
	
	/**
	 * Returns the value for a key of the given service within the template as Key-Value Pairs
	 *
	 * @param template the template name
	 * @param service the name of the service
	 * @param key the name of the key
	 * @return the value of the key of the service within the template
	 */
	@GET
	@Path("/{template}/{service" + ":.*}/{key}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	String get(@PathParam("template") String template, @PathParam("service") String service, @PathParam("key") String key);
	
	/**
	 * Adds a new key-value pair to the configuration of a service within a template
	 *
	 * @param config the config value
	 */
	@PUT
	@RolesAllowed({"EDIT_CONFIGVALUES"})
	void save(ConfigValue config);
	
	/**
	 * Delete a ConfigValue
	 *
	 * @param template the template name
	 * @param service the name of the service
	 * @param key the name of the key
	 */
	@DELETE
	@Path("/{template}/{service" + ":.*}/{key}")
	@RolesAllowed({"EDIT_CONFIGVALUES"})
	void delete(@PathParam("template") String template, @PathParam("service") String service, @PathParam("key") String key);
	
}
