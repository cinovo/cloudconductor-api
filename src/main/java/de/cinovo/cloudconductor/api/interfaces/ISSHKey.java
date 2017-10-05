package de.cinovo.cloudconductor.api.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.MediaType;
import de.cinovo.cloudconductor.api.model.SSHKey;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 * 
 * @author mweise
 *
 */
@Path(IRestPath.SSHKEY)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ISSHKey {
	
	/**
	 * @return all SSH keys
	 */
	@GET
	SSHKey[] getKeys();
	
	/**
	 * @param owner the owner of the key
	 * @return the SSH key
	 */
	@GET
	@Path(IRestPath.SSHKEY_DETAIL)
	SSHKey getKey(@PathParam(IRestPath.VAR_OWNER) String owner);
	
	/**
	 * @param newKey the new key
	 */
	@PUT
	void saveKey(SSHKey newKey);
	
	/**
	 * @param owner the owner of the key to delete
	 */
	@DELETE
	@Path(IRestPath.SSHKEY_DETAIL)
	void deleteKey(@PathParam(IRestPath.VAR_OWNER) String owner);
	
}
