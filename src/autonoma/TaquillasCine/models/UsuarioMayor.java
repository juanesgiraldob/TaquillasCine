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
public class UsuarioMayor extends Usuario {
    public UsuarioMayor(String nombre, String id) {
        super(nombre, id);
        calcularDescuentoUsuario();
    }
    
    @Override
    public void calcularDescuentoUsuario() {
        // Los adultos mayores tienen un 30% de descuento
        this.valorDescuento = 0.30;
    }
    
    @Override
    public String toString() {
        return "Usuario Mayor: " + nombre + " - ID: " + identificacion + 
               " - Descuento: " + (valorDescuento * 100) + "%";
    }
}
    

