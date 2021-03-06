package de.cinovo.cloudconductor.api.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright 2018 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@JsonTypeInfo(use = Id.CLASS)
public class SimpleTemplate {

	private String name;
	private int hostCount;
	private int packageCount;
	private Set<String> repos;
	private String group;

	/** default constructor */
	public SimpleTemplate() {
		// nothing to do
	}

	/**
	 * @param name			template name
	 * @param hostCount		number of hosts
	 * @param packageCount	number of packages
	 * @param group			template group
	 */
	public SimpleTemplate(String name, int hostCount, int packageCount, String group) {
		this.name = name;
		this.hostCount = hostCount;
		this.packageCount = packageCount;
		this.repos = new HashSet<>();
		this.group = group;
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
	 * @return the hostCount
	 */
	public int getHostCount() {
		return this.hostCount;
	}

	/**
	 * @param hostCount the hostCount to set
	 */
	public void setHostCount(int hostCount) {
		this.hostCount = hostCount;
	}

	/**
	 * @return the packageCount
	 */
	public int getPackageCount() {
		return this.packageCount;
	}

	/**
	 * @param packageCount the packageCount to set
	 */
	public void setPackageCount(int packageCount) {
		this.packageCount = packageCount;
	}

	/**
	 * @return the repos
	 */
	public Set<String> getRepos() {
		return this.repos;
	}

	/**
	 * @param repos the repos to set
	 */
	public void setRepos(Set<String> repos) {
		this.repos = repos;
	}

	/**
	 * @return the group
	 */
	public String getGroup() {
		return this.group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}
}
