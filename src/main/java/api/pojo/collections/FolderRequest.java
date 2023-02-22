package api.pojo.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FolderRequest extends FolderBase {

    private List<RequestRootRequest> item;

    public FolderRequest(String name, String description, List<RequestRootRequest> item) {
        super(name, description);
        this.item = item;
    }

    public FolderRequest(List<RequestRootRequest> item) {
        this.item = item;
    }

    public FolderRequest() {
    }

    public List<RequestRootRequest> getItem() {
        return item;
    }

    public void setItem(List<RequestRootRequest> item) {
        this.item = item;
    }


}
