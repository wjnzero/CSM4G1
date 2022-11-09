package com.management.cgmanagement.controller.tuition;

import com.management.cgmanagement.model.entity.Tuition;
import com.management.cgmanagement.model.entity.User;
import com.management.cgmanagement.service.tuition.ITuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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
    @GetMapping("/edit-tuition/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Tuition> tuition = tuitionService.findById(id);
        if (tuition.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/tuition/edit");
            modelAndView.addObject("tuition", tuition.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-tuition")
    public ModelAndView updateTuition(@ModelAttribute("tuition") Tuition tuition) {
        tuitionService.save(tuition);
        ModelAndView modelAndView = new ModelAndView("/tuition/edit");
        modelAndView.addObject("tuition", tuition);
        modelAndView.addObject("message", "tuition updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-tuition/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Tuition> tuition = tuitionService.findById(id);
        if (tuition.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/tuition/delete");
            modelAndView.addObject("tuition", tuition.get());
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-tuition")
    public String deleteTuition(@ModelAttribute("tuition") Tuition tuition) {
        tuitionService.remove(tuition.getId());
        return "redirect:tuitions";
    }
}