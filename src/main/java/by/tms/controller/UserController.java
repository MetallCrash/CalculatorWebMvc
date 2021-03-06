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
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String registrationPage(Model model) {
        model.addAttribute("newUser", new User());
        return "/registration";
    }

    @PostMapping("/reg")
    public String registrationPage(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult, HttpSession session) {
        session.removeAttribute("regMessage");
        if (bindingResult.hasErrors()) {
            return "/registration";
        } else {
            if (!userService.registerUser(user)) {
                session.setAttribute("regMessage", "This login already in use.");
                return "/registration";
            }
            return "redirect:/user/sign-in";
        }
    }

    @GetMapping("/sign-in")
    public String signInPage(Model model) {
        model.addAttribute("newUser", new User());
        return "/sign-in";
    }

    @PostMapping("/sign-in")
    public String signInPage(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            return "/sign-in";
        } else {
            User userInDB = userService.checkUser(user).get();
            if (userService.checkUser(user).isPresent()) {
                session.removeAttribute("signInMessage");
                session.setAttribute("user", userInDB);
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong login or password.");
                return "/sign-in";
            }
        }
    }

    @GetMapping("/sign-out")
    public String signOut(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
