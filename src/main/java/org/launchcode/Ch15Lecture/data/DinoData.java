package org.launchcode.Ch15Lecture.data;

import org.launchcode.Ch15Lecture.models.Dinosaur;

import java.util.ArrayList;

public class DinoData {
    // here we our list that we will use to store all of the dinos
    // that we want to add in the application
    private static ArrayList<Dinosaur> allDinos = new ArrayList<>();

    // let's create a method that acts a getter for this private
    // allDinos ArrayList
    public static ArrayList<Dinosaur> getAllDinos() {
        return allDinos;
    }

    // let's create a method now for adding Dinosaur objects into
    // the allDinos ArrayList
    // Inputs: Dinosaur object
    // Outputs:
    public static void addDino(Dinosaur newDinoObj) {
        allDinos.add(newDinoObj);
    }
}
