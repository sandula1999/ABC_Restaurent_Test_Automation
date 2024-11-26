package com.example.Hotel_Reservation_System.Repository;

import com.example.Hotel_Reservation_System.Entity.ResturantT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<ResturantT, Long> {
}
