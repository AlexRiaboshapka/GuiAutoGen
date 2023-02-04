package api.pojo.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NonNull
@JsonIgnoreProperties(ignoreUnknown = true)
public  abstract class FolderBase {
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
