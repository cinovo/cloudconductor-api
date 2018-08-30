package de.cinovo.cloudconductor.api.interfaces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.ConfigDiff;
import de.cinovo.cloudconductor.api.model.ConfigValue;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
	String[] getAvailableTemplates();

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
	 * Deletes all configuration values for the given template.
	 *
	 * @param templateName the name of the template
	 */
	@DELETE
	@Path("/{template}")
	@RolesAllowed({"EDIT_CONFIGVALUES"})
	void deleteForTemplate(@PathParam("template") String templateName);

	/**
	 * Returns all configuration key of a template in a non stacked variant
	 *
	 * @param template the template name
	 * @return array of configuration values
	 * @deprecated use getCleanUnstacked instead.
	 */
	@GET
	@Path("/{template}/unstacked")
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	@Deprecated
	ConfigValue[] getUnstacked(@PathParam("template") String template);

	/**
	 * Returns configuration of the given service within the template as Key-Value Pairs
	 *
	 * @param template the template name
	 * @param service  the name of the service
	 * @return array of key value pairs representing the configuration of the service within the template
	 */
	@GET
	@Path("/{template}/{service}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	ConfigValue[] get(@PathParam("template") String template, @PathParam("service") String service);

	/**
	 * Deletes all configuration values for given template and service.
	 *
	 * @param template the name of the template
	 * @param service  the name of the service
	 */
	@DELETE
	@Path("/{template}/{service}")
	@RolesAllowed({"EDIT_CONFIGVALUES"})
	void deleteForService(@PathParam("template") String template, @PathParam("service") String service);

	/**
	 * Returns the value for a key of the given service within the template as Key-Value Pairs
	 *
	 * @param template the template name
	 * @param service  the name of the service
	 * @param key      the name of the key
	 * @return the value of the key of the service within the template
	 */
	@GET
	@Path("/{template}/{service:.*}/{key}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	String get(@PathParam("template") String template, @PathParam("service") String service, @PathParam("key") String key);

	/**
	 * Returns the value for a key of the given service within the template as Key-Value Pair, but does no parent matching
	 *
	 * @param template the template name
	 * @param service  the name of the service
	 * @param key      the name of the key
	 * @return the value of the key of the service within the template
	 */
	@GET
	@Path("/{template}/{service:.*}/{key}/exact")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	String getExact(@PathParam("template") String template, @PathParam("service") String service, @PathParam("key") String key);

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
	 * @param service  the name of the service
	 * @param key      the name of the key
	 */
	@DELETE
	@Path("/{template}/{service:.*}/{key}")
	@RolesAllowed({"EDIT_CONFIGVALUES"})
	void delete(@PathParam("template") String template, @PathParam("service") String service, @PathParam("key") String key);


	/**
	 * Returns all configuration key of a template, without variable swaps
	 *
	 * @param template the template name
	 * @return array of configuration values
	 */
	@GET
	@Path("/clean/{template}")
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	ConfigValue[] getClean(@PathParam("template") String template);

	/**
	 * Returns all configuration key of a template in a non stacked variant, without variable swaps
	 *
	 * @param template the template name
	 * @return array of configuration values
	 */
	@GET
	@Path("/clean/unstacked/{template}")
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	ConfigValue[] getCleanUnstacked(@PathParam("template") String template);

	/**
	 * Returns configuration of the given service within the template as Key-Value Pairs, without variable swaps
	 *
	 * @param template the template name
	 * @param service  the name of the service
	 * @return array of key value pairs representing the configuration of the service within the template
	 */
	@GET
	@Path("/clean/{template}/{service}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	ConfigValue[] getClean(@PathParam("template") String template, @PathParam("service") String service);


	/**
	 * Returns the value for a key of the given service within the template as Key-Value Pairs, without variable swaps
	 *
	 * @param template the template name
	 * @param service  the name of the service
	 * @param key      the name of the key
	 * @return the value of the key of the service within the template
	 */
	@GET
	@Path("/clean/{template}/{service:.*}/{key}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	String getClean(@PathParam("template") String template, @PathParam("service") String service, @PathParam("key") String key);


	/**
	 * Returns the value for variables of the given  template as Key-Value Pair, but does no parent matching
	 *
	 * @param template the template name
	 * @return the value of the key of the service within the template
	 */
	@GET
	@Path("clean/vars/{template}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES", "USE_AGENT_API"})
	ConfigValue[] getCleanVars(@PathParam("template") String template);

	/**
	 * Returns the value for a key of the given service within the template as Key-Value Pair, but does no parent matching
	 *
	 * @param templateA the template name
	 * @param templateB the other themplate name
	 * @return the value of the key of the service within the template
	 */
	@GET
	@Path("diff/{templateA}/{templateB}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JAVAARGS, MediaType.APPLICATION_JAVAPROPS})
	@RolesAllowed({"VIEW_CONFIGVALUES", "EDIT_CONFIGVALUES"})
	ConfigDiff[] diffTemplates(@PathParam("templateA") String templateA, @PathParam("templateB") String templateB);
}



