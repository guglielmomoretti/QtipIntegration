package org.ceia.qtip.client;

import org.ceia.qtip.client.components.JsQtipAdjust;
import org.ceia.qtip.client.components.JsQtipContainer;
import org.ceia.qtip.client.components.JsQtipElement;
import org.ceia.qtip.client.components.JsQtipContent;
import org.ceia.qtip.client.components.JsQtipEvents;
import org.ceia.qtip.client.components.JsQtipHide;
import org.ceia.qtip.client.components.JsQtipPosition;
import org.ceia.qtip.client.components.JsQtipShow;
import org.ceia.qtip.client.components.JsQtipStyle;
import org.ceia.qtip.client.components.JsQtipTitle;
import org.ceia.qtip.client.components.QtipUtils;
import org.ceia.qtip.shared.QtipStandardStyles;
import org.ceia.qtip.shared.QtipEvent;
import org.ceia.qtip.shared.QtipTooltipPosition;
import org.ceia.qtip.shared.QtipBindEvents;

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
				JsQtipContainer container = new JsQtipContainer();
				JsQtipElement qtip = QtipUtils.createObject(JsQtipElement.class);
				JsQtipContent content = QtipUtils.createObject(JsQtipContent.class);
				JsQtipTitle title = QtipUtils.createObject(JsQtipTitle.class);
				JsQtipPosition position = QtipUtils.createObject(JsQtipPosition.class);
				JsQtipAdjust adjust = QtipUtils.createObject(JsQtipAdjust.class);
				JsQtipEvents events = QtipUtils.createObject(JsQtipEvents.class);
				JsQtipShow show = QtipUtils.createObject(JsQtipShow.class);
				JsQtipHide hide = QtipUtils.createObject(JsQtipHide.class);
				JsQtipStyle style = QtipUtils.createObject(JsQtipStyle.class);
				
				JsArrayString stringArray = (JsArrayString)JavaScriptObject.createArray();
				stringArray.push(QtipBindEvents.CLICK);
				
				JsArrayString styleArray = (JsArrayString)JavaScriptObject.createArray();
				styleArray.push(QtipStandardStyles.QTIP_BLUE);
				
				
				style.setClasses(styleArray);
				qtip.setStyle(style);
				qtip.setPosition(position);
				
				show.setTarget("#ref");
				show.setEvent(stringArray);
				show.setShowOnDocumentReady(true);
				events.initEvents(container);
				qtip.setEvents(events);
				qtip.setContent(content);

				qtip.setShowStrategy(show);
				content.setContent("Ciao ciao ciao ciao ");
				title.setCaption("Title");
				title.setButtonText("Close");
				//content.setQtipTitle(title);
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
