
package autonoma.TaquillasCine.models;

import autonoma.TaquillasCine.models.Funcion;

public class FuncionNoche extends Funcion {
    public FuncionNoche(String hora) {
        super(hora);
        calcularDescuentoFuncion();
    }
    
    @Override
    public void calcularDescuentoFuncion() {
        // Las funciones de noche no tienen descuento
        this.porcentajeDescuento = 0.0;
    }
    
    @Override
    public String toString() {
        return "Funcion Noche - Hora: " + hora + " - Descuento: " + (porcentajeDescuento * 100) + "%";
    }
}

