package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductCategoryService;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.utils.DisplayTagUtils;
import com.laptrinhjavaweb.utils.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller(value = "productControllerOfAdmin")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductCategoryService productCategoryService;

    @Autowired
    private MessageUtils messageUtils;

    @RequestMapping(value = "/admin/product-list", method = RequestMethod.GET)
    public ModelAndView getNews(@ModelAttribute("model") ProductDTO model,
                                HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/product/list");
        DisplayTagUtils.of(request, model);
        //Pageable pageable = new PageRequest(model.getPage() - 1, model.getMaxPageItems());
        Pageable pageable = PageRequest.of(model.getPage() - 1, model.getMaxPageItems());
        List<ProductDTO> posts = productService.findAll(model.getName(), pageable);
        model.setListResult(posts);
        model.setTotalItems(productService.getTotalItems(model.getName()));
        initMessageResponse(mav, request);
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/admin/product-edit", method = RequestMethod.GET)
    public ModelAndView editPostPage(@ModelAttribute("model") ProductDTO model,
                                     @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/product/edit");
        if (id != null) {
            model = productService.findById(id);
        }
        initMessageResponse(mav, request);
        mav.addObject("productCategories", productCategoryService.getCategories());
        mav.addObject("model", model);
        return mav;
    }

    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
        String message = request.getParameter("message");
        if (message != null && StringUtils.isNotEmpty(message)) {
            Map<String, String> messageMap = messageUtils.getMessage(message);
            mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
        }
    }
}
