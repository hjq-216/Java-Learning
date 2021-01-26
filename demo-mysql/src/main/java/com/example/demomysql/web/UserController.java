package com.example.demomysql.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getUsers() {
        String sql = "CREATE TABLE product("
                + "pid INT PRIMARY KEY AUTO_INCREMENT,"
                + "pname VARCHAR(20),"
                + "price DOUBLE"
                + ");";//创建表单
        jdbcTemplate.execute(sql);
        String sql1 = "INSERT INTO product VALUES (NULL, ?, ?);";//插入数据

        jdbcTemplate.update(sql1, "iPhone3GS", 3333);
        jdbcTemplate.update(sql1, "iPhone4", 5000);
        jdbcTemplate.update(sql1, "iPhone4S", 5001);
        jdbcTemplate.update(sql1, "iPhone5", 5555);
        jdbcTemplate.update(sql1, "iPhone5C", 3888);
        jdbcTemplate.update(sql1, "iPhone5S", 5666);
        jdbcTemplate.update(sql1, "iPhone6", 6666);
        jdbcTemplate.update(sql1, "iPhone6S", 7000);
        jdbcTemplate.update(sql1, "iPhone6SP", 7777);
        jdbcTemplate.update(sql1, "iPhoneX", 8888);
        String sql2="select * from product";//SQL查询语句
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql2);
        return list;
    }
}
