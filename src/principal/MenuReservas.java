package principal;

import enums.Estado;
import java.util.List;
import logica.Conductor;
import logica.NeMovilidad;
import logica.Reserva;
import logica.Vehiculo;

/** Gestiona la creación y consulta de reservas. */
public final class MenuReservas {
    private final MenuNecesidades menuNecesidades;
    private final MenuConductores menuConductores;
    private final MenuVehiculos menuVehiculos;

    public MenuReservas(MenuNecesidades menuNecesidades, MenuConductores menuConductores,
            MenuVehiculos menuVehiculos) {
        this.menuNecesidades = menuNecesidades;
        this.menuConductores = menuConductores;
        this.menuVehiculos = menuVehiculos;
    }

    public void mostrar() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n===========================================");
            System.out.println("Bienvenido al menú de reservas");
            System.out.println("===========================================");
            System.out.println("1.- Crear reserva");
            System.out.println("2.- Ver reservas");
            System.out.println("3.- Modificar reserva");
            System.out.println("4.- Buscar reserva");
            System.out.println("5.- Suspender reserva");
            System.out.println("6.- Eliminar reserva");
            System.out.println("0.- Volver");

            switch (Movilidad.leerInt()) {
                case 1 -> crear();
                case 2 -> listar();
                case 3 -> System.out.println("Modificar reserva");
                case 4 -> System.out.println("Buscar reserva");
                case 5 -> System.out.println("Suspender reserva");
                case 6 -> System.out.println("Eliminar reserva");
                case 0 -> volver = true;
                default -> System.out.println("Introduzca un número dentro del menú");
            }
        }
    }

    private void listar() {
        System.out.println("\nVer reservas");
        if (Movilidad.reserva.isEmpty()) {
            System.out.println("No existen reservas, debe crear una");
            crear();
            return;
        }
        for (Reserva reserva : Movilidad.reserva) {
            System.out.println(reserva);
        }
    }

    private void crear() {
        if (Movilidad.movilidad.isEmpty()) {
            System.out.println("No hay necesidades de movilidad registradas. Registre una antes de crear una reserva.");
            menuNecesidades.mostrar();
            if (Movilidad.movilidad.isEmpty()) {
                return;
            }
        }
        if (Movilidad.vehiculo.isEmpty()) {
            System.out.println("Registre un vehículo para continuar.");
            menuVehiculos.registrar();
        }
        if (Movilidad.conductor.isEmpty()) {
            System.out.println("Registre un conductor para continuar.");
            menuConductores.registrar();
        }

        NeMovilidad necesidad = seleccionar("la necesidad de movilidad", Movilidad.movilidad);
        Vehiculo vehiculo = seleccionar("el vehículo", Movilidad.vehiculo);
        Conductor conductor = seleccionar("el conductor", Movilidad.conductor);
        if (necesidad == null || vehiculo == null || conductor == null) {
            return;
        }

        Movilidad.reserva.add(new Reserva(Estado.INICIADA, necesidad, vehiculo, conductor));
        System.out.println("Reserva creada con la necesidad, el vehículo y el conductor seleccionados.");
    }

    private <T> T seleccionar(String descripcion, List<T> opciones) {
        System.out.println("Seleccione " + descripcion + ":");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ".- " + opciones.get(i));
        }
        int seleccion = Movilidad.leerInt();
        if (seleccion < 1 || seleccion > opciones.size()) {
            System.out.println("Selección no válida; no se creó la reserva.");
            return null;
        }
        return opciones.get(seleccion - 1);
    }
}