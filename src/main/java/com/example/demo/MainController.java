package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MainController {

    @Autowired
    PushNotificationService pushNotificationService;

    @GetMapping("/")
    public String index(Model model, @ModelAttribute("response") String response) {
        if (!response.isEmpty()) {
            System.out.println("==========================================");
            System.out.println("Response: " + response);
            System.out.println("==========================================");
        }
        return "index";
    }

    @PostMapping("/push")
    public String push(RedirectAttributes redirectAttributes) {
        System.out.println("Push通知送信");
//        https://firebase.google.com/docs/cloud-messaging/send-message

        String response = "{\"name\":\"mkyong\", \"age\":29}";
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/";
    }

}
