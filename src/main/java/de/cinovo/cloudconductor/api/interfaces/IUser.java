package de.cinovo.cloudconductor.api.interfaces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.PasswordChange;
import de.cinovo.cloudconductor.api.model.User;

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
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IUser {
	
	/**
	 * @return list of users
	 */
	@GET
	@RolesAllowed({"VIEW_USERS", "EDIT_USERS"})
	User[] getUsers();
	
	/**
	 * @param user the user to save
	 */
	@PUT
	@RolesAllowed({"EDIT_USERS"})
	void save(User user);
	
	/**
	 * 
	 * @param userName the user name
	 * @return the requested user
	 */
	@GET
	@Path("/{username}")
	@RolesAllowed({"VIEW_USERS", "EDIT_USERS"})
	User getUser(@PathParam("username") String userName);
	
	/**
	 * @param userName the user name
	 */
	@DELETE
	@Path("/{username}")
	@RolesAllowed({"EDIT_USERS"})
	void delete(@PathParam("username") String userName);
	
	/**
	 * @param userName the user name
	 * @return the user
	 */
	@PUT
	@Path("/{username}/authtoken")
	@RolesAllowed({"EDIT_USERS"})
	@Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	User createAuthToken(@PathParam("username") String userName);
	
	/**
	 * @param userName the user name
	 * @param token the token to revoke
	 */
	@DELETE
	@Path("/{username}/authtoken/{token}")
	@RolesAllowed({"EDIT_USERS"})
	void revokeAuthToken(@PathParam("username") String userName, @PathParam("token") String token);
	
	/**
	 * @param pwChange the password change request
	 */
	@PUT
	@Path("/changepassword")
	void changePassword(PasswordChange pwChange);
	
}
