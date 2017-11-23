package de.cinovo.cloudconductor.api.model;

import de.cinovo.cloudconductor.api.enums.UserPermissions;

import java.util.Set;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
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
