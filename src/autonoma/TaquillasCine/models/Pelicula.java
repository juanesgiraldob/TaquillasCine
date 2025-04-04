/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillasCine.models;

/**
 *
 * @author Asus
 */
public class Pelicula {
    private String titulo;
    private String director;
    private String genero;
    private int duracion;
    private double costoBase;
    private boolean activa;
    
    public Pelicula(String titulo, String director, String genero, int duracion, double costoBase) {
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.costoBase = costoBase;
        this.activa = true;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDirector() {
        return director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public double getCostoBase() {
        return costoBase;
    }
    
    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }
    
    public boolean isActiva() {
        return activa;
    }
    
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    @Override
    public String toString() {
        return "Pelicula: " + titulo + " | Director: " + director + " | Genero: " + genero +
               " | Duracion: " + duracion + " min | Costo: $" + costoBase;
    }
}

