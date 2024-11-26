package com.example.Hotel_Reservation_System.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class ResturantT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    private int capacity;

    private boolean isAvailable;
    private String type;


}
