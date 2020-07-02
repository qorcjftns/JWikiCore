package dev.cheulsoon.jwikicore.renderer;

import dev.cheulsoon.jwikicore.grammar.WikiGrammar;
import dev.cheulsoon.jwikicore.parser.WikiParser;

public class WikiRenderer {
	
	private String wikiText;
	
	public WikiRenderer(String wikiText) {
		this.wikiText = wikiText;
	}
	
	public String render() {
		WikiGrammar wikiGrammar = new WikiGrammar();
		WikiParser wikiParser = new WikiParser(wikiGrammar);
		
		return "";
	}

}
