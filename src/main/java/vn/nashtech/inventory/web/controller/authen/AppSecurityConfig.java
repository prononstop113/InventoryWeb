package vn.nashtech.inventory.web.controller.authen;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
@Autowired
private CustomAuthenticationProvider  customAuthenticationProvider;
    @Override
    protected void configure (HttpSecurity http)  throws Exception{
//       Allow Boostrap
        http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**","/vendor/**","/scss/**").permitAll();
        //Configure Security
        http.authorizeRequests()
            .antMatchers("/signup","/signin").permitAll()

//            .antMatchers("/", "/home").access("hasRole('USER')")  (for role function that will be updated in future)
//            .antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and().formLogin()
            .loginPage("/signin").permitAll()
            .loginProcessingUrl("/signin")
            .defaultSuccessUrl("/")
            .failureUrl("/signin?error=true");
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403")
            .and().csrf().disable();
//        http.authorizeRequests().and() //
//            .rememberMe().tokenRepository(this.persistentTokenRepository()) //
//            .tokenValiditySeconds(1 * 24 * 60 * 60);

        //Logout function
        http.logout().logoutUrl("/perform_logout")
            .logoutSuccessUrl("/signin")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID");
    }
@Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(customAuthenticationProvider);
}

}
