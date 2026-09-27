package principal;

import logica.Usuario;

/** Gestiona las operaciones disponibles para usuarios. */
public final class MenuUsuarios {
    public void mostrar() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n===========================================");
            System.out.println("Bienvenido al menú de usuarios");
            System.out.println("===========================================");
            System.out.println("1.- Agregar usuario");
            System.out.println("2.- Ver usuarios");
            System.out.println("3.- Buscar usuarios");
            System.out.println("4.- Modificar usuario");
            System.out.println("5.- Eliminar usuario");
            System.out.println("0.- Volver");

            switch (Movilidad.leerInt()) {
                case 1 -> agregar();
                case 2 -> listar();
                case 3 -> buscar();
                case 4 -> modificar();
                case 5 -> eliminar();
                case 0 -> volver = true;
                default -> System.out.println("Introduzca un número dentro del menú");
            }
        }
    }

    private void agregar() {
        System.out.println("Ingrese idUsuario: ");
        int idUsuario = Movilidad.leerInt();
        System.out.println("Ingrese usuario: ");
        String usuario = Movilidad.leerString();
        System.out.println("Ingrese contraseña: ");
        String contrasena = Movilidad.leerString();
        System.out.println("Ingrese rol: ");
        String rol = Movilidad.leerString();
        Movilidad.usuarios.add(new Usuario(idUsuario, usuario, contrasena, rol));
    }

    private void listar() {
        System.out.println("\nVer usuarios");
        for (Usuario usuario : Movilidad.usuarios) {
            System.out.println(usuario);
        }
    }

    private void buscar() {
        System.out.println("\nBuscar usuario");
        System.out.println("Ingrese usuario: ");
        String nombreUsuario = Movilidad.leerString();
        for (Usuario usuario : Movilidad.usuarios) {
            if (usuario.getUsuario().equals(nombreUsuario)) {
                System.out.println(usuario);
                return;
            }
        }
        System.out.println("Usuario no encontrado");
    }

    private void modificar() {
        System.out.println("\nModificar usuario");
        System.out.println("Ingrese usuario: ");
        String nombreUsuario = Movilidad.leerString();
        for (Usuario usuario : Movilidad.usuarios) {
            if (usuario.getUsuario().equals(nombreUsuario)) {
                System.out.println("Usuario encontrado");
                System.out.println("\nIngrese nuevo usuario: ");
                usuario.setUsuario(Movilidad.leerString());
                System.out.println("Usuario modificado");
                System.out.println("\nIngrese nueva contraseña: ");
                usuario.setContrasena(Movilidad.leerString());
                System.out.println("Contraseña modificada");
                System.out.println("\nIngrese nuevo rol: ");
                usuario.setRol(Movilidad.leerString());
                System.out.println("Rol modificada");
                return;
            }
        }
        System.out.println("Usuario no encontrado");
    }

    private void eliminar() {
        System.out.println("\nEliminar usuario");
        System.out.println("Ingrese usuario: ");
        String nombreUsuario = Movilidad.leerString();
        boolean eliminado = Movilidad.usuarios.removeIf(usuario -> usuario.getUsuario().equals(nombreUsuario));
        System.out.println(eliminado ? "Usuario eliminado" : "Usuario no encontrado");
    }
}