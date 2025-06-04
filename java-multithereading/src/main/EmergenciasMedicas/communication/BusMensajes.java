package EmergenciasMedicas.communication;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BusMensajes {
    private final BlockingQueue<Mensaje> mensajes = new LinkedBlockingQueue<>();

    // Enviar mensaje al bus
    public void enviar(Mensaje mensaje) {
        try {
            mensajes.put(mensaje);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Recibir siguiente mensaje (bloqueante)
    public Mensaje recibir() {
        try {
            return mensajes.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    // Ver si hay mensajes disponibles
    public boolean hayMensajes() {
        return !mensajes.isEmpty();
    }
}
