package autonoma.TaquillasCine.models;

public abstract class Usuario {
    protected String nombre;
    protected String identificacion;
    protected double valorDescuento;
    
    public Usuario(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getIdentificacion() {
        return identificacion;
    }
    
    public double getValorDescuento() {
        return valorDescuento;
    }
    
    // Método abstracto que deben implementar las clases hijas
    public abstract void calcularDescuentoUsuario();
}