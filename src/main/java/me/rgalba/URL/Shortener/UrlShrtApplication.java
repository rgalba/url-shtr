package me.rgalba.URL.Shortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class UrlShrtApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShrtApplication.class, args);
	}

	@Bean
	public Function<String, String> reverse() {
		return value -> new StringBuilder(value).reverse().toString();
	}

}
