package api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Workspace {
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String type;
    @NonNull
    private String description;
}
