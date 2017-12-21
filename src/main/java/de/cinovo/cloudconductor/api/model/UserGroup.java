package de.cinovo.cloudconductor.api.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import de.cinovo.cloudconductor.api.enums.UserPermissions;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@JsonTypeInfo(include = As.PROPERTY, use = Id.CLASS)
public class UserGroup {
	
	private String name;
	private String description;
	private Set<UserPermissions> permissions;
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the permissions
	 */
	public Set<UserPermissions> getPermissions() {
		return this.permissions;
	}
	
	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(Set<UserPermissions> permissions) {
		this.permissions = permissions;
	}
}
