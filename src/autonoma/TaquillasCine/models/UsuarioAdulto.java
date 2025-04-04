/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillasCine.models;

import autonoma.TaquillasCine.models.Usuario;

/**
 *
 * @author Asus
 */
public class UsuarioAdulto extends Usuario {
    public UsuarioAdulto(String nombre, String id) {
        super(nombre, id);
        calcularDescuentoUsuario();
    }
    
    @Override
    public void calcularDescuentoUsuario() {
        // Los adultos no tienen descuento
        this.valorDescuento = 0.0;
    }
    
    @Override
    public String toString() {
        return "Usuario Adulto: " + nombre + " - ID: " + identificacion + 
               " - Descuento: " + (valorDescuento * 100) + "%";
    }
} 

