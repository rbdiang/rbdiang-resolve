package rbdiang.resolve.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IndividualEntity {
    private String dn;
    private String issuerDn;
}
