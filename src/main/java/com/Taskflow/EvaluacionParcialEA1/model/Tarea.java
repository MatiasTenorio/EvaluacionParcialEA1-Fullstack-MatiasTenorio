package com.Taskflow.EvaluacionParcialEA1.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarea {
    @NotNull
    private Long id;

    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;
    
    @NotNull
    private estado estado;

    @NotNull
    private prioridad prioridad;

    @NotBlank
    private String responsable;

    @NotNull
    private LocalDate fechaCreacion;

    @NotNull
    private LocalDate fechaMaxima;
}
