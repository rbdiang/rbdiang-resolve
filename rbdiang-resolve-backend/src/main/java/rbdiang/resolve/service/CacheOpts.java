package rbdiang.resolve.service;

import java.util.List;

public interface CacheOpts {

    default List<?> viewAll() {
        return null;
    }
}
