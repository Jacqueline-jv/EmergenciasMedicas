package EmergenciasMedicas.logic;

import EmergenciasMedicas.data.ConcurrentPriorityQueue;
import EmergenciasMedicas.data.ResourceManager;
import EmergenciasMedicas.domain.Emergencia;
import EmergenciasMedicas.domain.Ambulancia;
import EmergenciasMedicas.domain.Medico;
import EmergenciasMedicas.domain.EquipoMedico;

public class AsignadorRecursos {

    private final ConcurrentPriorityQueue<Emergencia> colaEmergencias;
    private final ResourceManager resourceManager;

    public AsignadorRecursos(ConcurrentPriorityQueue<Emergencia> colaEmergencias, ResourceManager resourceManager) {
        this.colaEmergencias = colaEmergencias;
        this.resourceManager = resourceManager;
    }

    /**
     * Asigna recursos de forma segura y registra el resultado.
     */
    public void asignarRecursos(Emergencia emergencia) {
        synchronized (this) {
            try {
                Ambulancia ambulancia = resourceManager.obtenerAmbulancia();
                Medico medico = resourceManager.obtenerMedico();
                EquipoMedico equipo = resourceManager.obtenerEquipoMedico();

                if (ambulancia != null) {
                    emergencia.setAmbulancia(ambulancia);
                } else {
                    System.err.println("No hay ambulancias disponibles para: " + emergencia);
                }

                if (medico != null) {
                    emergencia.setMedico(medico);
                } else {
                    System.err.println("No hay médicos disponibles para: " + emergencia);
                }

                if (equipo != null) {
                    emergencia.setEquipoMedico(equipo);
                } else {
                    System.err.println("No hay equipos médicos disponibles para: " + emergencia);
                }

                System.out.println("Recursos asignados a: " + emergencia);

                // 🔔 Aquí podrías notificar a observadores si usas Observer/PubSub
                // notificarObservadores(emergencia);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error al asignar recursos: " + e.getMessage());
            }
        }
    }

    // Ejemplo de punto de extensión si implementas patrón Observer:
    /*
    private void notificarObservadores(Emergencia emergencia) {
        // lógica para notificar componentes registrados
    }
    */
}