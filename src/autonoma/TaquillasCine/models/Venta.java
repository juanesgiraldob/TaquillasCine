/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillasCine.models;

import autonoma.TaquillasCine.models.Boleta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {
    private Date fecha;
    private double totalVenta;
    private List<Boleta> boletas;
    
    public Venta(Date fecha) {
        this.fecha = fecha;
        this.boletas = new ArrayList<>();
        this.totalVenta = 0.0;
    }
    
    public void agregarBoleta(Boleta boleta) {
        boletas.add(boleta);
    }
    
    public double calcularTotalVenta() {
        totalVenta = 0.0;
        for (Boleta boleta : boletas) {
            totalVenta += boleta.getCostoFinal();
        }
        return totalVenta;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public double getTotalVenta() {
        return totalVenta;
    }
    
    public List<Boleta> getBoletas() {
        return boletas;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta - Fecha: ").append(fecha).append("\n");
        sb.append("Boletas:\n");
        for (Boleta boleta : boletas) {
            sb.append("- ").append(boleta.toString()).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", totalVenta));
        return sb.toString();
    }
}