package com.example.travelbackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Itinerary {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long id ;
    private Date dateD ;
    private Date dateF ;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user ;

    @OneToMany(mappedBy = "itinerary")
    private List<Accomodation> accomodations ;

    @OneToMany(mappedBy = "itinerary")
    private List<Transportation> transportations ;

    @OneToMany(mappedBy = "itinerary")
    private List<Activity> activities ;



}
