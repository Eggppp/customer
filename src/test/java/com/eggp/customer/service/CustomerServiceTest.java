package com.eggp.customer.service;

import com.eggp.common.helper.DatabaseHelper;
import com.eggp.customer.bean.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CustomerService单元测试
 */
public class CustomerServiceTest {
    private  final CustomerService customerService;
    public CustomerServiceTest(){
        customerService=new CustomerService();
    }

    @Before
    public void init(){
        // 初始化数据库
        // 运行单元测试时，优先从test/java、test/resources加载类或读取文件
        DatabaseHelper.executeSqlFile("init_sql/test_customer.sql");
    }

    @Test
    public void getCustomerListTest() throws Exception{
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2,customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception{
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public  void createCustomerTest() throws Exception{
        Map<String,Object> fieldMap = new HashMap<String,Object>();
        fieldMap.put("name","customer111");
        fieldMap.put("contact","sald");
        fieldMap.put("telephone","145");
        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTest() throws Exception{
        long id = 2;
        Map<String,Object> fieldMap = new HashMap<>();
        fieldMap.put("remark","sdfsdljal");
        boolean result = customerService.updateCustomer(id,fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest() throws  Exception{
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
