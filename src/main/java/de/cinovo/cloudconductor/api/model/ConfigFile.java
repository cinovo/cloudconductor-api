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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ConfigFile implements INamed {
	
	private String name;
	private String pkg;
	private String targetPath;
	private String owner;
	private String group;
	private String fileMode;
	private boolean isTemplate;
	private boolean isReloadable;
	private boolean isDirectory;
	private String checksum;
	private Set<String> dependentServices;
	private List<String> templates = new ArrayList<>();
	
	
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
	 * @return the targetPath
	 */
	public String getTargetPath() {
		return this.targetPath;
	}
	
	/**
	 * @param targetPath the targetPath to set
	 */
	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}
	
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return this.owner;
	}
	
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
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
	
	/**
	 * @return the fileMode
	 */
	public String getFileMode() {
		return this.fileMode;
	}
	
	/**
	 * @param fileMode the fileMode to set
	 */
	public void setFileMode(String fileMode) {
		this.fileMode = fileMode;
	}
	
	/**
	 * @return the isTemplate
	 */
	@JsonProperty("isReloadable")
	public boolean isReloadable() {
		return this.isReloadable;
	}
	
	/**
	 * @param reloadable the isReloadable to set
	 */
	public void setReloadable(boolean reloadable) {
		this.isReloadable = reloadable;
	}
	
	/**
	 * @return the isTemplate
	 */
	@JsonProperty("isTemplate")
	public boolean isTemplate() {
		return this.isTemplate;
	}
	
	/**
	 * @param template the isTemplate to set
	 */
	public void setTemplate(boolean template) {
		this.isTemplate = template;
	}
	
	/**
	 * @return the isDirectory
	 */
	@JsonProperty("isDirectory")
	public boolean isDirectory() {
		return this.isDirectory;
	}
	
	/**
	 * @param isDirectory the isDirectory to set
	 */
	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}
	
	/**
	 * @return the checksum
	 */
	public String getChecksum() {
		return this.checksum;
	}
	
	/**
	 * @param checksum the checksum to set
	 */
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	
	/**
	 * @return the pkg
	 */
	public String getPkg() {
		return this.pkg;
	}
	
	/**
	 * @param pkg the pkg to set
	 */
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	
	/**
	 * @return the dependentServices
	 */
	public Set<String> getDependentServices() {
		return this.dependentServices;
	}
	
	/**
	 * @param dependentServices the dependentServices to set
	 */
	public void setDependentServices(Set<String> dependentServices) {
		this.dependentServices = dependentServices;
	}
	
	/**
	 * @return the templates
	 */
	public List<String> getTemplates() {
		return this.templates;
	}
	
	/**
	 * @param templates the templates to set
	 */
	public void setTemplates(List<String> templates) {
		this.templates = templates;
	}
}
