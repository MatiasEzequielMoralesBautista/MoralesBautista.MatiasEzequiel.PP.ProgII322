package lab.proyectos;

public class ModeloMachineLearning extends Proyecto implements Actualizable {
    private double porcentajePrecision;

    public ModeloMachineLearning(String nombre, String equipo, EstadoProyecto estado, double porcentajePrecision) {
        super(nombre, equipo, estado);
        this.porcentajePrecision = Math.max(0, Math.min(100, porcentajePrecision));
    }

    public double getPorcentajePrecision() {
        return porcentajePrecision;
    }

    public void setPorcentajePrecision(double p) {
        this.porcentajePrecision = Math.max(0, Math.min(100, p));
    }

    @Override
    public void actualizarResultados() {
        if (porcentajePrecision < 100) {
            double nueva = porcentajePrecision + 5.0;
            if (nueva > 100) nueva = 100;
            System.out.printf("Actualizando ML '%s': %.1f -> %.1f%n", nombre, porcentajePrecision, nueva);
            porcentajePrecision = nueva;
            if (estadoActual == EstadoProyecto.EN_DESARROLLO) {
                estadoActual = EstadoProyecto.ENTRENANDO_MODELO;
            }
        } else {
            System.out.printf("Modelo '%s' ya tiene 100%% de precision.%n", nombre);
        }
    }

    @Override
    public String toString() {
        return infoBasica() + String.format(" | Precision: %.1f%%", porcentajePrecision);
    }
}
