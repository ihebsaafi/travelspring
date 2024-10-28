package com.example.travelbackend.Service;

import com.example.travelbackend.Entity.Accomodation;
import com.example.travelbackend.Entity.User;
import com.example.travelbackend.repository.AccomodationRepository;
import com.example.travelbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AccomodationService {

        @Autowired
        AccomodationRepository accomodationRepository;

        public Accomodation CreateAccomodation(Accomodation accomodation) {
            return accomodationRepository.save(accomodation) ;
        }
        public Accomodation updateAccomodation(Accomodation accomodationr) {
            return accomodationRepository.save(accomodationr) ;
        }
        public void deleteAccomodation(Long id) {accomodationRepository.deleteById(id);}
        public Accomodation getAccomodationbyId(Long id) {return accomodationRepository.findById(id).get();}
        public List<Accomodation> getAllAccomodations() {return accomodationRepository.findAll();}
}
