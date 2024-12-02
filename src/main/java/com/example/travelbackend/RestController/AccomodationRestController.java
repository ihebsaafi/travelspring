package com.example.travelbackend.RestController;


import com.example.travelbackend.Entity.Accomodation;
import com.example.travelbackend.Service.AccomodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accomodation")
public class AccomodationRestController {
    @Autowired
    AccomodationService accomodationService;

    @PostMapping("/save")
    public Accomodation saveAccomodation(@RequestBody Accomodation accomodation) {
        return accomodationService.CreateAccomodation(accomodation);
    }

    @GetMapping("/all")
    public List<Accomodation> getAllAccomodations() {

        return accomodationService.getAllAccomodations();
    }
    @GetMapping("/getone/{id}")
    public Accomodation getAccomodation(@PathVariable Long id) {
        return accomodationService.getAccomodationbyId(id);
    }
    @PutMapping("/update/{id}")
    public Accomodation updateAccomodation(@PathVariable Long id, @RequestBody Accomodation accomodation) {
        Accomodation acc= accomodationService.getAccomodationbyId(id);
        if(acc!=null) {
            accomodation.setId(id);
            return accomodationService.updateAccomodation(accomodation);
        }
        else {
            throw new RuntimeException("not found");}
    }
    @DeleteMapping("/accomodation/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        try{
            accomodationService.deleteAccomodation(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
