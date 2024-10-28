package com.example.travelbackend.Service;

import com.example.travelbackend.Entity.User;
import com.example.travelbackend.repository.Itinerary;
import com.example.travelbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ItinerayService {

    @Autowired
    Itinerary itinerary;

    public Itinerary CreateItinerary(Itinerary itinerary) {
        return itinerary.save(itinerary) ;
    }
    public Itinerary updateItinerary(Itinerary user) {
        return itinerary.save(user) ;
    }
    public void deleteItinerary(Long id) {itinerary.deleteById(id);}
    public Itinerary getItinerarybyId(Long id) {return itinerary.findById(id).get();}
    public List<Itinerary> getAllItinerary() {return itinerary.findAll();}
}
