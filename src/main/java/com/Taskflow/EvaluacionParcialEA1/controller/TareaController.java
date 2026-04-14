package com.Taskflow.EvaluacionParcialEA1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Taskflow.EvaluacionParcialEA1.model.Tarea;
import com.Taskflow.EvaluacionParcialEA1.service.TareaService;

@RequestMapping("api/tareas")
public class TareaController {
    @Autowired
    private TareaService service;
    
    @GetMapping
    public ResponseEntity<List<Tarea>> getTareas(){
        return ResponseEntity.ok(service.getTareas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getIdTarea(@PathVariable Long id){
        return ResponseEntity.ok(service.getIdTarea(id));
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Tarea t){
        if (service.save(t)){
            service.save(t);
            return new ResponseEntity<>("Nueva Tarea creada con exito!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Nueva Tarea creada con exito!", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("api/tareas/{id}/{e}")
    public ResponseEntity<String> updateEstado(@PathVariable Long id, @PathVariable int e){
        switch(service.updateEstado(id, e)) {
            case 1: service.updateEstado(id, e); 
                    return ResponseEntity.ok("Tarea actualizada con exito");
            case 2: return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Estado invalido");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarea no encontrada");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(service.delete(id)){
            service.delete(id);
            return ResponseEntity.noContent().build();
    }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/estado/{e}")
    public List<Tarea> filtrarEstado(@PathVariable String e){
        return service.filtrarEstado(e);
    }
}