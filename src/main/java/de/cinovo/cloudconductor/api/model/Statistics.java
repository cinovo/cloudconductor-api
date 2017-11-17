package de.cinovo.cloudconductor.api.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Copyright 2017 Cinovo AG<br>
 * <br>
 *
 * @author mweise
 */
@JsonTypeInfo(include = As.PROPERTY, use = Id.CLASS)
public class Statistics {
	
	private long numberOfHosts;
	private long numberOfTemplates;
	private long numberOfServices;
	private long numberOfPackages;
	
	public long getNumberOfHosts() {
		return numberOfHosts;
	}
	
	public void setNumberOfHosts(long numberOfHosts) {
		this.numberOfHosts = numberOfHosts;
	}
	
	public long getNumberOfTemplates() {
		return numberOfTemplates;
	}
	
	public void setNumberOfTemplates(long numberOfTemplates) {
		this.numberOfTemplates = numberOfTemplates;
	}
	
	public long getNumberOfServices() {
		return numberOfServices;
	}
	
	public void setNumberOfServices(long numberOfServices) {
		this.numberOfServices = numberOfServices;
	}
	
	public long getNumberOfPackages() {
		return numberOfPackages;
	}
	
	public void setNumberOfPackages(long numberOfPackages) {
		this.numberOfPackages = numberOfPackages;
	}

}
