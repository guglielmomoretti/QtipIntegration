package org.ceia.qtip.shared.wrappers;

import org.ceia.qtip.shared.QtipTooltipPosition;

public class QtipPosition {

	private QtipTooltipPosition tipAnchor;
	private QtipTooltipPosition componentAnchor;
	private QtipAdjust adjust;
	private boolean showRelativeToMouse;

	public QtipPosition() {
		// TODO Auto-generated constructor stub
	}

	public QtipTooltipPosition getTipAnchor() {
		return tipAnchor;
	}

	/**
	 * The corner of the tooltip to position in relation to the
	 * {@link #getComponentAnchor()}. See the Basics section for all possible
	 * corner values.
	 * 
	 * @param tipAnchor
	 * @return
	 */
	public QtipPosition setTipAnchor(QtipTooltipPosition tipAnchor) {
		this.tipAnchor = tipAnchor;
		return this;
	}

	public QtipTooltipPosition getComponentAnchor() {
		return componentAnchor;
	}

	/**
	 * The corner of the {@link #getTipAnchor()} element to position the
	 * tooltips corner at. See the Basics section for all possible corner
	 * values.
	 * 
	 * @param componentAnchor
	 * @return
	 */
	public QtipPosition setComponentAnchor(QtipTooltipPosition componentAnchor) {
		this.componentAnchor = componentAnchor;
		return this;
	}

	public QtipAdjust getAdjust() {
		return adjust;
	}

	/**
	 * Sets the adjustment for the tooltip position, see {@link QtipAdjust} for
	 * more details
	 * 
	 * @param adjust
	 * @return
	 */
	public QtipPosition setAdjust(QtipAdjust adjust) {
		this.adjust = adjust;
		return this;
	}

	public boolean isShowRelativeToMouse() {
		return showRelativeToMouse;
	}

	public QtipPosition setShowRelativeToMouse(boolean showRelativeToMouse) {
		this.showRelativeToMouse = showRelativeToMouse;
		return this;
	}

}
