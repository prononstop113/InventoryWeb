package vn.nashtech.inventory.web.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import vn.nashtech.inventory.web.model.Good;
import vn.nashtech.inventory.web.service.GoodService;


import java.util.Arrays;
import java.util.List;
@Service
public class GoodServiceImpl implements GoodService {
    RestTemplate rest = new RestTemplate();
    ResponseEntity<?> response;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override public void editGood(Good formGood) {
        rest.put("http://localhost:8091/good/{id}", formGood, Good.class);
    }

    @Override public String addGood(Good formGood) {
        String msg;
        try {
            response = rest.postForEntity("http://localhost:8091/good", formGood, String.class);
            msg = response.getBody().toString();
            return msg;
        } catch (HttpClientErrorException e) {
            msg = e.getResponseBodyAsString();
            return msg;
        }
    }
    @Override public List<Good> listGood() {

        List<Good> listGood;
      Good[]mlis= rest.getForObject("http://localhost:8091/good/list", Good[].class);
      listGood=Arrays.asList(mlis);
        return listGood;
    }

}

