
package com.broctagon.tp.websocket.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


/**
* @auther: Water
* @time: 4 Dec 2017 17:41:34
* 
*/

@Configuration
@EnableWebSocket
public class WebSocketConfig{
	
/*	@Autowired
	private CountWebSocketHandler countWebSocketHandler;*/

    @Bean
    public ServerEndpointExporter serverEndpointExporter(ApplicationContext context) {
    	
    	System.out.println("serverEndpointExporter");
    	
        return new ServerEndpointExporter();
    }
    
	@Bean
	public ReverseWebSocketEndpoint reverseWebSocketEndpoint() {
		return new ReverseWebSocketEndpoint();
	}
	
/*	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		System.out.println("WebSocketHandlerRegistry");
		
		// TODO Auto-generated method stub
     //   registry.addHandler(countWebSocketHandler, "/web/count").addInterceptors(new HandshakeInterceptor());
        
        registry.addHandler(countWebSocketHandler, "/web/count").withSockJS();
             
	}*/

}
