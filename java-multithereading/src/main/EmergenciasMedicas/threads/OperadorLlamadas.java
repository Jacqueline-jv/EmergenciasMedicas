package EmergenciasMedicas.threads;

import EmergenciasMedicas.domain.Emergencia;
import EmergenciasMedicas.logic.EmergenciaManager;

public class OperadorLlamadas extends Thread {

    private final EmergenciaManager emergenciaManager;

    public OperadorLlamadas(EmergenciaManager emergenciaManager) {
        this.emergenciaManager = emergenciaManager;
    }

    @Override
    public void run() {
        GeneradorEmergencias generador = new GeneradorEmergencias(emergenciaManager);

        try {
            while (true) {
                // Simula una llamada cada 5-10 segundos
                Thread.sleep((int) (Math.random() * 5000 + 5000));

                Emergencia emergencia = generador.generarEmergencia();
                emergenciaManager.registrarEmergencia(emergencia);
            }
        } catch (InterruptedException e) {
            System.out.println("Operador detenido.");
        }
    }
}




