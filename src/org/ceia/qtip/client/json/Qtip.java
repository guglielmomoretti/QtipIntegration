package org.ceia.qtip.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class Qtip extends JavaScriptObject {

	protected Qtip() {

	}

	public final native void setContent(QtipContent content) /*-{
		this.content = content;
	}-*/;

	public final native void setPosition(QtipPosition position) /*-{
		if (!@org.ceia.qtip.client.json.QtipUtils::isObjectEmpty(Lcom/google/gwt/core/client/JavaScriptObject;)(position)) {
			this.position = position;
		} else {
			@org.ceia.qtip.client.json.QtipUtils::removeKeyFromObject(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this,"position");
		}
	}-*/;

	public final native void setEvents(QtipEvents events) /*-{
		this.events = events;
	}-*/;

	public final native void setShowStrategy(QtipShow show) /*-{
		if (!@org.ceia.qtip.client.json.QtipUtils::isObjectEmpty(Lcom/google/gwt/core/client/JavaScriptObject;)(show)) {
			this.show = show;
		} else {
			@org.ceia.qtip.client.json.QtipUtils::removeKeyFromObject(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this,"show");
		}
	}-*/;

	public final native Qtip setDoNotHide() /*-{

		this.hide = false;
		return this;
	}-*/;

	public final native void setHideStrategy(QtipHide hide) /*-{

		if (!@org.ceia.qtip.client.json.QtipUtils::isObjectEmpty(Lcom/google/gwt/core/client/JavaScriptObject;)(hide)) {
			this.hide = hide;
		} else {
			@org.ceia.qtip.client.json.QtipUtils::removeKeyFromObject(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this,"hide");
		}
	}-*/;

}
