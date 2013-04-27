package org.ceia.qtip.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.TextResource;

public interface ResourceBundle extends ClientBundle {
	public static final ResourceBundle INSTANCE = GWT.create(ResourceBundle.class);

	@Source("org/ceia/qtip/client/res/jquery.js")
	public TextResource jQuery();

	@Source("org/ceia/qtip/client/res/jquery-migrate-1.0.0.js")
	public TextResource jQueryMigrate();

	@Source("org/ceia/qtip/client/res/jquery.qtip.min.js")
	public TextResource qTip();

	@Source("org/ceia/qtip/client/res/jquery.qtip.min.css")
	@NotStrict
	public CssResource qTipCss();

}
