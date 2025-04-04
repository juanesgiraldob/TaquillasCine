
package autonoma.TaquillasCine.models;

import autonoma.TaquillasCine.models.Boleta;
import autonoma.TaquillasCine.models.Venta;
import java.util.Date;

public class Factura {
    private int numeroFactura;
    private Date fechaEmision;
    private Venta venta;
    
    public Factura(Venta venta, int numeroFactura) {
        this.venta = venta;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = new Date(); // Fecha actual
    }
    
    public void imprimirFactura() {
        System.out.println("Factura de venta #" + numeroFactura);
        System.out.println("Fecha de emisión: " + fechaEmision);
        System.out.println("Fecha de venta: " + venta.getFecha());
        System.out.println("Detalle completo:");
        
        for (Boleta boleta : venta.getBoletas()) {
            System.out.println("\nPELICULA: " + boleta.getPelicula().getTitulo());
            System.out.println("SALA: " + boleta.getNumeroSala() + " | ASIENTO: " + boleta.getAsiento());
            System.out.println("FUNCION: " + boleta.getFuncion().getHora());
            System.out.println("CLIENTE: " + boleta.getUsuario().getNombre());
            System.out.println("VALOR: $" + String.format("%.2f", boleta.getCostoFinal()));
        }
        
        System.out.println("TOTAL A PAGAR: $" + String.format("%.2f", venta.getTotalVenta()));
        System.out.println("Gracias por su compra");
    }
    
    public int getNumeroFactura() {
        return numeroFactura;
    }
    
    public Date getFechaEmision() {
        return fechaEmision;
    }
    
    public Venta getVenta() {
        return venta;
    }
}