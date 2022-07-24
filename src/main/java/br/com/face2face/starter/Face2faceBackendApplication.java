package br.com.face2face.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="br.com.face2face")
@EntityScan("br.com.face2face")
@EnableJpaRepositories("br.com.face2face")
public class Face2faceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Face2faceBackendApplication.class, args);
	}

}
