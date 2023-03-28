package rbdiang.resolve.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GrpcClientApplication {

	@Bean
	ResolverClient clientTest() {
		return new ResolverClient();
	}
	public static void main(String[] args) {
		SpringApplication.run(GrpcClientApplication.class, args);
	}

}
