package dev.cheulsoon.jwikicore.parser;

import java.util.ArrayList;
import java.util.List;

import dev.cheulsoon.jwikicore.grammar.WikiGrammar;
import dev.cheulsoon.jwikicore.grammar.component.Component;
import dev.cheulsoon.jwikicore.grammar.component.PlainTextComponent;

public class WikiParser {
	
	private WikiGrammar grammar;
	
	public WikiParser(WikiGrammar grammar) {
		this.grammar = grammar;
	}
	/**
	 * If the provided string starts with the given component's start tag
	 * @param comp
	 * @param wikiText
	 * @return true if yes; false otherwise
	 */
	private boolean check(Component comp, String wikiText) {
		if(wikiText.startsWith(comp.getStartWikiTag())) return true;
		return false;
	}
	/**
	 * Find the position of given end tag
	 * @param comp
	 * @param wikiText
	 * @return position index of tag
	 */
	private int findEndTag(Component comp, String wikiText) {
		int position = wikiText.substring(comp.getStartWikiTag().length()).indexOf(comp.getEndWikiTag());
		return position + comp.getStartWikiTag().length();
	}
	
	public List<ParsedComponent> parse(String wikiText) {
		String stack = "";
		// get root parsedComponent
		List<ParsedComponent> parsedData = new ArrayList<ParsedComponent>();
		
		while(wikiText.length() > 0) {
			boolean foundTag = false;
			for(Component comp : grammar.getComponents()) {
				boolean checked = this.check(comp, wikiText);
				if(checked) {
					int endTagPos = findEndTag(comp, wikiText);
					if(endTagPos != -1) { // found comlete tag
						foundTag = true; // set flag
						
						// Split String
						String innerText = wikiText.substring(comp.getStartWikiTag().length(), endTagPos);
						String restText = wikiText.substring(endTagPos + comp.getEndWikiTag().length());
						
						// Proess stack if exist
						if(stack.length() >= 0) {
							ParsedComponent data = new ParsedComponent(new PlainTextComponent(), stack, null);
							parsedData.add(data);
							// clear stack
							stack = "";
						}
						
						List<ParsedComponent> recurse = this.parse(innerText);
						ParsedComponent data = new ParsedComponent(comp, null, comp.getHTMLTag());
						data.setChildren(recurse);
						
						parsedData.add(data);
						
						wikiText = restText;
						
						break;
						
					}
				}
			}
			if(!foundTag && wikiText.length() > 0) {
				stack += wikiText.charAt(0);
				wikiText = wikiText.substring(1); // process 1 character
			}
			foundTag = false;
		}
		
		if(stack.length() >= 0) {
			ParsedComponent data = new ParsedComponent(new PlainTextComponent(), stack, null);
			parsedData.add(data);
		}
		
		return parsedData;
	}
	
	

}
