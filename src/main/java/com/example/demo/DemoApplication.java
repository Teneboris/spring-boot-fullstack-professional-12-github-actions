package com.example.demo;

import com.example.demo.student.Gender;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

import static com.example.demo.student.Gender.FEMALE;
import static com.example.demo.student.Gender.MALE;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

/*	@Bean
	CommandLineRunner run(StudentRepository studentRepository) {
		return args -> {
			studentRepository.save(new Student(null, "Fotso Tene", "fotsotene@gmail.com", MALE));
			studentRepository.save(new Student(null, "Dany Martin", "danymartin@gmail.com", MALE));
			studentRepository.save(new Student(null, "Kelly Garcia", "kellygarcia@gmail.com", FEMALE));
			studentRepository.save(new Student(null, "Tenz Irene", "tenzirene@gmail.com", FEMALE));
		};
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}*/

}