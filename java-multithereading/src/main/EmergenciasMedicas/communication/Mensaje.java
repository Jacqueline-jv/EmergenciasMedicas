package EmergenciasMedicas.communication;

import java.time.LocalDateTime;

public class Mensaje {
    private final String origen;
    private final String destino;
    private final String contenido;
    private final LocalDateTime timestamp;

    public Mensaje(String origen, String destino, String contenido) {
        this.origen = origen;
        this.destino = destino;
        this.contenido = contenido;
        this.timestamp = LocalDateTime.now();
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + origen + " -> " + destino + ": " + contenido;
    }
}

