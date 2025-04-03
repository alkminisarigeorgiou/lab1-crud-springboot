package com.mars_crud.mars_crud.controller;

import com.mars_crud.mars_crud.entity.Resource;
import com.mars_crud.mars_crud.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resources")
public class ResourceController {
    @Autowired
    private ResourceRepository resourceRepository;
    
    @GetMapping
    public String showResource(Model model) {
        model.addAttribute("resources", resourceRepository.findAll());
        return "resources";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("resource", new Resource());
        return "add-resource";
    }

    @PostMapping("/add")
    public String addResource(@ModelAttribute Resource resource) {
        resourceRepository.save(resource);
        return "redirect:/resources";
    }
   
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Resource resource = resourceRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Invalid resource ID"));
        model.addAttribute("resource", resource);
        return "edit-resource";
    }


    @PostMapping("/edit/{id}")
    public String editResource(@PathVariable int id, @ModelAttribute Resource resource) {
        resource.setId(id);
        resourceRepository.save(resource);
        return "redirect:/resources";
    }


    @GetMapping("/delete/{id}")
    public String deleteResource(@PathVariable int id) {
        resourceRepository.deleteById(id);
        return "redirect:/resources";
    }
}
