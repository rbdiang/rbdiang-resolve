package rbdiang.resolve.client;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
@Slf4j
@Import(ResolverClient.class)
public class TestClient {
    private ResolverClient resolverClient;

    @PostConstruct
    public void runTests() {
        log.info("Running tests");
        log.info("normalize Foo...bar@gmail.com = {}", resolverClient.normalizeAddress("Foo...bar@gmail.com"));
        log.info("normalize Foo...bar@gmail.com = {}", resolverClient.normalizeAddress("Foo...bar@gmail.com"));
        log.info("normalize Foo...bar@gmail.com = {}", resolverClient.normalizeAddress("Foo...bar@gmail.com"));
        log.info("normalize Foo...bar@gmail.com = {}", resolverClient.normalizeAddress("Foo...bar@gmail.com"));

        resolverClient.shutdown();
    }
}
