package user.auth.springauthorization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import user.auth.springauthorization.model.JWTRequest;
import user.auth.springauthorization.model.JWTResponse;
import user.auth.springauthorization.model.User;
import user.auth.springauthorization.service.UserService;
import user.auth.springauthorization.utility.JWTUtility;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private JWTUtility jwtUtility;

    //@Autowired
    //private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public Map<String, String> home() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("a", "apple");
        return hashMap;
    }

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "saved";
    }

    @GetMapping("/get")
    public User getById(int id) {
        return userService.getById(id);
    }

    @PostMapping("/login")
    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUserName());
        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            jwtRequest.getUserName(),
//                            jwtRequest.getPassword()
//                    )
//            );
            String passw =userDetails.getPassword();
            String pass2 = jwtRequest.getPassword();
            if (!passw.equals(pass2)) {
                throw  new BadCredentialsException("Bad");
            }
        } catch (BadCredentialsException ex) {
            throw new Exception("INVALID CREDENTIALS", ex);
        }
        final String token = jwtUtility.generateToken(userDetails);
        return new JWTResponse(token);
    }
}
