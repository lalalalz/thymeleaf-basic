package hello.thymeleaf.beanName;


import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BeanNameTest {

    @Component
    static class HelloBean {
        public String hello(String str) {
            return "hello" + str;
        }
    }

    @Test
    void AllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(BeanNameTest.class);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }


}
