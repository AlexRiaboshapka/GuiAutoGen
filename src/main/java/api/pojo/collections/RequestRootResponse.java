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
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestRootResponse extends RequestRootBase {
    private MyRequestResponse request;
    @NonNull
    private List<Object> response;

    public RequestRootResponse(String name, MyRequestResponse request, @NonNull List<Object> response) {
        super(name);
        this.request = request;
        this.response = response;
    }

    public RequestRootResponse(String name, @NonNull List<Object> response, MyRequestResponse request, @NonNull List<Object> response1) {
        super(name, response);
        this.request = request;
        this.response = response1;
    }


}
