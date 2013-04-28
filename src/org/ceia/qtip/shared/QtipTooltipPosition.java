package org.ceia.qtip.shared;

public enum QtipTooltipPosition {

	BOTTOM_LEFT("bottom left"),
	BOTTOM_CENTER("bottom center"),
	BOTTOM_RIGHT("bottom right"),
	TOP_LEFT("top left"),
	TOP_CENTER("top center"),
	TOP_RIGHT("top right"),
	LEFT_TOP("left top"),
	LEFT_CENTER("left center"),
	LEFT_BOTTOM("left bottom"),
	RIGHT_TOP("right top"),
	RIGHT_CENTER("right center"),
	RIGHT_BOTTOM("left bottom");
	
	private String nativePosition;
	
	private QtipTooltipPosition(String position) {
		// TODO Auto-generated constructor stub
		this.setNativePosition(position);
	}

	public String getNativePosition() {
		return nativePosition;
	}

	private void setNativePosition(String nativePosition) {
		this.nativePosition = nativePosition;
	}

}
