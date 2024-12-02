package com.example.travelbackend.RestController;

import com.example.travelbackend.Entity.Itinerary;
import com.example.travelbackend.Service.ItinerayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itinerary")
public class ItineraryRestController {
        @Autowired
        ItinerayService itineraryService;

        @PostMapping("/save")
        public Itinerary saveItinerary(@RequestBody Itinerary itinerary) {
            return itineraryService.CreateItinerary(itinerary);
        }

        @GetMapping("/all")
        public List<Itinerary> getAllItinerays() {

            return itineraryService.getAllItinerary();
        }
        @GetMapping("/getone/{id}")
        public Itinerary getItinerary(@PathVariable Long id) {
            return itineraryService.getItinerarybyId(id);
        }
        @PutMapping("/update/{id}")
        public Itinerary updateItinerary(@PathVariable Long id, @RequestBody Itinerary itinerary) {
            Itinerary it= itineraryService.getItinerarybyId(id);
            if(it!=null) {
                itinerary.setId(id);
                return itineraryService.updateItinerary(itinerary);
            }
            else {
                throw new RuntimeException("not found");}
        }
        @DeleteMapping("/itinerary/{id}")
        public ResponseEntity<HttpStatus> deleteItinerary(@PathVariable("id") Long id) {
            try{
                itineraryService.deleteItinerary(id);
                return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
            } catch (Exception e){
                return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
