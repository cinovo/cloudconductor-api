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
public class ConfigDiff {


	private String key;
	private String service = null;

	private String valueA;
	private String valueB;

	/**
	 * @return the key
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
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
	 * @return the valueA
	 */
	public String getValueA() {
		return this.valueA;
	}

	/**
	 * @param valueA the valueA to set
	 */
	public void setValueA(String valueA) {
		this.valueA = valueA;
	}

	/**
	 * @return the valueB
	 */
	public String getValueB() {
		return this.valueB;
	}

	/**
	 * @param valueB the valueB to set
	 */
	public void setValueB(String valueB) {
		this.valueB = valueB;
	}
}
