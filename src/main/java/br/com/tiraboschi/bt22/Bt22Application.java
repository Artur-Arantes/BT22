package br.com.tiraboschi.bt22;

import br.com.tiraboschi.bt22.config.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ConfigProperties.class)
@SpringBootApplication
public class Bt22Application {

	public static void main(String[] args) {
		SpringApplication.run(Bt22Application.class, args);
	}

}
