package EmergenciasMedicas.domain;

public class EquipoMedico extends Recurso {
    private final String tipo;

    public EquipoMedico(String id, String tipo) {
        super(id);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Equipo #" + getId() + " (" + tipo + ") - " + getEstado();
    }
}

