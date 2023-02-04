package api.pojo.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NonNull
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FolderRequest extends FolderBase {
    private List<RequestRootRequest> item;

    public FolderRequest(String name, String description, List<RequestRootRequest> item) {
        super(name, description);
        this.item = item;
    }

    public FolderRequest(String name, List<RequestRootRequest> item) {
        super(name);
        this.item = item;
    }

    public FolderRequest(List<RequestRootRequest> item) {
        this.item = item;
    }
}
