package org.heartfulness.user;


import org.heartfulness.subscription.Subscription;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/hello")
    public String hello() {
        return "main/hello";
    }

    @GetMapping("/signup")
    public String signUp(ModelMap modelMap) {
        User user = new User();
        /*Subscription whispers = new Subscription("Whispers From the Brighter World");
        Subscription weekly = new Subscription("Weekly Inspiration");
        Subscription obt = new Subscription("One Beautiful Thought");
        user.addSubscription(whispers);user.addSubscription(weekly);user.addSubscription(obt);*/
        user = this.userRepository.findById(user.getId());

        modelMap.put("user",user);
        return "main/signup";
    }

    @PostMapping("/signup")
    public String returnSignUp(@Valid User user, BindingResult result) {
        this.userRepository.save(user);
        Integer userID = user.getId();
        List<User> users = this.userRepository.findAllByEmailOrSmsNumberOrWhatsappNumber(user.getEmail(),
                user.getSmsNumber(), user.getWhatsappNumber());

        for (User user1 : users) {
            if (!user1.getId().equals(userID)) {
                return "main/hello";
            }
        }
        //this.userRepository.save(user);
        return "main/new";
    }

}
