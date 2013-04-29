package org.ceia.qtip.client.components.listeners;

import org.ceia.qtip.shared.QtipEvent;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

public interface QtipEventListener {

	public void onEventReceived(QtipEvent event, Widget source);

}
