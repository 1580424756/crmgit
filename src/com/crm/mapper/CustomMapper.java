package com.crm.mapper;

import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;

import java.util.List;

public interface CustomMapper {
    //总条数
    public Integer customerCountByQueryVo(QueryVo vo);
    //每一页结果集
    public List<Customer> selectCustomerByQueryVo(QueryVo vo);

    //通过id来查询客户,通过id来查只能查一条，所以返回类型只是pojo类型即可
    public Customer QueryCustomerById(Integer id);

    //通过id来修改客户信息
    public void updateCustomerById(Customer customer);

    public void deleteCustomerById(Integer id);
}
