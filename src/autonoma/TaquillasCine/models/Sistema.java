package autonoma.TaquillasCine.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema implements GestionPeliculas, GestionUsuarios {
    private List<Pelicula> peliculas;
    private Map<String, Usuario> usuarios;
    private int contadorFacturas;
    
    public Sistema() {
        peliculas = new ArrayList<>();
        usuarios = new HashMap<>();
        contadorFacturas = 1000; // Comienza desde 1000
    }
    
    public void venderBoletas(Venta venta) {
        // Lógica para vender boletas
        venta.calcularTotalVenta();
    }
    
    public Factura generarFactura(Venta venta) {
        return new Factura(venta, contadorFacturas++);
    }
    
    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }
    
    @Override
    public void eliminarPelicula(String titulo) {
        peliculas.removeIf(p -> p.getTitulo().equals(titulo));
    }
    
    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getTitulo().equals(pelicula.getTitulo())) {
                peliculas.set(i, pelicula);
                break;
            }
        }
    }
    
    @Override
    public List<Pelicula> listarPeliculas() {
        return new ArrayList<>(peliculas);
    }
    
    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getIdentificacion(), usuario);
    }
    
    @Override
    public void eliminarUsuario(String identificacion) {
        usuarios.remove(identificacion);
    }
    
    @Override
    public void actualizarUsuario(Usuario usuario) {
        if (usuarios.containsKey(usuario.getIdentificacion())) {
            usuarios.put(usuario.getIdentificacion(), usuario);
        }
    }
    
    @Override
    public Usuario buscarUsuario(String id) {
        return usuarios.get(id);
    }
    
    public void gestionarPeliculas() {
        // Implementación de gestión de películas
        System.out.println("gestionando peliculas");
    }
    
    public void gestionarUsuarios() {
        // Implementación de gestión de usuarios
        System.out.println("gestionando usuarios");
    }
}
