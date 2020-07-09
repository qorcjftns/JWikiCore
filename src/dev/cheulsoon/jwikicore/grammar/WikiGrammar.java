package dev.cheulsoon.jwikicore.grammar;

import java.util.ArrayList;
import java.util.List;

import dev.cheulsoon.jwikicore.grammar.component.Component;

public class WikiGrammar {
	
	private List<Component> components;
	
	public WikiGrammar() {
		this.components = new ArrayList<Component>();
		this.loadComponents();
	}
	
	private void loadComponents() {
		this.components.add(new Component("'''", "'''", "b"));
		this.components.add(new Component("''", "''", "i"));
		this.components.add(new Component("~~", "~~", "del"));
		this.components.add(new Component("__", "__", "u"));
		this.components.add(new Component("^^", "^^", "sup"));
		this.components.add(new Component(",,", ",,", "sub"));
		this.components.add(new Component("### ", "\n", "h2"));
	}
	
	public List<Component> getComponents() {
		return this.components;
	}

}
