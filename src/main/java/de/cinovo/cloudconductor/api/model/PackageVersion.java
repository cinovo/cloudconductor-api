package de.cinovo.cloudconductor.api.model;

/*
 * #%L
 * cloudconductor-api
 * %%
 * Copyright (C) 2013 - 2014 Cinovo AG
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import de.cinovo.cloudconductor.api.interfaces.INamed;

/**
 * Copyright 2013 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
@JsonTypeInfo(include = As.PROPERTY, use = Id.CLASS)
public class PackageVersion implements INamed {
	
	private String name;
	private String version;
	private Set<Dependency> dependencies = new HashSet<>();
	private Set<String> repos = new HashSet<>();
	
	
	/**
	 * Create empty PackageVersion
	 */
	public PackageVersion() {
		
	}
	
	/**
	 * Create PackageVersion with given name, version and dependencies.
	 * 
	 * @param name the name
	 * @param version the version
	 * @param dependencies set of dependencies
	 */
	public PackageVersion(String name, String version, Set<Dependency> dependencies) {
		this.name = name;
		this.version = version;
		this.dependencies = dependencies;
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
	 * @return the dependencies
	 */
	public Set<Dependency> getDependencies() {
		return this.dependencies;
	}
	
	/**
	 * @param dependencies the dependencies to set
	 */
	public void setDependencies(Set<Dependency> dependencies) {
		this.dependencies = dependencies;
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
		return this.name + ":" + this.version + " (" + this.repos.toString() + ")";
	}
	
	@Override
	@JsonIgnore
	public boolean equals(Object obj) {
		if (!(obj instanceof PackageVersion)) {
			return false;
		}
		
		PackageVersion other = (PackageVersion) obj;
		if (this.name == null) {
			return false;
		}
		if (!this.name.equals(other.getName())) {
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
		int val = (this.getVersion() == null) ? 0 : this.getVersion().hashCode();
		int parent = (this.getName() == null) ? 0 : this.getName().hashCode();
		return val * parent;
	}
	
}
