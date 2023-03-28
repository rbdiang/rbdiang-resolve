package rbdiang.resolve.api;

import java.util.List;

public interface Resolver {

    List<IndividualEntity> resolveGroup(GroupEntity groupEntity);

    Normalized normalize(String raw);
}
