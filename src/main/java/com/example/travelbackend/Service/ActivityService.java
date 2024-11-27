package com.example.travelbackend.Service;



import com.example.travelbackend.Entity.Activity;
import com.example.travelbackend.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public Activity CreateActivity(Activity activity) {
        return activityRepository.save(activity) ;
    }
    public Activity updateActivity(Activity activity) {
        return activityRepository.save(activity) ;
    }
    public void deleteActivity(Long id) {activityRepository.deleteById(id);}
    public Activity getActivitybyId(Long id) {return activityRepository.findById(id).get();}
    public List<Activity> getAllActivity() {return activityRepository.findAll();}
}
