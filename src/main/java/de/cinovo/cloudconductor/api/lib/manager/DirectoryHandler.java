package de.cinovo.cloudconductor.api.lib.manager;

/*
 * #%L
 * cloudconductor-api
 * %%
 * Copyright (C) 2013 - 2014 Cinovo AG
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 * #L%
 */

import java.util.Set;

import de.cinovo.cloudconductor.api.IRestPath;
import de.cinovo.cloudconductor.api.lib.exceptions.CloudConductorException;
import de.cinovo.cloudconductor.api.lib.helper.DefaultRestHandler;
import de.cinovo.cloudconductor.api.model.Directory;

/**
 * Copyright 2013 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 *
 */
public class DirectoryHandler extends DefaultRestHandler<Directory> {
	
	/**
	 * @param cloudconductorUrl the config server url
	 */
	public DirectoryHandler(String cloudconductorUrl) {
		super(cloudconductorUrl);
	}
	
	/**
	 * @param cloudconductorUrl the config server url
	 * @param token the token
	 * @param agent the agent
	 */
	public DirectoryHandler(String cloudconductorUrl, String token, String agent) {
		super(cloudconductorUrl);
		this.setTokenMode(token, agent);
	}
	
	@Override
	protected String getDefaultPath() {
		return IRestPath.DIRECTORY;
	}
	
	@Override
	protected Class<Directory> getAPIClass() {
		return Directory.class;
	}
	
	/**
	 * @param template the template name
	 * @return the config files of the template
	 * @throws CloudConductorException Error indicating connection or data problems
	 */
	@SuppressWarnings("unchecked")
	public Set<Directory> getDirectoryByTemplate(String template) throws CloudConductorException {
		String path = this.pathGenerator(IRestPath.DIRECTORY_DIRECTORIES, template);
		return (Set<Directory>) this._get(path, this.getSetType(Directory.class));
	}
}
