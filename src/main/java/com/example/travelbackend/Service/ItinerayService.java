package com.example.travelbackend.Service;

import com.example.travelbackend.Entity.Itinerary;
import com.example.travelbackend.Entity.User;
import com.example.travelbackend.repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItinerayService {

    @Autowired
    ItineraryRepository itineraryRepository;

    public Itinerary CreateItinerary(Itinerary itinerary) {
        return itineraryRepository.save(itinerary) ;
    }
    public Itinerary updateItinerary(Itinerary itinerary) {
        return itineraryRepository.save(itinerary) ;
    }
    public void deleteItinerary(Long id) {itineraryRepository.deleteById(id);}
    public Itinerary getItinerarybyId(Long id) {return itineraryRepository.findById(id).get();}
    public List<Itinerary> getAllItinerary() {return itineraryRepository.findAll();}
}
