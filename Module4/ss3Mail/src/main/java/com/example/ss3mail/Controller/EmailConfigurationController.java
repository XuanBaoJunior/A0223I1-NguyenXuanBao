package com.example.ss3mail.Controller;

import com.example.ss3mail.Model.EmailConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/views/")
public class EmailConfigurationController {

    private EmailConfiguration emailConfiguration = new EmailConfiguration();

        @GetMapping("/email-config")
    public String showEmailConfig(Model model) {
        model.addAttribute("emailConfig", emailConfiguration);
        return "email-config";
    }

    @PostMapping("/update-email-config")
    public String updateEmailConfig(@RequestParam("language") String language,
                                    @RequestParam("pageSize") int pageSize,
                                    @RequestParam(value = "spamFilter", defaultValue = "false") boolean spamFilter,
                                    @RequestParam("signature") String signature) {
        emailConfiguration.setLanguage(language);
        emailConfiguration.setPageSize(pageSize);
        emailConfiguration.setSpamFilter(spamFilter);
        emailConfiguration.setSignature(signature);
        return "redirect:/views/email-config";
    }
}

