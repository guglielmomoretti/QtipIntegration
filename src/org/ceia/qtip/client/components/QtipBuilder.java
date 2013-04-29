package org.ceia.qtip.client.components;

import org.ceia.qtip.shared.QtipBindEvents;
import org.ceia.qtip.shared.wrappers.Qtip;
import org.ceia.qtip.shared.wrappers.QtipAdjust;
import org.ceia.qtip.shared.wrappers.QtipContent;
import org.ceia.qtip.shared.wrappers.QtipHide;
import org.ceia.qtip.shared.wrappers.QtipPosition;
import org.ceia.qtip.shared.wrappers.QtipShow;
import org.ceia.qtip.shared.wrappers.QtipStyle;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class QtipBuilder {

    private Qtip tip = null;
    private Widget tipOwner = null;

    private JsQtip jsQtip = new JsQtip();
    private JsQtipElement jsQtipElement = QtipUtils.createObject(JsQtipElement.class);

    private JsQtipAdjust jsQtipAdjust = null;
    private JsQtipContent jsQtipContent = null;
    private JsQtipHide jsQtipHide = null;
    private JsQtipShow jsQtipShow = null;
    private JsQtipStyle jsQtipStyle = null;
    private JsQtipPosition jsQtipPosition = null;
    private JsQtipTitle jsQtipTitle = null;

    public QtipBuilder(Widget tipOwner, Qtip tip) {
	this.tip = tip;
	this.tipOwner = tipOwner;

	if (!checkIdPresentOnElement(this.tipOwner.getElement())) {
	    this.tipOwner.getElement().setAttribute("id", DOM.createUniqueId());
	}

    }

    private boolean checkIdPresentOnElement(Element element) {
	String id = element.getAttribute("id");
	return !(id == null || id.length() <= 0);
    }

    public JsQtip buildJsQtip() {

	// imposto gli eventi di default
	if (tip.hasContent()) {
	    // mi prendo il content
	    QtipContent content = tip.getContent();

	    // creo l'oggetto nativo
	    jsQtipContent = QtipUtils.createObject(JsQtipContent.class);

	    if (content.getContentAttribute() == null) {
		jsQtipContent.setContent(content.getContent());
	    } else {
		jsQtipContent.setContentAttribute(content.getContentAttribute());
	    }

	    if (tip.hasTitle()) {
		jsQtipTitle = QtipUtils.createObject(JsQtipTitle.class);
		jsQtipTitle.setCaption(content.getTitle().getCaption());
		jsQtipTitle.setButtonText(content.getTitle().getButtonText());
		// imposto il title nell'oggetto content
		jsQtipContent.setQtipTitle(jsQtipTitle);
	    }

	    // imposto il content
	    jsQtipElement.setContent(jsQtipContent);

	}

	if (tip.hasPosition()) {
	    QtipPosition position = tip.getPosition();

	    // creo l'oggetto nativo
	    jsQtipPosition = QtipUtils.createObject(JsQtipPosition.class);

	    // imposto l'anchor
	    if (position.getTipAnchor() != null)
		jsQtipPosition.setTipAnchor(position.getTipAnchor().getNativePosition());

	    if (position.getComponentAnchor() != null)
		jsQtipPosition.setComponentAnchor(position.getComponentAnchor().getNativePosition());

	    // imposto il follow mouse
	    jsQtipPosition.setShowRelativeToMouse(position.isShowRelativeToMouse());

	    if (tip.hasAdjust()) {

		QtipAdjust adjust = tip.getAdjust();

		jsQtipAdjust = QtipUtils.createObject(JsQtipAdjust.class);
		jsQtipAdjust.setShowRelativeToMouse(adjust.isShowRelative());

		jsQtipAdjust.setX(adjust.getX());
		jsQtipAdjust.setY(adjust.getY());

		jsQtipPosition.setAdjust(jsQtipAdjust);

	    }

	    // imposto la posizione
	    jsQtipElement.setPosition(jsQtipPosition);
	}

	if (tip.hasShow()) {

	    QtipShow show = tip.getShow();

	    jsQtipShow = QtipUtils.createObject(JsQtipShow.class);

	    // prendo gli eventi

	    if (show.getEvents() != null && show.getEvents().length > 0) {
		QtipBindEvents[] events = show.getEvents();
		JsArrayString eventsArray = QtipUtils.createArray(JsArrayString.class);
		for (QtipBindEvents qtipBindEvents : events) {
		    eventsArray.push(qtipBindEvents.getNativeEventBinding());
		}
		jsQtipShow.setEvents(eventsArray);
	    }
	    if (show.getDelay() != QtipShow.DEFAULT_QTIP_SHOW_DELAY)
		jsQtipShow.setDelay(show.getDelay());

	    jsQtipShow.setShowOnDocumentReady(show.isShowOnDocumentReady());
	    jsQtipShow.setSolo(show.isSolo());

	    if (show.getTarget() != null)
		jsQtipShow.setTarget(show.getTarget());

	    // imposto lo show
	    jsQtipElement.setShowStrategy(jsQtipShow);
	}

	if (tip.hasHide()) {

	    QtipHide hide = tip.getHide();

	    if (!tip.isPersistent()) {
		jsQtipHide = QtipUtils.createObject(JsQtipHide.class);

		if (hide.getEvents() != null && hide.getEvents().length > 0) {
		    // prendo gli eventi
		    QtipBindEvents[] events = hide.getEvents();
		    JsArrayString eventsArray = QtipUtils.createArray(JsArrayString.class);
		    for (QtipBindEvents qtipBindEvents : events) {
			eventsArray.push(qtipBindEvents.getNativeEventBinding());
		    }
		    jsQtipHide.setEvents(eventsArray);
		}

		if (hide.getDelay() != QtipHide.DEFAULT_QTIP_HIDE_DELAY)
		    jsQtipHide.setDelay(hide.getDelay());

		if (hide.isFixed() != null)
		    jsQtipHide.setFixed(hide.isFixed());

		if (hide.isShouldLeave() != null)
		    jsQtipHide.setLeave(hide.isShouldLeave());

		if (hide.getHideDistance() > -1)
		    jsQtipHide.setHideDistance(hide.getHideDistance());

		if (hide.getInactiveInterval() > -1)
		    jsQtipHide.setInactiveInterval(hide.getInactiveInterval());

		if (hide.getTarget() != null)
		    jsQtipHide.setTarget(hide.getTarget());

		// imposto l'hide
		jsQtipElement.setHideStrategy(jsQtipHide);

	    } else {
		// avoid hide element
		jsQtipElement.setDoNotHide();
	    }

	} else {
	    if (tip.isPersistent()) {
		// avoid hide element
		jsQtipElement.setDoNotHide();
	    }
	}

	if (tip.hasStyle()) {

	    QtipStyle style = tip.getStyle();

	    jsQtipStyle = QtipUtils.createObject(JsQtipStyle.class);

	    if (style.getClasses() != null && style.getClasses().length > 0) {
		JsArrayString styleArray = QtipUtils.createArray(JsArrayString.class);
		String[] styles = style.getClasses();
		for (String tipStyle : styles) {
		    styleArray.push(tipStyle);
		}
		jsQtipStyle.setClasses(styleArray);
	    }

	    if (style.getHeight() > -1) {
		jsQtipStyle.setHeight(style.getHeight());
	    }

	    if (style.getWidth() > -1) {
		jsQtipStyle.setWidth(style.getWidth());
	    }

	    if (style.isUseDefaultStyle() != null)
		jsQtipStyle.setUseDefaultStyle(style.isUseDefaultStyle());

	    // imposto lo style
	    jsQtipElement.setStyle(jsQtipStyle);
	}

	jsQtip.setJsQtipElement(jsQtipElement);

	return jsQtip;
    }
}
