package rbdiang.resolve.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroupEntity {
    private String dn;
    private GroupType groupType;
}
