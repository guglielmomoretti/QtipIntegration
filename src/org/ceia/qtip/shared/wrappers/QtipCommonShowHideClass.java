package org.ceia.qtip.shared.wrappers;

import org.ceia.qtip.shared.QtipBindEvents;

public class QtipCommonShowHideClass {

    public static final int DEFAULT_QTIP_SHOW_DELAY = 140;
    public static final int DEFAULT_QTIP_HIDE_DELAY = 0;

    private String target;
    private QtipBindEvents[] events;
    private int delay = DEFAULT_QTIP_HIDE_DELAY;

    public QtipCommonShowHideClass() {
	// TODO Auto-generated constructor stub
    }

    public String getTarget() {
	return target;
    }

    public void setTarget(String target) {
	this.target = target;
    }

    public QtipBindEvents[] getEvents() {
	return events;
    }

    public void setEvents(QtipBindEvents... events) {
	this.events = events;
    }

    public int getDelay() {
	return delay;
    }

    public void setDelay(int delay) {
	this.delay = delay;
    }

}
