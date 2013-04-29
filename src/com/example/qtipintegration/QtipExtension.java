package com.example.qtipintegration;

import org.ceia.qtip.client.QtipExtensionServerRpc;

import com.vaadin.server.AbstractExtension;

public class QtipExtension extends AbstractExtension {

    private QtipExtensionServerRpc rpc = new QtipExtensionServerRpc() {
	private int clickCount = 0;

	@Override
	public void show() {
	    // TODO Auto-generated method stub

	}

	@Override
	public void hide() {
	    // TODO Auto-generated method stub

	}

    };

    public QtipExtension() {
	// TODO Auto-generated constructor stub
	registerRpc(rpc);
    }

}
