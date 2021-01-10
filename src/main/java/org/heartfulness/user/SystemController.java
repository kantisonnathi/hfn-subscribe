package org.heartfulness.user;

import org.heartfulness.subscription.Subscription;
import org.heartfulness.subscription.SubscriptionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class SystemController {

    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    public SystemController(UserRepository userRepository, SubscriptionRepository subscriptionRepository) {
        this.userRepository = userRepository;
        this.subscriptionRepository = subscriptionRepository;
    }
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/entry")
    public String getDetails(ModelMap modelMap) {
        User user = new User();
        modelMap.put("user",user);
        return "main/signup2";
    }

    @PostMapping("/entry")
    public String gotDetails(@Valid User user) {
        Integer id = user.getId();
        Set<User> others = new HashSet<>();
        if (user.getEmail() != "" && user.getEmail() != null) {
            others.addAll(this.userRepository.findAllByEmail(user.getEmail()));
        }
        if (user.getSmsNumber() != "" && user.getSmsNumber() != null) {
            others.addAll(this.userRepository.findAllBySmsNumber(user.getSmsNumber()));
        }
        if (user.getWhatsappNumber() != "" && user.getWhatsappNumber() != null) {
            others.addAll(this.userRepository.findAllByWhatsappNumber(user.getWhatsappNumber()));
        }

        if (others.size() != 0) {
            Object[] oth = others.toArray();
            User u = (User)oth[0];
            id = u.getId();
        } else {
            this.userRepository.save(user);
            id = user.getId();
        }
        return "redirect:" + id + "/pref";
    }

    @GetMapping("{userId}/pref")
    public String getPreferences(@PathVariable("userId") Integer userId, ModelMap modelMap) {
        User user = this.userRepository.findById(userId);
        Subscription whispers = new Subscription("Whispers From the Brighter World");
        Subscription weekly = new Subscription("Weekly Inspiration");
        Subscription obt = new Subscription("One Beautiful Thought");
        user.addSubscription(whispers);user.addSubscription(weekly);user.addSubscription(obt);
        modelMap.put("user", user);
        modelMap.put("subscriptions", user.getSubscriptions());
        return "main/preferences";
    }

    @PostMapping("{userId}/pref")
    public String gotPreferences(@Valid User user) {
        this.userRepository.save(user);
        List<Subscription> subscriptions = user.getSubscriptions();
        for (Subscription sub : subscriptions) {
            this.subscriptionRepository.save(sub);
        }
        return "main/hello";
    }
}
