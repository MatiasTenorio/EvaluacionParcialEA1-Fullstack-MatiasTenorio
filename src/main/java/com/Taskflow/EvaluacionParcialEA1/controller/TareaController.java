package com.Taskflow.EvaluacionParcialEA1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Taskflow.EvaluacionParcialEA1.model.Tarea;
import com.Taskflow.EvaluacionParcialEA1.model.estado;
import com.Taskflow.EvaluacionParcialEA1.service.TareaService;

@RequestMapping("api/tareas")
public class TareaController {
    @Autowired
    private TareaService service;
    
    @GetMapping("api/tareas/")
    public List<Tarea> getTareas(){
        return service.getTareas();
    }

    @GetMapping("api/tareas/{id}")
    public Tarea getIdTarea(Long id){
        return service.getIdTarea(id);
    }

    @PostMapping("api/tareas")
    public void save(Tarea t){
        service.save(t);
    }

    @PutMapping("api/tareas/{id}")
    public boolean updateEstado(Long id){
        return service.updateEstado(id);
    }

    @DeleteMapping("api/tareas/{id}")
    public void delete(Long id){
        service.delete(id);
    }

    @GetMapping("api/tarea/estado/{estado}")
    public Tarea filtrarEstado(estado e){
        return service.filtrarEstado(e);
    }
}