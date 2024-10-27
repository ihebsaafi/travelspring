package com.example.travelbackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long id ;
    private String name ;
    private String description ;
    private Long price ;
    private Date duration ;

    @ManyToOne
    @JoinColumn(name = "itinerary")
    private Itinerary itinerary ;

}
