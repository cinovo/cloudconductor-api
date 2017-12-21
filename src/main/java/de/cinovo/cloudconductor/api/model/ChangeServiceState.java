package de.cinovo.cloudconductor.api.model;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@JsonTypeInfo(include = As.PROPERTY, use = Id.CLASS)
public class ChangeServiceState {

	private String host;
	private String service;
	private ServiceStates targetState;

	/**
	 * @return the host
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
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
	public ServiceStates getTargetState() {
		return this.targetState;
	}

	/**
	 * @param targetState the targetState to set
	 */
	public void setTargetState(ServiceStates targetState) {
		this.targetState = targetState;
	}
}
