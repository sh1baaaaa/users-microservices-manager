package general.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private Integer age;

    private String city;

    private String country;

}
