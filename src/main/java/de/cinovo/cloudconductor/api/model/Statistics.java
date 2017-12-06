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
	
	
	/**
	 * @return the numberOfHosts
	 */
	public long getNumberOfHosts() {
		return this.numberOfHosts;
	}
	
	/**
	 * @param numberOfHosts the numberOfHosts to set
	 */
	public void setNumberOfHosts(long numberOfHosts) {
		this.numberOfHosts = numberOfHosts;
	}
	
	/**
	 * @return the numberOfTemplates
	 */
	public long getNumberOfTemplates() {
		return this.numberOfTemplates;
	}
	
	/**
	 * @param numberOfTemplates the numberOfTemplates to set
	 */
	public void setNumberOfTemplates(long numberOfTemplates) {
		this.numberOfTemplates = numberOfTemplates;
	}
	
	/**
	 * @return the numberOfServices
	 */
	public long getNumberOfServices() {
		return this.numberOfServices;
	}
	
	/**
	 * @param numberOfServices the numberOfServices to set
	 */
	public void setNumberOfServices(long numberOfServices) {
		this.numberOfServices = numberOfServices;
	}
	
	/**
	 * @return the numberOfPackages
	 */
	public long getNumberOfPackages() {
		return this.numberOfPackages;
	}
	
	/**
	 * @param numberOfPackages the numberOfPackages to set
	 */
	public void setNumberOfPackages(long numberOfPackages) {
		this.numberOfPackages = numberOfPackages;
	}
	
}
