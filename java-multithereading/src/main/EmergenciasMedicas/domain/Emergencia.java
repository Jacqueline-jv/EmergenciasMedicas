package EmergenciasMedicas.domain;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Emergencia implements Comparable<Emergencia> {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private final String ubicacion;
    private final NivelGravedad gravedad;
    private final LocalDateTime horaLlamada;

    // Recursos asignados
    private Ambulancia ambulancia;
    private Medico medico;
    private EquipoMedico equipoMedico;

    public Emergencia(String ubicacion, NivelGravedad gravedad) {
        this.id = count.incrementAndGet();
        this.ubicacion = ubicacion;
        this.gravedad = gravedad;
        this.horaLlamada = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public NivelGravedad getGravedad() {
        return gravedad;
    }

    public LocalDateTime getHoraLlamada() {
        return horaLlamada;
    }

    // Setters
    public void setAmbulancia(Ambulancia ambulancia) {
        this.ambulancia = ambulancia;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setEquipoMedico(EquipoMedico equipoMedico) {
        this.equipoMedico = equipoMedico;
    }

    // Getters
    public Ambulancia getAmbulancia() {
        return ambulancia;
    }

    public Medico getMedico() {
        return medico;
    }

    public EquipoMedico getEquipoMedico() {
        return equipoMedico;
    }

    // Ordenar emergencias por prioridad y luego por hora
    @Override
    public int compareTo(Emergencia otra) {
        int comparacion = Integer.compare(otra.gravedad.getPrioridad(), this.gravedad.getPrioridad());
        if (comparacion == 0) {
            return this.horaLlamada.compareTo(otra.horaLlamada);
        }
        return comparacion;
    }

    @Override
    public String toString() {
        return "Emergencia #" + id + " [" + gravedad + "] en " + ubicacion +
                " a las " + horaLlamada +
                (ambulancia != null ? ", Ambulancia: " + ambulancia.getId() : "") +
                (medico != null ? ", Médico: " + medico.getId() : "") +
                (equipoMedico != null ? ", Equipo: " + equipoMedico.getId() : "");
    }
}