package org.ceia.qtip.shared.wrappers;

public class QtipTitle {

	private String caption;
	private String buttonText;

	public QtipTitle() {
		// TODO Auto-generated constructor stub
	}

	public String getCaption() {
		return caption;
	}

	/**
	 * Text/HTML which will appear inside the title element of the content. If
	 * set to false, no title will be created. An anonymous function can also be
	 * used to return the title text, whose scope is the target element.
	 * 
	 * @param caption
	 * @return
	 */
	public QtipTitle setCaption(String caption) {
		this.caption = caption;
		return this;
	}

	public String getButtonText() {
		return buttonText;
	}

	/**
	 * Text/HTML which will appear inside the title's button element (e.g. close
	 * link) located to the right of the title content. The button will close
	 * the tooltip when clicked.
	 * 
	 * @param buttonText
	 * @return
	 */
	public QtipTitle setButtonText(String buttonText) {
		this.buttonText = buttonText;
		return this;
	}

}