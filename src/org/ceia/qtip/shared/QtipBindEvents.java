package org.ceia.qtip.shared;

public enum QtipBindEvents {

	BLUR("blur"),
	FOCUS("focus"),
	LOAD("load"),
	RESIZE("resize"),
	SCROLL("scroll"),
	UNLOAD("unload"),
	BEFOREUNLOAD("beforeunload"),
	CLICK("click"),
	DBLCLICK("dblclick"),
	MOUSEDOWN("mousedown"),
	MOUSEUP("mouseup"),
	MOUSEMOVE("mousemove"),
	MOUSEOVER("mouseover"),
	MOUSEOUT("mouseout"),
	MOUSEENTER("mouseenter"),
	MOUSELEAVE("mouseleave"),
	CHANGE("change"),
	SELECT("select"),
	SUBMIT("submit"),
	KEYDOWN("keydown"),
	KEYPRESS("keypress"),
	KEYUP("keyup"),
	ERROR("error"),
	READY("ready");
	

	private String nativeEventBinding = "";
	
	private QtipBindEvents(String bindEvent) {
		// TODO Auto-generated constructor stub
		this.setNativeEventBinding(bindEvent);
	}

	public String getNativeEventBinding() {
		return nativeEventBinding;
	}

	private void setNativeEventBinding(String nativeEventBinding) {
		this.nativeEventBinding = nativeEventBinding;
	}
}
