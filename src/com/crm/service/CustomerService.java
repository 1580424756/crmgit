package com.crm.service;

import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;
import com.crm.utils.Page;

public interface CustomerService {
    public Page<Customer> selectPageQueryVo(QueryVo queryVo);

    public Customer QueryCustomerById(Integer id);

    public void updateCustomerById(Customer customer);

    public void deleteCustomerById(Integer id);
}
