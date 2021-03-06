package de.cinovo.cloudconductor.api.interfaces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.enums.UpdateRange;
import de.cinovo.cloudconductor.api.model.AgentOption;
import de.cinovo.cloudconductor.api.model.PackageDiff;
import de.cinovo.cloudconductor.api.model.PackageVersion;
import de.cinovo.cloudconductor.api.model.PackageVersionUpdates;
import de.cinovo.cloudconductor.api.model.Repo;
import de.cinovo.cloudconductor.api.model.SSHKey;
import de.cinovo.cloudconductor.api.model.Service;
import de.cinovo.cloudconductor.api.model.ServiceDefaultState;
import de.cinovo.cloudconductor.api.model.SimplePackageVersion;
import de.cinovo.cloudconductor.api.model.SimpleTemplate;
import de.cinovo.cloudconductor.api.model.Template;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

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
	 * @return list of simple hosts
	 */
	@GET
	@Path("/simple")
	SimpleTemplate[] getSimpleTemplates();


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
	 * @param packageName  the package to update
	 * @return the updated template
	 */
	@PUT
	@Path("/{template}/package/{pkg}")
	@RolesAllowed({"EDIT_TEMPLATE"})
	Template updatePackage(@PathParam("template") String templateName, @PathParam("pkg") String packageName);

	/**
	 * @param templateName the template name
	 * @param packageName  the package to remove
	 * @return the updated template
	 */
	@DELETE
	@Path("/{template}/package/{pkg}")
	@RolesAllowed({"EDIT_TEMPLATE"})
	Template deletePackage(@PathParam("template") String templateName, @PathParam("pkg") String packageName);

	/**
	 * Update single package of template to latest version within update range.
	 *
	 * @param templateName the template name
	 * @param packageName  the package to update
	 * @param range			the update range
	 * @return the updated template
	 */
	@PUT
	@Path("/{template}/package/{pkg}/range/{range}")
	@RolesAllowed({"EDIT_TEMPLATE"})
	Template updatePackage(@PathParam("template") String templateName, //
						   @PathParam("pkg") String packageName, //
						   @PathParam("range") UpdateRange range //
	);

	/**
	 * Update single package of template to specific target version.
	 *
	 * @param templateName	the template name
	 * @param packageName 	the package to update
	 * @param targetVersion	the target version
	 * @return the updated template
	 */
	@PUT
	@Path("/{template}/package/{pkg}/version/{version}")
	@RolesAllowed({"EDIT_TEMPLATE"})
	Template updatePackage(@PathParam("template") String templateName, //
						   @PathParam("pkg") String packageName, //
						   @PathParam("version") String targetVersion //
	);

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
	 * @param option       the agent option to set
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
	 * @param templateName the name of the template
	 * @return default states for all services related to the given template
	 */
	@GET
	@Path("/{template}/servicedefaultstate")
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	ServiceDefaultState[] getServiceDefaultStates(@PathParam("template") String templateName);

	/**
	 * @param templateName the name of the template
	 * @param serviceName  the name of the service
	 * @return the default state of the given service in the template
	 */
	@GET
	@Path("/{template}/servicedefaultstate/{service}")
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	ServiceDefaultState getServiceDefaultState(@PathParam("template") String templateName, @PathParam("service") String serviceName);

	/**
	 * @param templateName    the name of the template
	 * @param serviceName     the name of the service
	 * @param newDefaultState the new default state for the given service and template
	 * @return the updated default state
	 */
	@PUT
	@Path("/{template}/servicedefaultstate/{service}")
	@RolesAllowed({"EDIT_TEMPLATE"})
	ServiceDefaultState saveServiceDefaultState(@PathParam("template") String templateName, @PathParam("service") String serviceName, ServiceDefaultState newDefaultState);

	/**
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
	
	/**
	 * @param templateName		name of the template to override
	 * @param packageVersions	new package versions for given template
	 * @return the modified template
	 */
	@PUT
	@Path("/{template}/package/versions")
	@RolesAllowed({"EDIT_TEMPLATE"})
	Template replacePackageVersionsForTemplate(@PathParam("template") String templateName, List<SimplePackageVersion> packageVersions);
	
	/**
	 * @param templateName	the name of the template
	 * @return package versions used in the given template without its dependencies
	 */
	@GET
	@Path("/{template}/package/versions/simple")
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	SimplePackageVersion[] getSimplePackageVersionsForTemplate(@PathParam("template") String templateName);

	/**
	 * @param templateName	 name of the template
	 * @return package versions as maps
	 */
	@GET
	@Path("/{template}/updates")
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	PackageVersionUpdates getPackageVersionUpdatesForTemplate(@PathParam("template") String templateName);

	/**
	 * @param templateA the name of the first template of the diff
	 * @param templateB the name of the second template of the diff
	 * @return default states for all services related to the given template
	 */
	@GET
	@Path("/packagediff/{templateA}/{templateB}")
	@RolesAllowed({"VIEW_TEMPLATE", "EDIT_TEMPLATE"})
	PackageDiff[] packageDiff(@PathParam("templateA") String templateA, @PathParam("templateB") String templateB);
}
