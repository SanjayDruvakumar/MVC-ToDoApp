package todo.configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("todo")
public class SpringContainerConfiguration {
@Bean
public ViewResolver resolver() {
	InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
	internalResourceViewResolver.setPrefix("/jsp/");
	internalResourceViewResolver.setSuffix(".jsp");
	return internalResourceViewResolver;
}

@Bean
public EntityManager getEntityManager() {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	return manager;
}
}
