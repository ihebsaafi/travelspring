package com.example.travelbackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
    public class User {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private  Long id ;
        private String name ;
        private String phone ;
        private String age ;
        private String email;
        private String password ;

    @OneToMany(mappedBy = "user")
    private List<Itinerary> Itinerarys ;
    }

