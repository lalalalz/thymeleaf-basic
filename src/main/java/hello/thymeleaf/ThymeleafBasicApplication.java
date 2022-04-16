package hello.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ThymeleafBasicApplication {
	public static void main(String[] args) {
		SpringApplication.run(ThymeleafBasicApplication.class, args);
	}
}
