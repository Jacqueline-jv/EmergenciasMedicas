package EmergenciasMedicas.monitor;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Estadisticas {

    private static final AtomicInteger emergenciasAtendidas = new AtomicInteger(0);
    private static final AtomicLong tiempoTotalRespuesta = new AtomicLong(0);

    public static void registrarEmergenciaAtendida(long tiempoRespuestaMs) {
        emergenciasAtendidas.incrementAndGet();
        tiempoTotalRespuesta.addAndGet(tiempoRespuestaMs);
    }

    public static void mostrarResumen() {
        int atendidas = emergenciasAtendidas.get();
        long tiempoTotal = tiempoTotalRespuesta.get();

        System.out.println("\n📊 ESTADÍSTICAS GENERALES 📊");
        System.out.println("✅ Emergencias atendidas: " + atendidas);

        if (atendidas > 0) {
            System.out.println("⏱️ Tiempo promedio de respuesta: " + (tiempoTotal / atendidas) + " ms");
        } else {
            System.out.println("No hay datos suficientes aún.");
        }
    }

    public static void resetear() {
        emergenciasAtendidas.set(0);
        tiempoTotalRespuesta.set(0);
    }
}
