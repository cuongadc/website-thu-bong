package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductCategoryService;
import com.laptrinhjavaweb.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "productControllerOfWeb")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductCategoryService productCategoryService;

    @RequestMapping(value = "/the-loai-{category}", method = RequestMethod.GET)
    public ModelAndView listProduct(@PathVariable("category") String category) {
        ModelAndView mav = new ModelAndView("web/product/list");
        mav.addObject("categories", productCategoryService.findAll());
        mav.addObject("products", productService.findAll(category));
        mav.addObject("category", productCategoryService.findByCode(category));
        return mav;
    }

    @RequestMapping(value = "/{seourl}-{id}", method = RequestMethod.GET)
    public ModelAndView detailProduct(@PathVariable("id") long productId) {
        ModelAndView mav = new ModelAndView("web/product/detail");
        ProductDTO model = productService.findById(productId);
        mav.addObject("categories", productCategoryService.findAll());
        mav.addObject("model", model);
        return mav;
    }
}
