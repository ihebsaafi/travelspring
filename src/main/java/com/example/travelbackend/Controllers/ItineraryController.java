package com.example.travelbackend.Controllers;


import com.example.travelbackend.Entity.Itinerary;
import com.example.travelbackend.Service.ItinerayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ItineraryController {

    @Autowired
    ItinerayService itinerayService;


    @RequestMapping("/AddIt")
    public String addItinerary(Model model) {
        Itinerary itinerary = new Itinerary();
        model.addAttribute("ItineraryForm", itinerary);
        return "new_itinerary";
    }

    @RequestMapping(value = "/saveIT", method = RequestMethod.POST)
    public String saveItinerary(@ModelAttribute("ItineraryForm") Itinerary itinerary) {
        itinerayService.CreateItinerary(itinerary);
        return "redirect:/AllItineraries";
    }

    @RequestMapping("/AllIt")
    public String ListItinerary(Model model) {
        List<Itinerary> ListItineraies= itinerayService.getAllItinerary();
        model.addAttribute("ListItineraries", ListItineraies);
        return "list_itineraries";
    }

    @GetMapping("deleteIt/{id}")
    public String deleteItinerary(@PathVariable("id") long id) {
        itinerayService.deleteItinerary(id);
        return "redirect:/AllItineraries";
    }

    @GetMapping("/editIt/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Itinerary itinerary=itinerayService.getItinerarybyId(id);
        model.addAttribute("itinerary", itinerary);
        return "update_itinerary";
    }

    @PostMapping("/updateIt/{id}")
    public String updateItinerary(@PathVariable("id") long id, Itinerary itinerary) {
        itinerayService.updateItinerary(itinerary);
        return "redirect:/AllItineraries";
    }
}
