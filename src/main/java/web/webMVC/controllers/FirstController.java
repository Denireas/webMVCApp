package web.webMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String Calculator(@RequestParam(value = "a", required = false) double a,
                             @RequestParam(value = "b", required = false) double b,
                             @RequestParam(value = "operation", required = false) String operation,
                            Model model) {

        //System.out.println("Hello, " + name + " " + surname);

        String op = "";
        double res = 0;

        switch (operation) {
            case "multi":
                op = " * ";
                res = a * b;
                break;
            case "add":
                op = " + ";
                res = a + b;
                break;
            case "div":
                op = " / ";
                res = a / b;
                break;
            case "sub":
                op = " - ";
                res = a - b;
                break;
            default:
                op = " + ";
                res = 0;
                break;
        }

        model.addAttribute("result", "Result: " + a + op + b + " = " + res);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
