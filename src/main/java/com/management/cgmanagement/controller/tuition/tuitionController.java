package com.management.cgmanagement.controller.tuition;

import com.management.cgmanagement.model.Tuition;
import com.management.cgmanagement.model.User;
import com.management.cgmanagement.service.tuition.ITuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class tuitionController {
    @Autowired
    private ITuitionService tuitionService;

    @GetMapping("/create-tuition")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/user/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create-tuition")
    public ModelAndView saveTuition(@ModelAttribute("tuition") Tuition tuition) {
        tuitionService.save(tuition);
        ModelAndView modelAndView = new ModelAndView("/tuition/create");
        modelAndView.addObject("tuition", new Tuition());
        modelAndView.addObject("message", "New tuition created successfully");
        return modelAndView;
    }
    @GetMapping("/tuitions")
    public ModelAndView listtuitions() {
        ModelAndView modelAndView = new ModelAndView("/tuition/list");
        modelAndView.addObject("tuitions", tuitionService.findAll());
        return modelAndView;
    }

}