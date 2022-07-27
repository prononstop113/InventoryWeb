package vn.nashtech.inventory.web.controller.authen;

import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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

         //         user = rest.postForObject("http://localhost:8090/user/signin", cre, User.class);

//         if (response.hasBody() == false) {
//             msg = response.getStatusCode().toString();
//             System.out.println("sssssss test");
//             System.out.println(msg);
//         }


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
        System.out.println("log 1 \n");
        System.out.println(res.getStatusCode());
        System.out.println(res.getHeaders());
        System.out.println(res.getStatusCode().getReasonPhrase());


        if (res.getStatusCode().isError()) {
            System.out.println("log 2 \n");

      msg=res.getStatusCode().getReasonPhrase();
            throw new BadCredentialsException(msg);


        } else {
            user = (User) res.getBody();
            System.out.println(user.getEmail());
            return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
        }
//        if (user != null) {
//
//        }
//        HttpServletRequest request;
//        HttpServletResponse response;
//        request.setAttribute("msg", msg);
//        request.getRequestDispatcher("signin.jsp").forward(request, response);
    }
    @Override public boolean supports(Class<?> authenticationType) {
        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
    }
}
