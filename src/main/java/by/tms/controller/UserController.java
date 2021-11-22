package by.tms.controller;

import by.tms.entity.User;
import by.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String homePage() {
        return "home";
    }

    @GetMapping("/user/reg")
    public String registrationPage(Model model) {
        model.addAttribute("newUser", new User());
        return "/registration";
    }

    @PostMapping("/user/reg")
    public String createPost(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "/registration";
        }
        userService.registerUser(user);
        session.setAttribute("user", user);
        return "redirect:/calc";
    }
}
