package de.cinovo.cloudconductor.api.interfaces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.Package;
import de.cinovo.cloudconductor.api.model.PackageVersion;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Map;
import java.util.Set;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path(IRestPath.PKG)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IPackage {
	
	/**
	 * @param page the number of the page
	 * @param pageSize the number of packages per page
	 * @param uriInfo the uri info
	 * @return response including page of packages
	 */
	@GET
	@RolesAllowed({"VIEW_CONFIGURATIONS","EDIT_CONFIGURATIONS"})
	Response get(@DefaultValue("0") @QueryParam("page") int page, //
			@DefaultValue("0") @QueryParam("per_page") int pageSize, //
			@Context UriInfo uriInfo);
	
	/**
	 * @param pkgName the name of the package
	 * @return the package
	 */
	@GET
	@Path(IRestPath.PKG_DETAIL)
	@RolesAllowed({"VIEW_CONFIGURATIONS","EDIT_CONFIGURATIONS"})
	Package get(@PathParam(IRestPath.VAR_PKG) String pkgName);
	
	/**
	 * Get the existing package versions of a package
	 *
	 * @param pkgname the package name
	 * @return collection of package versions
	 */
	@GET
	@Path(IRestPath.PKG_VERSION)
	@RolesAllowed({"VIEW_CONFIGURATIONS","EDIT_CONFIGURATIONS"})
	Set<PackageVersion> getVersions(@PathParam(IRestPath.VAR_PKG) String pkgname);
	
	/**
	 * @param pkgname the package name
	 * @return map of template-packageVersion pairs
	 */
	@GET
	@Path(IRestPath.PKG_USAGE)
	@RolesAllowed({"VIEW_CONFIGURATIONS","EDIT_CONFIGURATIONS"})
	Map<String, String> getUsage(@PathParam(IRestPath.VAR_PKG) String pkgname);
	
	/**
	 * Get the existing package versions of a repo
	 *
	 * @param repoName the repo name
	 * @return collection of package versions
	 */
	@GET
	@Path(IRestPath.PKG_VERSION_REPO)
	@RolesAllowed({"VIEW_CONFIGURATIONS","EDIT_CONFIGURATIONS"})
	Set<PackageVersion> getVersionsForRepo(@PathParam(IRestPath.VAR_REPO) String repoName);
}
