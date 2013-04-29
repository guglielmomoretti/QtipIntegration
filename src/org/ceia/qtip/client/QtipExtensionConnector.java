package org.ceia.qtip.client;

import com.google.gwt.user.client.Window;
import com.vaadin.shared.ui.Connect;

import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ServerConnector;

import com.example.qtipintegration.QtipExtension;
import com.vaadin.client.extensions.AbstractExtensionConnector;

@Connect(QtipExtension.class)
public class QtipExtensionConnector extends AbstractExtensionConnector {

    QtipExtensionServerRpc rpc = RpcProxy.create(QtipExtensionServerRpc.class, this);

    public QtipExtensionConnector() {
	registerRpc(QtipExtensionClientRpc.class, new QtipExtensionClientRpc() {
	    public void alert(String message) {
		// TODO Do something useful
		Window.alert(message);
	    }
	});

    }

    @Override
    protected void extend(ServerConnector target) {
	// TODO Auto-generated method stub

    }

}
