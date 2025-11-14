package com.utn.tareas.repository;

import com.utn.tareas.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {
    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(0);

    public TareaRepository(){
        save(new Tarea(null,"Limpiar los pisos", false, Prioridad.ALTA));
        save(new Tarea(null,"Lavar los platos", false, Prioridad.MEDIA));
        save(new Tarea(null,"Sacar la basura", false, Prioridad.BAJA));
        save(new Tarea(null,"Pasear al perro", true, Prioridad.MEDIA));
        save(new Tarea(null,"Terminar el TP de Desarrollo", false, Prioridad.ALTA));
    }

    public List<Tarea> findAll() {
        return new ArrayList<>(tareas);
    }

    public Optional<Tarea> findById(Long id) {
        return tareas.stream()
                .filter(tarea -> tarea.getId().equals(id))
                .findFirst();
    }

    public Tarea save(Tarea tarea) {
        long nuevoId = contadorId.incrementAndGet();
        tarea.setId(nuevoId);
        tareas.add(tarea);
        return tarea;
    }

    public void deleteById(Long id) {
        tareas.removeIf(tarea -> tarea.getId().equals(id));
    }
}
