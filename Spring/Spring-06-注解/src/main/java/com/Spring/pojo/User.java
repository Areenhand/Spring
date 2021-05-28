package com.Spring.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

//相当于新建了一个bean实例
@Component
@Scope("singleton")//单例模式
public class User {
    @Value("福周")//给一个属性注入值，但多个属性的时候，建议xml中注入
    public String name;

    @Value("孙福周")
    public void setName(String name) {

        this.name = name;
    }

}
