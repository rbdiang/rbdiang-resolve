package rbdiang.resolve.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Normalized {
    private String raw;
    private String normalized;
}
