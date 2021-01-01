package org.heartfulness.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "main/hello";
    }

    @GetMapping("/signup")
    public String signUp(ModelMap modelMap) {
        User user = new User();
        modelMap.put("user", user);
        return "main/signup";
    }

    @PostMapping("/signup")
    public String returnSignUp(@Valid User user, BindingResult result) {
        this.userRepository.save(user);
        return "main/hello";
    }
}
