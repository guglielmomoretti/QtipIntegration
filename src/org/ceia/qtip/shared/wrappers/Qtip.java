package org.ceia.qtip.shared.wrappers;

public class Qtip {

    private QtipAdjust adjust;
    private QtipContent content;

    private QtipHide hide;
    private QtipShow show;
    private QtipStyle style;
    private QtipTitle title;
    private QtipPosition position;
    private QtipMode mode = QtipMode.STANDARD_TIP;

    private boolean persistent = false;

    public boolean isPersistent() {
	return persistent;
    }

    public void setPersistent(boolean persistent) {
	this.persistent = persistent;
    }

    public QtipAdjust getAdjust() {
	if (adjust == null) {
	    adjust = new QtipAdjust();
	}

	return adjust;
    }

    public QtipPosition getPosition() {
	if (position == null) {
	    position = new QtipPosition();
	}

	return position;
    }

    public QtipContent getContent() {
	if (content == null) {
	    content = new QtipContent();
	    if (title != null) {
		content.setTitle(title);
	    }
	}
	return content;
    }

    public QtipHide getHide() {
	if (hide == null) {
	    hide = new QtipHide();
	}
	return hide;
    }

    public QtipShow getShow() {
	if (show == null) {
	    show = new QtipShow();
	}
	return show;
    }

    public QtipStyle getStyle() {
	if (style == null) {
	    style = new QtipStyle();
	}
	return style;
    }

    public QtipTitle getTitle() {
	if (title == null) {
	    title = new QtipTitle();
	    if (content != null) {
		content.setTitle(title);
	    }
	}
	return title;
    }

    public Qtip removeTitle() {
	if (title != null) {
	    if (content != null) {
		content.setTitle(null);
	    }
	}

	title = null;
	return this;
    }

    public Qtip removeContent() {
	this.title = null;
	this.content = null;
	return this;
    }

    public Qtip removeHide() {
	hide = null;
	return this;
    }

    public Qtip removeShow() {
	show = null;
	return this;
    }

    public Qtip removeStyle() {
	style = null;
	return this;
    }

    public boolean hasPosition() {
	return position != null;
    }

    public boolean hasStyle() {
	return style != null;
    }

    public boolean hasShow() {
	return show != null;
    }

    public boolean hasHide() {
	return hide != null;
    }

    public boolean hasTitle() {
	return title != null;
    }

    public boolean hasContent() {
	return content != null;
    }

    public boolean hasAdjust() {
	return adjust != null;
    }

    public QtipMode getMode() {
	return mode;
    }

    public void setMode(QtipMode mode) {
	this.mode = mode;
    }
}
