package autonoma.TaquillasCine.models;

import autonoma.TaquillasCine.models.Funcion;

public class FuncionPrimera extends Funcion {
    
    public FuncionPrimera(String hora) {
        super(hora);
        calcularDescuentoFuncion();
    }
    
    @Override
    public void calcularDescuentoFuncion() {
        // Las funciones de primera tienen un 5% de descuento
        this.porcentajeDescuento = 0.05;
    }
    
    @Override
    public String toString() {
        return "Funcion Primera - Hora: " + hora + " - Descuento: " + (porcentajeDescuento * 100) + "%";
    }
}