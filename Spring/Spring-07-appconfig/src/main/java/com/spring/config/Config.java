package com.spring.config;


import com.spring.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//这个也会被spring容器托管，注册到容器中，因为它本身就是一个@Component
//@Configuration 代表这是一个配置类，就和我们之气看到的beans.xml
@Configuration
@ComponentScan("com.spring.pojo")
@Import(Config2.class)
public class Config {

    // 注册一个bean，就相当于之前的一个bean实例
    // 这个方法的名字，就相当于bean标签的id属性
    // 这个方法的返回值，就相当于bean标签的class属性
    @Bean
    public User user(){
        return new User();//就是返回注入到bean的对象
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("121"));


    }

}
