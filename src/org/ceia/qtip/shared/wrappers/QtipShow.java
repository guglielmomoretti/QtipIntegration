package org.ceia.qtip.shared.wrappers;

public class QtipShow extends QtipCommonShowHideClass {

    private boolean solo = false;
    private boolean showOnDocumentReady = false;

    public QtipShow() {
	// TODO Auto-generated constructor stub
	setDelay(DEFAULT_QTIP_SHOW_DELAY);
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
