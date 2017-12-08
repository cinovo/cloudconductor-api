package de.cinovo.cloudconductor.api.interfaces;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.AgentOption;
import de.cinovo.cloudconductor.api.model.PackageVersion;
import de.cinovo.cloudconductor.api.model.Repo;
import de.cinovo.cloudconductor.api.model.SSHKey;
import de.cinovo.cloudconductor.api.model.Service;
import de.cinovo.cloudconductor.api.model.Template;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path("/template")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ITemplate {
	
	/**
	 * @return set of service objects
	 */
	@GET
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	Template[] get();
	
	/**
	 * @param template the template to save
	 */
	@PUT
	@RolesAllowed({"EDIT_TEMPLATE"})
	void save(Template template);
	
	/**
	 * @param templateName the template name
	 */
	@DELETE
	@Path("/{template}")
	@RolesAllowed({"EDIT_TEMPLATE"})
	void delete(@PathParam("template") String templateName);
	
	/**
	 * @param templateName the template name
	 * @return the template
	 */
	@GET
	@Path("/{template}")
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	Template get(@PathParam("template") String templateName);
	
	/**
	 * @param templateName the template name
	 * @param packageName the package to update
	 * @return the updated template
	 */
	@PUT
	@Path("/{template}/package/{pkg}")
	@RolesAllowed({"EDIT_TEMPLATE"})
	Template updatePackage(@PathParam("template") String templateName, @PathParam("pkg") String packageName);
	
	/**
	 * @param templateName the template name
	 * @param packageName the package to remove
	 * @return the updated template
	 */
	@DELETE
	@Path("/{template}/package/{pkg}")
	@RolesAllowed({"EDIT_TEMPLATE"})
	Template deletePackage(@PathParam("template") String templateName, @PathParam("pkg") String packageName);
	
	/**
	 * @param templateName the name of the template
	 * @return set of service objects
	 */
	@GET
	@Path("/{template}/agentoption")
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	AgentOption getAgentOption(@PathParam("template") String templateName);
	
	/**
	 * @param templateName the name of the template
	 * @param option the agent option to set
	 * @return set of service objects
	 */
	@PUT
	@Path("/{template}/agentoption")
	@RolesAllowed({"EDIT_TEMPLATE"})
	AgentOption saveAgentOption(@PathParam("template") String templateName, AgentOption option);
	
	/**
	 * @param templateName the name of the template
	 * @return keys which belong to the given template
	 */
	@GET
	@Path("/{template}/sshkeys")
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	SSHKey[] getSSHKeysForTemplate(@PathParam("template") String templateName);
	
	/**
	 * @param templateName the name of the template
	 * @return services which belong to the given template
	 */
	@GET
	@Path("/{template}/services")
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	Service[] getServicesForTemplate(@PathParam("template") String templateName);
	
	/**
	 * 
	 * @param templateName the name of the template
	 * @return repositories which belong to the given template
	 */
	@GET
	@Path("/{template}/repo")
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	Repo[] getReposForTemplate(@PathParam("template") String templateName);
	
	/**
	 * @param templateName the name of the template
	 * @return package versions used in the given template
	 */
	@GET
	@Path("/{template}/package/versions")
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	PackageVersion[] getPackageVersionsForTemplate(@PathParam("template") String templateName);
}
