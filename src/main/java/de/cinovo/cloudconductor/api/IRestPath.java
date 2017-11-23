package de.cinovo.cloudconductor.api;

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

/**
 * Path's provided and supported by the api
 * 
 * Copyright 2013 Cinovo AG<br>
 * <br>
 * 
 * @author psigloch
 * 
 */
public interface IRestPath {
	
	/**
	 * current directory "/"
	 */
	String ROOT = "/";
	
	// -------------------------------------------------------
	// VARIABLES
	// -------------------------------------------------------
	
	/** variable for name */
	String VAR_NAME = "name";
	/** variable for template name */
	String VAR_TEMPLATE = "template";
	/** variable for host name */
	String VAR_HOST = "host";
	/** variable for service name */
	String VAR_SERVICE = "service";
	/** variable for key */
	String VAR_KEY = "key";
	/** variable for package name */
	String VAR_PKG = "pkg";
	/** variable for version name */
	String VAR_VERSION = "version";
	/** variable for agent name */
	String VAR_AGENT = "agent";
	/** variable for agent UUID */
	String VAR_UUID = "uuid";
	/** variable for SSH key owner **/
	String VAR_OWNER = "owner";
	/** variable for the id of a token **/
	String VAR_TOKENID = "tokenId";
	/** variable for the id of a link **/
	String VAR_LINKID = "linkId";
	/** variable for a repository **/
	String VAR_REPO = "repo";
	/** variable for the id of a repo mirror **/
	String VAR_RMID = "rmId";
	
	// -------------------------------------------------------
	// DEFAULT
	// -------------------------------------------------------
	
	/**
	 * the default identifier for a name
	 */
	String DEFAULT_NAME = "/{" + IRestPath.VAR_NAME + "}";
	
	// -------------------------------------------------------
	// AGENT
	// -------------------------------------------------------
	
	/**
	 * agent api
	 */
	String AGENT = "/agent";
	
	/**
	 * notify package state for template and host
	 */
	String AGENT_PACKAGE_STATE = "/{" + IRestPath.VAR_TEMPLATE + "}/{" + IRestPath.VAR_HOST + "}/{" + IRestPath.VAR_UUID + "}/package";
	
	/**
	 * notify service state for template and host
	 */
	String AGENT_SERVICE_STATE = "/{" + IRestPath.VAR_TEMPLATE + "}/{" + IRestPath.VAR_HOST + "}/{" + IRestPath.VAR_UUID + "}/service";
	
	/**
	 * notify server that agent is alive
	 */
	String AGENT_HEART_BEAT = "/{" + IRestPath.VAR_TEMPLATE + "}/{" + IRestPath.VAR_HOST + "}/{" + IRestPath.VAR_AGENT + "}/{" + IRestPath.VAR_UUID + "}/heartbeat";
	
	/**
	 * check if the server exists
	 */
	String AGENT_PING = "/ping";
	// -------------------------------------------------------
	// CONFIG FILES
	// -------------------------------------------------------
	/**
	 * configfile api
	 */
	String FILE = "/file";
	
	/**
	 * interact with the data of a config file
	 */
	String FILE_DATA = "/{" + IRestPath.VAR_NAME + "}/data";
	/**
	 * interact with details of a configuration file
	 */
	String FILE_DETAILS = "/{" + IRestPath.VAR_NAME + "}";
	/**
	 * interact with files of a specific template
	 */
	String FILE_TEMPLATE = "/template/{" + IRestPath.VAR_TEMPLATE + "}";
	
	// -------------------------------------------------------
	// CONFIG VALUES
	// -------------------------------------------------------
	
	/**
	 * config value api
	 */
	String CONFIG = "/config";
	/**
	 * interact with the config of a template
	 */
	String CONFIG_TEMPLATE = "/{" + IRestPath.VAR_TEMPLATE + "}";
	/**
	 * interact with the config of a template for a specific key
	 */
	String CONFIG_TEMPLATE_KEY = "/{" + IRestPath.VAR_TEMPLATE + "}/{" + IRestPath.VAR_KEY + "}";
	/**
	 * interact with the config of a service of a template
	 */
	String CONFIG_TEMPLATE_SERVICE = "/{" + IRestPath.VAR_TEMPLATE + "}/{" + IRestPath.VAR_SERVICE + "}";
	/**
	 * interact with the config of a service of a template for a specific key
	 */
	String CONFIG_TEMPLATE_SERVICE_KEY = "/{" + IRestPath.VAR_TEMPLATE + "}/{" + IRestPath.VAR_SERVICE + ":.*}/{" + IRestPath.VAR_KEY + "}";
	/**
	 * all configuration values not stacked
	 */
	String CONFIG_TEMPLATE_UNSTACKED = "/{" + IRestPath.VAR_TEMPLATE + "}/unstacked";
	
	// -------------------------------------------------------
	// HOST
	// -------------------------------------------------------
	/**
	 * host api
	 */
	String HOST = "/host";
	/**
	 * interact with a single host
	 */
	String HOST_DETAIL = "/{" + IRestPath.VAR_HOST + "}";
	/**
	 * interact with the services of a host
	 */
	String HOST_SERVICES = "/{" + IRestPath.VAR_HOST + "}/service";
	/**
	 * interact with the services of a host
	 */
	String HOST_SERVICE_SVC = "/{" + IRestPath.VAR_HOST + "}/{" + IRestPath.VAR_SERVICE + "}";
	/**
	 * check if host is in sync with template
	 */
	String HOST_SYNC = "/{" + IRestPath.VAR_HOST + "}/synced";
	/**
	 * starts a service on host
	 */
	String HOST_SERVICE_START = IRestPath.HOST_SERVICE_SVC + "/start";
	/**
	 * stops a service on a host
	 */
	String HOST_SERVICE_STOP = IRestPath.HOST_SERVICE_SVC + "/stop";
	/**
	 * restarts a service on a host
	 */
	String HOST_SERVICE_RESTART = IRestPath.HOST_SERVICE_SVC + "/restart";
	
	// -------------------------------------------------------
	// PACKAGE
	// -------------------------------------------------------
	/**
	 * host api
	 */
	String PKG = "/package";
	/**
	 * interact with single package
	 */
	String PKG_DETAIL = "/{" + IRestPath.VAR_PKG + "}";
	/**
	 * interact with the package versions of a host
	 */
	String PKG_VERSION = "/{" + IRestPath.VAR_PKG + "}/versions";
	/**
	 * interact with usage of a package
	 */
	String PKG_USAGE = "/{" + IRestPath.VAR_PKG + "}/usage";
	/**
	 * interact with the package versions of a host
	 */
	String PKG_VERSION_SINGLE = IRestPath.PKG_VERSION + "/{" + IRestPath.VAR_VERSION + "}";
	/**
	 * interact with package versions of a single repository
	 */
	String PKG_VERSION_REPO = "/versions/repo/{" + IRestPath.VAR_REPO + "}";
	
	// -------------------------------------------------------
	// SERVICE
	// -------------------------------------------------------
	/**
	 * service api
	 */
	String SERVICE = "/service";
	/**
	 * interact with a single service
	 */
	String SERVICE_DETAIL = "/{" + IRestPath.VAR_SERVICE + "}";
	/**
	 * interact with the usage of a single service
	 */
	String SERVICE_USAGE = "/{" + IRestPath.VAR_SERVICE + "}/usage";
	/**
	 * interact with the packages of a service
	 */
	String SERVICE_PKG = "/{" + IRestPath.VAR_SERVICE + "}/packages";
	/**
	 * interact with the packages of a service
	 */
	String SERVICE_PKG_SINGLE = IRestPath.SERVICE_PKG + "/{" + IRestPath.VAR_PKG + "}";
	
	/**
	 * approve the started state of a service
	 */
	String SERVICE_APPROVE_STARTED = "/{" + IRestPath.VAR_SERVICE + "}/approvestarted/{" + IRestPath.VAR_HOST + "}";
	
	// -------------------------------------------------------
	// SSH KEY
	// -------------------------------------------------------
	/**
	 * service api
	 */
	String SSHKEY = "/ssh";
	/**
	 * interact with a single ssh key
	 */
	String SSHKEY_DETAIL = "/{" + IRestPath.VAR_OWNER + "}";
	
	// -------------------------------------------------------
	// TEMPLATE
	// -------------------------------------------------------
	/**
	 * template api
	 */
	String TEMPLATE = "/template";
	/**
	 * interact with a single template
	 */
	String TEMPLATE_DETAIL = "/{" + IRestPath.VAR_TEMPLATE + "}";
	/**
	 * interact with a single package of a single template
	 */
	String TEMPLATE_PACKAGE = "/{" + IRestPath.VAR_TEMPLATE + "}/package/{" + IRestPath.VAR_PKG + "}";
	/**
	 * interact with the agent option of a single template
	 */
	String TEMPLATE_AGENTOPTION = "/{" + IRestPath.VAR_TEMPLATE + "}/agentoption";
	/**
	 * interact with the services of a template
	 */
	String TEMPLATE_SERVICE = "/{" + IRestPath.VAR_TEMPLATE + "}/services";
	/**
	 * interact with the services of a template
	 */
	String TEMPLATE_SERVICE_SINGLE = IRestPath.TEMPLATE_SERVICE + "/{" + IRestPath.VAR_SERVICE + "}";
	/**
	 * interact with the hosts of a template
	 */
	String TEMPLATE_HOST = "/{" + IRestPath.VAR_TEMPLATE + "}/hosts";
	/**
	 * interact with the hosts of a template
	 */
	String TEMPLATE_HOST_SINGLE = IRestPath.TEMPLATE_HOST + "/{" + IRestPath.VAR_HOST + "}";
	/**
	 * interact with the sshkeys of a template
	 */
	String TEMPLATE_SSHKEY = "/{" + IRestPath.VAR_TEMPLATE + "}/sshkeys";
	/**
	 * interact with the sshkeys of a template
	 */
	String TEMPLATE_SSHKEY_SINGLE = IRestPath.TEMPLATE_SSHKEY + "/{" + IRestPath.VAR_NAME + "}";
	/**
	 * interact with the package versions of a template
	 */
	String TEMPLATE_VERSION = "/{" + IRestPath.VAR_TEMPLATE + "}/package/versions";
	/**
	 * interact with the package versions of a template
	 */
	String TEMPLATE_VERSION_SINGLE = IRestPath.TEMPLATE_VERSION + "/{" + IRestPath.VAR_PKG + "}/{" + IRestPath.VAR_VERSION + "}";
	/**
	 * interact with repositories of a template
	 */
	String TEMPLATE_REPO = "/{" + IRestPath.VAR_TEMPLATE + "}/repo";
	
	// -------------------------------------------------------
	// IOModule
	// -------------------------------------------------------
	/**
	 * IOModule api
	 */
	String IO = "/io";
	/**
	 * io versions
	 */
	String IO_VERSION = "/versions";
	
	// -------------------------------------------------------
	// Link
	// -------------------------------------------------------
	/**
	 * link API
	 */
	String LINK = "/links";
	/**
	 * interact with a single link
	 */
	String LINK_DETAIL = "/{" + IRestPath.VAR_LINKID + "}";
	
	// -------------------------------------------------------
	// Repository
	// -------------------------------------------------------
	/**
	 * repository API
	 */
	String REPO = "/repo";
	/**
	 * interact with a single repository
	 */
	String REPO_DETAIL = "/{" + IRestPath.VAR_NAME + "}";
	
	// -------------------------------------------------------
	// Repository Mirror
	// -------------------------------------------------------
	/**
	 * repository mirror API
	 */
	String REPOMIRROR = "/repomirror";
	/**
	 * interact with a single repository mirror
	 */
	String REPOMIRROR_DETAIL = "/{" + IRestPath.VAR_RMID + "}";
	
	/**
	 * settings API
	 */
	String SETTINGS = "/settings";
	/**
	 * websockets configuration API
	 */
	String WSCONFIG = "/wsconfig";
	
	/**
	 * statistics API
	 */
	public static final String STATS = "/stats";
}
