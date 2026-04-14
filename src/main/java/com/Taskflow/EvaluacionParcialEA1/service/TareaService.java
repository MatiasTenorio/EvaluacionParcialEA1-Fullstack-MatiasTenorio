package com.Taskflow.EvaluacionParcialEA1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Taskflow.EvaluacionParcialEA1.model.Tarea;
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

    public boolean save(Tarea nuevaTarea){
         boolean limiteTitulo = true;
         if (nuevaTarea.getTitulo().length() > 100) {
            limiteTitulo = false;
         } else {repository.save(nuevaTarea);}
         return limiteTitulo;
    }

    public int updateEstado(Long id, int e){
        return repository.updateEstado(id,e);
    }

    public boolean delete(Long id){
        return repository.delete(id);
    }

    public List<Tarea> filtrarEstado(String e){
        return repository.filtrarEstado(e);
    }
}
