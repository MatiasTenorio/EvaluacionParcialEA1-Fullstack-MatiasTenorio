package com.Taskflow.EvaluacionParcialEA1.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Taskflow.EvaluacionParcialEA1.model.Tarea;
import com.Taskflow.EvaluacionParcialEA1.model.estado;
import com.Taskflow.EvaluacionParcialEA1.repository.TareaRepository;

@Service
public class TareaService {
    @Autowired
    private TareaRepository repository;
    
    public List<Tarea> getTareas(){
        return repository.getTareas();
    }
    
    public Tarea getIdTarea(Long id) {
        return repository.getIdTarea(id);
    }

    public void save(Tarea t){
        t = new Tarea();
        t.setFechaCreacion(LocalDate.now());
        repository.save(t);
    }

    public boolean updateEstado(Long id){
        return repository.updateEstado(id);
    }

    public void delete(Long id){
        repository.delete(id);
    }

    public Tarea filtrarEstado(estado e){
        return repository.filtrarEstado(e);
    }
}
