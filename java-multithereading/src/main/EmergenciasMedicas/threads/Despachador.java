package EmergenciasMedicas.threads;

import EmergenciasMedicas.communication.BusMensajes;
import EmergenciasMedicas.data.ConcurrentPriorityQueue;
import EmergenciasMedicas.data.ResourceManager;

public class Despachador implements Runnable {
    private ConcurrentPriorityQueue colaEmergencias;
    private ResourceManager resourceManager;
    private BusMensajes busMensajes;

    public Despachador(ConcurrentPriorityQueue colaEmergencias, ResourceManager resourceManager, BusMensajes busMensajes) {
        this.colaEmergencias = colaEmergencias;
        this.resourceManager = resourceManager;
        this.busMensajes = busMensajes;
    }

    @Override
    public void run() {
        // Lógica del despachador
    }
}

