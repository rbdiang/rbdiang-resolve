package rbdiang.resolve.grpc.rest.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;
import rbdiang.resolve.client.ResolverClient;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Data
@AllArgsConstructor
@Import({
        ResolverClient.class
})
@RestController("/resolve/")
public class ResolverController {

    private final ResolverClient resolverClient;

    @SuppressWarnings("unused")
    @PostConstruct
    public void init() {
      log.info("Initialize ResolverController");
    }

    @GetMapping(path="/normalize/{raw}")
    public String normalize(@PathVariable(name="raw") String raw) {
        String answer = resolverClient.normalizeAddress(raw);
        log.info("Raw: {} normalized to: {}", raw, answer);
        return answer;
    }

    @PostMapping(path = "/nomalize/")
    public Map<String,String> nomalizeAll(@RequestBody List<String> rawList) {
        if (rawList == null) {
            throw new IllegalArgumentException("Input can not be null");
        }

        Map<String, String> answer = rawList
                .stream()
                .map(r -> new String[]{r,resolverClient.normalizeAddress(r)})
                .collect(Collectors.toMap(array -> array[0], array ->array[1] ));

        log.info("Conversion: {}", answer);
        return answer;
    }

    @PreDestroy
    public void shutdown() {
        log.info("Shutting down resolver client");
        resolverClient.shutdown();
    }
}
