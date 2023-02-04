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
public class RequestRootRequest extends RequestRootBase {
    private MyRequestRequest request;
    private List<Object> response;

    public RequestRootRequest(String name, MyRequestRequest request, List<Object> response) {
        super(name);
        this.request = request;
        this.response = response;
    }

    public RequestRootRequest(String name, MyRequestRequest request) {
        super(name);
        this.request = request;
    }
}
