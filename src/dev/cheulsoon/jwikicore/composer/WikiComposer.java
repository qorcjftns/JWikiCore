package dev.cheulsoon.jwikicore.composer;

import java.util.List;

import dev.cheulsoon.jwikicore.parser.ParsedComponent;

/**
 * Composes Parsed Component into HTML Text
 * @author qorcj
 *
 */
public class WikiComposer {
	
	/**
	 * Constructor of WikiComposer
	 */
	public WikiComposer() {
		
	}
	
	/**
	 * Perform comose on the parsed Component and produces HTML text
	 * @param parsedComponent generated by WikiParser
	 * @return HTML text
	 */

	public String compose(List<ParsedComponent> parsedComponent) {
		// scope: parsedComponent.asl;dsjadlksad
		ParsedComponent pc = parsedComponent.get(0);
		String returnString = "";
		returnString += "<" + pc.getTag() + ">"; // <b>
		returnString += pc.getChildren().get(0).getText(); // <b>
		returnString += "</" + pc.getTag() + ">"; // </b>
		
		return returnString;
	}

}
