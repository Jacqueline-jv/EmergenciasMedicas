package EmergenciasMedicas.domain;

public class Ambulancia extends Recurso {
    private final String placa;

    public Ambulancia(String id, String placa) {
        super(id);
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public String toString() {
        return "Ambulancia #" + getId() + " [" + placa + "] - " + getEstado();
    }
}


