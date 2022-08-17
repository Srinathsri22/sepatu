package com.example.SepatuCartOrder.service;

import com.example.SepatuCartOrder.dto.OrderDto;
import com.example.SepatuCartOrder.entity.Order;

import java.util.List;

public interface OrderService {

    public Order addOrder(Order order );
    public List<OrderDto> viewOrder(String userId);
}
