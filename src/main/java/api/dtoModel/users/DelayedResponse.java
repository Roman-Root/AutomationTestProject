package api.dtoModel.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class DelayedResponse {

    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private ArrayList<Datum> data;
    private Support support;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    private static class Datum{
        private Integer id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    private static class Support{
        private String url;
        private String text;
    }
}
