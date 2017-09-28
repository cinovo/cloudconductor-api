package de.cinovo.cloudconductor.api.enums;

/**
 * Copyright 2015 Cinovo AG<br>
 * <br>
 * 
 * @author psigloch
 *
 */
public enum RepoProviderType {
	/** no provider chosen */
	NONE,
	/** {@link HTTPProvider} */
	HTTP,
	/** {@link AWSS3Provider} */
	AWSS3,
	/** {@link FileProvider} */
	FILE
}
