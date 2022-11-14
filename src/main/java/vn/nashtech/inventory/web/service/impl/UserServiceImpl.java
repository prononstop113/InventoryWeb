package vn.nashtech.inventory.web.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import vn.nashtech.inventory.web.model.FormInput;
import vn.nashtech.inventory.web.model.User;
import vn.nashtech.inventory.web.service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    RestTemplate rest = new RestTemplate();
    ResponseEntity<?> response;
    ObjectMapper obj = new ObjectMapper();

    @Override
    public void editUser(FormInput form){
        rest.put("http://localhost:8090/updateProfile/{id}", form, User.class);
    }

    @Override public String signUp(FormInput form) {
        String msg;
        try {
            response = rest.postForEntity("http://localhost:8090/user/signup", form, String.class);
            msg = response.getBody().toString();
            return msg;
        } catch (HttpClientErrorException e) {
            msg = e.getResponseBodyAsString();
            return msg;
        }
    }
    @Override
    public List<User> listUser()  {
        List<User> listUser;
        try {
            String rs;
            rs = rest.getForObject("http://localhost:8090/user/listUser", String.class);
            listUser = obj.readValue(rs, new TypeReference<List<User>>() {
                @Override public int compareTo(TypeReference<List<User>> o) {
                    return super.compareTo(o);
                }
            });
            return listUser;
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    };
    }

