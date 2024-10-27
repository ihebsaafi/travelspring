package com.example.travelbackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Accomodation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long id ;
    private String name ;
    private String location ;
    private Long price ;

    @ManyToOne
    @JoinColumn(name = "itinerary")
    private Itinerary itinerary ;

}
