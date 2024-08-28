package com.example.latihan_rest_buku.services;

import com.example.latihan_rest_buku.entity.Buku;
import com.example.latihan_rest_buku.entity.BukuRequest;
import com.example.latihan_rest_buku.repository.BukuRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class BukuService {
    @Autowired
    private BukuRepository bukuRepository;

    public List<Buku> getAll(){
        return bukuRepository.findAll();
    }

    public ResponseEntity<Buku> getById(Long id){
        Optional<Buku> buku = bukuRepository.findById(id);
        if (buku.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(buku.get(), HttpStatus.OK);
    }

    public ResponseEntity<Buku> save(BukuRequest request){
        Buku buku = new Buku();
        buku.setJudul(request.getJudul());
        buku.setPenulis(request.getPenulis());
        buku.setTahunTerbit(request.getTahunTerbit());
        Buku bukuSaved = bukuRepository.save(buku);
        return new ResponseEntity<>(bukuSaved, HttpStatus.CREATED);
    }

    public ResponseEntity<Buku> update(Long id, BukuRequest request){
        Optional<Buku> buku = bukuRepository.findById(id);
        if (buku.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        buku.get().setJudul(request.getJudul());
        buku.get().setPenulis(request.getPenulis());
        buku.get().setTahunTerbit(request.getTahunTerbit());

        return new ResponseEntity<>(bukuRepository.save(buku.get()), HttpStatus.OK);
    }

    public ResponseEntity<Buku> delete(Long id){
        Optional<Buku> buku = bukuRepository.findById(id);
        if (buku.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bukuRepository.deleteById(id);

        return new ResponseEntity<>(buku.get(), HttpStatus.OK);
    }
}
