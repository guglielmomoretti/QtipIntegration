package org.ceia.qtip.client.components;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class JsQtipStyle extends JavaScriptObject {

	protected JsQtipStyle() {
		// TODO Auto-generated constructor stub
	}

	public final native void setClasses(JsArrayString classes) /*-{
		this.classes = classes.join(" ");
	}-*/;

	public final native void setUseDefaultStyle(boolean useDefault) /*-{
		this.def = useDefault;
	}-*/;

	public final native void setWidth(int width) /*-{
		this.width = width;
	}-*/;

	public final native void setHeight(int height) /*-{
		this.height = height;
	}-*/;
}
