package org.ceia.qtip.client.components.listeners;

import org.ceia.qtip.shared.QtipEvent;

import com.google.gwt.user.client.Element;

public interface QtipEventListener {

	public void onEventReceived(QtipEvent event, Element source);

}
