package de.cinovo.cloudconductor.api.interfaces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.AgentOption;
import de.cinovo.cloudconductor.api.model.PackageVersion;
import de.cinovo.cloudconductor.api.model.Repo;
import de.cinovo.cloudconductor.api.model.SSHKey;
import de.cinovo.cloudconductor.api.model.Service;
import de.cinovo.cloudconductor.api.model.Template;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Set;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path(IRestPath.TEMPLATE)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ITemplate {
	
	/**
	 * @return set of service objects
	 */
	@GET
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	Set<Template> get();
	
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
	@Path(IRestPath.TEMPLATE_DETAIL)
	@RolesAllowed({"EDIT_TEMPLATE"})
	void delete(@PathParam(IRestPath.VAR_TEMPLATE) String templateName);
	
	/**
	 * @param templateName the template name
	 * @return the template
	 */
	@GET
	@Path(IRestPath.TEMPLATE_DETAIL)
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	Template get(@PathParam(IRestPath.VAR_TEMPLATE) String templateName);
	
	/**
	 * @param templateName the template name
	 * @param packageName the package to update
	 * @return the updated template
	 */
	@PUT
	@Path(IRestPath.TEMPLATE_PACKAGE)
	@RolesAllowed({"EDIT_TEMPLATE"})
	Template updatePackage(@PathParam(IRestPath.VAR_TEMPLATE) String templateName, @PathParam(IRestPath.VAR_PKG) String packageName);
	
	/**
	 * @param templateName the template name
	 * @param packageName the package to remove
	 * @return the updated template
	 */
	@DELETE
	@Path(IRestPath.TEMPLATE_PACKAGE)
	@RolesAllowed({"EDIT_TEMPLATE"})
	Template deletePackage(@PathParam(IRestPath.VAR_TEMPLATE) String templateName, @PathParam(IRestPath.VAR_PKG) String packageName);
	
	/**
	 * @param templateName the name of the template
	 * @return set of service objects
	 */
	@GET
	@Path(IRestPath.TEMPLATE_AGENTOPTION)
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	AgentOption getAgentOption(@PathParam(IRestPath.VAR_TEMPLATE) String templateName);
	
	/**
	 * @param templateName the name of the template
	 * @param option the agent option to set
	 * @return set of service objects
	 */
	@PUT
	@Path(IRestPath.TEMPLATE_AGENTOPTION)
	@RolesAllowed({"EDIT_TEMPLATE"})
	AgentOption saveAgentOption(@PathParam(IRestPath.VAR_TEMPLATE) String templateName, AgentOption option);
	
	/**
	 * @param templateName the name of the template
	 * @return keys which belong to the given template
	 */
	@GET
	@Path(IRestPath.TEMPLATE_SSHKEY)
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	SSHKey[] getSSHKeysForTemplate(@PathParam(IRestPath.VAR_TEMPLATE) String templateName);
	
	/**
	 * @param templateName the name of the template
	 * @return services which belong to the given template
	 */
	@GET
	@Path(IRestPath.TEMPLATE_SERVICE)
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	Service[] getServicesForTemplate(@PathParam(IRestPath.VAR_TEMPLATE) String templateName);
	
	/**
	 * 
	 * @param templateName the name of the template
	 * @return repositories which belong to the given template
	 */
	@GET
	@Path(IRestPath.TEMPLATE_REPO)
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	Repo[] getReposForTemplate(@PathParam(IRestPath.VAR_TEMPLATE) String templateName);
	
	/**
	 * @param templateName the name of the template
	 * @return package versions used in the given template
	 */
	@GET
	@Path(IRestPath.TEMPLATE_VERSION)
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	PackageVersion[] getPackageVersionsForTemplate(@PathParam(IRestPath.VAR_TEMPLATE) String templateName);
}
