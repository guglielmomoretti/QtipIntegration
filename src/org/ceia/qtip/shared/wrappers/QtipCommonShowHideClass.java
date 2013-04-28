package org.ceia.qtip.shared.wrappers;

import org.ceia.qtip.shared.QtipBindEvents;

public class QtipCommonShowHideClass {

	private String target;
	private QtipBindEvents[] events;
	private int showDelay;

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

	public void setEvents(QtipBindEvents[] events) {
		this.events = events;
	}

	public int getShowDelay() {
		return showDelay;
	}

	public void setShowDelay(int showDelay) {
		this.showDelay = showDelay;
	}

}
