package de.cinovo.cloudconductor.api.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Map;
import java.util.SortedSet;

/**
 * Copyright 2021 Cinovo AG<br>
 * <br>
 *
 * @author mweise
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class PackageVersionUpdates {

    private final Map<String, SortedSet<String>> available;
    private final Map<String, SortedSet<String>> inRange;

    public PackageVersionUpdates(Map<String, SortedSet<String>> available, Map<String, SortedSet<String>> inRange) {
        this.available = available;
        this.inRange = inRange;
    }

    public Map<String, SortedSet<String>> getAvailable() {
        return available;
    }

    public Map<String, SortedSet<String>> getInRange() {
        return inRange;
    }
}
