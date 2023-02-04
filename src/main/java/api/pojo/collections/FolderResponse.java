package api.pojo.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FolderResponse extends FolderBase {
    private List<RequestRootResponse> item;

    public FolderResponse(String name, String description, List<RequestRootResponse> item) {
        super(name, description);
        this.item = item;
    }

    public FolderResponse(String name, List<RequestRootResponse> item) {
        super(name);
        this.item = item;
    }

    public FolderResponse(List<RequestRootResponse> item) {
        this.item = item;
    }
}
