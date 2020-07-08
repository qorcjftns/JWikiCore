package dev.cheulsoon.jwikicore.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev.cheulsoon.jwikicore.grammar.component.Component;

public class ParsedComponent {
	
	private Component componentType;
	private String text;
	private String tag;
	private List<Map<String, String>> attributes;
	
	private List<ParsedComponent> children;
	
	public ParsedComponent(Component componentType, String text, String tag) {
		this.componentType = componentType;
		this.text = text;
		this.tag = tag;
		this.children = new ArrayList<>();
	}
	
	public void addComponent(ParsedComponent pc) {
		this.children.add(pc);
	}
	
	
	// Getter / Setter

	public Component getComponentType() {
		return componentType;
	}

	public void setComponentType(Component componentType) {
		this.componentType = componentType;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<Map<String, String>> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Map<String, String>> attributes) {
		this.attributes = attributes;
	}

	public List<ParsedComponent> getChildren() {
		return children;
	}

	public void setChildren(List<ParsedComponent> children) {
		this.children = children;
	}
	
	

}
