package de.cinovo.cloudconductor.api.interfaces;

import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.Package;
import de.cinovo.cloudconductor.api.model.PackageVersion;

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
	 * @return set of packages
	 */
	@GET
	Set<Package> get();
	
	/**
	 * @param pkgName the name of the package
	 * @return the package
	 */
	@GET
	@Path(IRestPath.PKG_DETAIL)
	Package get(@PathParam(IRestPath.VAR_PKG) String pkgName);
	
	/**
	 * Get the existing package versions of a package
	 *
	 * @param pkgname the package name
	 * @return collection of package versions
	 */
	@GET
	@Path(IRestPath.PKG_VERSION)
	Set<PackageVersion> getVersions(@PathParam(IRestPath.VAR_PKG) String pkgname);
	
	/**
	 * @param pkgname the package name
	 * @return map of template-packageVersion pairs
	 */
	@GET
	@Path(IRestPath.PKG_USAGE)
	Map<String, String> getUsage(@PathParam(IRestPath.VAR_PKG) String pkgname);
	
	/**
	 * Get the existing package versions of a repo
	 *
	 * @param repoName the repo name
	 * @return collection of package versions
	 */
	@GET
	@Path(IRestPath.PKG_VERSION_REPO)
	Set<PackageVersion> getVersionsForRepo(@PathParam(IRestPath.VAR_REPO) String repoName);
}
