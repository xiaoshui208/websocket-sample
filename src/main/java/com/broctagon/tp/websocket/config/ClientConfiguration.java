
package com.broctagon.tp.websocket.config;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import com.broctagon.tp.websocket.client.SimpleClientWebSocketHandler;


/**
* @auther: Water
* @time: 5 Dec 2017 11:58:36
* 
*/

@Configuration
public class ClientConfiguration implements CommandLineRunner {

	//@Value("${websocket.uri}")
	private String webSocketUri = "ws://localhost:8080/reverse";

	private final CountDownLatch latch = new CountDownLatch(1);

//	private final AtomicReference<String> messagePayload = new AtomicReference<>();

	@Override
	public void run(String... args) throws Exception {
		System.out.print("Waiting for response: latch=" + this.latch.getCount());
/*		if (this.latch.await(10, TimeUnit.SECONDS)) {
			System.out.print("Got response: " + this.messagePayload.get());
		}
		else {
			System.out.print("Response not received: latch=" + this.latch.getCount());
		}*/
	}

	@Bean
	public WebSocketConnectionManager wsConnectionManager() {

		System.out.println("wsConnectionManager");
		WebSocketConnectionManager manager = new WebSocketConnectionManager(client(),
				handler(), this.webSocketUri);
		manager.setAutoStartup(true);

		return manager;
	}

	@Bean
	public StandardWebSocketClient client() {
		System.out.println("client");
		return new StandardWebSocketClient();
	}

	@Bean
	public SimpleClientWebSocketHandler handler() {
		System.out.println("handler");
		return new SimpleClientWebSocketHandler();
	}


}