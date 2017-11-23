package de.cinovo.cloudconductor.api.enums;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
public enum UserPermissions {

	/**
	 * rights for the hosts
	 */
	VIEW_HOST,
	EDIT_HOST,

	/**
	 * rights for the templates
	 */
	VIEW_TEMPLATE,
	EDIT_TEMPLATE,

	/**
	 * rights for the config values
	 */
	VIEW_CONFIGVALUES,
	EDIT_CONFIGVALUES,

	/**
	 * rights for the user management
	 */
	VIEW_USERS,
	EDIT_USERS,

	/**
	 * rights for the ssh key management
	 */
	VIEW_SSH,
	EDIT_SSH,

	/**
	 * rights for the agents
	 */
	USE_AGENT_API,

	/**
	 * rights for everything not otherwise spezified
	 */
	VIEW_CONFIGURATIONS,
	EDIT_CONFIGURATIONS
}