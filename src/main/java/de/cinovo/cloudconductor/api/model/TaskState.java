package de.cinovo.cloudconductor.api.model;

/**
 * Copyright 2014 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 *
 */
public enum TaskState {
	
	/**
	 * the task is unused
	 */
	OFF,
	/**
	 * the task is executed once
	 */
	ONCE,
	/**
	 * the task gets repeated
	 */
	REPEAT
}
