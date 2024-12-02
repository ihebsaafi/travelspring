package com.example.travelbackend.Controllers;

import com.example.travelbackend.Entity.Activity;
import com.example.travelbackend.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller

public class ActivityController {

    @Autowired
    ActivityService activityService;


    @RequestMapping("/AddAct")
    public String addActivity(Model model) {
        Activity activity = new Activity();
        model.addAttribute("ActivityForm", activity);
        return "new_activity";
    }

    @RequestMapping(value = "/saveAct", method = RequestMethod.POST)
    public String saveActivity(@ModelAttribute("ActivityForm") Activity activity) {
        activityService.CreateActivity(activity);
        return "redirect:/AllActivities";
    }

    @RequestMapping("/AllAct")
    public String ListActivity(Model model) {
        List<Activity> ListActivities= activityService.getAllActivity();
        model.addAttribute("ListActivities", ListActivities);
        return "liste_activities";
    }

    @GetMapping("deleteAct/{id}")
    public String deleteActivity(@PathVariable("id") long id) {
        activityService.deleteActivity(id);
        return "redirect:/AllActivities";
    }

    @GetMapping("/editAct/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Activity activity=activityService.getActivitybyId(id);
        model.addAttribute("activity", activity);
        return "update_activity";
    }

    @PostMapping("/updateAct/{id}")
    public String updateActivity(@PathVariable("id") long id, Activity activity) {
        activityService.updateActivity(activity);
        return "redirect:/AllActivities";
    }

}
