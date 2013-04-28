package org.ceia.qtip.client.components;

import com.google.gwt.core.client.JavaScriptObject;

public class JsQtipAdjust extends JavaScriptObject {

	protected JsQtipAdjust() {
		// TODO Auto-generated constructor stub
	}

	public final native void setX(int x) /*-{
		this.x = x;
	}-*/;

	public final native void setY(int y) /*-{
		this.y = y;
	}-*/;

	public final native void setShowRelativeToMouse(boolean showRelative) /*-{
		this.mouse = showRelative;
	}-*/;

}
