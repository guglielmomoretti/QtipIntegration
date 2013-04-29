package org.ceia.qtip.client;

import org.ceia.qtip.shared.QtipStandardStyles;
import org.ceia.qtip.shared.QtipTooltipPosition;
import org.ceia.qtip.shared.wrappers.Qtip;
import org.ceia.qtip.shared.wrappers.QtipMode;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class QtipProva implements EntryPoint {

    public QtipWidget qtipWidget;

    @Override
    public void onModuleLoad() {
	final TextBox box = new TextBox();
	TextBox refbox = new TextBox();
	refbox.setValue("ciao");
	refbox.getElement().setId("ref");

	QtipWidget.checkScriptInjected();

	Scheduler.get().scheduleDeferred(new ScheduledCommand() {

	    @Override
	    public void execute() {
		// TODO Auto-generated method stub
		Qtip tip = new Qtip();
		tip.getContent().setContent("Proviamo il builder");
		tip.getTitle().setCaption("Titolo della finestra");
		// tip.setPersistent(true);
		// tip.getTitle().setButtonText("Close");
		// tip.getShow().setShowOnDocumentReady(true);
		tip.getPosition().setComponentAnchor(QtipTooltipPosition.RIGHT_CENTER);
		tip.getPosition().setTipAnchor(QtipTooltipPosition.LEFT_CENTER);
		// tip.getShow().setTarget("#ref");
		// tip.getAdjust().setShowRelative(false);
		// tip.getPosition().setShowRelativeToMouse(true);
		// tip.getAdjust().setX(20);
		// tip.getAdjust().setY(20);

		// tip.getShow().setEvents(QtipBindEvents.CLICK);
		// tip.getHide().setHideDistance(400);
		tip.getStyle().setClasses(QtipStandardStyles.QTIP_RED);
		qtipWidget = new QtipWidget(box);
		tip.setMode(QtipMode.TOGGLE_TIP);
		qtipWidget.addTooltip(tip);
		

	    }
	});

	RootPanel.get().add(box);
	RootPanel.get().add(refbox);

	Button b = new Button("Remove");
	Button b2 = new Button("Add");

	RootPanel.get().add(b);
	RootPanel.get().add(b2);

	b.addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		qtipWidget.hide();
	    }
	});

	b2.addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		qtipWidget.show();
	    }
	});

    }
}
