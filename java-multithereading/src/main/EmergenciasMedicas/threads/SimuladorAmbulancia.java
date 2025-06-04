package EmergenciasMedicas.threads;

import EmergenciasMedicas.communication.BusMensajes;
import EmergenciasMedicas.data.ResourceManager;

public class SimuladorAmbulancia implements Runnable {
    private ResourceManager resourceManager;
    private BusMensajes busMensajes;

    public SimuladorAmbulancia(ResourceManager resourceManager, BusMensajes busMensajes) {
        this.resourceManager = resourceManager;
        this.busMensajes = busMensajes;
    }

    @Override
    public void run() {
        // Lógica de simulación
    }
}
