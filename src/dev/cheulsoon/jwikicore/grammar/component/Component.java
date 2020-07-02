package dev.cheulsoon.jwikicore.grammar.component;

public class Component {
	
	// Private properties
	
	private String startWikiTag;
	private String endWikiTag;
	private String HTMLTag;
	
	public Component(String start, String end, String html) {
		this.startWikiTag = start;
		this.endWikiTag = end;
		this.HTMLTag = html;
	}
	
	public Component() {
		this("", "", "");
	}
	
	// Getter / Setter
	
	public String getStartWikiTag() {
		return startWikiTag;
	}
	public void setStartWikiTag(String startWikiTag) {
		this.startWikiTag = startWikiTag;
	}
	public String getEndWikiTag() {
		return endWikiTag;
	}
	public void setEndWikiTag(String endWikiTag) {
		this.endWikiTag = endWikiTag;
	}
	public String getHTMLTag() {
		return HTMLTag;
	}
	public void setHTMLTag(String hTMLTag) {
		HTMLTag = hTMLTag;
	}
	
	
	
}
