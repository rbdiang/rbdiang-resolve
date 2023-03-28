package rbdiang.resolve.gprc.hazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
		GrpcResolveService.class
})
@EnableCaching
public class GrpcResolverHazelcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcResolverHazelcastApplication.class, args);
	}

}
