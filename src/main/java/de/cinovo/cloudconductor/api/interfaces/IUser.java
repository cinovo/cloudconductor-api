package de.cinovo.cloudconductor.api.interfaces;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.PasswordChange;
import de.cinovo.cloudconductor.api.model.User;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IUser {
	
	/**
	 * @return list of users
	 */
	@GET
	@RolesAllowed({"VIEW_USERS", "EDIT_USER"})
	List<User> getUsers();
	
	/**
	 * @param user the user to save
	 */
	@PUT
	@RolesAllowed({"EDIT_USER"})
	void save(User user);
	
	/**
	 * @param userName the user name
	 */
	@DELETE
	@Path("/{username}")
	@RolesAllowed({"EDIT_USER"})
	void delete(@PathParam("username") String userName);
	
	/**
	 * @param userName the user name
	 * @return the user
	 */
	@POST
	@Path("/{username}/authtoken")
	@RolesAllowed({"EDIT_USER"})
	User createAuthToken(@PathParam("username") String userName);
	
	/**
	 * @param userName the user name
	 * @param token the token to revoke
	 * @return the User which was changed
	 */
	@DELETE
	@Path("/{username}/authtoken")
	@RolesAllowed({"EDIT_USER"})
	User revokeAuthToken(@PathParam("username") String userName, String token);
	
	/**
	 * @param pwChange the password change request
	 */
	@PUT
	@Path("/changepassword")
	void changePassword(PasswordChange pwChange);
	
}
