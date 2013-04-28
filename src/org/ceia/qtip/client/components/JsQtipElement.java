package org.ceia.qtip.client.components;

import java.util.ArrayList;

import org.ceia.qtip.client.components.listeners.QtipEventListener;
import org.ceia.qtip.shared.QtipEvent;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

public class JsQtipElement extends JavaScriptObject {

	private static final ArrayList<QtipEventListener> listeners = new ArrayList<QtipEventListener>();

	protected JsQtipElement() {

	}

	public final native void setContent(JsQtipContent content) /*-{
		this.content = content;
	}-*/;

	public final native void setPosition(JsQtipPosition position) /*-{
		if (!@org.ceia.qtip.client.components.QtipUtils::isObjectEmpty(Lcom/google/gwt/core/client/JavaScriptObject;)(position)) {
			this.position = position;
		} else {
			@org.ceia.qtip.client.components.QtipUtils::removeKeyFromObject(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this,"position");
		}
	}-*/;

	public final native void setEvents(JsQtipEvents events) /*-{
		this.events = events;
	}-*/;

	public final native void setShowStrategy(JsQtipShow show) /*-{
		if (!@org.ceia.qtip.client.components.QtipUtils::isObjectEmpty(Lcom/google/gwt/core/client/JavaScriptObject;)(show)) {
			this.show = show;
		} else {
			@org.ceia.qtip.client.components.QtipUtils::removeKeyFromObject(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this,"show");
		}
	}-*/;

	public final native JsQtipElement setDoNotHide() /*-{

		this.hide = false;
		return this;
	}-*/;

	public final native void setHideStrategy(JsQtipHide hide) /*-{

		if (!@org.ceia.qtip.client.components.QtipUtils::isObjectEmpty(Lcom/google/gwt/core/client/JavaScriptObject;)(hide)) {
			this.hide = hide;
		} else {
			@org.ceia.qtip.client.components.QtipUtils::removeKeyFromObject(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this,"hide");
		}
	}-*/;

	public final native JsQtipElement setStyle(JsQtipStyle style) /*-{
		this.style = style;
		return this;
	}-*/;

	public final void addEventListener(QtipEventListener listener) {
		if (!listeners.contains(listener))
			listeners.add(listener);
	}

	public final void removeEventListener(QtipEventListener listener) {
		listeners.remove(listener);
	}

	private final void fireEvent(String event, Element source) {
		for (QtipEventListener listener : listeners) {
			try {
				listener.onEventReceived(QtipEvent.valueOf(event), source);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
