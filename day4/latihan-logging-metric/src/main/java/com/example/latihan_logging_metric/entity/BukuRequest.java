package com.example.latihan_logging_metric.entity;

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
