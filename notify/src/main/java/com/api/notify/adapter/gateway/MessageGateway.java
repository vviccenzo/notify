package com.api.notify.adapter.gateway;

public interface MessageGateway {

	public String send(String exchange, String routingKey, Object message);
	
}
