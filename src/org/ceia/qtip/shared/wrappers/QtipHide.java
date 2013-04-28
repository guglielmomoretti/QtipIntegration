package org.ceia.qtip.shared.wrappers;

public class QtipHide extends QtipCommonShowHideClass {

	private int inactiveInterval;
	private boolean isFixed;
	private boolean shouldLeave;
	private int hideDistance;

	public int getInactiveInterval() {
		return inactiveInterval;
	}

	public QtipHide setInactiveInterval(int inactiveInterval) {
		this.inactiveInterval = inactiveInterval;
		return this;
	}

	public boolean isFixed() {
		return isFixed;
	}

	public QtipHide setFixed(boolean isFixed) {
		this.isFixed = isFixed;
		return this;
	}

	public boolean isShouldLeave() {
		return shouldLeave;
	}

	public QtipHide setShouldLeave(boolean shouldLeave) {
		this.shouldLeave = shouldLeave;
		return this;
	}

	public int getHideDistance() {
		return hideDistance;
	}

	public QtipHide setHideDistance(int hideDistance) {
		this.hideDistance = hideDistance;
		return this;
	}

}
