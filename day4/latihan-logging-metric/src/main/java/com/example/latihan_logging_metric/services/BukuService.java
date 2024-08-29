package com.example.latihan_logging_metric.services;

import com.example.latihan_logging_metric.entity.Buku;
import com.example.latihan_logging_metric.entity.BukuRequest;
import com.example.latihan_logging_metric.repository.BukuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BukuService {
    @Autowired
    private BukuRepository bukuRepository;

    public List<Buku> getAll(){
        log.info("getAll Service Start");
        return bukuRepository.findAll();
    }

    public ResponseEntity<Buku> getById(Long id){
        log.info("getById Service Start");
        Optional<Buku> buku = bukuRepository.findById(id);
        if (buku.isEmpty()) {
            log.error("Buku id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(buku.get(), HttpStatus.OK);
    }

    public ResponseEntity<Buku> save(BukuRequest request){
        log.info("save Service Start");
        Buku buku = new Buku();
        buku.setJudul(request.getJudul());
        buku.setPenulis(request.getPenulis());
        buku.setTahunTerbit(request.getTahunTerbit());
        Buku bukuSaved = bukuRepository.save(buku);
        return new ResponseEntity<>(bukuSaved, HttpStatus.CREATED);
    }

    public ResponseEntity<Buku> update(Long id, BukuRequest request){
        log.info("update Service Start");
        Optional<Buku> buku = bukuRepository.findById(id);
        if (buku.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        buku.get().setJudul(request.getJudul());
        buku.get().setPenulis(request.getPenulis());
        buku.get().setTahunTerbit(request.getTahunTerbit());

        log.debug("Updated book: {}", buku.get().getJudul());

        return new ResponseEntity<>(bukuRepository.save(buku.get()), HttpStatus.OK);
    }

    public ResponseEntity<Buku> delete(Long id){
        log.info("delete Service Start");
        Optional<Buku> buku = bukuRepository.findById(id);
        if (buku.isEmpty()) {
            log.error("Buku id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.debug("Deleted book: {}", buku.get().getJudul());
        bukuRepository.deleteById(id);

        return new ResponseEntity<>(buku.get(), HttpStatus.OK);
    }
}
