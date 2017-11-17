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
	public static final String ROOT = "/";
	
	// -------------------------------------------------------
	// VARIABLES
	// -------------------------------------------------------
	
	/** variable for name */
	public static final String VAR_NAME = "name";
	/** variable for template name */
	public static final String VAR_TEMPLATE = "template";
	/** variable for host name */
	public static final String VAR_HOST = "host";
	/** variable for service name */
	public static final String VAR_SERVICE = "service";
	/** variable for key */
	public static final String VAR_KEY = "key";
	/** variable for package name */
	public static final String VAR_PKG = "pkg";
	/** variable for version name */
	public static final String VAR_VERSION = "version";
	/** variable for agent name */
	public static final String VAR_AGENT = "agent";
	/** variable for agent UUID */
	public static final String VAR_UUID = "uuid";
	/** variable for SSH key owner **/
	public static final String VAR_OWNER = "owner";
	/** variable for the id of a token **/
	public static final String VAR_TOKENID = "tokenId";
	/** variable for the id of a link **/
	public static final String VAR_LINKID = "linkId";
	/** variable for a repository **/
	public static final String VAR_REPO = "repo";
	/** variable for the id of a repo mirror **/
	public static final String VAR_RMID = "rmId";
	
	// -------------------------------------------------------
	// DEFAULT
	// -------------------------------------------------------
	
	/**
	 * the default identifier for a name
	 */
	public static final String DEFAULT_NAME = "/{" + IRestPath.VAR_NAME + "}";
	
	// -------------------------------------------------------
	// AGENT
	// -------------------------------------------------------
	
	/**
	 * agent api
	 */
	public static final String AGENT = "/agent";
	
	/**
	 * notify package state for template and host
	 */
	public static final String AGENT_PACKAGE_STATE = "/{" + IRestPath.VAR_TEMPLATE + "}/{" + IRestPath.VAR_HOST + "}/{" + IRestPath.VAR_UUID + "}/package";
	
	/**
	 * notify service state for template and host
	 */
	public static final String AGENT_SERVICE_STATE = "/{" + IRestPath.VAR_TEMPLATE + "}/{" + IRestPath.VAR_HOST + "}/{" + IRestPath.VAR_UUID + "}/service";
	
	/**
	 * notify server that agent is alive
	 */
	public static final String AGENT_HEART_BEAT = "/{" + IRestPath.VAR_TEMPLATE + "}/{" + IRestPath.VAR_HOST + "}/{" + IRestPath.VAR_AGENT + "}/{" + IRestPath.VAR_UUID + "}/heartbeat";
	
	/**
	 * check if the server exists
	 */
	public static final String AGENT_PING = "/ping";
	// -------------------------------------------------------
	// CONFIG FILES
	// -------------------------------------------------------
	/**
	 * configfile api
	 */
	public static final String FILE = "/file";
	
	/**
	 * interact with the data of a config file
	 */
	public static final String FILE_DATA = "/{" + IRestPath.VAR_NAME + "}/data";
	/**
	 * interact with details of a configuration file
	 */
	public static final String FILE_DETAILS = "/{" + IRestPath.VAR_NAME + "}";
	/**
	 * interact with files of a specific template
	 */
	public static final String FILE_TEMPLATE = "/template/{" + IRestPath.VAR_TEMPLATE + "}";
	
	// -------------------------------------------------------
	// CONFIG VALUES
	// -------------------------------------------------------
	
	/**
	 * config value api
	 */
	public static final String CONFIG = "/config";
	/**
	 * interact with the config of a template
	 */
	public static final String CONFIG_TEMPLATE = "/{" + IRestPath.VAR_TEMPLATE + "}";
	/**
	 * interact with the config of a template for a specific key
	 */
	public static final String CONFIG_TEMPLATE_KEY = "/{" + IRestPath.VAR_TEMPLATE + "}/{" + IRestPath.VAR_KEY + "}";
	/**
	 * interact with the config of a service of a template
	 */
	public static final String CONFIG_TEMPLATE_SERVICE = "/{" + IRestPath.VAR_TEMPLATE + "}/{" + IRestPath.VAR_SERVICE + "}";
	/**
	 * interact with the config of a service of a template for a specific key
	 */
	public static final String CONFIG_TEMPLATE_SERVICE_KEY = "/{" + IRestPath.VAR_TEMPLATE + "}/{" + IRestPath.VAR_SERVICE + ":.*}/{" + IRestPath.VAR_KEY + "}";
	/**
	 * all configuration values not stacked
	 */
	public static final String CONFIG_TEMPLATE_UNSTACKED = "/{" + IRestPath.VAR_TEMPLATE + "}/unstacked";
	
	// -------------------------------------------------------
	// HOST
	// -------------------------------------------------------
	/**
	 * host api
	 */
	public static final String HOST = "/host";
	/**
	 * interact with a single host
	 */
	public static final String HOST_DETAIL = "/{" + IRestPath.VAR_HOST + "}";
	/**
	 * interact with the services of a host
	 */
	public static final String HOST_SERVICES = "/{" + IRestPath.VAR_HOST + "}/service";
	/**
	 * interact with the services of a host
	 */
	public static final String HOST_SERVICE_SVC = "/{" + IRestPath.VAR_HOST + "}/{" + IRestPath.VAR_SERVICE + "}";
	/**
	 * check if host is in sync with template
	 */
	public static final String HOST_SYNC = "/{" + IRestPath.VAR_HOST + "}/synced";
	/**
	 * starts a service on host
	 */
	public static final String HOST_SERVICE_START = IRestPath.HOST_SERVICE_SVC + "/start";
	/**
	 * stops a service on a host
	 */
	public static final String HOST_SERVICE_STOP = IRestPath.HOST_SERVICE_SVC + "/stop";
	/**
	 * restarts a service on a host
	 */
	public static final String HOST_SERVICE_RESTART = IRestPath.HOST_SERVICE_SVC + "/restart";
	
	// -------------------------------------------------------
	// PACKAGE
	// -------------------------------------------------------
	/**
	 * host api
	 */
	public static final String PKG = "/package";
	/**
	 * interact with single package
	 */
	public static final String PKG_DETAIL = "/{" + IRestPath.VAR_PKG + "}";
	/**
	 * interact with the package versions of a host
	 */
	public static final String PKG_VERSION = "/{" + IRestPath.VAR_PKG + "}/versions";
	/**
	 * interact with usage of a package
	 */
	public static final String PKG_USAGE = "/{" + IRestPath.VAR_PKG + "}/usage";
	/**
	 * interact with the package versions of a host
	 */
	public static final String PKG_VERSION_SINGLE = IRestPath.PKG_VERSION + "/{" + IRestPath.VAR_VERSION + "}";
	/**
	 * interact with package versions of a single repository
	 */
	public static final String PKG_VERSION_REPO = "/versions/repo/{" + IRestPath.VAR_REPO + "}";
	
	// -------------------------------------------------------
	// SERVICE
	// -------------------------------------------------------
	/**
	 * service api
	 */
	public static final String SERVICE = "/service";
	/**
	 * interact with a single service
	 */
	public static final String SERVICE_DETAIL = "/{" + IRestPath.VAR_SERVICE + "}";
	/**
	 * interact with the usage of a single service
	 */
	public static final String SERVICE_USAGE = "/{" + IRestPath.VAR_SERVICE + "}/usage";
	/**
	 * interact with the packages of a service
	 */
	public static final String SERVICE_PKG = "/{" + IRestPath.VAR_SERVICE + "}/packages";
	/**
	 * interact with the packages of a service
	 */
	public static final String SERVICE_PKG_SINGLE = IRestPath.SERVICE_PKG + "/{" + IRestPath.VAR_PKG + "}";
	
	/**
	 * approve the started state of a service
	 */
	public static final String SERVICE_APPROVE_STARTED = "/{" + IRestPath.VAR_SERVICE + "}/approvestarted/{" + IRestPath.VAR_HOST + "}";
	
	// -------------------------------------------------------
	// SSH KEY
	// -------------------------------------------------------
	/**
	 * service api
	 */
	public static final String SSHKEY = "/ssh";
	/**
	 * interact with a single ssh key
	 */
	public static final String SSHKEY_DETAIL = "/{" + IRestPath.VAR_OWNER + "}";
	
	// -------------------------------------------------------
	// TEMPLATE
	// -------------------------------------------------------
	/**
	 * template api
	 */
	public static final String TEMPLATE = "/template";
	/**
	 * interact with a single template
	 */
	public static final String TEMPLATE_DETAIL = "/{" + IRestPath.VAR_TEMPLATE + "}";
	/**
	 * interact with a single package of a single template
	 */
	public static final String TEMPLATE_PACKAGE = "/{" + IRestPath.VAR_TEMPLATE + "}/package/{" + IRestPath.VAR_PKG + "}";
	/**
	 * interact with the agent option of a single template
	 */
	public static final String TEMPLATE_AGENTOPTION = "/{" + IRestPath.VAR_TEMPLATE + "}/agentoption";
	/**
	 * interact with the services of a template
	 */
	public static final String TEMPLATE_SERVICE = "/{" + IRestPath.VAR_TEMPLATE + "}/services";
	/**
	 * interact with the services of a template
	 */
	public static final String TEMPLATE_SERVICE_SINGLE = IRestPath.TEMPLATE_SERVICE + "/{" + IRestPath.VAR_SERVICE + "}";
	/**
	 * interact with the hosts of a template
	 */
	public static final String TEMPLATE_HOST = "/{" + IRestPath.VAR_TEMPLATE + "}/hosts";
	/**
	 * interact with the hosts of a template
	 */
	public static final String TEMPLATE_HOST_SINGLE = IRestPath.TEMPLATE_HOST + "/{" + IRestPath.VAR_HOST + "}";
	/**
	 * interact with the sshkeys of a template
	 */
	public static final String TEMPLATE_SSHKEY = "/{" + IRestPath.VAR_TEMPLATE + "}/sshkeys";
	/**
	 * interact with the sshkeys of a template
	 */
	public static final String TEMPLATE_SSHKEY_SINGLE = IRestPath.TEMPLATE_SSHKEY + "/{" + IRestPath.VAR_NAME + "}";
	/**
	 * interact with the package versions of a template
	 */
	public static final String TEMPLATE_VERSION = "/{" + IRestPath.VAR_TEMPLATE + "}/package/versions";
	/**
	 * interact with the package versions of a template
	 */
	public static final String TEMPLATE_VERSION_SINGLE = IRestPath.TEMPLATE_VERSION + "/{" + IRestPath.VAR_PKG + "}/{" + IRestPath.VAR_VERSION + "}";
	/**
	 * interact with repositories of a template
	 */
	public static final String TEMPLATE_REPO = "/{" + IRestPath.VAR_TEMPLATE + "}/repo";
	
	// -------------------------------------------------------
	// IOModule
	// -------------------------------------------------------
	/**
	 * IOModule api
	 */
	public static final String IO = "/io";
	/**
	 * io versions
	 */
	public static final String IO_VERSION = "/versions";
	
	// -------------------------------------------------------
	// REPORT
	// -------------------------------------------------------
	/**
	 * Report api
	 */
	public static final String REPORT = "/report";
	
	// -------------------------------------------------------
	// AUTH TOKEN
	// -------------------------------------------------------
	/**
	 * auth token api
	 */
	public static final String AUTHTOKEN = "/authtoken";
	/**
	 * generate a new token
	 */
	public static final String AUTHTOKEN_GENERATE = "/generate";
	/**
	 * revoke an existing token
	 */
	public static final String AUTHTOKEN_REVOKE = "/{" + IRestPath.VAR_TOKENID + "}/revoke";
	
	// -------------------------------------------------------
	// Link
	// -------------------------------------------------------
	/**
	 * link API
	 */
	public static final String LINK = "/links";
	/**
	 * interact with a single link
	 */
	public static final String LINK_DETAIL = "/{" + IRestPath.VAR_LINKID + "}";
	
	// -------------------------------------------------------
	// Repository
	// -------------------------------------------------------
	/**
	 * repository API
	 */
	public static final String REPO = "/repo";
	/**
	 * interact with a single repository
	 */
	public static final String REPO_DETAIL = "/{" + IRestPath.VAR_NAME + "}";
	
	// -------------------------------------------------------
	// Repository Mirror
	// -------------------------------------------------------
	/**
	 * repository mirror API
	 */
	public static final String REPOMIRROR = "/repomirror";
	/**
	 * interact with a single repository mirror
	 */
	public static final String REPOMIRROR_DETAIL = "/{" + IRestPath.VAR_RMID + "}";
	
	/**
	 * settings API
	 */
	public static final String SETTINGS = "/settings";
	/**
	 * websockets configuration API
	 */
	public static final String WSCONFIG = "/wsconfig";
	
	/**
	 * statistics API
	 */
	public static final String STATS = "/stats";
}
