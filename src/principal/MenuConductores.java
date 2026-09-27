package principal;

import logica.Conductor;

/** Gestiona las operaciones disponibles para conductores. */
public final class MenuConductores {
    public void mostrar() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n===========================================");
            System.out.println("Bienvenido al menú de Conductores");
            System.out.println("===========================================");
            System.out.println("1.- Agregar conductor");
            System.out.println("2.- Ver conductor");
            System.out.println("3.- Modificar conductor");
            System.out.println("4.- Buscar conductor");
            System.out.println("5.- Eliminar conductgor");
            System.out.println("0.- Volver");

            switch (Movilidad.leerInt()) {
                case 1 -> registrar();
                case 2 -> {
                    System.out.println("\nVer conductor");
                    for (Conductor conductor : Movilidad.conductor) {
                        System.out.println(conductor);
                    }
                }
                case 3 -> System.out.println("\nModificar conductor");
                case 4 -> System.out.println("\nBuscar conductor");
                case 5 -> System.out.println("\nEliminar conductor");
                case 0 -> volver = true;
                default -> System.out.println("Introduzca un número dentro del menú");
            }
        }
    }

    void registrar() {
        System.out.println("Identificador numérico:");
        int idPersona = Movilidad.leerInt();
        System.out.println("Nombre:");
        String nombre = Movilidad.leerString();
        System.out.println("Identificador institucional:");
        String id = Movilidad.leerString();
        System.out.println("Cargo:");
        String cargo = Movilidad.leerString();
        System.out.println("Dependencia:");
        String dependencia = Movilidad.leerString();
        System.out.println("Licencia:");
        String licencia = Movilidad.leerString();
        System.out.println("Grado:");
        String grado = Movilidad.leerString();

        Movilidad.conductor.add(new Conductor(licencia, grado, "Disponible", idPersona, nombre, id, cargo, dependencia));
        System.out.println("Conductor registrado.");
    }
}