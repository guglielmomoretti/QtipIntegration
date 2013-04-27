package org.ceia.qtip.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class QtipTitle extends JavaScriptObject {

	protected QtipTitle() {
		// TODO Auto-generated constructor stub
	}

	public final native void setCaption(String caption) /*-{
		this.text = caption;
	}-*/;

	public final native void setButtonText(String buttonText) /*-{
		this.button = buttonText;
	}-*/;
}