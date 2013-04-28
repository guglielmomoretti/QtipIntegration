package org.ceia.qtip.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class QtipProva implements EntryPoint {

	@Override
	public void onModuleLoad() {
		TextBox box = new TextBox();
		TextBox refbox = new TextBox();
		refbox.setValue("ciao");
		refbox.getElement().setId("ref");
		QtipWidget tip = new QtipWidget(box, "Vediamo se funziona");
		RootPanel.get().add(box);
		RootPanel.get().add(refbox);

	}
}
