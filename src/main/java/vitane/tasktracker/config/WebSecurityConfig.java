package vitane.tasktracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final String USER_ROLE = "USER";
    private final String OPER_ROLE = "OPER";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/index").permitAll()
                    .antMatchers(HttpMethod.GET, "/add", "redirect:/add").hasRole(USER_ROLE)
                    .antMatchers(HttpMethod.POST, "/add").hasRole(USER_ROLE)
                    .antMatchers(HttpMethod.GET, "/task", "redirect:/tasklist").hasRole(OPER_ROLE)
                    .antMatchers(HttpMethod.POST, "/find").hasRole(OPER_ROLE)
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login").permitAll()
                .and()
                    .logout().permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("qwe")
                        .roles(USER_ROLE)
                    .build();

        UserDetails operator =
                User.withDefaultPasswordEncoder()
                        .username("operator")
                        .password("qwe")
                        .roles(OPER_ROLE)
                    .build();

        return new InMemoryUserDetailsManager(user, operator);
    }
}
