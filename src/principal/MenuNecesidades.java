package principal;

import enums.TipoMovilidad;
import java.time.LocalDate;
import java.time.LocalTime;
import logica.NeMovilidad;

/** Gestiona el registro y la consulta de necesidades de movilidad. */
public final class MenuNecesidades {
    public void mostrar() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n================================================");
            System.out.println("Bienvenido al menú de necesidades de movilidad");
            System.out.println("==================================================");
            System.out.println("1.- Crear necesidad de movilidad");
            System.out.println("2.- Ver necesidades de movilidad");
            System.out.println("3.- Modificar necesidad de movilidad");
            System.out.println("4.- Buscar necesidad de movilidad");
            System.out.println("5.- Suspender necesidad de movilidad");
            System.out.println("6.- Eliminar necesidad de movilidad");
            System.out.println("0.- Volver");

            switch (Movilidad.leerInt()) {
                case 1 -> {
                    registrar();
                    System.out.println("Desea registrar otra necesidad de movilidad? (s/n)");
                    if (Movilidad.leerString().equalsIgnoreCase("s")) {
                        registrar();
                    }
                }
                case 2 -> mostrarNecesidades();
                case 3 -> {
                    System.out.println("Modificar necesidad de movilidad");
                    mostrarNecesidades();
                }
                case 4 -> System.out.println("Buscar necesidad de movilidad");
                case 5 -> System.out.println("Suspender necesidad de movilidad");
                case 6 -> System.out.println("Eliminar necesidad de movilidad");
                case 0 -> volver = true;
                default -> System.out.println("Introduzca un número dentro del menú");
            }
        }
    }

    private void mostrarNecesidades() {
        if (Movilidad.movilidad.isEmpty()) {
            System.out.println("No existe alguna necesidad de movilidad");
            System.out.println("Desea crear una necesidad de movilidad? (s/n)");
            if (Movilidad.leerString().equalsIgnoreCase("s")) {
                registrar();
            }
            return;
        }

        System.out.println("===============================");
        System.out.println("Ver necesidades de movilidad");
        System.out.println("===============================");
        for (NeMovilidad necesidad : Movilidad.movilidad) {
            System.out.println(necesidad);
        }
    }

    void registrar() {
        System.out.println("\n=====================================");
        System.out.println("Registro de necesidad de Movilidad");
        System.out.println("======================================");
        System.out.println("\nIndique Solicitante:");
        String solicitante = Movilidad.leerString();
        System.out.println("Carrera o unidad:");
        String carrera = Movilidad.leerString();
        System.out.println("Motivo del viaje:");
        String motivo = Movilidad.leerString();
        System.out.println("Lugar de salida:");
        String lugarSalida = Movilidad.leerString();
        System.out.println("Lugar de destino:");
        String lugarDestino = Movilidad.leerString();
        System.out.println("Cantidad de pasajeros:");
        int pasajeros = Movilidad.leerInt();
        System.out.println("Fecha de salida (AAAA-MM-DD):");
        LocalDate fechaSalida = LocalDate.parse(Movilidad.leerString());
        System.out.println("Fecha de regreso (AAAA-MM-DD):");
        LocalDate fechaRegreso = LocalDate.parse(Movilidad.leerString());
        System.out.println("Hora de salida (HH:MM):");
        LocalTime horaSalida = LocalTime.parse(Movilidad.leerString());
        System.out.println("Hora de regreso (HH:MM):");
        LocalTime horaRegreso = LocalTime.parse(Movilidad.leerString());

        TipoMovilidad[] tipos = TipoMovilidad.values();
        for (int i = 0; i < tipos.length; i++) {
            System.out.println((i + 1) + ".- " + tipos[i]);
        }
        System.out.println("\nSeleccione el tipo de movilidad:\n");
        int opcionTipo = Movilidad.leerInt();
        if (opcionTipo < 1 || opcionTipo > tipos.length) {
            System.out.println("Tipo de movilidad no válido; no se registró la necesidad.");
            return;
        }
        System.out.println("Observaciones:");
        String observaciones = Movilidad.leerString();

        Movilidad.movilidad.add(new NeMovilidad(solicitante, carrera, motivo, lugarSalida, lugarDestino,
                pasajeros, fechaSalida, fechaRegreso, horaSalida, horaRegreso, tipos[opcionTipo - 1], observaciones));
        System.out.println("Necesidad de movilidad registrada.");
    }
}