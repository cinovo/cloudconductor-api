package de.cinovo.cloudconductor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import de.cinovo.cloudconductor.api.interfaces.INamed;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Copyright 2019 Cinovo AG<br>
 * <br>
 *
 * @author mweise
 */
@JsonTypeInfo(use = Id.NONE)
public class SimplePackageVersion implements INamed {
	
	private String name;
	private String version;
	private Set<String> repos = new HashSet<>();
	
	/**
	 * Create empty PackageVersion
	 */
	public SimplePackageVersion() {
		// nothing to do
	}
	
	/**
	 * @param name		the package name
	 * @param version	the version string
	 * @param repos		set of providing repos
	 */
	public SimplePackageVersion(String name, String version, Collection<String> repos) {
		this.name = name;
		this.version = version;
		this.repos = new LinkedHashSet<>(repos);
	}
	
	/**
	 * @return the name
	 */
	@Override
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
	 * @return the version
	 */
	public String getVersion() {
		return this.version;
	}
	
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
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
	
	@Override
	@JsonIgnore
	public String toString() {
		return this.name + ":" + this.version;
	}
	
	@Override
	@JsonIgnore
	public boolean equals(Object obj) {
		if (!(obj instanceof SimplePackageVersion)) {
			return false;
		}
		SimplePackageVersion other = (SimplePackageVersion) obj;
		if (this.name == null || !this.name.equals(other.getName())) {
			return false;
		}
		
		if (this.version == null) {
			return false;
		}
		return this.version.equals(other.getVersion());
	}
	
	@Override
	@JsonIgnore
	public int hashCode() {
		return Objects.hash(this.getName(), this.getVersion());
	}
	
}
