package org.ceia.qtip.client;

import java.util.ArrayList;

import org.ceia.qtip.client.components.JsQtip;
import org.ceia.qtip.client.components.JsQtipElement;
import org.ceia.qtip.client.components.QtipBuilder;
import org.ceia.qtip.client.components.listeners.QtipEventListener;
import org.ceia.qtip.shared.QtipEvent;
import org.ceia.qtip.shared.wrappers.Qtip;
import org.ceia.qtip.shared.wrappers.QtipMode;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.Widget;

public class QtipWidget {

    public static boolean scriptInjected = false;

    private Widget tipOwner = null;

    private ArrayList<QtipEventListener> listeners = new ArrayList<QtipEventListener>();
    private ArrayList<Qtip> qtipList = new ArrayList<Qtip>();

    private String tipOwnerId = "";

    private boolean isShowing = false;

    private String mode = QtipMode.STANDARD_TIP.name();

    public QtipWidget(Widget owner) {
	tipOwner = owner;
    }

    /**
     * Add a tooltip to the widget.
     * <br><br>
     * The Qtip instance passed is parsed using the {@link QtipBuilder} helper
     * class
     * that translates our Qtip Configuration into JavascriptObject so that we
     * can install our tooltip natively.
     * 
     * @param tip
     */
    public void addTooltip(Qtip tip) {

	if (!qtipList.contains(tip)) {
	    qtipList.add(tip);

	    /**
	     * Inizitialize operational MODE
	     */
	    if (qtipList.size() == 1) {
		if (tip.getMode() == QtipMode.TOGGLE_TIP) {
		    tip.setPersistent(true);
		}
		mode = tip.getMode().name();
	    }

	    QtipBuilder builder = new QtipBuilder(tipOwner, tip);
	    // init var
	    tipOwnerId = getOwnerID();

	    JsQtip qtip = builder.buildJsQtip();

	    // Is it present more than one tooltip?
	    if (qtipList.size() > 1) {
		// yes, so proceed removing the qtip data from the object
		// http://craigsworks.com/projects/qtip2/tutorials/advanced/#multi
		removePreviuosTooltipData();
	    }

	    // aggiungo il tooltip
	    Scheduler.get().scheduleDeferred(new TooltipScheduledCommand(getOwnerID(), qtip.getJsQtipElement()));
	}

    }

    /**
     * Removes Tips from the Widget
     * 
     */
    public native void removeTips()/*-{
	try {
	    $wnd.jQuery("#" + this.@org.ceia.qtip.client.QtipWidget::tipOwnerId).qtip('destroy');
	} catch (e) {

	}
    }-*/;

    /**
     * Shows the Tip in the widget
     * Problems may occur if we try to show tooltips where we have set the
     * widget to have more than one tooltip.
     */
    public native void show() /*-{
	try {
	    if (this.@org.ceia.qtip.client.QtipWidget::mode == "TOGGLE_TIP") {
		this.@org.ceia.qtip.client.QtipWidget::isShowing = true;

		$wnd.console.log("showButton: " + this.@org.ceia.qtip.client.QtipWidget::isShowing);
	    }
	    $wnd.jQuery("#" + this.@org.ceia.qtip.client.QtipWidget::tipOwnerId).data('qtip').show();
	} catch (e) {

	}
    }-*/;

    /**
     * Hide all the shown tooltips
     */
    public native void hide() /*-{
	try {

	    $wnd.jQuery("#" + this.@org.ceia.qtip.client.QtipWidget::tipOwnerId).data('qtip').hide();
	} catch (e) {

	}
    }-*/;

    private String getOwnerID() {
	return tipOwner.getElement().getId();
    }

    /**
     * This class is dependent on the Jquery.js, qtip.js and the Master CSS
     * StyleSheet of the Qtip Library.
     * 
     * <br> If you call this method, this method will inject, only once, all the
     * required scripts. If you have already included the script, please don't
     * call this method.
     * <br><br>
     * FIXME We should check if jQuery is already included, along with Qtip to
     * avoid the user calling this method.
     */
    public static void checkScriptInjected() {
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

    /**
     * Add a listener to the qtip tooltip to receive its events.
     * Events are defined in {@link QtipEvent} enumerate.
     * 
     * @param listener
     */
    public void addQtipListener(QtipEventListener listener) {

	if (listeners.contains(listener))
	    return;

	listeners.add(listener);
    }

    /**
     * Remove a listener from the qtip tooltip to stop receiving its events.
     * 
     * @param listener
     */
    public void removeQtipListener(QtipEventListener listener) {

	if (!listeners.contains(listener))
	    return;

	listeners.remove(listener);
    }

    private final void fireEvent(String event, Widget source) {
	for (QtipEventListener listener : listeners) {
	    try {
		listener.onEventReceived(QtipEvent.valueOf(event), source);
	    } catch (Exception e) {
		// TODO: handle exception
	    }
	}
    }

    private void removePreviuosTooltipData() {
	Scheduler.get().scheduleDeferred(new ScheduledCommand() {

	    @Override
	    public void execute() {
		// TODO Auto-generated method stub
		checkIfTooltipIsPresent(getOwnerID());
	    }
	});
    }

    private native void checkIfTooltipIsPresent(String id) /*-{
	$wnd.jQuery("#" + id).removeData('qtip');
    }-*/;

    private native void createQtip(String id, JsQtipElement qtipElement, QtipWidget mainContainer) /*-{

	var content = qtipElement.content;
	var position = qtipElement.position;
	var hide = qtipElement.hide;

	var show = qtipElement.show;
	var style = qtipElement.style;

	var qtipObject = {};
	var eventList = {};

	if (content != null)
	    qtipObject.content = content;
	if (position != null)
	    qtipObject.position = position;

	if (hide != null)
	    qtipObject.hide = hide;

	if (show != null)
	    qtipObject.show = show;

	if (style != null)
	    qtipObject.style = style;

	eventList.show = function(event, api) {
	    $wnd.console.log(mainContainer.@org.ceia.qtip.client.QtipWidget::mode);
	    $wnd.console.log("beforeShow: " + mainContainer.@org.ceia.qtip.client.QtipWidget::isShowing);

	    if (mainContainer.@org.ceia.qtip.client.QtipWidget::mode == "TOGGLE_TIP"
		    && !mainContainer.@org.ceia.qtip.client.QtipWidget::isShowing) {
		mainContainer.@org.ceia.qtip.client.QtipWidget::isShowing = false;
		event.preventDefault();
		return;
	    }
	    mainContainer.@org.ceia.qtip.client.QtipWidget::fireEvent(Ljava/lang/String;Lcom/google/gwt/user/client/ui/Widget;)("SHOW",mainContainer.@org.ceia.qtip.client.QtipWidget::tipOwner)
	};

	eventList.hide = function(event, api) {
	    if (mainContainer.@org.ceia.qtip.client.QtipWidget::mode == "TOGGLE_TIP") {
		mainContainer.@org.ceia.qtip.client.QtipWidget::isShowing = false;
	    }
	    mainContainer.@org.ceia.qtip.client.QtipWidget::fireEvent(Ljava/lang/String;Lcom/google/gwt/user/client/ui/Widget;)("HIDE",mainContainer.@org.ceia.qtip.client.QtipWidget::tipOwner)
	};

	eventList.focus = function(event, api) {
	    mainContainer.@org.ceia.qtip.client.QtipWidget::fireEvent(Ljava/lang/String;Lcom/google/gwt/user/client/ui/Widget;)("FOCUS",mainContainer.@org.ceia.qtip.client.QtipWidget::tipOwner)
	};

	eventList.blur = function(event, api) {

	    mainContainer.@org.ceia.qtip.client.QtipWidget::fireEvent(Ljava/lang/String;Lcom/google/gwt/user/client/ui/Widget;)("BLUR",mainContainer.@org.ceia.qtip.client.QtipWidget::tipOwner)
	};

	qtipObject.events = eventList;

	$wnd.jQuery("#" + id).qtip(qtipObject);

    }-*/;

    class TooltipScheduledCommand implements ScheduledCommand {

	private String widgetId;
	private JsQtipElement qtipElement;

	public TooltipScheduledCommand(String widgetId, JsQtipElement qtipElement) {
	    super();
	    this.widgetId = widgetId;
	    this.qtipElement = qtipElement;
	}

	@Override
	public void execute() {
	    // TODO Auto-generated method stub
	    createQtip(widgetId, qtipElement, QtipWidget.this);
	}

    }
}
