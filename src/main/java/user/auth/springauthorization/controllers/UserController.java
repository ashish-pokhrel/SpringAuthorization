package user.auth.springauthorization.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/login")
    public Map<String, String> login() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("a", "apple");
        return hashMap;
    }
}
