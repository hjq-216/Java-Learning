package com.spring.test;

import com.spring.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("demo.xml");
        Person person = (Person) applicationContext.getBean("Person");
        System.out.println(person);
    }
}
