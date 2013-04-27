package org.ceia.qtip.client;

import org.ceia.qtip.client.json.QtipUtils;
import org.ceia.qtip.client.json.Qtip;
import org.ceia.qtip.client.json.QtipAdjust;
import org.ceia.qtip.client.json.QtipContent;
import org.ceia.qtip.client.json.QtipEvents;
import org.ceia.qtip.client.json.QtipHide;
import org.ceia.qtip.client.json.QtipPosition;
import org.ceia.qtip.client.json.QtipShow;
import org.ceia.qtip.client.json.QtipTitle;
import org.ceia.qtip.shared.QtipEvent;
import org.ceia.qtip.shared.QtipTooltipPosition;
import org.ceia.qtip.shared.QtipVisibilityEventList;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Widget;

public class QtipWidget {

	public static boolean scriptInjected = false;
	private Widget tipOwner = null;

	public QtipWidget(Widget owner, String tooltipDescription) {
		// TODO Auto-generated constructor stub
		this.tipOwner = owner;

		tipOwner.getElement().setAttribute("qtip", tooltipDescription);
		String id = tipOwner.getElement().getAttribute("id");
		if (id == null || id.length() <= 0) {
			tipOwner.getElement().setAttribute("id", "" + Random.nextInt(1000000));
		}

		checkScriptInjected();
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				// TODO Auto-generated method stub
				Qtip qtip = QtipUtils.createObject(Qtip.class);
				QtipContent content = QtipUtils.createObject(QtipContent.class);
				QtipTitle title = QtipUtils.createObject(QtipTitle.class);
				QtipPosition position = QtipUtils.createObject(QtipPosition.class);
				QtipAdjust adjust = QtipUtils.createObject(QtipAdjust.class);
				QtipEvents events = QtipUtils.createObject(QtipEvents.class);
				QtipShow show = QtipUtils.createObject(QtipShow.class);
				QtipHide hide = QtipUtils.createObject(QtipHide.class);
				 
				JsArrayString stringArray = (JsArrayString)JavaScriptObject.createArray();
				stringArray.push(QtipVisibilityEventList.CLICK);
				
				qtip.setPosition(position);
				
				show.setTarget("#ref");
				show.setEvent(stringArray);
				events.initEvents();
				qtip.setEvents(events);
				qtip.setContent(content);

				qtip.setShowStrategy(show);
				content.setContent("Ciao ciao ciao ciao ");
				title.setCaption("Title");
				title.setButtonText("Close");
				content.setQtipTitle(title);
				position.setAnchor(QtipTooltipPosition.LEFT_CENTER);
				position.setAnchorPosition(QtipTooltipPosition.RIGHT_CENTER);
				position.setShowRelativeToMouse(false);
				position.setAdjust(adjust);
				
				adjust.setShowRelativeToMouse(true);
				adjust.setX(100);
				
				
				qtip.setPosition(null);
				qtip.setDoNotHide();
				//JsonUtils.safeEval(new JSONObject(qtip).toString())
				createQtip(tipOwner.getElement().getAttribute("id"), qtip);
			}
		});
	}

	private void checkScriptInjected() {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				// TODO Auto-generated method stub
				if (!scriptInjected) {

					JavascriptInjector.inject(ResourceBundle.INSTANCE.jQuery().getText());
					JavascriptInjector.inject(ResourceBundle.INSTANCE.qTip().getText());
					JavascriptInjector.inject(ResourceBundle.INSTANCE.jQueryMigrate().getText());
					ResourceBundle.INSTANCE.qTipCss().ensureInjected();

					scriptInjected = true;
				}
			}
		});

	}

	public native void createQtip(String id, JavaScriptObject contentJson) /*-{
		$wnd.jQuery("#" + id).qtip(contentJson);
	}-*/;

}
