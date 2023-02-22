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
@NonNull
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionRequest extends CollectionBase {
    private List<FolderRequest> item;

    public CollectionRequest(Info info, List<FolderRequest> item) {
        super(info);
        this.item = item;
    }

    public CollectionRequest(List<FolderRequest> item) {
        this.item = item;
    }

    public CollectionRequest() {
    }
}
