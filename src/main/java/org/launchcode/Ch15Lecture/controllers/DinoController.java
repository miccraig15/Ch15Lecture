package org.launchcode.Ch15Lecture.controllers;

import org.launchcode.Ch15Lecture.data.DinoData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dino")
public class DinoController {

    // Here is a method that handles get requests at
    // the /dino path
    @GetMapping
    public String dino(Model model) {
        // let's pass in a list of all of the dinos in our
        // data layer
        model.addAttribute("allDinos", DinoData.getAllDinos());

        return "dino/index";
    }

}
