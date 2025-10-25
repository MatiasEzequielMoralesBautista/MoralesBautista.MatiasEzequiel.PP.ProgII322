package lab.proyectos;

import java.util.ArrayList;
import java.util.List;

public class SistemaRegistro {
    private List<Proyecto> proyectos;

    public SistemaRegistro() {
        proyectos = new ArrayList<>();
    }

    public void agregarProyecto(Proyecto proyecto) throws ProyectoExistenteException {
        for (Proyecto p : proyectos) {
            if (p.getNombre().equalsIgnoreCase(proyecto.getNombre())
                    && p.getEquipoResponsable().equalsIgnoreCase(proyecto.getEquipoResponsable())) {
                throw new ProyectoExistenteException("Ya existe un proyecto con ese nombre y equipo responsable.");
            }
        }
        proyectos.add(proyecto);
        System.out.println("Proyecto agregado: " + proyecto.getNombre() + " (" + proyecto.getEquipoResponsable() + ")");
    }

    public void mostrarProyectos() {
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos registrados.");
            return;
        }
        System.out.println("Listado de proyectos:");
        for (Proyecto p : proyectos) {
            System.out.println(p.toString());
        }
    }

    public void actualizarResultadosProyectos() {
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos para actualizar.");
            return;
        }
        for (Proyecto p : proyectos) {
            if (p instanceof Actualizable) {
                ((Actualizable) p).actualizarResultados();
            } else {
                System.out.printf("El proyecto '%s' (visualizacion) no puede actualizarse con este método.%n", p.getNombre());
            }
        }
    }

    public void actualizarEstadoProyectos(EstadoProyecto nuevoEstado) {
        if (nuevoEstado == null) {
            System.out.println("No se indico un nuevo estado (nulo).");
            return;
        }
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos registrados.");
            return;
        }

        int modificados = 0;
        for (Proyecto p : proyectos) {
            EstadoProyecto viejo = p.getEstadoActual();
            if (viejo != nuevoEstado) {
                p.setEstadoActual(nuevoEstado);
                System.out.printf("Proyecto '%s': %s -> %s%n", p.getNombre(), viejo, nuevoEstado);
                modificados++;
            }
        }
        if (modificados == 0) {
            System.out.println("No se realizo ninguna modificacion.");
        } else {
            System.out.printf("Total de proyectos modificados: %d%n", modificados);
        }
    }
}
