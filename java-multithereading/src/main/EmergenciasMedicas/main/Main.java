package EmergenciasMedicas.main;

import EmergenciasMedicas.data.ConcurrentPriorityQueue;
import EmergenciasMedicas.data.ResourceManager;
import EmergenciasMedicas.domain.Emergencia;
import EmergenciasMedicas.logic.AsignadorRecursos;
import EmergenciasMedicas.logic.EmergenciaManager;
import EmergenciasMedicas.threads.OperadorLlamadas;

public class Main {
    public static void main(String[] args) {
        // Crear cola de emergencias
        ConcurrentPriorityQueue<Emergencia> colaEmergencias = new ConcurrentPriorityQueue<>();

        // Crear gestor de emergencias
        EmergenciaManager gestor = new EmergenciaManager(colaEmergencias);

        // Crear ResourceManager e inicializar recursos
        ResourceManager resourceManager = new ResourceManager();
        resourceManager.inicializarRecursos(); // Asegúrate de tener este método

        // Crear AsignadorRecursos pasando la cola y el gestor de recursos
        AsignadorRecursos asignadorRecursos = new AsignadorRecursos(colaEmergencias, resourceManager);

        // Crear y arrancar hilo de operador de llamadas
        Thread operador = new Thread(new OperadorLlamadas(gestor));
        operador.start();

        // Crear y arrancar hilo para asignar recursos periódicamente
        Thread asignador = new Thread(() -> {
            try {
                while (true) {
                    Emergencia emergencia = gestor.obtenerSiguienteEmergencia();
                    if (emergencia != null) {
                        asignadorRecursos.asignarRecursos(emergencia);
                    }
                    Thread.sleep(2000); // Espera 2 segundos
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Asignador detenido.");
            }
        });
        asignador.start();
    }
}