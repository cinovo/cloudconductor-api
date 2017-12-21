package de.cinovo.cloudconductor.api.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import de.cinovo.cloudconductor.api.interfaces.INamed;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@JsonTypeInfo(include = As.PROPERTY, use = Id.CLASS)
public class User implements INamed {
	
	private String loginName;
	private String displayName;
	private Date registrationDate;
	private boolean active;
	private String email;
	private String password;
	
	private Set<String> userGroups = new HashSet<>();
	private Set<String> agents = new HashSet<>();
	private Set<AuthToken> authTokens = new HashSet<>();
	
	
	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return this.loginName;
	}
	
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return this.displayName;
	}
	
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	/**
	 * @return the registrationDate
	 */
	public Date getRegistrationDate() {
		return this.registrationDate;
	}
	
	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	/**
	 * @param authTokens the authTokens to set
	 */
	public void setAuthTokens(Set<AuthToken> authTokens) {
		this.authTokens = authTokens;
	}
	
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return this.active;
	}
	
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the userGroups
	 */
	public Set<String> getUserGroups() {
		return this.userGroups;
	}
	
	/**
	 * @param userGroups the userGroups to set
	 */
	public void setUserGroups(Set<String> userGroups) {
		this.userGroups = userGroups;
	}
	
	/**
	 * @return the agents
	 */
	public Set<String> getAgents() {
		return this.agents;
	}
	
	/**
	 * @param agents the agents to set
	 */
	public void setAgents(Set<String> agents) {
		this.agents = agents;
	}
	
	/**
	 * @return the authTokens
	 */
	public Set<AuthToken> getAuthTokens() {
		return this.authTokens;
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
	
	@JsonIgnore
	@Override
	public String getName() {
		return this.loginName;
	}
}
