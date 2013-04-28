package org.ceia.qtip.client.components;


public class JsQtipShow extends JsQtipCommonShowHideClass {

	protected JsQtipShow() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Determines whether or not the tooltip will hide all others when the
	 * show.event is triggered on the show.target.
	 * 
	 * @param solo
	 */
	public final native void setSolo(boolean solo) /*-{
		this.solo = solo;
	}-*/;

	/**
	 * Determines whether or not the tooltip will hide all others when the
	 * show.event is triggered on the show.target. If a jQuery object is used as
	 * its value, only tooltips found within that object will be hidden.
	 * 
	 * @param soloTarget
	 */
	public final native void setSolo(String soloTarget) /*-{
		this.solo = soloTarget;
	}-*/;

	/**
	 * Determines whether or not the tooltip is shown once the document is
	 * loaded e.g. when the document.ready() event is triggered.
	 * 
	 * <br>
	 * <br>
	 * <b>Notes:</b> This option obeys your show.delay setting, so set it to
	 * zero if you want it to show instantly on page load!<br>
	 * Enabling this option on multiple tooltips can slow down your page load
	 * times.
	 * 
	 * @param show
	 */
	public final native void setShowOnDocumentReady(boolean show) /*-{
		this.ready = show;
	}-*/;
}
