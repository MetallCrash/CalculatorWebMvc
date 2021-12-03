package by.tms.controller;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.CalculatorService;
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
@RequestMapping("/calc")
public class CalculatorController {


    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String calculate(Model model, HttpSession session) {
        model.addAttribute("newOperation", new Operation());
        User user = (User) session.getAttribute("user");
        model.addAttribute("operationList", calculatorService.showOperationList(user));
        return "/calculator";
    }

    @PostMapping()
    public String calculate(@ModelAttribute("newOperation") @Valid Operation operation,
                            BindingResult bindingResult, Model model, HttpSession session) {
        if (!bindingResult.hasErrors()) {
            operation.setResult(calculatorService.calculate(operation));
            String result = operation.getNum1() + operation.getAction() + operation.getNum2() + "=" + operation.getResult();
            model.addAttribute("result", result);
            User user = (User) session.getAttribute("user");
            if (user != null) {
                calculatorService.saveOperation(user, operation);
                model.addAttribute("operationList", calculatorService.showOperationList(user));
            }
        }
        return "/calculator";
    }
}
