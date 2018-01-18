package de.cinovo.cloudconductor.api.model;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import de.cinovo.cloudconductor.api.enums.ServiceState;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@JsonTypeInfo(include = As.PROPERTY, use = Id.CLASS)
public class ChangeServiceState {

	private String hostUuid;
	private String service;
	private ServiceState targetState;

	/**
	 * @return the hostUuid
	 */
	public String getHostUuid() {
		return this.hostUuid;
	}

	/**
	 * @param hostUuid the hostUuid to set
	 */
	public void setHostUuid(String hostUuid) {
		this.hostUuid = hostUuid;
	}

	/**
	 * @return the service
	 */
	public String getService() {
		return this.service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * @return the targetState
	 */
	public ServiceState getTargetState() {
		return this.targetState;
	}

	/**
	 * @param targetState the targetState to set
	 */
	public void setTargetState(ServiceState targetState) {
		this.targetState = targetState;
	}
}
