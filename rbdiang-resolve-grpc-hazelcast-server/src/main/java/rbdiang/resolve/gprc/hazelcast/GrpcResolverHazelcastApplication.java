package rbdiang.resolve.gprc.hazelcast;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
		GrpcResolveService.class
})
@EnableCaching
@Slf4j
public class GrpcResolverHazelcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcResolverHazelcastApplication.class, args);
	}

}
