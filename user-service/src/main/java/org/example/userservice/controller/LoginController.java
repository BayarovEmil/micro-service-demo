package org.example.userservice.controller;

import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final MessageSource messageSource;

    public LoginController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    public Map<String, String> loginPage(Locale locale) {
        Map<String, String> messages = new HashMap<>();
        messages.put("title", messageSource.getMessage("login.title", null, locale));
        messages.put("emailLabel", messageSource.getMessage("login.email", null, locale));
        messages.put("passwordLabel", messageSource.getMessage("login.password", null, locale));
        messages.put("button", messageSource.getMessage("login.button", null, locale));
        return messages;
    }

    @PostMapping("/do")
    public ResponseEntity<String> doLogin(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            Locale locale) {
        if (email == null || email.trim().isEmpty()) {
            String errorMsg = messageSource.getMessage("error.email.required", null, locale);
            return ResponseEntity.badRequest().body(errorMsg);
        }

        if (!"1234".equals(password)) {
            String errMsg = messageSource.getMessage("error.password.invalid", null, locale);
            return ResponseEntity.status(401).body(errMsg);
        }

        String successMsg = messageSource.getMessage("login.success", null, locale);
        return ResponseEntity.ok(successMsg);
    }
}
