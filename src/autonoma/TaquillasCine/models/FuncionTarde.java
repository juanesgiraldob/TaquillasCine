package autonoma.TaquillasCine.models;

import autonoma.TaquillasCine.models.Funcion;

public class FuncionTarde extends Funcion {
    
    public FuncionTarde(String hora) {
        super(hora);
        calcularDescuentoFuncion();
    }
    
    @Override
    public void calcularDescuentoFuncion() {
        // Las funciones de tarde tienen un 10% de descuento
        this.porcentajeDescuento = 0.10;
    }
    
    @Override
    public String toString() {
        return "Funcion Tarde - Hora: " + hora + " - Descuento: " + (porcentajeDescuento * 100) + "%";
    }
}