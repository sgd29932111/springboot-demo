package com.werun.order.service;

import com.werun.order.dto.OrderDTO;

public interface OrderService {

    OrderDTO create(OrderDTO OrderDTO);

    OrderDTO finish(String orderId);
}
