package dev.cheulsoon.jwikicore.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import dev.cheulsoon.jwikicore.renderer.WikiRenderer;


class WikiTest {

	@Test
	void testRenderer() {
		String wikiText = "'''bold''' and ''italic''\nnew paragraph\n### Heaging 2\n";
		String htmlText = "<p><b>bold</b> and <i>italic</i><br/></p><p>new paragraph</p><h2>Heading 2</h2>";
		
		WikiRenderer renderer = new WikiRenderer(wikiText);
		String rendered = renderer.render();
		
		assertEquals(htmlText, rendered);
	}

}
