package me.rgalba.bb8url.functions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class BB8UrltApplication {

	public static void main(String[] args) {
		SpringApplication.run(BB8UrltApplication.class, args);
	}

	@Bean
	public Function<String, String> reverse() {
		return value -> new StringBuilder(value).reverse().toString();
	}

}
