package rbdiang.resolve.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import rbdiang.resolve.api.Normalized;

import java.util.Optional;

@Slf4j
@Component
@CacheConfig(cacheNames = {"normalize"})
public class NormalizeCache {

    @Cacheable(unless="#result != null")
    public Optional<Normalized> getCachedValue(String raw) {
        String result = fetchNormalizedResult(raw);
        return Optional.of(new Normalized(raw, result));
    }

    /**
     * normalize specified raw string by converting to lower case removing all strings,
     * and replacing consecutive dots with a single dot.
     * @param raw string to normalize
     * @return normalized string
     */
    private String fetchNormalizedResult(String raw) {
        if (StringUtils.hasText(raw)) {
            return raw
                    .toLowerCase()
                    .replaceAll(" ","")
                    .replaceAll("\\.{2,}",".");
        }
        return null;
    }
}
