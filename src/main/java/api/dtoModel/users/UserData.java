package api.dtoModel.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserData {

    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<Datum> data;
    private Support support;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Datum {
        private Integer id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Support{
        private String url;
        private String text;

    }

}
