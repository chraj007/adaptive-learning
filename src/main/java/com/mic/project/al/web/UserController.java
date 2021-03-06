package com.mic.project.al.web;

import com.mic.project.al.model.Questionnaire;
import com.mic.project.al.model.User;
import com.mic.project.al.repository.UserDocumentsRepository;
import com.mic.project.al.service.QuessionaireService;
import com.mic.project.al.service.SecurityService;
import com.mic.project.al.service.UserService;
import com.mic.project.al.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private QuessionaireService quessionaireService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserDocumentsRepository userDocumentsRepository;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = "/questionnaire", method = RequestMethod.GET)
    public String questionnaire(Model model) {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Questionnaire questionnaire = quessionaireService.findByUserName(user.getUsername());
        questionnaire = questionnaire == null ? new Questionnaire() : questionnaire;
        model.addAttribute("questionnaireForm", questionnaire);

        return "questionnaire";

    }

    @RequestMapping(value = "/questionnaire", method = RequestMethod.POST)
    public String questionnaire(@ModelAttribute Questionnaire questionnaireForm, Model model) {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        questionnaireForm.setUserName(user.getUsername());
        quessionaireService.save(questionnaireForm, user.getUsername());
        model.addAttribute("message", "Successfully submitted quessionaire");
        model.addAttribute("questionnaireForm", questionnaireForm);
        return "questionnaire";

    }

    @RequestMapping(value = "/userprofile", method = RequestMethod.GET)
    public String userProfile(Model model) {
        org.springframework.security.core.userdetails.User userprofile = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user1 = userService.findByUsername(userprofile.getUsername());
        model.addAttribute("userProfileForm", user1);
        return "userprofile";
    }

    @RequestMapping(value = "/userprofile", method = RequestMethod.POST)
    public String userProfile(@ModelAttribute User user, Model model) {
        org.springframework.security.core.userdetails.User userprofile = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userProfileForm", user);
        return "userprofile";
    }


    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        org.springframework.security.core.userdetails.User userprofile = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Questionnaire byUserName = quessionaireService.findByUserName(userprofile.getUsername());
        if (byUserName == null) {
            return "redirect:/questionnaire";
        }

        model.addAttribute("docsUploaded", userDocumentsRepository.findByUserName(userprofile.getUsername()).size());
        model.addAttribute("learningStyle", byUserName.getLearningStyle());

        return "home";
    }


}
