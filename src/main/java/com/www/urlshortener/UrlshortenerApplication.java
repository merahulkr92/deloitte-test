package com.www.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class UrlshortenerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UrlshortenerApplication.class, args);
	}

}
