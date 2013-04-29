package org.ceia.qtip.client.components;

import com.google.gwt.core.client.JavaScriptObject;

public class JsQtipElement extends JavaScriptObject {

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

    public final native void setShowStrategy(JsQtipShow show) /*-{
		if (!@org.ceia.qtip.client.components.QtipUtils::isObjectEmpty(Lcom/google/gwt/core/client/JavaScriptObject;)(show)) {
			this.show = show;
		} else {
			@org.ceia.qtip.client.components.QtipUtils::removeKeyFromObject(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this,"show");
		}
    }-*/;

    public final native void setDoNotHide() /*-{
		this.hide = false;
    }-*/;

    public final native void setHideStrategy(JsQtipHide hide) /*-{

		if (!@org.ceia.qtip.client.components.QtipUtils::isObjectEmpty(Lcom/google/gwt/core/client/JavaScriptObject;)(hide)) {
			this.hide = hide;
		} else {
			@org.ceia.qtip.client.components.QtipUtils::removeKeyFromObject(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this,"hide");
		}
    }-*/;

    public final native void setStyle(JsQtipStyle style) /*-{
		this.style = style;
    }-*/;


}
