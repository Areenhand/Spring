# 1.spring
    
    spring就是帮我们创建和组装bean对象的框架，以至于简化代码
    xml上帮助我们管理spring中的方法和对象
    bean是一个由Spring IoC容器实例化、组装和管理的对象。
    
# 2.IOC理论推导
    
    控制反转英文全称：Inversion of Control，简称就是IoC。
    控制反转通过依赖注入（DI）方式实现对象之间的松耦合关系。
    程序运行时，依赖对象由【辅助程序】动态生成并注入到被依赖对象中，动态绑定两者的使用关系。
    Spring IoC容器就是这样的辅助程序，它负责对象的生成和依赖的注入，让后在交由我们使用。
    简而言之，就是：IoC就是一个对象定义其依赖关系而不创建它们的过程。
    
    
    
# 3.helloSpring

    
# 4.IOC创建对象的方式
    Spring通过DI（依赖注入）实现IOC（控制反转），
        常用的注入方式主要有三种：构造方法注入（Construct注入），setter注入，
                             基于注解的注入（接口注入）
    
# 5.spring配置

    
# 6.依赖注入

    
#7.bean的自动装配

    @Autowired（自动注入）修饰符有三个属性：Constructor，byType，byName。默认按照byType注入。
    





```xml
     <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.5</version>
        </dependency>
    
    <!-- https://mvnrepository.com/artifact/junit/junit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
```

##注解说明
     - @Autowired ：自动装配类型，名字
        如果@Autowired不能唯一自动装配上属性，则需要通过@Qualifier(value="xxx")
     - @Nullable ： 字段标记了这个注解，说明这个字段可以为null
     - @Resource ： 自动装配通过名字，类型
     
 # 8、使用注解开发
    在spring4之后使用注解开发，必须要导入aop的包
    
    使用注解时，需要导入context约束，增加注解的支持
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd">
    <!-- 开启注解支持   -->
    <context:annotation-config/>


</beans>
```

1.bean

2.属性的注入
```java
//相当于新建了一个bean实例
@Component
public class User {
    @Value("福周")//给一个属性注入值，但多个属性的时候，建议xml中注入
    public String name;

    @Value("孙福周")
    public void setName(String name) {
        this.name = name;
    }
}

```

3.衍生的注解
    
    @Component 衍生注解
        dao [@repository]
        service [@Service]
        Controller [@Controller]
        
    这四个注解功能是一样的，都是装配bean,代表某个类注册到spring中注册
4.自动装配置

    - @Autowired ：自动装配类型，名字
           如果@Autowired不能唯一自动装配上属性，则需要通过@Qualifier(value="xxx")
    - @Nullable ： 字段标记了这个注解，说明这个字段可以为null
    - @Resource ： 自动装配通过名字，类型
    
5.作用域

```java
//相当于新建了一个bean实例
@Component
@Scope("singleton")//单例模式<----
public class User {
    @Value("福周")//给一个属性注入值，但多个属性的时候，建议xml中注入
    public String name;

    @Value("孙福周")
    public void setName(String name) {

        this.name = name;
    }

}
```
    prototype：每次请求重新生成行的对象，但不管后续，让他自生自灭 
    singleton:单例模式
    request：只实用与Web，多个请求，多个对象，请求结束，生命周期结束
    session：只实用与Web，每个对象都有自己全新的实例，会存活更长时间
    global session：只实用与Web，只有应用在基于porlet的web应用程序中才有意义，
        它映射到porlet的global范围的session，如果普通的servlet的web 应用中使用了这个scope，
        容器会把它作为普通的session的scope对待
    
6.小节
    
    xml与注解：
        · xml更加万能，适用于任何场合！维护简单方便
        · 注解不是自己类使用不了，维护相对复杂，相对于xml没有那么简单明了。

    xml与注解最佳实例：
        · xml用来管理bean
        · 注解只负责完成属性的注入
        · 我们在使用过程中，要注意的问题：必须要让注解生效，就需要开启注解的支持
    
```text
<!--指定扫描指定的包-->
    <context:component-scan base-package="com.Spring"/>
    <!--注解驱动-->
    <context:annotation-config/>
```

### 9.使用java的方式配置spring
    
    我们现在要完全不使用Spring的xml配置，全权交给java来做
    javaConfig 是Spring的一个子项目，在spring4之后，他成为一个核心功能
    
    
    
实体类
```java
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

```

配置文件
```java

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
}
```

测试类
```java
import com.spring.config.Config;
import com.spring.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
         // 如果完成使用了配置类方式去做，我们就只能通过AnnotationConfig 上下文来获取容器，
        // 通过该配置类的class对象加载
        ApplicationContext context=
            new AnnotationConfigApplicationContext(Config.class);
        User user = (User) context.getBean("user"); //注意大小写 注入的bean是方法名
        System.out.println(user.getName());
    }
}
```

这种纯java的配置方式，在SpringBoot中随处可见！

# 10.代理模式

    为什么要学写代理模式？
    因为这就是SpringAop的底层！【SpringAOP和SpringMvc】
    代理模式的分类：
        · 静态代理
        · 动态代理
 
        

## 10.1、静态代理

    角色分析：
        · 抽象角色：一般会接口或抽象类
        · 真实角色：被代理的角色
        · 代理角色：代理真实
    