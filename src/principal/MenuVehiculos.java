package principal;

import logica.Vehiculo;

/** Gestiona las operaciones disponibles para vehículos. */
public final class MenuVehiculos {
    public void mostrar() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n===========================================");
            System.out.println("Bienvenido al menú de Vehiculo");
            System.out.println("===========================================");
            System.out.println("1.- Agregar vehiculo");
            System.out.println("2.- Ver vehiculo");
            System.out.println("3.- Modificar vehiculo");
            System.out.println("4.- Buscar vehiculo");
            System.out.println("5.- Eliminar vehiculo");
            System.out.println("0.- Volver");

            switch (Movilidad.leerInt()) {
                case 1 -> registrar();
                case 2 -> {
                    System.out.println("\nVer vehiculo");
                    for (Vehiculo vehiculo : Movilidad.vehiculo) {
                        System.out.println(vehiculo);
                    }
                }
                case 3 -> System.out.println("Modificar vehiculo");
                case 4 -> System.out.println("Buscar vehiculo");
                case 5 -> System.out.println("Eliminar Vehiculo");
                case 0 -> volver = true;
                default -> System.out.println("Introduzca un número dentro del menú");
            }
        }
    }

    void registrar() {
        System.out.println("Marca:");
        String marca = Movilidad.leerString();
        System.out.println("Modelo:");
        String modelo = Movilidad.leerString();
        System.out.println("Patente:");
        String patente = Movilidad.leerString();
        System.out.println("Tipo de vehículo:");
        String tipo = Movilidad.leerString();
        System.out.println("Capacidad de pasajeros:");
        int capacidad = Movilidad.leerInt();

        Movilidad.vehiculo.add(new Vehiculo(marca, modelo, patente, tipo, "Disponible", capacidad));
        System.out.println("Vehículo registrado.");
    }
}