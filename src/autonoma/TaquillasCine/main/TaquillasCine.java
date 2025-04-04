package autonoma.TaquillasCine.main;

import autonoma.TaquillasCine.models.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TaquillasCine {
    private static Scanner scanner = new Scanner(System.in);
    private static Sistema sistema = new Sistema();
    
    public static void main(String[] args) {
       
        mostrarMenuPrincipal();
    }
   
    
    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\nSISTEMA DE TAQUILLA DE CINE");
            System.out.println("1. Gestionar Peliculas");
            System.out.println("2. Gestionar Usuarios");
            System.out.println("3. Vender Boletas");
            System.out.println("4. Salir");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    menuGestionPeliculas();
                    break;
                case 2:
                    menuGestionUsuarios();
                    break;
                case 3:
                    procesarVenta();
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);
    }
    
    private static void menuGestionPeliculas() {
        int opcion;
        do {
            System.out.println("\nGESTION DE PELICULAS");
            System.out.println("1. Agregar Pelicula");
            System.out.println("2. Listar Peliculas");
            System.out.println("3. Actualizar Pelicula");
            System.out.println("4. Eliminar Pelicula");
            System.out.println("5. Volver al Menu Principal");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    agregarPelicula();
                    break;
                case 2:
                    listarPeliculas();
                    break;
                case 3:
                    actualizarPelicula();
                    break;
                case 4:
                    eliminarPelicula();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }
    
    private static void menuGestionUsuarios() {
        int opcion;
        do {
            System.out.println("\nGESTION DE USUARIOS");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Buscar Usuario");
            System.out.println("3. Actualizar Usuario");
            System.out.println("4. Eliminar Usuario");
            System.out.println("5. Volver al Menu Principal");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    buscarUsuario();
                    break;
                case 3:
                    actualizarUsuario();
                    break;
                case 4:
                    eliminarUsuario();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcion no válida.");
            }
        } while (opcion != 5);
    }
    
    // Métodos para gestion de películas
    private static void agregarPelicula() {
        System.out.println("\nAGREGAR PELICULA");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Director: ");
        String director = scanner.nextLine();
        System.out.print("Genero: ");
        String genero = scanner.nextLine();
        System.out.print("Duracion (minutos): ");
        int duracion = scanner.nextInt();
        System.out.print("Costo Base: ");
        double costoBase = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
        
        Pelicula pelicula = new Pelicula(titulo, director, genero, duracion, costoBase);
        sistema.agregarPelicula(pelicula);
        System.out.println("Pelicula agregada con exito!");
    }
    
    private static void listarPeliculas() {
        System.out.println("\nLISTADO DE PELICULAS");
        List<Pelicula> peliculas = sistema.listarPeliculas();
        if (peliculas.isEmpty()) {
            System.out.println("No hay peliculas registradas");
            return;
        }
        
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println((i+1) + ". " + peliculas.get(i));
        }
    }
    
    private static void actualizarPelicula() {
        listarPeliculas();
        List<Pelicula> peliculas = sistema.listarPeliculas();
        
        if (peliculas.isEmpty()) {
            return;
        }
        
        System.out.print("\nSeleccione el numero de la pelicula a actualizar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar buffer
        
        if (indice < 0 || indice >= peliculas.size()) {
            System.out.println("Numero invalido");
            return;
        }
        
        Pelicula pelicula = peliculas.get(indice);
        
        System.out.println("\nACTUALIZAR PELÍCULA");
        System.out.print("Nuevo titulo [" + pelicula.getTitulo() + "]: ");
        String titulo = scanner.nextLine();
        if (!titulo.isEmpty()) pelicula.setTitulo(titulo);
        
        System.out.print("Nuevo director [" + pelicula.getDirector() + "]: ");
        String director = scanner.nextLine();
        if (!director.isEmpty()) pelicula.setDirector(director);
        
        System.out.print("Nuevo genero [" + pelicula.getGenero() + "]: ");
        String genero = scanner.nextLine();
        if (!genero.isEmpty()) pelicula.setGenero(genero);
        
        System.out.print("Nueva duracion [" + pelicula.getDuracion() + "]: ");
        String duracionStr = scanner.nextLine();
        if (!duracionStr.isEmpty()) pelicula.setDuracion(Integer.parseInt(duracionStr));
        
        System.out.print("Nuevo costo base [" + pelicula.getCostoBase() + "]: ");
        String costoStr = scanner.nextLine();
        if (!costoStr.isEmpty()) pelicula.setCostoBase(Double.parseDouble(costoStr));
        
        System.out.print("¿Esta activa? (true/false) [" + pelicula.isActiva() + "]: ");
        String activaStr = scanner.nextLine();
        if (!activaStr.isEmpty()) pelicula.setActiva(Boolean.parseBoolean(activaStr));
        
        sistema.actualizarPelicula(pelicula);
        System.out.println("Pelicula actualizada con exito!");
    }
    
    private static void eliminarPelicula() {
        listarPeliculas();
        List<Pelicula> peliculas = sistema.listarPeliculas();
        
        if (peliculas.isEmpty()) {
            return;
        }
        
        System.out.print("\nSeleccione el numero de la pelicula a eliminar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar buffer
        
        if (indice < 0 || indice >= peliculas.size()) {
            System.out.println("Numero invalido");
            return;
        }
        
        Pelicula pelicula = peliculas.get(indice);
        sistema.eliminarPelicula(pelicula.getTitulo());
        System.out.println("Pelicula eliminada");
    }
    
    // Métodos para gestión de usuarios
    private static void registrarUsuario() {
        System.out.println("\nREGISTRAR USUARIO");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Identificacion: ");
        String id = scanner.nextLine();
        
        System.out.println("Tipo de usuario:");
        System.out.println("1. Nino");
        System.out.println("2. Adulto");
        System.out.println("3. Adulto Mayor");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        Usuario usuario = null;
        switch (tipo) {
            case 1:
                usuario = new UsuarioNino(nombre, id);
                break;
            case 2:
                usuario = new UsuarioAdulto(nombre, id);
                break;
            case 3:
                usuario = new UsuarioMayor(nombre, id);
                break;
            default:
                System.out.println("Tipo no valido.");
                return;
        }
        
        sistema.registrarUsuario(usuario);
        System.out.println("Usuario registrado con exito!");
    }
    
    private static void buscarUsuario() {
        System.out.println("\nBUSCAR USUARIO");
        System.out.print("Ingrese la identificacion: ");
        String id = scanner.nextLine();
        
        Usuario usuario = sistema.buscarUsuario(id);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }
    
    private static void actualizarUsuario() {
        System.out.println("\nACTUALIZAR USUARIO");
        System.out.print("Ingrese la identificacion del usuario a actualizar: ");
        String id = scanner.nextLine();
        
        Usuario usuario = sistema.buscarUsuario(id);
        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }
        
        System.out.println("Usuario actual: " + usuario);
        System.out.print("Nuevo nombre [" + usuario.getNombre() + "]: ");
        String nombre = scanner.nextLine();
        
        Usuario nuevoUsuario = null;
        if (usuario instanceof UsuarioNino) {
            nuevoUsuario = new UsuarioNino(nombre.isEmpty() ? usuario.getNombre() : nombre, id);
        } else if (usuario instanceof UsuarioAdulto) {
            nuevoUsuario = new UsuarioAdulto(nombre.isEmpty() ? usuario.getNombre() : nombre, id);
        } else if (usuario instanceof UsuarioMayor) {
            nuevoUsuario = new UsuarioMayor(nombre.isEmpty() ? usuario.getNombre() : nombre, id);
        }
        
        sistema.actualizarUsuario(nuevoUsuario);
        System.out.println("Usuario actualizado con exito!");
    }
    
    private static void eliminarUsuario() {
        System.out.println("\nELIMINAR USUARIO");
        System.out.print("Ingrese la identificacion del usuario a eliminar: ");
        String id = scanner.nextLine();
        
        Usuario usuario = sistema.buscarUsuario(id);
        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }
        
        System.out.println("Usuario a eliminar: " + usuario);
        System.out.print("¿Esta seguro? (S/N): ");
        String confirma = scanner.nextLine();
        
        if (confirma.equalsIgnoreCase("S")) {
            sistema.eliminarUsuario(id);
            System.out.println("Usuario eliminado");
        } else {
            System.out.println("Operacion cancelada");
        }
    }
    
    // Método para procesar ventas
    private static void procesarVenta() {
        List<Pelicula> peliculas = sistema.listarPeliculas();
        if (peliculas.isEmpty()) {
            System.out.println("\nNo hay peliculas disponibles para vender boletas");
            return;
        }
        
        System.out.println("\nVENTA DE BOLETAS");
        
        // Buscar al usuario
        System.out.print("Ingrese ID del usuario: ");
        String idUsuario = scanner.nextLine();
        Usuario usuario = sistema.buscarUsuario(idUsuario);
        
        if (usuario == null) {
            System.out.println("Usuario no encontrado. Debe registrar al usuario primero.");
            return;
        }
        
        // Seleccionar película
        listarPeliculas();
        System.out.print("\nSeleccione el numero de la pelicula: ");
        int indicePelicula = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar buffer
        
        if (indicePelicula < 0 || indicePelicula >= peliculas.size()) {
            System.out.println("Numero de película invalido.");
            return;
        }
        
        Pelicula peliculaSeleccionada = peliculas.get(indicePelicula);
        
        // Seleccionar función
        System.out.println("\nSeleccione tipo de funcion:");
        System.out.println("1. Primera (Antes de las 15:00)");
        System.out.println("2. Tarde (Entre 15:00 y 19:00)");
        System.out.println("3. Noche (Después de las 19:00)");
        int tipoFuncion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese hora de la funcion (HH:MM): ");
        String hora = scanner.nextLine();
        
        Funcion funcion = null;
        switch (tipoFuncion) {
            case 1:
                funcion = new FuncionPrimera(hora);
                break;
            case 2:
                funcion = new FuncionTarde(hora);
                break;
            case 3:
                funcion = new FuncionNoche(hora);
                break;
            default:
                System.out.println("Tipo de funcion invalido");
                return;
        }
        
        // Obtener información adicional para la boleta
        System.out.print("Ingrese numero de sala: ");
        int numeroSala = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese numero de asiento: ");
        String asiento = scanner.nextLine();
        
        // Crear boleta
        Boleta boleta = new Boleta(peliculaSeleccionada, funcion, usuario, numeroSala, asiento);
        
        // Crear venta
        Venta venta = new Venta(new Date());
        venta.agregarBoleta(boleta);
        
        // Calcular el costo final
        double costoFinal = boleta.calcularCostoFinal();
        System.out.println("\n== RESUMEN DE VENTA ==");
        System.out.println("Pelicula: " + peliculaSeleccionada.getTitulo());
        System.out.println("Funcion: " + funcion.getHora());
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Sala: " + numeroSala);
        System.out.println("Asiento: " + asiento);
        System.out.println("Costo Base: $" + peliculaSeleccionada.getCostoBase());
        System.out.println("Descuento Funcion: " + funcion.getPorcentajeDescuento() + "%");
        System.out.println("Descuento Usuario: " + usuario.getValorDescuento() + "%");
        System.out.println("Costo Final: $" + costoFinal);
        
        // Confirmar venta
        System.out.print("\n¿Confirmar venta? (S/N): ");
        String confirma = scanner.nextLine();
        
        if (confirma.equalsIgnoreCase("S")) {
            // Procesar la venta en el sistema
            sistema.venderBoletas(venta);
            
            // Generar factura
            Factura factura = sistema.generarFactura(venta);
            
            // Mostrar información de la factura
            System.out.println("\nFACTURA");
            System.out.println("Numero de Factura: " + factura.getNumeroFactura());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println("Fecha: " + dateFormat.format(new Date()));
            System.out.println("Total: $" + venta.calcularTotalVenta());
            System.out.println("\n¡Venta realizada con exito!");
        } else {
            System.out.println("Venta cancelada");
        }
    }
}