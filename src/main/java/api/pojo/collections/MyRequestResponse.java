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
public class MyRequestResponse extends MyRequestBase {
    private MyUrl url;

    public MyRequestResponse(String method, @NonNull List<MyHeader> header, String description, MyBody body, MyUrl url) {
        super(method, header, description, body);
        this.url = url;
    }

    public MyRequestResponse(MyUrl url) {
        this.url = url;
    }

    public MyRequestResponse(@NonNull List<MyHeader> header, MyUrl url) {
        super(header);
        this.url = url;
    }
}
