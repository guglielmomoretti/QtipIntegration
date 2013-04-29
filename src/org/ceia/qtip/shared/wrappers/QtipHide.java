package org.ceia.qtip.shared.wrappers;

public class QtipHide extends QtipCommonShowHideClass {

    private int inactiveInterval = -1;
    private Boolean isFixed = null;
    private Boolean shouldLeave = null;
    private int hideDistance = -1;

    public QtipHide() {
	// TODO Auto-generated constructor stub
	setDelay(DEFAULT_QTIP_HIDE_DELAY);
    }

    public int getInactiveInterval() {
	return inactiveInterval;
    }

    public QtipHide setInactiveInterval(int inactiveInterval) {
	this.inactiveInterval = inactiveInterval;
	return this;
    }

    public Boolean isFixed() {
	return isFixed;
    }

    public QtipHide setFixed(boolean isFixed) {
	this.isFixed = isFixed;
	return this;
    }

    public Boolean isShouldLeave() {
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
