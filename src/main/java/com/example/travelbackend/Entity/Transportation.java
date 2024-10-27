package com.example.travelbackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Transportation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long id ;
    private Date typeTransport ;
    private Date duration ;
    private Long price ;

    @ManyToOne
    @JoinColumn(name = "itinerary")
    private Itinerary itinerary ;
}
