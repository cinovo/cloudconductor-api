package de.cinovo.cloudconductor.api.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.Authentication;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IAuth {
	
	/**
	 * @param auth the auth object
	 * @return the jwt token for the user
	 */
	@PUT
	@Path("/")
	String auth(Authentication auth);
	
	/**
	 * @param currentToken token which will expire soon
	 * @return the new token
	 */
	@PUT
	@Path("/refresh")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	String refresh(String currentToken);
	
	/**
	 * logout the current user and destroy his jwt token
	 */
	@PUT
	@Path("/logout")
	void logout();
	
}
