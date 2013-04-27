package org.ceia.qtip.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class QtipStyle extends JavaScriptObject {

	protected QtipStyle() {
		// TODO Auto-generated constructor stub
	}

	public final native void setClasses(String... classes) /*-{
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
