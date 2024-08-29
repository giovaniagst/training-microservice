package com.example.latihan_logging_metric.controller;

import com.example.latihan_logging_metric.entity.Buku;
import com.example.latihan_logging_metric.entity.BukuRequest;
import com.example.latihan_logging_metric.services.BukuService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class BukuController {
    @Autowired
    private BukuService bukuService;

    @GetMapping("/api/buku")
    public List<Buku> getAllBuku(){
        return bukuService.getAll();
    }

    @GetMapping("/api/buku/{id}")
    public ResponseEntity<Buku> getBukuById(@PathVariable Long id){
        return bukuService.getById(id);
    }

    @PostMapping("/api/buku")
    public ResponseEntity<Buku> createBuku(@Valid @RequestBody BukuRequest buku, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.error("Validation Error: {}", bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(null);
        }
        return bukuService.save(buku);
    }

    @PutMapping("/api/buku/{id}")
    public ResponseEntity<Buku> updateBuku(@PathVariable Long id, @RequestBody @Valid BukuRequest bukuRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("Validation Error: {}", bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(null);
        }

        return bukuService.update(id, bukuRequest);
    }

    @DeleteMapping("/api/buku/{id}")
    public ResponseEntity<Buku> deleteBuku(@PathVariable Long id){
        return bukuService.delete(id);
    }
}
