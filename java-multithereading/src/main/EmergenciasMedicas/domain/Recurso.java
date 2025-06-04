package EmergenciasMedicas.domain;

public abstract class Recurso {
    private String id;
    private EstadoRecurso estado;

    public Recurso(String id) {
        this.id = id;
        this.estado = EstadoRecurso.DISPONIBLE;
    }

    public String getId() {
        return id;
    }

    public EstadoRecurso getEstado() {
        return estado;
    }

    public void setEstado(EstadoRecurso estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id='" + id + '\'' +
                ", estado=" + estado +
                '}';
    }
}