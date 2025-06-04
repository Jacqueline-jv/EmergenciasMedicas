package EmergenciasMedicas.domain;

public class Medico extends Recurso {
    private final String nombre;

    public Medico(String id, String nombre) {
        super(id);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Médico #" + getId() + " " + nombre + " - " + getEstado();
    }
}

