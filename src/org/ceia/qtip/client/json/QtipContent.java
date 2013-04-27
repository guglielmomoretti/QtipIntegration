package org.ceia.qtip.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class QtipContent extends JavaScriptObject {

	protected QtipContent() {
		// TODO Auto-generated constructor stub
	}

	public final native void setQtipTitle(JavaScriptObject title) /*-{
		this.title = title;
	}-*/;

	public final native void setContent(String content) /*-{
		this.text = content
	}-*/;

	public final native void setContentAttribute(String attribute) /*-{
		this.attr = attribute
	}-*/;

}
