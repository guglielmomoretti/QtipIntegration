package org.ceia.qtip.shared.wrappers;

public class QtipAdjust {

	private int x;
	private int y;
	private boolean showRelative;

	public QtipAdjust() {
		// TODO Auto-generated constructor stub
	}

	public int getX() {
		return x;
	}

	/**
	 * A positive or negative pixel value by which to offset the tooltip in the
	 * horizontal plane e.g. the x-axis. Negative values cause a reduction in
	 * the value e.g. moves tooltip to the left.
	 * 
	 * @param x
	 * @return
	 */
	public QtipAdjust setX(int x) {
		this.x = x;
		return this;
	}

	public int getY() {
		return y;
	}

	/**
	 * A positive or negative pixel value by which to offset the tooltip in the
	 * vertical plane e.g. the y-axis. Negative values cause a reduction in the
	 * value e.g. moves tooltip upwards.
	 * 
	 * @param y
	 * @return
	 */
	public QtipAdjust setY(int y) {
		this.y = y;
		return this;
	}

	public boolean isShowRelative() {
		return showRelative;
	}

	/**
	 * When the position target is set to mouse, this option determines whether
	 * the tooltip follows the mouse when hovering over the show target.
	 * 
	 * @param showRelative
	 * @return
	 */
	public QtipAdjust setShowRelative(boolean showRelative) {
		this.showRelative = showRelative;
		return this;
	}

}
