package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.OrderDTO;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> findAll();
    List<OrderDTO> findByUser(String userName);
    void addOrder(OrderDTO orderDTO);
}
