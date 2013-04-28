package org.ceia.qtip.client.components;

import com.google.gwt.core.client.JavaScriptObject;

public class JsQtipContent extends JavaScriptObject {

	protected JsQtipContent() {
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
