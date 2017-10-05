package de.cinovo.cloudconductor.api.interfaces;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.AgentOption;
import de.cinovo.cloudconductor.api.model.Template;

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
	Set<Template> get();
	
	/**
	 * @param template the template to save
	 */
	@PUT
	void save(Template template);
	
	/**
	 * @param templateName the template name
	 */
	@DELETE
	@Path(IRestPath.TEMPLATE_DETAIL)
	void delete(@PathParam(IRestPath.VAR_TEMPLATE) String templateName);
	
	/**
	 * @param templateName the template name
	 * @return the template
	 */
	@GET
	@Path(IRestPath.TEMPLATE_DETAIL)
	Template get(@PathParam(IRestPath.VAR_TEMPLATE) String templateName);
	
	/**
	 * @param templateName the template name
	 * @param packageName the package to update
	 * @return the updated template
	 */
	@PUT
	@Path(IRestPath.TEMPLATE_PACKAGE)
	Template updatePackage(@PathParam(IRestPath.VAR_TEMPLATE) String templateName, @PathParam(IRestPath.VAR_PKG) String packageName);
	
	/**
	 * @param templateName the template name
	 * @param packageName the package to remove
	 * @return the updated template
	 */
	@DELETE
	@Path(IRestPath.TEMPLATE_PACKAGE)
	Template deletePackage(@PathParam(IRestPath.VAR_TEMPLATE) String templateName, @PathParam(IRestPath.VAR_PKG) String packageName);
	
	/**
	 * @param templateName the name of the template
	 * @return set of service objects
	 */
	@GET
	@Path(IRestPath.TEMPLATE_AGENTOPTION)
	AgentOption getAgentOption(@PathParam(IRestPath.VAR_TEMPLATE) String templateName);
	
	/**
	 * @param templateName the name of the template
	 * @param option the agent option to set
	 * @return set of service objects
	 */
	@PUT
	@Path(IRestPath.TEMPLATE_AGENTOPTION)
	AgentOption saveAgentOption(@PathParam(IRestPath.VAR_TEMPLATE) String templateName, AgentOption option);
}
