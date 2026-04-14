package com.Taskflow.EvaluacionParcialEA1.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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
        Optional<Tarea> optTarea = listaTareas.stream().filter(t -> t.getId().equals(id)).findFirst();
        return optTarea.get();
    }

    public void save(Tarea t){
        t.setFechaCreacion(LocalDate.now());
        listaTareas.add(t);
    }

    public int  updateEstado(Long id, int opc){
        for(int i = 0; i < listaTareas.size(); i++){
            if(listaTareas.get(i).getId().equals(id)){
                switch(opc){
                    default: return 2;
                    case 1: listaTareas.get(i).setEstado(estado.PENDIENTE);
                    case 2: listaTareas.get(i).setEstado(estado.EN_PROGRESO);
                    case 3: listaTareas.get(i).setEstado(estado.COMPLETADA);
                    case 4: listaTareas.get(i).setEstado(estado.CANCELADA);
                    return 1;
                }
            }
        }
        return 0;
    }

    public boolean delete(Long id){
        return listaTareas.removeIf(t -> t.getId().equals(id));
    }

    public List<Tarea> filtrarEstado(String e){
        Stream<Tarea> streamTarea = listaTareas.stream().filter(t -> t.getEstado().toString().equals(e));
        return streamTarea.toList();
    }
}
