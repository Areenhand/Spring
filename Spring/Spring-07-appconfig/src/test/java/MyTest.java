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
