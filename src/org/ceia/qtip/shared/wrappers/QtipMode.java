package org.ceia.qtip.shared.wrappers;

public enum QtipMode {

    /**
     * The tip act as a TOOGLE, if you call the hide Method, the tip will not be
     * visible until the show method will be called
     */
    TOGGLE_TIP,
    /**
     * The tip act as a STANDARD tip. The tip wil be shown depending on wich
     * events are set for showing
     */
    STANDARD_TIP

}
