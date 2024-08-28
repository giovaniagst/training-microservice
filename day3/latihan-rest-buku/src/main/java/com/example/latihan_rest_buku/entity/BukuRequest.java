package com.example.latihan_rest_buku.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BukuRequest {
    @NotBlank
    private String judul;

    @NotBlank
    private String penulis;

    @Min(value = 0)
    private Integer tahunTerbit;
}
