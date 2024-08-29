package com.example.latihan_logging_metric.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "BUKU")
@Data
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "JUDUL")
    private String judul;

    @Column(name = "PENULIS")
    private String penulis;

    @Column(name = "TAHUN_TERBIT")
    private Integer tahunTerbit;
}
