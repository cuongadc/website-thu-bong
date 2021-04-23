package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "orderApiOfAdmin")
@RequestMapping(value = "/api/admin/order")
public class OrderAPI {

    @Autowired
    private IOrderService orderService;

    @PutMapping
    public ResponseEntity<Void> updateStatus(@RequestBody OrderDTO orderDTO) {
        //orderService.updateStatus(orderDTO);
        return ResponseEntity.noContent().build();
    }
}
