/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillasCine.models;

import autonoma.TaquillasCine.models.Usuario;

/**
 *
 * @author Asus Isabela Quintero
 */
public class UsuarioNino extends Usuario {
     public UsuarioNino(String nombre, String id) {
        super(nombre, id);
        calcularDescuentoUsuario();
    }
    
    @Override
    public void calcularDescuentoUsuario() {
        // Los niños tienen un 20% de descuento
        this.valorDescuento = 0.20;
    }
    
    @Override
    public String toString() {
        return "Usuario Niño: " + nombre + " - ID: " + identificacion + 
               " - Descuento: " + (valorDescuento * 100) + "%";
    }
}
