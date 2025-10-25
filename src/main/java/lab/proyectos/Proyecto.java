package lab.proyectos;

public abstract class Proyecto {
    protected String nombre;
    protected String equipoResponsable;
    protected EstadoProyecto estadoActual;

    public Proyecto(String nombre, String equipoResponsable, EstadoProyecto estadoActual) {
        this.nombre = nombre;
        this.equipoResponsable = equipoResponsable;
        this.estadoActual = estadoActual;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEquipoResponsable() {
        return equipoResponsable;
    }

    public EstadoProyecto getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoProyecto nuevo) {
        this.estadoActual = nuevo;
    }

    public String infoBasica() {
        return String.format("Nombre: %s | Equipo: %s | Estado: %s",
                nombre, equipoResponsable, estadoActual);
    }
}
