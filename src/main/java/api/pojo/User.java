package api.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @NonNull
    private String name;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private Address address;
    private String id;
}
