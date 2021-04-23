package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.IOrderService;
import com.laptrinhjavaweb.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "orderControllerOfWeb")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IProductCategoryService productCategoryService;

    @RequestMapping(value = "/don-hang", method = RequestMethod.GET)
    public ModelAndView orderPage() {
        ModelAndView mav = new ModelAndView("web/order/list");
        String name = SecurityUtils.getPrincipal().getUsername();
        mav.addObject("categories", productCategoryService.findAll());
        mav.addObject("orders", orderService.findByUser(name));
        return mav;
    }
}
