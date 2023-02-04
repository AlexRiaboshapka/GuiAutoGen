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
public class MyRequestRequest extends MyRequestBase {
    private String url;

    public MyRequestRequest(String url, String method, String description, @NonNull List<MyHeader> header, MyBody body) {
        super(method, header, description, body);
        this.url = url;
    }

    public MyRequestRequest(String url) {
        this.url = url;
    }

    public MyRequestRequest(@NonNull List<MyHeader> header, String url) {
        super(header);
        this.url = url;
    }

}
