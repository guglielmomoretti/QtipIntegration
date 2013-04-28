package org.ceia.qtip.client.components;

import com.google.gwt.core.client.JavaScriptObject;

public class JsQtipPosition extends JavaScriptObject {

	protected JsQtipPosition() {
		// TODO Auto-generated constructor stub
	}

	public final native void setAnchor(String anchor) /*-{
		this.my = anchor;
	}-*/;

	public final native void setAnchorPosition(String position) /*-{
		this.at = position;
	}-*/;

	public final native void setAdjust(JsQtipAdjust adjust) /*-{
		this.adjust = adjust;
	}-*/;

	public final native void setShowRelativeToMouse(boolean showRelative) /*-{
		if (!showRelative) {
			this.target = false;
		} else {
			this.target = 'mouse';
		}

	}-*/;

}
