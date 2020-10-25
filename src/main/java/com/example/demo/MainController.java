package com.example.demo;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class MainController {

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
        String response = "{\"name\":\"mkyong\", \"age\":29}";
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/";
    }

}
