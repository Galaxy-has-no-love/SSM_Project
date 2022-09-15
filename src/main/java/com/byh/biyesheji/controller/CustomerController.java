package com.byh.biyesheji.controller;

import com.byh.biyesheji.pojo.Customer;
import com.byh.biyesheji.util.Page;
import com.byh.biyesheji.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户模块controller
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String list(Model model, Page page){
        //分页查询
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Customer> list= customerService.list();
        //总条数
        int total = (int) new PageInfo<>(list).getTotal();
        page.setTotal(total);

        model.addAttribute("list",list);
        model.addAttribute("totals",total);
        return "cstpage/cst-list";
    }

    /**
     * 设置会员
     * @param id
     * @return
     */
    @RequestMapping("/shezhihuiyuan")
    @ResponseBody
    public String shezhihuiyuan(int id){
        customerService.shezhihuiyuan(id);
        return "success";
    }

    @RequestMapping("/del")
    public String del(int id){
        customerService.del(id);
        return "redirect:list";
    }
}
