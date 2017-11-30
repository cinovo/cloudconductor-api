package de.cinovo.cloudconductor.api.model;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
public class Authentication {
	
	private String username;
	private String password;
	private String token;
	
	
	/**
	 * Create an empty authentication object
	 */
	public Authentication() {
	}
	
	/**
	 * Create new authentication object using token.
	 * 
	 * @param token the token to be used
	 */
	public Authentication(String token) {
		this.token = token;
	}
	
	/**
	 * Create a new authentication object using username and password
	 * 
	 * @param username the username to be used
	 * @param password the password to be used
	 */
	public Authentication(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
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
}
