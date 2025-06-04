package EmergenciasMedicas.logic;

import EmergenciasMedicas.data.ConcurrentPriorityQueue;
import EmergenciasMedicas.domain.Emergencia;

import java.util.List;

public class EmergenciaManager {

    private final ConcurrentPriorityQueue<Emergencia> colaEmergencias;

    public EmergenciaManager(ConcurrentPriorityQueue<Emergencia> colaEmergencias) {
        this.colaEmergencias = colaEmergencias;
    }

    public void registrarEmergencia(Emergencia emergencia) {
        colaEmergencias.enqueue(emergencia);
    }

    public Emergencia obtenerSiguienteEmergencia() {
        return colaEmergencias.dequeue();
    }

    public List<Emergencia> getEmergenciasPendientes() {
        return colaEmergencias.getAll(); // Necesitas implementar este método en la cola si no existe
    }

    public void obtenerRecursosDisponibles() {
        // Aquí puedes simular o imprimir recursos disponibles.
        // Por ahora lo dejamos como ejemplo fijo:
        System.out.println("🚑 Ambulancias disponibles: 3");
        System.out.println("👨‍⚕️ Médicos de emergencia: 5");
        System.out.println("🏥 Camas hospitalarias disponibles: 12");
    }
}