package org.ceia.qtip.client.json;

import org.ceia.qtip.shared.QtipTooltipPosition;

import com.google.gwt.core.client.JavaScriptObject;

public class QtipPosition extends JavaScriptObject{

	protected QtipPosition() {
		// TODO Auto-generated constructor stub
	}

	public final native void setAnchor(String anchor) /*-{
		this.my = anchor;
	}-*/;

	public final native void setAnchorPosition(String position) /*-{
		this.at = position;
	}-*/;

	public final native void setAdjust(QtipAdjust adjust) /*-{
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
