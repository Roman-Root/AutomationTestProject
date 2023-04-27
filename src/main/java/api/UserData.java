package api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

}
