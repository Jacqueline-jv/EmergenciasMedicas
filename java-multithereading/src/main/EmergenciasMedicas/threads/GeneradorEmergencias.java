package EmergenciasMedicas.threads;

import EmergenciasMedicas.domain.Emergencia;
import EmergenciasMedicas.domain.NivelGravedad;
import EmergenciasMedicas.logic.EmergenciaManager;

import java.util.Random;

public class GeneradorEmergencias implements Runnable {

    private EmergenciaManager emergenciaManager;
    private static final String[] ubicaciones = {
            "Centro", "Sur", "Norte", "Este", "Oeste", "Comuna 13", "Belén", "Manrique"
    };

    public GeneradorEmergencias(EmergenciaManager emergenciaManager) {
        this.emergenciaManager = emergenciaManager;
    }

    // CAMBIAR DE PRIVATE A PUBLIC
    public Emergencia generarEmergencia() {
        Random rand = new Random();
        NivelGravedad gravedad = NivelGravedad.values()[rand.nextInt(NivelGravedad.values().length)];
        String ubicacion = ubicaciones[rand.nextInt(ubicaciones.length)];
        return new Emergencia(ubicacion, gravedad);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000); // cada 5 segundos
                Emergencia nueva = generarEmergencia();
                System.out.println("Nueva emergencia generada: " + nueva);
                emergenciaManager.registrarEmergencia(nueva);
            } catch (InterruptedException e) {
                System.out.println("Generador de emergencias interrumpido.");
                break;
            }
        }
    }
}





