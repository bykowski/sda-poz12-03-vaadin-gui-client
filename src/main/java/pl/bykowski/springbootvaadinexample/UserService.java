package pl.bykowski.springbootvaadinexample;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserService {

    public void addUserToApi(long id, String name, String surname, int age, String sex) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("name", name);
        jsonObject.put("surname", surname);
        jsonObject.put("age", age);
        jsonObject.put("sex", sex);

        HttpEntity httpEntity = new HttpEntity(jsonObject.toString(), httpHeaders);
        restTemplate.exchange(
                "http://localhost:8080/api",
                HttpMethod.POST,
                httpEntity,
                Void.class);
    }
}
