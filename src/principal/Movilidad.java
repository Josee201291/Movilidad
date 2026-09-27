/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;
import enums.Estado;
import enums.TipoMovilidad;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logica.Conductor;
import logica.NeMovilidad;
import logica.Reserva;
import logica.Usuario;
import logica.Vehiculo;

/** Punto de entrada y menús de la aplicación de gestión de movilidad. */
public class Movilidad {
    private static final Scanner teclado = new Scanner(System.in);
    /** Usuarios registrados en memoria. */
    public static List<Usuario> usuarios = new ArrayList<>();
    /** Vehículos registrados en memoria. */
    public static List<Vehiculo> vehiculo = new ArrayList<>();
    /** Reservas registradas en memoria. */
    public static List<Reserva> reserva = new ArrayList<>();
    /** Conductores registrados en memoria. */
    public static List<Conductor> conductor = new ArrayList<>();
    /** Necesidades de movilidad registradas en memoria. */
    public static List<NeMovilidad> movilidad = new ArrayList<>();

    /** Crea la instancia principal de la aplicación. */
    public Movilidad() {
    }
    
    /** Inicia la aplicación y muestra el flujo de autenticación. 
     * @param args argumentos de la línea de comandos
     * @throws InterruptedException si el flujo de ejecución es interrumpido
     */
    public static void main(String[] args) throws InterruptedException {
       ingreso();
    }
    
    /** Gestiona el inicio de sesión y dirige al menú principal.
     * @return rol del usuario administrador configurado
     */
    public static String ingreso(){

        usuarios.add(new Usuario(1, "Admin", "grupo1", "Admin"));
        usuarios.add(new Usuario(2, "User", "grupo2", "User"));
        vehiculo.add(new Vehiculo("Toyota", "Corolla", "ABC123", "Sedan", "Disponible", 4));
        conductor.add(new Conductor("B", "Senior", "Disponible", 1, "Juan Pérez", "JP001", "Conductor", "Transporte"));

        int contador=0;
       
        while (contador < 3){
            System.out.println("\n===========================================");
            System.out.println("Sistema SiReAu: Gestión VDG (Modo terminal)");
            System.out.println("===========================================");
            System.out.println("Ingreso al sistema");
            System.out.println("\nIndique usuario: ");
            String usuario = leerString();
            System.out.println("Indique contraseña: ");
            String clave = leerString();


            
        
            if (usuario.equals(usuarios.get(0).getUsuario()) || usuario.equals(usuarios.get(1).getUsuario()) && clave.equals(usuarios.get(0).getContrasena()) || clave.equals(usuarios.get(1).getContrasena())){
                menuPrincipal();
                break;
            
            }else{
                System.out.println("\nUsuario o contraseña incorrectos");
                contador +=1;
            }
          }
        
            if (contador == 3){
                System.out.println("\nIntrodujo mal clave y/o contraseña 3 veces");
            }
        
        return usuarios.get(0).getRol();
    }
    
 /** Muestra el menú principal y procesa la opción seleccionada. */
 public static void menuPrincipal(){
        System.out.println("\n===========================================");
        System.out.println("Bienvenidos al sistema de reservas ");
        System.out.println("===========================================");
        System.out.println("1.- Registrar necesidades de movilidad");
        System.out.println("2.- Gestionar Reservas");
        System.out.println("3.- Gestionar conductores");
        System.out.println("4.- Gestionar vehiculos");
        System.out.println("5.- Gestionar usuarios");
        System.out.println("0.- Salir");
        
        int seleccion = leerInt();
        
        switch (seleccion){
            case 1 -> {
                menuMovilidad();
            }
            case 2 -> {
                menuReservas();
            }
            case 3 -> {
                menuConductor();
            }
            case 4 -> {
                menuVehiculo();
            }
            case 5 -> {
                menuUsuario();
            }
            case 0 -> {
                System.out.println("Saliendo . . .");
                break;
            }
            default -> {
                System.out.println("Debe introducir un número del menu");
                menuPrincipal();
            }
    
        }
                
    }

    /** Muestra las operaciones de necesidades de movilidad. */
    public static void menuMovilidad(){
        System.out.println("\n===========================================");
        System.out.println("Bienvenido al menú de necesidades de movilidad");
        System.out.println("===========================================");
        System.out.println("1.- Crear necesidad de movilidad");
        System.out.println("2.- Ver necesidades de movilidad");
        System.out.println("3.- Modificar necesidad de movilidad");
        System.out.println("4.- Buscar necesidad de movilidad");
        System.out.println("5.- Suspender necesidad de movilidad");
        System.out.println("6.- Eliminar necesidad de movilidad");
        System.out.println("0.- Volver");
        
        int seleccion = leerInt();
        
        switch (seleccion){
            case 1 ->{
                System.out.println("\nCrear necesidad de movilidad");
                registrarNecesidadMovilidad();
                menuPrincipal();
            }
            case 2 ->{
                System.out.println("\nVer necesidades de movilidad");
                for(NeMovilidad movi: movilidad){
                    System.out.println(movi);
                }
            }
            case 3 ->{
                System.out.println("Modificar necesidad de movilidad");
            }
            case 4 ->{
                System.out.println("Buscar necesidad de movilidad");
            }
            case 5 ->{
                System.out.println("Suspender necesidad de movilidad");
            }
            case 6 ->{
                System.out.println("Eliminar necesidad de movilidad");
            }
            case 0 -> {
                menuPrincipal();
            }
            default -> {
                System.out.println("Introduzca un número dentro del menú");
                menuMovilidad();
            }
        }
    }
    
    /** Muestra las operaciones de reservas. */
    public static void menuReservas(){
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
        
        
        int seleccion = leerInt();
        
        switch (seleccion){
            case 1 ->{
                System.out.println("\nCrear reserva");
                crearReserva();
                menuPrincipal();
            }
            case 2 ->{
                System.out.println("\nVer reservas");
                for(Reserva reservan: reserva){
                    System.out.println(reservan);
                }
            }
            case 3 ->{
                System.out.println("Modificar reserva");
            }
            case 4 ->{
                System.out.println("Buscar reserva");
            }
            case 5 ->{
                System.out.println("Suspender reserva");
            }
            case 6 ->{
                System.out.println("Eliminar reserva");
            }
            case 0 -> {
                menuPrincipal();
            }
            default -> {
                System.out.println("Introduzca un número dentro del menú");
                menuReservas();
            }
        }
    }
    


    /** Registra una necesidad para que pueda asociarse después a una reserva. */
    private static void registrarNecesidadMovilidad() {
        System.out.println("Solicitante:");
        String solicitante = leerString();
        System.out.println("Carrera o unidad:");
        String carrera = leerString();
        System.out.println("Motivo:");
        String motivo = leerString();
        System.out.println("Lugar de salida:");
        String lugarSalida = leerString();
        System.out.println("Lugar de destino:");
        String lugarDestino = leerString();
        System.out.println("Cantidad de pasajeros:");
        int pasajeros = leerInt();
        System.out.println("Fecha de salida (AAAA-MM-DD):");
        LocalDate fechaSalida = LocalDate.parse(leerString());
        System.out.println("Fecha de regreso (AAAA-MM-DD):");
        LocalDate fechaRegreso = LocalDate.parse(leerString());
        System.out.println("Hora de salida (HH:MM):");
        LocalTime horaSalida = LocalTime.parse(leerString());
        System.out.println("Hora de regreso (HH:MM):");
        LocalTime horaRegreso = LocalTime.parse(leerString());

        TipoMovilidad[] tipos = TipoMovilidad.values();
        for (int i = 0; i < tipos.length; i++) {
            System.out.println((i + 1) + ".- " + tipos[i]);
        }
        System.out.println("\nSeleccione el tipo de movilidad:\n");
        int opcionTipo = leerInt();
        if (opcionTipo < 1 || opcionTipo > tipos.length) {
            System.out.println("Tipo de movilidad no válido; no se registró la necesidad.");
            return;
        }
        System.out.println("Observaciones:");
        String observaciones = leerString();

        movilidad.add(new NeMovilidad(solicitante, carrera, motivo, lugarSalida, lugarDestino, pasajeros,
                fechaSalida, fechaRegreso, horaSalida, horaRegreso, tipos[opcionTipo - 1], observaciones));
        System.out.println("Necesidad de movilidad registrada.");
    }

    /** Crea una reserva únicamente a partir de una necesidad ya registrada. */
    private static void crearReserva() {
        if (movilidad.isEmpty()) {
            System.out.println("No hay necesidades de movilidad registradas. Registre una antes de crear una reserva.");
            return;
        }
        if (vehiculo.isEmpty()) {
            System.out.println("No hay vehículos registrados. Registre un vehículo antes de crear una reserva.");
            return;
        }
        if (conductor.isEmpty()) {
            System.out.println("No hay conductores registrados. Registre un conductor antes de crear una reserva.");
            return;
        }

        NeMovilidad necesidad = seleccionarDeLista("la necesidad de movilidad", movilidad);
        if (necesidad == null) {
            return;
        }
        Vehiculo vehiculoSeleccionado = seleccionarDeLista("el vehículo", vehiculo);
        if (vehiculoSeleccionado == null) {
            return;
        }
        Conductor conductorSeleccionado = seleccionarDeLista("el conductor", conductor);
        if (conductorSeleccionado == null) {
            return;
        }

        Reserva nuevaReserva = new Reserva(Estado.INICIADA, necesidad, vehiculoSeleccionado, conductorSeleccionado);
        reserva.add(nuevaReserva);
        System.out.println("Reserva creada con la necesidad, el vehículo y el conductor seleccionados.");
    }

    private static <T> T seleccionarDeLista(String descripcion, List<T> opciones) {
        System.out.println("Seleccione " + descripcion + ":");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ".- " + opciones.get(i));
        }
        int seleccion = leerInt();
        if (seleccion < 1 || seleccion > opciones.size()) {
            System.out.println("Selección no válida; no se creó la reserva.");
            return null;
        }
        return opciones.get(seleccion - 1);
    }

    private static void registrarConductor() {
        System.out.println("Identificador numérico:");
        int idPersona = leerInt();
        System.out.println("Nombre:");
        String nombre = leerString();
        System.out.println("Identificador institucional:");
        String id = leerString();
        System.out.println("Cargo:");
        String cargo = leerString();
        System.out.println("Dependencia:");
        String dependencia = leerString();
        System.out.println("Licencia:");
        String licencia = leerString();
        System.out.println("Grado:");
        String grado = leerString();

        conductor.add(new Conductor(licencia, grado, "Disponible", idPersona, nombre, id, cargo, dependencia));
        System.out.println("Conductor registrado.");
    }

    private static void registrarVehiculo() {
        System.out.println("Marca:");
        String marca = leerString();
        System.out.println("Modelo:");
        String modelo = leerString();
        System.out.println("Patente:");
        String patente = leerString();
        System.out.println("Tipo de vehículo:");
        String tipo = leerString();
        System.out.println("Capacidad de pasajeros:");
        int capacidad = leerInt();

        vehiculo.add(new Vehiculo(marca, modelo, patente, tipo, "Disponible", capacidad));
        System.out.println("Vehículo registrado.");
    }

    /** Muestra las operaciones de conductores. */
    public static void menuConductor(){
    System.out.println("\n===========================================");
    System.out.println("Bienvenido al menú de Conductores");
    System.out.println("===========================================");
        System.out.println("1.- Agregar conductor");
        System.out.println("2.- Ver conductor");
        System.out.println("3.- Modificar conductor");
        System.out.println("4.- Buscar conductor");
        System.out.println("5.- Eliminar conductgor");
        System.out.println("0.- Volver");
        
        int seleccion = leerInt();
        
        switch (seleccion){
            case 1 ->{
                System.out.println("\nAgregar conductor");
                registrarConductor();
                menuPrincipal();
            }
            case 2 ->{
                System.out.println("\nVer conductor");
                for(Conductor conductores: conductor){
                    System.out.println(conductores);
                }
            }
            case 3 ->{
                System.out.println("\nModificar conductor");
            }
            case 4 ->{
                System.out.println("\nBuscar conductor");
            }
            case 5 ->{
                System.out.println("\nEliminar conductor");
            }
            case 0 -> {
                menuPrincipal();
            }
            default -> {
                System.out.println("Introduzca un número dentro del menú");
                menuConductor();
            }
        }
    }

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


/** Muestra las operaciones de usuarios. */
public static void menuUsuario(){
    System.out.println("\n===========================================");
    System.out.println("Bienvenido al menú de usuarios");
    System.out.println("===========================================");
        System.out.println("1.- Agregar usuario");
        System.out.println("2.- Ver usuarios");
        System.out.println("3.- Buscar usuarios");
        System.out.println("4.- Modificar usuario");
        System.out.println("5.- Eliminar usuario");
        System.out.println("0.- Volver");
        
        int seleccion = leerInt();
        
        switch (seleccion){
            case 1 ->{
                System.out.println("\nAgregar usuario");
                System.out.println("Ingrese idUsuario: ");
                int idUsuario = leerInt();
                System.out.println("Ingrese usuario: ");
                String usuario = leerString();
                System.out.println("Ingrese contraseña: ");
                String contrasena = leerString();
                System.out.println("Ingrese rol: ");
                String rol = leerString();

                Usuario nuevoUsuario = new Usuario(idUsuario, usuario, contrasena, rol);
                usuarios.add(nuevoUsuario);
            }
            case 2 ->{
                System.out.println("\nVer usuarios");
                for(Usuario usuario: usuarios){
                    System.out.println(usuario);
                }
            }
            case 3 ->{
                System.out.println("\nBuscar usuario");
                System.out.println("Ingrese usuario: ");
                String usuario = leerString();
                for(Usuario u: usuarios){
                    if(u.getUsuario().equals(usuario)){
                        System.out.println(u);
                        break;
                    }else{
                        System.out.println("Usuario no encontrado");
                    }
                }
            }
            case 4 ->{
                System.out.println("\nModificar usuario");
                System.out.println("Ingrese usuario: ");
                String usuario = leerString();
                for(Usuario u: usuarios){
                    if(u.getUsuario().equals(usuario)){
                        System.out.println("Usuario encontrado");
                        System.out.println("\nIngrese nuevo usuario: ");
                        String nuevoUsuario = leerString();
                        u.setUsuario(nuevoUsuario);
                        System.out.println("Usuario modificado");
                        System.out.println("\nIngrese nueva contraseña: ");
                        String nuevaContrasena = leerString();
                        u.setContrasena(nuevaContrasena);
                        System.out.println("Contraseña modificada");
                        System.out.println("\nIngrese nuevo rol: ");
                        String nuevoRol = leerString();
                        u.setRol(nuevoRol);
                        System.out.println("Rol modificada");
                        break;
                    }else{
                        System.out.println("Usuario no encontrado");
                    }
                }
            }
            case 5 ->{
                System.out.println("\nEliminar usuario");
                System.out.println("Ingrese usuario: ");
                String usuario = leerString();
                for(Usuario u: usuarios){
                    if(u.getUsuario().equals(usuario)){
                        usuarios.remove(u);
                        System.out.println("Usuario eliminado");
                        break;
                    }else{
                        System.out.println("Usuario no encontrado");
                    }
                }
            }
            case 0 -> {
                menuPrincipal();
            }
            default -> {
                System.out.println("Introduzca un número dentro del menú");
                menuUsuario();
            }
        }
    }
    
    
    /** Lee una cadena desde la entrada estándar.
     * @return texto introducido por el usuario
     */
    public static String leerString(){
        String datos = teclado.nextLine();
        return datos;
    }
    
    /** Lee un entero desde la entrada estándar.
     * @return entero introducido por el usuario
     */
    public static int leerInt(){
        int datos = Integer.parseInt(leerString().trim());
        return datos;
        
    }
    
    /** Lee un número decimal desde la entrada estándar.
     * @return número decimal introducido por el usuario
     */
    public static double leerDouble(){
        double datos = Double.parseDouble(leerString().trim());
        return datos;
        
    }
   
}