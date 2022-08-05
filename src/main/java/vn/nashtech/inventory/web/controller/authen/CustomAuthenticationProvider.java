package vn.nashtech.inventory.web.controller.authen;

import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.nashtech.inventory.web.model.Credentials;
import vn.nashtech.inventory.web.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
private      String msg = "";


    private RestTemplate rest = new RestTemplate();

 private ResponseEntity<?> isValid (Credentials cre) {
     ResponseEntity<User> response;
     try {
        response= rest.postForEntity("http://localhost:8090/user/signin", cre, User.class);
        return response;
     } catch (Exception e) {
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
     }
 }
 @Override public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {

        User user= new User() ;
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        Credentials cre = new Credentials();
        cre.setUsername(username);
        cre.setPassword(password);
        ResponseEntity res = isValid(cre);


        if (res.getStatusCode().isError()) {

      msg=res.getStatusCode().getReasonPhrase();
            throw new BadCredentialsException(msg);


        } else {
            user = (User) res.getBody();
            return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
        }

    }
    @Override public boolean supports(Class<?> authenticationType) {
        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
    }


}
