package com.example.travelbackend.Controllers;

import com.example.travelbackend.Entity.Accomodation;
import com.example.travelbackend.Service.AccomodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class AccomodationController {

    @Autowired
    AccomodationService accomodationService;


    @RequestMapping("/AddAcc")
    public String addAccomodation(Model model) {
        Accomodation accomodation = new Accomodation();
        model.addAttribute("AccomodationForm", accomodation);
        return "new_accomodation";
    }

    @RequestMapping(value = "/saveAcc", method = RequestMethod.POST)
    public String saveAccomodation(@ModelAttribute("AccomodationForm") Accomodation accomodation) {
        accomodationService.CreateAccomodation(accomodation);
        return "redirect:/AllAccomodations";
    }

    @RequestMapping("/AllAcc")
    public String ListAccomodation(Model model) {
        List<Accomodation> ListAccomodations= accomodationService.getAllAccomodations();
        model.addAttribute("ListAccomodations", ListAccomodations);
        return "liste_accomodations";
    }

    @GetMapping("deleteAcc/{id}")
    public String deleteAccomodation(@PathVariable("id") long id) {
        accomodationService.deleteAccomodation(id);
        return "redirect:/AllAccomodations";
    }

    @GetMapping("/editAcc/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Accomodation accomodation = new Accomodation();
        model.addAttribute("accomodation", accomodation);
        return "update_accomodation";
    }

    @PostMapping("/updateAcc/{id}")
    public String updateAccomodation(@PathVariable("id") long id, Accomodation accomodation) {
        accomodationService.updateAccomodation(accomodation);
        return "redirect:/AllAccomodations";
    }

}
