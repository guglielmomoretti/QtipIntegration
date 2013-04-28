package org.ceia.qtip.client.components;

import org.ceia.qtip.shared.QtipEvent;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

public class JsQtipEvents extends JavaScriptObject {

	protected JsQtipEvents() {
		// TODO Auto-generated constructor stub

	}

	public final native void initEvents(JsQtipContainer mainContainer) /*-{
		this.show = function(event, api) {
			$wnd.console.log(api.elements.tooltip);
			mainContainer.@org.ceia.qtip.client.components.JsQtipContainer::fireEvent(Ljava/lang/String;Lcom/google/gwt/user/client/Element;)("SHOW",api.elements.tooltip)
		};
		this.hide = function(event, api) {
			mainContainer.@org.ceia.qtip.client.components.JsQtipContainer::fireEvent(Ljava/lang/String;Lcom/google/gwt/user/client/Element;)("HIDE",api.elements.tooltip)
		};

		this.focus = function(event, api) {
			mainContainer.@org.ceia.qtip.client.components.JsQtipContainer::fireEvent(Ljava/lang/String;Lcom/google/gwt/user/client/Element;)("FOCUS",api.elements.tooltip)
		};
		this.blur = function(event, api) {

			mainContainer.@org.ceia.qtip.client.components.JsQtipContainer::fireEvent(Ljava/lang/String;Lcom/google/gwt/user/client/Element;)("BLUR",api.elements.tooltip)
		};

	}-*/;

	private static void logEvent(String event, Element element) {
		System.out.println(QtipEvent.valueOf(event));
	}
}
