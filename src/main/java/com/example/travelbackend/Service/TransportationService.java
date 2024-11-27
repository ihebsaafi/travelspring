package com.example.travelbackend.Service;
import com.example.travelbackend.Entity.Transportation;
import com.example.travelbackend.repository.TransportationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransportationService {

    @Autowired
    TransportationRepository transportationRepository;

    public Transportation CreateTransportation(Transportation transportation) {return transportationRepository.save(transportation) ;}
    public Transportation updateTransportation(Transportation transportation) {
        return transportationRepository.save(transportation) ;
    }
    public void deleteTransportation(Long id) {transportationRepository.deleteById(id);}
    public Transportation getTransportationbyId(Long id) {return transportationRepository.findById(id).get();}
    public List<Transportation> getAllTransportaions() {return transportationRepository.findAll();}
}
