package org.dohrm.test.websocket.single;

import org.dohrm.test.websocket.services.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author MDO
 * @since 02/06/2015.
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private TestServices services;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(singleHandler(), "/single")
                .setAllowedOrigins("*");
    }

    public SingleHandler singleHandler() {
        return new SingleHandler(services);
    }

}
