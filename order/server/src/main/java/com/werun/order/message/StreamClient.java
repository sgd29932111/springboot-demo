package com.werun.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

    String INPUT = "myMessage";

    String INPUT2 = "myMessage2";

    String INPUT3 = "myMessage3";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.INPUT2)
    MessageChannel output2();

    @Output(StreamClient.INPUT3)
    MessageChannel output3();
}
