package com.laptrinhjavaweb.service.impl;


import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.entity.OrderEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.OrderRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.IOrderService;
import com.laptrinhjavaweb.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<OrderDTO> findAll() {
        List<OrderDTO> results = new ArrayList<>();
        List<OrderEntity> orderEntities = orderRepository.findAll();
        for (OrderEntity item: orderEntities) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(item.getId());
            orderDTO.setFullName(item.getUserOrder().getFullName());
            orderDTO.setProductName(item.getProductOrder().getName());
            orderDTO.setPrice(item.getProductOrder().getPrice());
            //orderDTO.setStatus(item.getStatus());
            orderDTO.setTotalPrice(item.getPrice());
            orderDTO.setCreatedDate(item.getCreatedDate());
            orderDTO.setQuantity(item.getQuantity());
            orderDTO.setPhone(item.getUserOrder().getPhone());
            results.add(orderDTO);
        }
        return results;
    }

    @Override
    public List<OrderDTO> findByUser(String userName) {
        List<OrderDTO> results = new ArrayList<>();
        List<OrderEntity> orderEntities = orderRepository.findByUserOrder_UserName(userName);
        for (OrderEntity item: orderEntities) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(item.getId());
            orderDTO.setFullName(item.getUserOrder().getFullName());
            orderDTO.setProductName(item.getProductOrder().getName());
            orderDTO.setPrice(item.getProductOrder().getPrice());
            //orderDTO.setStatus(item.getStatus());
            orderDTO.setCreatedDate(item.getCreatedDate());
            orderDTO.setTotalPrice(item.getPrice());
            orderDTO.setQuantity(item.getQuantity());
            results.add(orderDTO);
        }
        return results;
    }

    @Override
    @Transactional
    public void addOrder(OrderDTO orderDTO) {
        String userName = SecurityUtils.getPrincipal().getUsername();
        UserEntity userEntity = userRepository.findOneByUserName(userName);
        ProductEntity productEntity = productRepository.findById(orderDTO.getProductId()).get();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setPrice(productEntity.getPrice() * orderDTO.getQuantity());
        orderEntity.setQuantity(orderDTO.getQuantity());
        orderEntity.setProductOrder(productEntity);
        orderEntity.setUserOrder(userEntity);
        orderRepository.save(orderEntity);
    }
}
