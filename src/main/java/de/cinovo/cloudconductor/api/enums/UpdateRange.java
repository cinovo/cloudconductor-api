package de.cinovo.cloudconductor.api.enums;

/**
 * Copyright 2021 Cinovo AG<br>
 * <br>
 *
 * @author mweise
 */
public enum UpdateRange {
    /** [0] Update to latest version, without any restriction e.g. 1.2.3 to 2.5.6 */
    all,

    /** [1] Update to latest version within major, e.g. 1.2.3 to 1.4.0 */
    major,

    /** [2] Update to latest version within minor, e.g. 1.2.3 to 1.2.5 */
    minor,

    /** [3] Update to latest version within patch, e.g. 1.2.3-1 to 1.2.3-5 */
    patch,
}
