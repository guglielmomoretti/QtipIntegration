package org.ceia.qtip.client.json;

import org.ceia.qtip.shared.QtipEvent;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

public class QtipEvents extends JavaScriptObject {

	protected QtipEvents() {
		// TODO Auto-generated constructor stub

	}

	public final native void initEvents() /*-{
		this.show = function(event, api) {
			$wnd.console.log(api.elements.tooltip);
			@org.ceia.qtip.client.json.QtipEvents::logEvent(Ljava/lang/String;Lcom/google/gwt/user/client/Element;)("SHOW",api.elements.tooltip)
		};
		this.hide = function(event, api) {
			@org.ceia.qtip.client.json.QtipEvents::logEvent(Ljava/lang/String;Lcom/google/gwt/user/client/Element;)("HIDE",api.elements.tooltip)
		};

		this.focus = function(event, api) {
			@org.ceia.qtip.client.json.QtipEvents::logEvent(Ljava/lang/String;Lcom/google/gwt/user/client/Element;)("FOCUS",api.elements.tooltip)
		};
		this.blur = function(event, api) {
			
			@org.ceia.qtip.client.json.QtipEvents::logEvent(Ljava/lang/String;Lcom/google/gwt/user/client/Element;)("BLUR",api.elements.tooltip)
		};

	}-*/;

	private static void logEvent(String event, Element element) {
		System.out.println(QtipEvent.valueOf(event));
	}
}
