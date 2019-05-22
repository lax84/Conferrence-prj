package com.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*@Configuration
@ComponentScan(basePackages= {"com.ems"})
@EnableWebMvc
@PropertySource(value= {"classpath:/application.properties"},ignoreResourceNotFound=true)
@EnableTransactionManagement*/
@SpringBootApplication
public class SpringWebConfig {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String args[]) {
		SpringApplication.run(SpringWebConfig.class, args);
	}
}
