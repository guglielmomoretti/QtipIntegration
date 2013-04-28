package org.ceia.qtip.client.components;

import com.google.gwt.core.client.JavaScriptObject;

public class JsQtipTitle extends JavaScriptObject {

	protected JsQtipTitle() {
		// TODO Auto-generated constructor stub
	}

	public final native void setCaption(String caption) /*-{
		this.text = caption;
	}-*/;

	public final native void setButtonText(String buttonText) /*-{
		this.button = buttonText;
	}-*/;
}