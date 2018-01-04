package de.cinovo.cloudconductor.api.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import de.cinovo.cloudconductor.api.enums.ServiceState;

/**
 * Copyright 2018 Cinovo AG<br>
 * <br>
 * 
 * @author mweise
 *
 */
@JsonTypeInfo(include = As.PROPERTY, use = Id.CLASS)
public class ServiceDefaultState {
	
	private String service;
	private String template;
	private ServiceState state = ServiceState.STOPPED;
	
	
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
	 * @return the defaultState
	 */
	public ServiceState getState() {
		return this.state;
	}
	
	/**
	 * @param defaultState the defaultState to set
	 */
	public void setDefaultState(ServiceState defaultState) {
		this.state = defaultState;
	}
	
}
