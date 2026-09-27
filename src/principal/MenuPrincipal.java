package principal;

/** Coordina el menú principal y sus módulos. */
public final class MenuPrincipal {
    private final MenuNecesidades menuNecesidades = new MenuNecesidades();
    private final MenuConductores menuConductores = new MenuConductores();
    private final MenuVehiculos menuVehiculos = new MenuVehiculos();
    private final MenuReservas menuReservas = new MenuReservas(menuNecesidades, menuConductores, menuVehiculos);
    private final MenuUsuarios menuUsuarios = new MenuUsuarios();

    public void mostrar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n===========================================");
            System.out.println("Bienvenidos al sistema de reservas ");
            System.out.println("===========================================");
            System.out.println("1.- Registrar necesidades de movilidad");
            System.out.println("2.- Gestionar Reservas");
            System.out.println("3.- Gestionar conductores");
            System.out.println("4.- Gestionar vehiculos");
            System.out.println("5.- Gestionar usuarios");
            System.out.println("0.- Salir");

            switch (Movilidad.leerInt()) {
                case 1 -> menuNecesidades.mostrar();
                case 2 -> menuReservas.mostrar();
                case 3 -> menuConductores.mostrar();
                case 4 -> menuVehiculos.mostrar();
                case 5 -> menuUsuarios.mostrar();
                case 0 -> {
                    System.out.println("Saliendo . . .");
                    salir = true;
                }
                default -> System.out.println("Debe introducir un número del menu");
            }
        }
    }
}