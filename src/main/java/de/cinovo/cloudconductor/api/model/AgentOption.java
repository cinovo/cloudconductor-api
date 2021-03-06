package de.cinovo.cloudconductor.api.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import de.cinovo.cloudconductor.api.enums.TaskState;

import java.util.concurrent.TimeUnit;

/**
 * Copyright 2014 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@JsonTypeInfo(use = Id.CLASS)
public class AgentOption {
	
	private int aliveTimer = 2;
	private TimeUnit aliveTimerUnit = TimeUnit.MINUTES;
	
	private TaskState doSshKeys = TaskState.REPEAT;
	private int sshKeysTimer = 15;
	private TimeUnit sshKeysTimerUnit = TimeUnit.MINUTES;
	
	private TaskState doPackageManagement = TaskState.REPEAT;
	private int packageManagementTimer = 15;
	private TimeUnit packageManagementTimerUnit = TimeUnit.MINUTES;
	
	private TaskState doFileManagement = TaskState.REPEAT;
	private int fileManagementTimer = 15;
	private TimeUnit fileManagementTimerUnit = TimeUnit.MINUTES;
	
	private String templateName;
	
	private String uuid;

	/** default constructor */
	public AgentOption() {
		// nothing to do
	}

	public AgentOption(int aliveTimer, TimeUnit aliveTimerUnit, TaskState doSshKeys, int sshKeysTimer, TimeUnit sshKeysTimerUnit, TaskState doPackageManagement, int packageManagementTimer, TimeUnit packageManagementTimerUnit, TaskState doFileManagement, int fileManagementTimer, TimeUnit fileManagementTimerUnit, String templateName) {
		this.aliveTimer = aliveTimer;
		this.aliveTimerUnit = aliveTimerUnit;
		this.doSshKeys = doSshKeys;
		this.sshKeysTimer = sshKeysTimer;
		this.sshKeysTimerUnit = sshKeysTimerUnit;
		this.doPackageManagement = doPackageManagement;
		this.packageManagementTimer = packageManagementTimer;
		this.packageManagementTimerUnit = packageManagementTimerUnit;
		this.doFileManagement = doFileManagement;
		this.fileManagementTimer = fileManagementTimer;
		this.fileManagementTimerUnit = fileManagementTimerUnit;
		this.templateName = templateName;
	}

	/**
	 * @return the aliveTimer
	 */
	public int getAliveTimer() {
		return this.aliveTimer;
	}
	
	/**
	 * @param aliveTimer the aliveTimer to set
	 */
	public void setAliveTimer(int aliveTimer) {
		this.aliveTimer = aliveTimer;
	}
	
	/**
	 * @return the aliveTimerUnit
	 */
	public TimeUnit getAliveTimerUnit() {
		return this.aliveTimerUnit;
	}
	
	/**
	 * @param aliveTimerUnit the aliveTimerUnit to set
	 */
	public void setAliveTimerUnit(TimeUnit aliveTimerUnit) {
		this.aliveTimerUnit = aliveTimerUnit;
	}
	
	/**
	 * @return the doSshKeys
	 */
	public TaskState getDoSshKeys() {
		return this.doSshKeys;
	}
	
	/**
	 * @param doSshKeys the doSshKeys to set
	 */
	public void setDoSshKeys(TaskState doSshKeys) {
		this.doSshKeys = doSshKeys;
	}
	
	/**
	 * @return the sshKeysTimer
	 */
	public int getSshKeysTimer() {
		return this.sshKeysTimer;
	}
	
	/**
	 * @param sshKeysTimer the sshKeysTimer to set
	 */
	public void setSshKeysTimer(int sshKeysTimer) {
		this.sshKeysTimer = sshKeysTimer;
	}
	
	/**
	 * @return the sshKeysTimerUnit
	 */
	public TimeUnit getSshKeysTimerUnit() {
		return this.sshKeysTimerUnit;
	}
	
	/**
	 * @param sshKeysTimerUnit the sshKeysTimerUnit to set
	 */
	public void setSshKeysTimerUnit(TimeUnit sshKeysTimerUnit) {
		this.sshKeysTimerUnit = sshKeysTimerUnit;
	}
	
	/**
	 * @return the doPackageManagement
	 */
	public TaskState getDoPackageManagement() {
		return this.doPackageManagement;
	}
	
	/**
	 * @param doPackageManagement the doPackageManagement to set
	 */
	public void setDoPackageManagement(TaskState doPackageManagement) {
		this.doPackageManagement = doPackageManagement;
	}
	
	/**
	 * @return the packageManagementTimer
	 */
	public int getPackageManagementTimer() {
		return this.packageManagementTimer;
	}
	
	/**
	 * @param packageManagementTimer the packageManagementTimer to set
	 */
	public void setPackageManagementTimer(int packageManagementTimer) {
		this.packageManagementTimer = packageManagementTimer;
	}
	
	/**
	 * @return the packageManagementTimerUnit
	 */
	public TimeUnit getPackageManagementTimerUnit() {
		return this.packageManagementTimerUnit;
	}
	
	/**
	 * @param packageManagementTimerUnit the packageManagementTimerUnit to set
	 */
	public void setPackageManagementTimerUnit(TimeUnit packageManagementTimerUnit) {
		this.packageManagementTimerUnit = packageManagementTimerUnit;
	}
	
	/**
	 * @return the doFileManagement
	 */
	public TaskState getDoFileManagement() {
		return this.doFileManagement;
	}
	
	/**
	 * @param doFileManagement the doFileManagement to set
	 */
	public void setDoFileManagement(TaskState doFileManagement) {
		this.doFileManagement = doFileManagement;
	}
	
	/**
	 * @return the fileManagementTimer
	 */
	public int getFileManagementTimer() {
		return this.fileManagementTimer;
	}
	
	/**
	 * @param fileManagementTimer the fileManagementTimer to set
	 */
	public void setFileManagementTimer(int fileManagementTimer) {
		this.fileManagementTimer = fileManagementTimer;
	}
	
	/**
	 * @return the fileManagementTimerUnit
	 */
	public TimeUnit getFileManagementTimerUnit() {
		return this.fileManagementTimerUnit;
	}
	
	/**
	 * @param fileManagementTimerUnit the fileManagementTimerUnit to set
	 */
	public void setFileManagementTimerUnit(TimeUnit fileManagementTimerUnit) {
		this.fileManagementTimerUnit = fileManagementTimerUnit;
	}
	
	/**
	 * @return the templateName
	 */
	public String getTemplateName() {
		return this.templateName;
	}
	
	/**
	 * @param templateName the templateName to set
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return this.uuid;
	}
	
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
