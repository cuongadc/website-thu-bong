package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.ProductCategoryDTO;
import com.laptrinhjavaweb.service.IProductCategoryService;
import com.laptrinhjavaweb.utils.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller(value = "productCategoryControllerOfAdmin")
public class ProductCategoryController {

    @Autowired
    private IProductCategoryService productCategoryService;

    @Autowired
    private MessageUtils messageUtils;

    @RequestMapping(value = "/admin/productcategory-list", method = RequestMethod.GET)
    public ModelAndView getNews(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/productcategory/list");
        List<ProductCategoryDTO> productCategoryDTOS = productCategoryService.findAll();
        initMessageResponse(mav, request);
        mav.addObject("productcategories", productCategoryDTOS);
        return mav;
    }

    @RequestMapping(value = "/admin/productcategory-edit", method = RequestMethod.GET)
    public ModelAndView editPostPage(@ModelAttribute("model") ProductCategoryDTO model,
                                     @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/productcategory/edit");
        if (id != null) {
            model = productCategoryService.findById(id);
        }
        initMessageResponse(mav, request);
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
