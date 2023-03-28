package rbdiang.resolve.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import rbdiang.resolve.api.Normalized;
import rbdiang.resolve.cache.NormalizeCache;

@Slf4j
@Component
@AllArgsConstructor
@Import({
        NormalizeCache.class
})
public class NormalizeService {
    private NormalizeCache normalizeCache;

    public Normalized normalize(String raw) {
        return normalizeCache.getCachedValue(raw).get();
    }
}
