package org.launchcode.Ch15Lecture.controllers;

import org.launchcode.Ch15Lecture.data.DinoData;
import org.launchcode.Ch15Lecture.models.Dinosaur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

    @GetMapping("add")
    public String displayAddDinoForm() {
        return "dino/add";
    }

    @PostMapping("add")
    public String processAddDinoForm(Model model, @ModelAttribute @Valid Dinosaur newDinoObj,
                                     Errors errors) {
        // now that we have the 3 necessary pieces of data we need from the form,
        // let's create a Dinosaur object using this data
        // Dinosaur newDinoObj = new Dinosaur(species, diet, aquatic);

        // Now that we are validating the post request data via model validation, we need to
        // check that the data is passing using this Errors object before adding the dino to the
        // allDinos list
        if(errors.hasErrors()) {
            // If errors.hasErros is true, let's re-render the dino/add instead of
            // continuing on and adding the dino into the allDinos list and rendering the
            // dino/index page
            // Before we re-render out the dino/add view, let's pass in an error message to the view
            // so that the user gets some feedback about what went wrong
            model.addAttribute("errorMsg", "The species must contain at least 3 characters!");
            return "dino/add";
        }


        // What should we do with this Dinosaur object?
        // Let's add it to the allDinos list!
        DinoData.addDino(newDinoObj);

        // Now that we have processed our post request and
        // stored our Dinosaur object in our allDinos list,
        // what page should we render?
        // Anytime we render dino/index, we need to pass in the allDinos list
        // so that our Thymeleaf can render all of dinos in the table
        model.addAttribute("allDinos", DinoData.getAllDinos());

        return "dino/index";
    }

}
