package com.myapp.controller;

import com.myapp.DAO.ProductDAO;
import com.myapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "GoodsCompare", method = RequestMethod.GET)
    public ModelAndView odsCompare() {
        return new ModelAndView("goods_compare");
    }

    @RequestMapping(value = "Product", method = RequestMethod.GET)
    public ModelAndView productPage() {
        return new ModelAndView("product");
    }

    @RequestMapping(value = "ProductList", method = RequestMethod.GET)
    public ModelAndView productListPage() {
        return new ModelAndView("product_list");
    }

    @RequestMapping(value = "processSearch", method = RequestMethod.GET)
    public ModelAndView searchResultPage(Model model, HttpServletRequest request) {
        model.addAttribute("searchWord", request.getParameter("searchWord"));
        return new ModelAndView("search_result");
    }


}
