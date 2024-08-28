package com.example.latihan_rest_buku.repository;

import com.example.latihan_rest_buku.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BukuRepository extends JpaRepository<Buku, Long> {

}
