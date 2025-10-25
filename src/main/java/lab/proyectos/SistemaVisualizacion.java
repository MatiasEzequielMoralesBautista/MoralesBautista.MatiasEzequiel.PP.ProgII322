package lab.proyectos;

public class SistemaVisualizacion extends Proyecto {
    private int cantidadGraficos;

    public SistemaVisualizacion(String nombre, String equipo, EstadoProyecto estado, int cantidadGraficos) {
        super(nombre, equipo, estado);
        if (cantidadGraficos <= 0) throw new IllegalArgumentException("cantidadGraficos debe ser > 0");
        this.cantidadGraficos = cantidadGraficos;
    }

    public int getCantidadGraficos() {
        return cantidadGraficos;
    }

    public void setCantidadGraficos(int cantidadGraficos) {
        if (cantidadGraficos <= 0) throw new IllegalArgumentException("cantidadGraficos debe ser > 0");
        this.cantidadGraficos = cantidadGraficos;
    }

    @Override
    public String toString() {
        return infoBasica() + String.format(" | Cantidad graficos: %d", cantidadGraficos);
    }
}
