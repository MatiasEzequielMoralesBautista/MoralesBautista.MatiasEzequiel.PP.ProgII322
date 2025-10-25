package lab.proyectos;

public class Main {
    public static void main(String[] args) {
        SistemaRegistro reg = new SistemaRegistro();

        try {
            reg.agregarProyecto(new AnalisisEstadistico("Comportamiento de Usuarios", "DataLab-B", EstadoProyecto.EN_DESARROLLO, TipoAnalisis.PREDICTIVO));
            reg.agregarProyecto(new ModeloMachineLearning("Clasificador de Imagenes", "VisorTeam", EstadoProyecto.EN_DESARROLLO, 72.5));
            reg.agregarProyecto(new SistemaVisualizacion("Dash Ventas", "VizTeam", EstadoProyecto.EN_DESARROLLO, 5));

        } catch (ProyectoExistenteException ex) {
            System.out.println("Error al agregar: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println("Argumento invalido: " + ex.getMessage());
        }

        System.out.println("\n--- Mostrar proyectos ---");
        reg.mostrarProyectos();

        System.out.println("\n--- Actualizar resultados ---");
        reg.actualizarResultadosProyectos();

        System.out.println("\n--- Mostrar proyectos (despues de actualizar) ---");
        reg.mostrarProyectos();

        System.out.println("\n--- Actualizar estado a FINALIZADO ---");
        reg.actualizarEstadoProyectos(EstadoProyecto.FINALIZADO);

        System.out.println("\n--- Mostrar proyectos (final) ---");
        reg.mostrarProyectos();
    }
}
