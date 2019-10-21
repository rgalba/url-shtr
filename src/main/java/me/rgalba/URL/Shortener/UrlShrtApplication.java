package me.rgalba.URL.Shortener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.util.Scanner;

@SpringBootApplication
public class UrlShrtApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UrlShrtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inform the URL:");
		System.out.println("ex: https://mysite.com");
		Scanner scanner = new Scanner(System.in);
		String urlInput = scanner.nextLine();
		URL url = new URL(urlInput);
		System.out.println("URL received: " + url);
	}
}
