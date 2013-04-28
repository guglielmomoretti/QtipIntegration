package org.ceia.qtip.shared.wrappers;

public class Qtip {

	private QtipAdjust adjust;
	private QtipContent content;

	private QtipHide hide;
	private QtipShow show;
	private QtipStyle style;
	private QtipTitle title;

	public QtipAdjust getAdjust() {
		if (adjust == null) {
			adjust = new QtipAdjust();
		}

		return adjust;
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
}
