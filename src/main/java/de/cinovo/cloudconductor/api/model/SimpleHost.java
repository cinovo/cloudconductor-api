package de.cinovo.cloudconductor.api.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Copyright 2018 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@JsonTypeInfo(include = As.PROPERTY, use = Id.CLASS)
public class SimpleHost {

	private String name;
	private String agent;
	private String uuid;

	private String template;

	private Long lastSeen;

	private Long numberOfServices;
	private Long numberOfPackages;

	/**
	 * @param name             the name
	 * @param agent            the agent name
	 * @param uuid             the uuid
	 * @param template         the template name
	 * @param lastSeen         the last seen date
	 * @param numberOfServices the service count
	 * @param numberOfPackages the package count
	 */
	public SimpleHost(String name, String agent, String uuid, String template, Long lastSeen, Long numberOfServices, Long numberOfPackages) {
		this.name = name;
		this.agent = agent;
		this.uuid = uuid;
		this.template = template;
		this.lastSeen = lastSeen;
		this.numberOfServices = numberOfServices;
		this.numberOfPackages = numberOfPackages;
	}

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
	 * @return the agent
	 */
	public String getAgent() {
		return this.agent;
	}

	/**
	 * @param agent the agent to set
	 */
	public void setAgent(String agent) {
		this.agent = agent;
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
	 * @return the lastSeen
	 */
	public Long getLastSeen() {
		return this.lastSeen;
	}

	/**
	 * @param lastSeen the lastSeen to set
	 */
	public void setLastSeen(Long lastSeen) {
		this.lastSeen = lastSeen;
	}

	/**
	 * @return the numberOfServices
	 */
	public Long getNumberOfServices() {
		return this.numberOfServices;
	}

	/**
	 * @param numberOfServices the numberOfServices to set
	 */
	public void setNumberOfServices(Long numberOfServices) {
		this.numberOfServices = numberOfServices;
	}

	/**
	 * @return the numberOfPackages
	 */
	public Long getNumberOfPackages() {
		return this.numberOfPackages;
	}

	/**
	 * @param numberOfPackages the numberOfPackages to set
	 */
	public void setNumberOfPackages(Long numberOfPackages) {
		this.numberOfPackages = numberOfPackages;
	}
}
