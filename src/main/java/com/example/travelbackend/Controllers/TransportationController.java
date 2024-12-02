package com.example.travelbackend.Controllers;


import com.example.travelbackend.Entity.Transportation;
import com.example.travelbackend.Service.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TransportationController {

    @Autowired
    TransportationService transportationService;


    @RequestMapping("/AddT")
    public String addTransportation(Model model) {
        Transportation transportation = new Transportation();
        model.addAttribute("TransportationForm", transportation);
        return "new_transportation";
    }

    @RequestMapping(value = "/saveT", method = RequestMethod.POST)
    public String saveTransportation(@ModelAttribute("TransportationForm") Transportation transportation) {
        transportationService.CreateTransportation(transportation);
        return "redirect:/AllTransportations";
    }

    @RequestMapping("/AllT")
    public String ListTransportation(Model model) {
        List<Transportation> ListTransportaion= transportationService.getAllTransportaions();
        model.addAttribute("ListTransportation", ListTransportaion);
        return "list_transportation";
    }

    @GetMapping("deleteT/{id}")
    public String deleteTransportaion(@PathVariable("id") long id) {
        transportationService.deleteTransportation(id);
        return "redirect:/AllTransportations";
    }

    @GetMapping("/editT/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Transportation transportation=transportationService.getTransportationbyId(id);
        model.addAttribute("transportation", transportation);
        return "update_transportation";
    }

    @PostMapping("/updateT/{id}")
    public String updateTransportation(@PathVariable("id") long id, Transportation transportation) {
        transportationService.updateTransportation(transportation);
        return "redirect:/AllTransportations";
    }
}
