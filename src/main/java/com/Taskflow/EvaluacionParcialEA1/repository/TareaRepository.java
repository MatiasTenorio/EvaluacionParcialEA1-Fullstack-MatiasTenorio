package com.Taskflow.EvaluacionParcialEA1.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Taskflow.EvaluacionParcialEA1.model.Tarea;
import com.Taskflow.EvaluacionParcialEA1.model.estado;

@Repository
public class TareaRepository {
    private final List<Tarea> listaTareas = new ArrayList<>();

    public List<Tarea> getTareas(){
        return listaTareas;
    }

    public Tarea getIdTarea(Long id) {
        for (Tarea t:listaTareas){
            if(t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }

    public void save(Tarea t){
        listaTareas.add(t);
    }

    public boolean updateEstado(Long id){
        for (Tarea t : listaTareas) {
            if(t.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public void delete(Long id){
        for (Tarea t : listaTareas) {
            if (t.getId().equals(id)) {
                listaTareas.remove(t);
            }
        }
    }

    public Tarea filtrarEstado(estado e){
        for (Tarea t : listaTareas) {
            if (t.getEstado().equals(e)) {
                return t;
            }
        }
        return null;
    }
}
