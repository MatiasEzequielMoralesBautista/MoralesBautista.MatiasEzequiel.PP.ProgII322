package lab.proyectos;

public class AnalisisEstadistico extends Proyecto implements Actualizable {
    private TipoAnalisis tipoAnalisis;
    private boolean resultadosActualizados = false;

    public AnalisisEstadistico(String nombre, String equipo, EstadoProyecto estado, TipoAnalisis tipoAnalisis) {
        super(nombre, equipo, estado);
        this.tipoAnalisis = tipoAnalisis;
    }

    public TipoAnalisis getTipoAnalisis() {
        return tipoAnalisis;
    }

    @Override
    public void actualizarResultados() {
        resultadosActualizados = true;
        System.out.printf("Actualizando analisis '%s' (tipo: %s). Resultado: listo.%n", nombre, tipoAnalisis);
    }

    @Override
    public String toString() {
        return infoBasica() + String.format(" | Tipo Analisis: %s | Resultados actualizados: %s",
                tipoAnalisis, resultadosActualizados ? "Sí" : "No");
    }
}
