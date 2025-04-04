
package autonoma.TaquillaCine.models;

public class Boleta {
    private double costoFinal;
    private int numeroSala;
    private String asiento;
    private Pelicula pelicula;
    private Funcion funcion;
    private Usuario usuario;
    
    public Boleta(Pelicula pelicula, Funcion funcion, Usuario usuario, int numeroSala, String asiento) {
        this.pelicula = pelicula;
        this.funcion = funcion;
        this.usuario = usuario;
        this.numeroSala = numeroSala;
        this.asiento = asiento;
        calcularCostoFinal();
    }
    
    public double calcularCostoFinal() {
        double costoBase = pelicula.getCostoBase();
        double descuentoFuncion = funcion.getPorcentajeDescuento();
        double descuentoUsuario = usuario.getValorDescuento();
        
        // Aplicamos descuentos
        costoFinal = costoBase * (1 - descuentoFuncion) * (1 - descuentoUsuario);
        return costoFinal;
    }
    
    public double getCostoFinal() {
        return costoFinal;
    }
    
    public int getNumeroSala() {
        return numeroSala;
    }
    
    public String getAsiento() {
        return asiento;
    }
    
    public Pelicula getPelicula() {
        return pelicula;
    }
    
    public Funcion getFuncion() {
        return funcion;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    @Override
    public String toString() {
        return "Boleta - Pelicula: " + pelicula.getTitulo() + 
               " | Funcion: " + funcion.getHora() + 
               " | Usuario: " + usuario.getNombre() + 
               " | Sala: " + numeroSala + 
               " | Asiento: " + asiento + 
               " | Costo: $" + String.format("%.2f", costoFinal);
    }
}
