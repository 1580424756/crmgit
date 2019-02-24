package com.crm.controller;

import com.crm.pojo.BaseDict;
import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;
import com.crm.service.BaseDictService;
import com.crm.service.CustomerService;
import com.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    @Value("${fromType.code}")
    private String fromTypeCode;

    @RequestMapping(value = "/customer/list")
    public String list(QueryVo vo, Model model) {
        //解决硬编码
       /* List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode("002");
        List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode("001");
        List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode("006");*/

        /**
         *    查询出客户列表，也就是客户的种类，有哪些类型的客户，客户的具体信息不在base_dict这张表
         */
        //客户来源
        List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(fromTypeCode);
        //客户所属行业
        List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode("001");
        //客户级别
        List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode("006");
        /**
         *         将查到的信息，传给customer.jsp页面去，
         *         作为前台要查询客户信息的条件
         */

        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        /**
         *   通过5个条件，查询分页对象
         */
        Page<Customer> page = customerService.selectPageQueryVo(vo);
        //将查到的5个对象的信息，传到页面去
        model.addAttribute("page", page);

        //回显前台条件查询的条件,重新放到request域中去显示
        model.addAttribute("custName", vo.getCustName());
        model.addAttribute("custSource", vo.getCustSource());
        model.addAttribute("custIndustry", vo.getCustIndustry());
        model.addAttribute("custLevel", vo.getCustLevel());
        return "customer";
    }

    @RequestMapping("customer/edit.action")
    //根据id来查询
    //业务逻辑：一点击修改按钮，将数据回显到页面上，用aiax技术，只修改部分页面，不刷新
    @ResponseBody
    public Customer edit(Integer id, Model model) {
        Customer customer = customerService.QueryCustomerById(id);
        return customer;
    }

    @RequestMapping("customer/update.action")
    @ResponseBody
    public String update(Customer customer) {
        customerService.updateCustomerById(customer);
        return "OK";
    }
    @RequestMapping("customer/delete.action")
    @ResponseBody
    public String delete(Integer id){
        customerService.deleteCustomerById(id);
        return "OK";
    }
}
