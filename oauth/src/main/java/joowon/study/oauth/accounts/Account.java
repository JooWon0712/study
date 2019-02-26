package joowon.study.oauth.accounts;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JooWon0712.
 * User: joowon
 * Date: 2019-02-26
 * Time: 16:01
 */
@Entity
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String userPassword;

}
