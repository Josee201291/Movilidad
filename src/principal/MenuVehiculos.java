package principal;

import logica.Vehiculo;

/** Muestra las operaciones de vehículos. */
    public static void menuVehiculo(){
        System.out.println("\n===========================================");
        System.out.println("Bienvenido al menú de Vehiculo");
        System.out.println("===========================================");
        System.out.println("1.- Agregar vehiculo");
        System.out.println("2.- Ver vehiculo");
        System.out.println("3.- Modificar vehiculo");
        System.out.println("4.- Buscar vehiculo");
        System.out.println("5.- Eliminar vehiculo");
        System.out.println("0.- Volver");
        
        int seleccion = leerInt();

        switch (seleccion){
            case 1 -> {
                System.out.println("\nAgregar vehiculo");
                registrarVehiculo();
                menuVehiculo();
            }
            case 2 -> {
                System.out.println("\nVer vehiculo");
                if (vehiculo.isEmpty()) {
                    System.out.println("No hay vehículos registrados.");
                } else {
                    for(Vehiculo v : vehiculo){
                        System.out.println(v);
                    }
                }
                menuVehiculo();
            }
            case 3 -> {
                System.out.println("\nModificar vehiculo");
                modificarVehiculo();
                menuVehiculo();
            }
            case 4 -> {
                System.out.println("\nBuscar vehiculo");
                buscarVehiculo();
                menuVehiculo();
            }
            case 5 -> {
                System.out.println("\nEliminar Vehiculo");
                eliminarVehiculo();
                menuVehiculo();
            }
            case 0 -> {
                menuPrincipal();
            }
            default -> {
                System.out.println("Introduzca un número dentro del menú");
                menuVehiculo();
            }
        }
    }

    private static void buscarVehiculo() {
        System.out.println("Ingrese patente a buscar:");
        String patente = leerString();
        boolean encontrado = false;
        
        for (Vehiculo v : vehiculo) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                System.out.println("\nVehículo encontrado:");
                System.out.println(v);
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Vehículo no encontrado con la patente especificada.");
        }
    }

    private static void modificarVehiculo() {
        System.out.println("Ingrese patente del vehículo a modificar:");
        String patente = leerString();
        boolean encontrado = false;

        for (Vehiculo v : vehiculo) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                System.out.println("Vehículo encontrado: " + v);
                
                System.out.println("Ingrese nueva marca:");
                v.setMarca(leerString());
                
                System.out.println("Ingrese nuevo modelo:");
                v.setModelo(leerString());
                
                System.out.println("Ingrese nuevo tipo:");
                v.setTipo(leerString());
                
                System.out.println("Ingrese nuevo estado (ej. Disponible, En Mantenimiento, En Uso):");
                v.setEstado(leerString());
                
                System.out.println("Ingrese nueva capacidad de pasajeros:");
                v.setCapacidad(leerInt());

                System.out.println("Vehículo modificado exitosamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Vehículo no encontrado.");
        }
    }

    private static void eliminarVehiculo() {
        System.out.println("Ingrese patente del vehículo a eliminar:");
        String patente = leerString();
        boolean encontrado = false;

        for (int i = 0; i < vehiculo.size(); i++) {
            if (vehiculo.get(i).getPatente().equalsIgnoreCase(patente)) {
                vehiculo.remove(i);
                System.out.println("Vehículo eliminado exitosamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Vehículo no encontrado.");
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