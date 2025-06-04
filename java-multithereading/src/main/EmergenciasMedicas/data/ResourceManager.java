package EmergenciasMedicas.data;

import EmergenciasMedicas.domain.Ambulancia;
import EmergenciasMedicas.domain.EquipoMedico;
import EmergenciasMedicas.domain.Medico;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class ResourceManager {
    private final List<Ambulancia> ambulancias = new CopyOnWriteArrayList<>();
    private final List<Medico> medicos = new CopyOnWriteArrayList<>();
    private final List<EquipoMedico> equipos = new CopyOnWriteArrayList<>();

    private final Semaphore semAmbulancias = new Semaphore(0);
    private final Semaphore semMedicos = new Semaphore(0);
    private final Semaphore semEquipos = new Semaphore(0);

    // Inicializa los recursos disponibles (solo si están vacíos)
    public void inicializarRecursos() {
        if (ambulancias.isEmpty() && medicos.isEmpty() && equipos.isEmpty()) {
            for (int i = 1; i <= 5; i++) {
                String id = String.valueOf(i); //

                ambulancias.add(new Ambulancia(id, "PLACA-" + i));
                semAmbulancias.release();

                medicos.add(new Medico(id, "Dr. " + i));
                semMedicos.release();

                equipos.add(new EquipoMedico(id, "Equipo Tipo " + i));
                semEquipos.release();
            }
        } else {
            System.out.println("⚠️ Recursos ya han sido inicializados. No se duplicarán.");
        }
    }

    // Getters y otros métodos para obtener recursos (opcional)
    public Ambulancia obtenerAmbulancia() throws InterruptedException {
        semAmbulancias.acquire();
        return ambulancias.remove(0);
    }

    public Medico obtenerMedico() throws InterruptedException {
        semMedicos.acquire();
        return medicos.remove(0);
    }

    public EquipoMedico obtenerEquipoMedico() throws InterruptedException {
        semEquipos.acquire();
        return equipos.remove(0);
    }
}


