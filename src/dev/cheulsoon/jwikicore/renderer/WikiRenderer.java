package dev.cheulsoon.jwikicore.renderer;

import dev.cheulsoon.jwikicore.composer.WikiComposer;
import dev.cheulsoon.jwikicore.grammar.WikiGrammar;
import dev.cheulsoon.jwikicore.parser.ParsedComponent;
import dev.cheulsoon.jwikicore.parser.WikiParser;

public class WikiRenderer {
	
	private String wikiText;
	
	public WikiRenderer(String wikiText) {
		this.wikiText = wikiText;
	}
	
	public String render() {
		WikiGrammar wikiGrammar = new WikiGrammar();
		WikiParser parser = new WikiParser(wikiGrammar);
		ParsedComponent parsedComponent = parser.parse(this.wikiText);
		
		WikiComposer wikiComposer = new WikiComposer();
		return wikiComposer.compose(parsedComponent);
	}

}
