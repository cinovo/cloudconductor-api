package de.cinovo.cloudconductor.api.interfaces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.UserGroup;

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
@Path("/usergroup")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IUserGroup {

	/**
	 * @return list of usergroups
	 */
	@GET
	List<UserGroup> getUserGroups();

	/**
	 * @param userGroup the user group to save
	 */
	@PUT
	void save(UserGroup userGroup);

	/**
	 * @param userGroupName the user group name
	 */
	@DELETE
	@Path("/{usergroupname}")
	void delete(@PathParam("usergroupname") String userGroupName);

}
