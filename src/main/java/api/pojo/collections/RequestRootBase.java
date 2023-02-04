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
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RequestRootBase {
    private String name;
    private List<Object> response;

    protected RequestRootBase(String name) {
        this.name = name;
    }

    protected RequestRootBase(String name, List<Object> response) {
        this.name = name;
        this.response = response;
    }
}
