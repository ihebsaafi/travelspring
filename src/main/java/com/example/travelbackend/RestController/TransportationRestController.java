package com.example.travelbackend.RestController;


import com.example.travelbackend.Entity.Transportation;
import com.example.travelbackend.Service.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportation")
public class TransportationRestController {
        @Autowired
        TransportationService transportationService;

        @PostMapping("/save")
        public Transportation saveTransportation(@RequestBody Transportation transportation) {
            return transportationService.CreateTransportation(transportation);
        }

        @GetMapping("/all")
        public List<Transportation> getAllTransportations() {

            return transportationService.getAllTransportaions();
        }
        @GetMapping("/getone/{id}")
        public Transportation getTransportation(@PathVariable Long id) {
            return transportationService.getTransportationbyId(id);
        }
        @PutMapping("/update/{id}")
        public Transportation updateTransportation(@PathVariable Long id, @RequestBody Transportation transportation) {
            Transportation tra= transportationService.getTransportationbyId(id);
            if(tra!=null) {
                transportation.setId(id);
                return transportationService.updateTransportation(transportation);
            }
            else {
                throw new RuntimeException("not found");}
        }
        @DeleteMapping("/transportation/{id}")
        public ResponseEntity<HttpStatus> deleteTransportaion(@PathVariable("id") Long id) {
            try{
                transportationService.deleteTransportation(id);
                return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
            } catch (Exception e){
                return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
