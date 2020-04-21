package de.cinovo.cloudconductor.api.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2020 Cinovo AG<br>
 * <br>
 *
 * @author mweise
 */
@JsonTypeInfo(use = Id.CLASS)
public class ConfigValues {
	
	private final List<ConfigValue> elements;
	
	public ConfigValues() {
		this(new ArrayList<>());
	}
	
	public ConfigValues(List<ConfigValue> elements) {
		this.elements = new ArrayList<>(elements);
	}
	
	/**
	 * @return the elements
	 */
	public List<ConfigValue> getElements() {
		return this.elements;
	}
	
}
