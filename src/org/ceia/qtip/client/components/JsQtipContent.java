package org.ceia.qtip.client.components;

import com.google.gwt.core.client.JavaScriptObject;

public class JsQtipContent extends JavaScriptObject {

    protected JsQtipContent() {
	// TODO Auto-generated constructor stub
    }

    public final native void setQtipTitle(JsQtipTitle title) /*-{
		if (title != null)
			this.title = title;
    }-*/;

    public final native void setContent(String content) /*-{
		if (content != null)
			this.text = content
    }-*/;

    public final native void setContentAttribute(String attribute) /*-{
		if (attribute != null)
			this.attr = attribute
    }-*/;

}
