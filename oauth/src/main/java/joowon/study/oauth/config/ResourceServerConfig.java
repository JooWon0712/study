package joowon.study.oauth.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * Created by JooWon0712.
 * User: joowon
 * Date: 2019-02-26
 * Time: 15:13
 */
@Component
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("resource_id").stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // INFO : Resource Server 접근 권한 설정
        http.anonymous()
            .and()
            .authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/").permitAll()
                .mvcMatchers(HttpMethod.GET, "/hello").authenticated()
                .anyRequest().permitAll()
            .and()
            .exceptionHandling()
                .accessDeniedHandler(new OAuth2AccessDeniedHandler());

    }
}
