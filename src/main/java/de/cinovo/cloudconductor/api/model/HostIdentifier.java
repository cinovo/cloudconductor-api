package de.cinovo.cloudconductor.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class HostIdentifier {

	private String name;
	private String uuid;

	/**
	 * @param name the name
	 * @param uuid the uuid
	 */
	@JsonCreator
	public HostIdentifier(@JsonProperty("name") String name, @JsonProperty("uuid") String uuid) {
		this.name = name;
		this.uuid = uuid;
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
