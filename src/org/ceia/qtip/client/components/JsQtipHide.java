package org.ceia.qtip.client.components;

public class JsQtipHide extends JsQtipCommonShowHideClass {

	protected JsQtipHide() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Time in milliseconds in which the tooltip should be hidden if it remains
	 * inactive e.g. isn't interacted with. If set to false, tooltip will not
	 * hide when inactive. <br>
	 * <br>
	 * <b>Examples:</b> Let's create a tooltip that shows on click, but hides
	 * only when inactive for 3 seconds:
	 * 
	 * {@link JsQtipHide}.setInactiveInterval(3000)
	 * 
	 * @param interval
	 */
	public final native void setInactiveInterval(int interval) /*-{
		this.inactive = interval;
	}-*/;

	/**
	 * When set to true, the tooltip will not hide if moused over, allowing the
	 * contents to be clicked and interacted with. <br>
	 * <br>
	 * <b>Notes:</b> Adding a hide delay is generally done when this is enabled
	 * to give the user time to mouseover the tooltip before hiding <br>
	 * <br>
	 * Primarily for use in conjunction with mouseout and similar
	 * mouse-orientated hide events.
	 * 
	 * @param fixed
	 */
	public final native void setFixed(boolean fixed) /*-{
		this.fixed = fixed;
	}-*/;

	/**
	 * Additional hide setting that allows you to specify whether the tooltip
	 * will hide when leaving the window it's contained within. This option
	 * requires you to be using either mouseout or mouseleave as (one of) your
	 * hide events.<br>
	 * <br>
	 * <b>This only applies when using mouseout or mouseleave as (one of) your
	 * hide event(s)</b>
	 * 
	 * @param leave
	 */
	public final native void setLeave(boolean leave) /*-{
		this.leave = leave;
	}-*/;

	/**
	 * This setting allows you to determine the distance after which the tooltip
	 * hides when the mouse is moved from the point it triggered the tooltip.
	 * This is what the regular browser tooltips behave like.
	 * 
	 * <br>
	 * <br>
	 * <b>Notes:</b>The event itself is classed as a hide option, but the
	 * initial position of the mouse on the show.target is what determines the
	 * coordinates used to calculate the distance.
	 * 
	 * @param distance
	 */
	public final native void setHideDistance(int distance) /*-{
		this.distance = distance;
	}-*/;

}
