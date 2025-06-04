package EmergenciasMedicas.domain;

public enum NivelGravedad {
    CRITICO(100),
    GRAVE(75),
    MODERADO(50),
    LEVE(25);

    private final int prioridad;

    NivelGravedad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }
}




