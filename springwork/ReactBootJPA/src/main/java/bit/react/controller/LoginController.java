package bit.react.controller;

import bit.react.repository.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public Map<String, String> login(@RequestParam String username, @RequestParam String password) {
        System.out.println("login: " + username + "," + password);
        String token = loginService.login(username, password);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("Authorization", "Bearer " + token);
        return map;
    }
}
