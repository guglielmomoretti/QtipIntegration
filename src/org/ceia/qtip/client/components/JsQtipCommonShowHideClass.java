package org.ceia.qtip.client.components;

import org.ceia.qtip.shared.QtipBindEvents;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class JsQtipCommonShowHideClass extends JavaScriptObject {

	protected JsQtipCommonShowHideClass() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Defines the HTML element(s) which will trigger your specified
	 * show.event(s). When set to false, the element the .qtip() method was
	 * called upon is used. <br>
	 * <br>
	 * Example: This will cause the first H1 element to show the tooltip when
	 * the show.event is triggered (in this case mouseenter): <br>
	 * <br>
	 * <b>QtipShow.setTartget("$('h1:first')");</b> <br>
	 * <br>
	 * We can also cause the tooltip to open if multiple elements are moused
	 * over e.g. all header elements: <br>
	 * <b>QtipShow.setTartget("$('h1, h2, h3, h4')");</b> <br>
	 * <br>
	 * <b>Notes: </b> Setting a different show target does not effect the
	 * positioning, which is controlled via the position.target option.
	 */
	public final native void setTarget(String target) /*-{
		//$wnd.console.log("$wnd.jQuery('" + target +"')");
		this.target = $wnd.jQuery( target );
	}-*/;

	/**
	 * Event(s) which will trigger the tooltip to be shown. <br>
	 * All possible values are documented under the
	 * {@link QtipBindEvents} Helper Class.<br>
	 * Other values may be documented under jQuery's Event bind() documentation.
	 * 
	 * @param events
	 */
	public final native void setEvent(JsArrayString events) /*-{
		$wnd.console.log(events);
		this.event = events.join(" ");
	}-*/;

	/**
	 * Time in milliseconds by which to delay showing of the tooltip when the
	 * show.event is triggered on the show.target
	 * 
	 * @param delay
	 */
	public final native void setShowDelay(int delay) /*-{
		this.delay = delay;
	}-*/;

}
