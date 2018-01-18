package de.cinovo.cloudconductor.api.interfaces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.Package;
import de.cinovo.cloudconductor.api.model.PackageStateChanges;
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

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path("/package")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IPackage {

	/**
	 * @param page     the number of the page
	 * @param pageSize the number of packages per page
	 * @param uriInfo  the uri info
	 * @return response including page of packages
	 */
	@GET
	@RolesAllowed({"VIEW_CONFIGURATIONS", "EDIT_CONFIGURATIONS"})
	Response get(@DefaultValue("0") @QueryParam("page") int page, //
				 @DefaultValue("0") @QueryParam("per_page") int pageSize, //
				 @Context UriInfo uriInfo);

	/**
	 * @param pkgName the name of the package
	 * @return the package
	 */
	@GET
	@Path("/{pkg}")
	@RolesAllowed({"VIEW_CONFIGURATIONS", "EDIT_CONFIGURATIONS"})
	Package get(@PathParam("pkg") String pkgName);

	/**
	 * Get the existing package versions of a package
	 *
	 * @param pkgname the package name
	 * @return collection of package versions
	 */
	@GET
	@Path("/{pkg}/versions")
	@RolesAllowed({"VIEW_CONFIGURATIONS", "EDIT_CONFIGURATIONS"})
	PackageVersion[] getVersions(@PathParam("pkg") String pkgname);

	/**
	 * @param pkgname the package name
	 * @return map of template-packageVersion pairs
	 */
	@GET
	@Path("/{pkg}/usage")
	@RolesAllowed({"VIEW_CONFIGURATIONS", "EDIT_CONFIGURATIONS"})
	Map<String, String> getUsage(@PathParam("pkg") String pkgname);

	/**
	 * Get the existing package versions of a repo
	 *
	 * @param repoName the repo name
	 * @return collection of package versions
	 */
	@GET
	@Path("/versions/repo/{repo}")
	@RolesAllowed({"VIEW_CONFIGURATIONS", "EDIT_CONFIGURATIONS"})
	PackageVersion[] getVersionsForRepo(@PathParam("repo") String repoName);

	/**
	 * Get the package difference between the host and its template
	 *
	 * @param hostName the host name
	 * @return collection of package changes
	 */
	@GET
	@Path("/changes/{host}")
	@RolesAllowed({"VIEW_CONFIGURATIONS", "EDIT_CONFIGURATIONS"})
	PackageStateChanges getPackageChanges(@PathParam("host") String hostName);
}
