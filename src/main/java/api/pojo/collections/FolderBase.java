package api.pojo.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class FolderBase {
    private String name;
    private String description;

    protected FolderBase(String name, String description) {
        this.name = name;
        this.description = description;
    }

    protected FolderBase(String name) {
        this.name = name;
    }

    protected FolderBase() {
    }

}
