package org.ceia.qtip.client.components;

import java.util.ArrayList;

import org.ceia.qtip.client.components.listeners.QtipEventListener;
import org.ceia.qtip.shared.QtipEvent;

import com.google.gwt.user.client.Element;

public class JsQtipContainer {

	private static final ArrayList<QtipEventListener> listeners = new ArrayList<QtipEventListener>();

	
	
	@SuppressWarnings("unused")
	private final void fireEvent(String event, Element source) {
		for (QtipEventListener listener : listeners) {
			try {
				listener.onEventReceived(QtipEvent.valueOf(event), source);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
