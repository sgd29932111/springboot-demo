package com.werun.order.message;

import com.werun.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(value = StreamClient.INPUT2)
    @SendTo(StreamClient.INPUT3)
    public String porcess(OrderDTO message) {
        log.info("StreamReceiver: {}", message);
        return "received.";
    }

//    @StreamListener(value = StreamClient.INPUT2)
//    public void process2(String message) {
//        log.info("StreamReceiver2: {}", message);
//    }

    @StreamListener(value = StreamClient.INPUT3)
    public void process2(String message) {
        log.info("StreamReceiver2: {}", message);
    }
}
