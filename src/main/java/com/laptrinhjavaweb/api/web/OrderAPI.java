package com.laptrinhjavaweb.api.web;

import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController(value = "orderApiOfWeb")
@RequestMapping(value = "/api/order")
public class OrderAPI {

    @Autowired
    private IOrderService orderService;

    @PostMapping
    public ResponseEntity<Void> addOrder(@RequestBody OrderDTO orderDTO) {
        orderService.addOrder(orderDTO);
        return ResponseEntity.noContent().build();
    }
}
