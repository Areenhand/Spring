package com.spring.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

//这里这个注解的意思，就是说明这个类被Spring接管你，注册到容器中
@Configuration
public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("ASDF")//属性注入值
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
