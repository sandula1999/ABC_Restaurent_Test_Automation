package com.example.Hotel_Reservation_System.Service;

import com.example.Hotel_Reservation_System.Entity.ResturantT;
import com.example.Hotel_Reservation_System.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public ResturantT addTable(ResturantT resturantT) {
        return tableRepository.save(resturantT);
    }

    public List<ResturantT> getAllTables() {
        return tableRepository.findAll();
    }

    public Optional<ResturantT> getTableById(Long id) {
        return tableRepository.findById(id);
    }

    public ResturantT updateTable(Long id, ResturantT updatedResturantT) {
        return tableRepository.findById(id).map(table -> {
            table.setCapacity(updatedResturantT.getCapacity());
            table.setAvailable(updatedResturantT.isAvailable());
            table.setType(updatedResturantT.getType());
            return tableRepository.save(table);
        }).orElseThrow(() -> new ResourceNotFoundException("Table not found with id: " + id));
    }

    public void deleteTable(Long id) {
        tableRepository.deleteById(id);
    }
}
