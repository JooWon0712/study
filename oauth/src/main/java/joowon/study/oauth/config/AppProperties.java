package joowon.study.oauth.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

/**
 * Created by JooWon0712.
 * User: joowon
 * Date: 2019-02-27
 * Time: 14:23
 */
@Component
@ConfigurationProperties(prefix = "study-app")
@Getter @Setter
public class AppProperties {

    @NotEmpty
    private String clientId;

    @NotEmpty
    private String clientSecret;
}
