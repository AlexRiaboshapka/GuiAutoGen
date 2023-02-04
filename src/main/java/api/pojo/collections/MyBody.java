package api.pojo.collections;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class MyBody {
    private String mode;
    private String raw;
    @NonNull
    private String[] formdata;
}
