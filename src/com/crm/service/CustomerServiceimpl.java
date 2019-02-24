package com.crm.service;

import com.crm.mapper.CustomMapper;
import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;
import com.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 查询客户的信息
 */
/**
 * 根据从前台接收过来的查询条件数据，可以用一个pojo类（QueryVo）来接收。-----------------查询客户信息
 *
 *前台需要分页显示，所以应该返回分页类page，-----------------查询数据总条数
 *
 *            所以dao需要编写两个查询： 查询：
 *                                      1. 需要根据条件分页查询客户信息
 *                                      2. 需要根据条件查询数据总条数
 */
@Service
public class CustomerServiceimpl implements CustomerService {
    @Autowired
    private CustomMapper customMapper;

    @Override
    //通过5个条件查询分页对象
    public Page<Customer> selectPageQueryVo(QueryVo vo) {
        Page<Customer> page = new Page<Customer>();
        //设设置每页数据的数
        vo.setSize(5);
        //page类需要这个每页的记录数量去计算总共有多少页
        page.setSize(5);

        if (vo != null) {
            //判断当前页
            if (vo.getPage() != null) {
                page.setPage(vo.getPage());
                //设置查询条件，从那一条数据开始查
                vo.setStartRow((vo.getPage() - 1) * vo.getSize());
            }
            //判断客户名称是否为空
            if (vo.getCustName() != null && !"".equals(vo.getCustName().trim())) {
                //将从页面获取的名字去掉空格，再次传进去
                vo.setCustName(vo.getCustName().trim());
            }
            //判断客户来源
            if (vo.getCustSource() != null && !"".equals(vo.getCustSource().trim())) {
                vo.setCustSource(vo.getCustSource().trim());
            }
            //判断所属行业
            if (vo.getCustIndustry() != null && !"".equals(vo.getCustIndustry().trim())) {
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            //判断客户级别
            if (vo.getCustLevel() != null && !"".equals(vo.getCustLevel().trim())) {
                vo.setCustLevel(vo.getCustLevel().trim());
            }
            //总条数
            page.setTotal(customMapper.customerCountByQueryVo(vo));
            //设置结果集
            page.setRows(customMapper.selectCustomerByQueryVo(vo));
        }

        return page;
    }

    @Override
    //通过id来查询客户用于回显
    public Customer QueryCustomerById(Integer id) {
        return customMapper.QueryCustomerById(id);
    }
    @Override
    //通过id来修改客户信息
    public void updateCustomerById(Customer customer){
         customMapper.updateCustomerById(customer);
    }
    @Override
    public void deleteCustomerById(Integer id) {
    customMapper.deleteCustomerById(id);
    }
}
