package org.ceia.qtip.shared.wrappers;

import org.ceia.qtip.shared.QtipStandardStyles;

public class QtipStyle {

	private String[] classes;
	private boolean useDefaultStyle;
	private int width;
	private int height;

	public QtipStyle() {
		// TODO Auto-generated constructor stub
	}

	public String[] getClasses() {
		return classes;
	}

	/**
	 * A space separated string containing all class names which should be added
	 * to the main qTip element. There are several base styles included in the
	 * CSS file provided, included in the {@link QtipStandardStyles}
	 * 
	 * @param classes
	 * @return
	 */
	public QtipStyle setClasses(String... classes) {
		this.classes = classes;
		return this;
	}

	public boolean isUseDefaultStyle() {
		return useDefaultStyle;
	}

	/**
	 * This propery allows you to prevent the .qtip-default class from being
	 * applied to the main tooltip element. <br>
	 * <br>
	 * Notes: Doing so will cause the tooltip to have no visual styling if you
	 * haven't applied any custom classes
	 * 
	 * @param useDefaultStyle
	 * @return
	 */
	public QtipStyle setUseDefaultStyle(boolean useDefaultStyle) {
		this.useDefaultStyle = useDefaultStyle;
		return this;
	}

	public int getWidth() {
		return width;
	}

	/**
	 * This property allows you to override all applied CSS width styles for the
	 * tooltip. Can be any valid width CSS value. Please note that this does not
	 * override max/min width styles! Change those in the CSS file provided. <br>
	 * <br>
	 * Notes Again, this does not override max/min width styles!
	 * 
	 * @param width
	 * @return
	 */
	public QtipStyle setWidth(int width) {
		this.width = width;
		return this;
	}

	public int getHeight() {
		return height;
	}

	/**
	 * This propery allows you to override all applied CSS height styles for the
	 * tooltip. Can be any valid width CSS value. Please note that this does not
	 * override max/min height styles! Change those in the CSS file provided. <br>
	 * <br>
	 * Notes Again, this does not override max/min height styles!
	 * 
	 * @param height
	 * @return
	 */
	public QtipStyle setHeight(int height) {
		this.height = height;
		return this;
	}

}
