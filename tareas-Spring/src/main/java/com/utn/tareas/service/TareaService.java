package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TareaService {
    private final TareaRepository tareaRepository;

    @Value("${app.nombre}")
    private String appNombre;

    @Value("${app.max-tareas}")
    private int maxTareas;

    @Value("${app.mostrar-estadisticas}")
    private boolean mostrarEstadisticas;

    public TareaService(TareaRepository tareaRepository){
        this.tareaRepository= tareaRepository;
    }

    public Tarea agregarNuevaTarea(String descripcion, Prioridad prioridad) {
        if (tareaRepository.findAll().size() >= maxTareas) {
            throw new IllegalStateException("Se ha alcanzado el límite máximo de " + maxTareas + " tareas.");
        }
        Tarea nuevaTarea = new Tarea(null, descripcion, false, prioridad);
        return tareaRepository.save(nuevaTarea);
    }

    public List<Tarea> listarTodas() {
        return tareaRepository.findAll();
    }

    public List<Tarea> listarPendientes() {
        return tareaRepository.findAll().stream()
                .filter(tarea -> !tarea.isCompletada())
                .collect(Collectors.toList());
    }

    public List<Tarea> listarCompletadas() {
        return tareaRepository.findAll().stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    public Optional<Tarea> marcarComoCompletada(Long id) {
        Optional<Tarea> tareaOptional = tareaRepository.findById(id);
        if (tareaOptional.isPresent()) {
            Tarea tarea = tareaOptional.get();
            tarea.setCompletada(true);
        }
        return tareaOptional;
    }

    public String obtenerEstadisticas() {
        if (!mostrarEstadisticas) {
            return "Las estadísticas están desactivadas.";
        }

        List<Tarea> todas = listarTodas();
        long total = todas.size();
        long completadas = todas.stream().filter(Tarea::isCompletada).count();
        long pendientes = total - completadas;

        return String.format("Estadísticas: Total de tareas: %d, Completadas: %d, Pendientes: %d",
                total, completadas, pendientes);
    }

    public void imprimirConfiguracion() {
        System.out.println("--- Configuración de la Aplicación ---");
        System.out.println("Nombre de la App: " + appNombre);
        System.out.println("Límite máximo de tareas: " + maxTareas);
        System.out.println("Mostrar estadísticas: " + mostrarEstadisticas);
        System.out.println("------------------------------------");
    }
}
