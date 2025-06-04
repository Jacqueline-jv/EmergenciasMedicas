package EmergenciasMedicas.monitor;

import EmergenciasMedicas.data.ConcurrentPriorityQueue;
import EmergenciasMedicas.data.ResourceManager;

public class MonitorEstado implements Runnable {
    private ConcurrentPriorityQueue colaEmergencias;
    private ResourceManager resourceManager;

    public MonitorEstado(ConcurrentPriorityQueue colaEmergencias, ResourceManager resourceManager) {
        this.colaEmergencias = colaEmergencias;
        this.resourceManager = resourceManager;
    }

    @Override
    public void run() {
        // Lógica del monitor
    }
}

