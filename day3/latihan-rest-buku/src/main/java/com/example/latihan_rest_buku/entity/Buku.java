package com.example.latihan_rest_buku.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "buku")
@Data
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "judul")
    private String judul;

    @Column(name = "penulis")
    private String penulis;

    @Column(name = "tahun_terbit")
    private Integer tahunTerbit;
}
