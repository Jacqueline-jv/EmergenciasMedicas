package EmergenciasMedicas.presentation;

import EmergenciasMedicas.domain.Emergencia;
import EmergenciasMedicas.domain.NivelGravedad;
import EmergenciasMedicas.logic.EmergenciaManager;

import java.util.Scanner;

public class InterfazConsola {

    private final EmergenciaManager emergenciaManager;
    private final Scanner scanner;

    public InterfazConsola(EmergenciaManager emergenciaManager) {
        this.emergenciaManager = emergenciaManager;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    verEmergenciasPendientes();
                    break;
                case 2:
                    verRecursosDisponibles();
                    break;
                case 3:
                    crearEmergenciaManual();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 4);
    }

    private void mostrarMenu() {
        System.out.println("\n--- SISTEMA DE GESTIÓN DE EMERGENCIAS ---");
        System.out.println("1. Ver emergencias pendientes");
        System.out.println("2. Ver recursos disponibles");
        System.out.println("3. Crear emergencia manual");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void verEmergenciasPendientes() {
        System.out.println("\n--- Emergencias Pendientes ---");
        for (Emergencia e : emergenciaManager.getEmergenciasPendientes()) {
            System.out.println(e);
        }
    }

    private void verRecursosDisponibles() {
        System.out.println("\n--- Recursos Disponibles ---");
        emergenciaManager.obtenerRecursosDisponibles();
    }

    private void crearEmergenciaManual() {
        System.out.println("\n--- Crear Emergencia Manual ---");
        System.out.print("Ingrese la ubicación: ");
        String ubicacion = scanner.nextLine();

        System.out.println("Seleccione nivel de gravedad:");
        System.out.println("1. CRÍTICO");
        System.out.println("2. GRAVE");
        System.out.println("3. MODERADO");
        System.out.println("4. LEVE");

        NivelGravedad gravedad = null;
        int opcion = obtenerOpcion();
        switch (opcion) {
            case 1:
                gravedad = NivelGravedad.CRITICO;
                break;
            case 2:
                gravedad = NivelGravedad.GRAVE;
                break;
            case 3:
                gravedad = NivelGravedad.MODERADO;
                break;
            case 4:
                gravedad = NivelGravedad.LEVE;
                break;
            default:
                gravedad = null;
                break;
        }

        if (gravedad != null) {
            Emergencia nueva = new Emergencia(ubicacion, gravedad);
            emergenciaManager.registrarEmergencia(nueva);
            System.out.println("✅ Emergencia registrada con éxito:\n" + nueva);
        } else {
            System.out.println("❌ Nivel de gravedad no válido.");
        }
    }
}





