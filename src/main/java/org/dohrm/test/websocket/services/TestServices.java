package org.dohrm.test.websocket.services;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author MDO
 * @since 02/06/2015.
 */
@Service
public class TestServices {

    private final AtomicInteger COUNTER = new AtomicInteger();

    public String counterString(String payload) {
        return Integer.toString(COUNTER.incrementAndGet()) + "-" + payload;
    }

}
