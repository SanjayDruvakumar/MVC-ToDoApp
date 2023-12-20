package todo.configuration;

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
}
