package com.werun.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.werun.common.ProductInfoOutput;
import com.werun.order.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProductInfoReceiver {

    private final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public ProductInfoReceiver(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>)JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfoOutput>>() {});
        log.info("从队列【{}】接收到消息: {}", "productInfo", productInfoOutputList);

        //储存到redis中
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId()),
                    String.valueOf(productInfoOutput.getProductStock()));
        }
    }
}
