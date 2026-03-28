package com.raj.medicall.controller;

import com.raj.medicall.entity.Medicine;
import com.raj.medicall.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medi")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;
    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMedicine(){
        return ResponseEntity.ok(medicineService.getAll());
    }

    @DeleteMapping("/{id}")
    public String removeMedicine(@PathVariable Long id){
        return medicineService.remove(id);
    }
}
