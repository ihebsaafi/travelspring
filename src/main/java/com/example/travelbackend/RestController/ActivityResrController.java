package com.example.travelbackend.RestController;

import com.example.travelbackend.Entity.Activity;
import com.example.travelbackend.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")

public class ActivityResrController {
    @Autowired
    ActivityService activityService;

    @PostMapping("/save")
    public Activity saveActivity(@RequestBody Activity activity) {
        return activityService.CreateActivity(activity);
    }

    @GetMapping("/allActivity")
    public List<Activity> getAllActivities() {

        return activityService.getAllActivity();
    }
    @GetMapping("/getone/{id}")
    public Activity getActivity(@PathVariable Long id) {
        return activityService.getActivitybyId(id);
    }
    @PutMapping("/updateAcrtivity/{id}")
    public Activity updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
        Activity act= activityService.getActivitybyId(id);
        if(act!=null) {
            activity.setId(id);
            return activityService.updateActivity(activity);
        }
        else {
            throw new RuntimeException("not found");}
    }
    @DeleteMapping("/activity/{id}")
    public ResponseEntity<HttpStatus> deleteActivity(@PathVariable("id") Long id) {
        try{
            activityService.deleteActivity(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
