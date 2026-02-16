package org.example.Model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import lombok.Data;
import org.example.Entity.UserInfo;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Component;


@Data
@Component
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfoDto extends UserInfo {

    private String userName ;
    private String lastName ;
    private String password ;
    private Long phoneNumber ;
    private String emal ;

}
