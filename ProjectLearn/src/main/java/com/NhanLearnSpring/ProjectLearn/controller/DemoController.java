package com.NhanLearnSpring.ProjectLearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.NhanLearnSpring.ProjectLearn.service.IDemoService;

@Controller
public class DemoController {

    @Autowired
    private IDemoService demoService;
    @GetMapping("say")
    public String sayHelloWorld(final ModelMap model) {
        String data = demoService.sayHello();
        model.addAttribute("data", data);

        return "hello_world";
    }
}
