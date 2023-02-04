package api.pojo.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionResponse extends CollectionBase {

    private List<FolderResponse> item;

    public CollectionResponse(Info info, List<FolderResponse> item) {
        super(info);
        this.item = item;
    }

    public CollectionResponse(List<FolderResponse> item) {
        this.item = item;
    }
}
