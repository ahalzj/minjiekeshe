package com.agile.controller;

import com.agile.pojo.*;
import com.agile.service.CategoryService;
import com.agile.service.OrderService;
import com.agile.service.ProductService;
import com.agile.service.ReferalLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NavigateController {
    @Autowired
    private CategoryService categoryService = null;
    @Autowired
    private ProductService productService = null;
    @Autowired
    private ReferalLinkService referalLinkService = null;
    @Autowired
    private OrderService orderService = null;

    @RequestMapping("/home")
    public String home(Model model) {
        List<Category> categories = categoryService.list();
        List<ReferalLink> links = referalLinkService.listAll();
        model.addAttribute("categories", categories);
        model.addAttribute("links", links);
        return "index";
    }

    @RequestMapping("/loginPage")
    public String tologinPage() {
        return "loginPage";
    }

    @RequestMapping("/registerPage")
    public String toRegisterPage() {
        return "registerPage";
    }

    @RequestMapping("/registerSuccessPage")
    public String toRegisterSuccessPage(){
        return "registerSuccessPage";
    }

    @RequestMapping("/payPage")
    public String toPayPage(){
        return "alipay";
    }

    @RequestMapping("confirmPay")
    public String toConfirmPayPage(Model model, int order_id){
        Order order = orderService.get(order_id);
        model.addAttribute("order", order);
        return "confirmPay";}
}
