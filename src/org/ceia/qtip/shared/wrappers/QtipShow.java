package org.ceia.qtip.shared.wrappers;

public class QtipShow extends QtipCommonShowHideClass {

	private boolean solo;
	private String soloTarget;
	private boolean showOnDocumentReady;

	public QtipShow() {
		// TODO Auto-generated constructor stub
	}

	public boolean isSolo() {
		return solo;
	}

	/**
	 * Determines whether or not the tooltip will hide all others when the
	 * show.event is triggered on the show.target.
	 * 
	 * @param solo
	 * @return
	 */
	public QtipShow setSolo(boolean solo) {
		this.solo = solo;
		return this;
	}

	public String getSoloTarget() {
		return soloTarget;
	}

	/**
	 * Determines whether or not the tooltip will hide all others when the
	 * show.event is triggered on the show.target. If a jQuery object is used as
	 * its value, only tooltips found within that object will be hidden.
	 * 
	 * @param solo
	 * @return
	 */
	public QtipShow setSoloTarget(String soloTarget) {
		this.soloTarget = soloTarget;
		return this;
	}

	public boolean isShowOnDocumentReady() {
		return showOnDocumentReady;
	}

	/**
	 * Determines whether or not the tooltip is shown once the document is
	 * loaded e.g. when the document.ready() event is triggered.
	 * 
	 * @param showOnDocumentReady
	 * @return
	 */
	public QtipShow setShowOnDocumentReady(boolean showOnDocumentReady) {
		this.showOnDocumentReady = showOnDocumentReady;
		return this;
	}

}
