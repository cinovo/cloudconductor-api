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

	private String template;
	private String service;
	private ServiceStates targetState;


	/**
	 * @return the template
	 */
	public String getTemplate() {
		return this.template;
	}

	/**
	 * @param template the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
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
