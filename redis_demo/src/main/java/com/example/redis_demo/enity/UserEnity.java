package com.example.redis_demo.enity;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserEnity implements Serializable {

    private Long id;

    private String guid;

    private String name;

    private String age;

    private Date createTime;

}

