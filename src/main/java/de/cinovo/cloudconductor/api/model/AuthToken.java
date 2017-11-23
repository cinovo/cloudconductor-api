package de.cinovo.cloudconductor.api.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import java.util.Date;

/**
 * 
 * Copyright 2017 Cinovo AG<br>
 * <br>
 * 
 * @author mweise
 *
 */
@JsonTypeInfo(include = As.PROPERTY, use = Id.CLASS)
public class AuthToken {
	
	private String token;
	private Date creationDate;
	private Date revoked;

	
	/**
	 * @return the token
	 */
	public String getToken() {
		return this.token;
	}
	
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}
	
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	 * @return the revoked
	 */
	public Date getRevoked() {
		return this.revoked;
	}
	
	/**
	 * @param revoked the revoked to set
	 */
	public void setRevoked(Date revoked) {
		this.revoked = revoked;
	}
	
}
