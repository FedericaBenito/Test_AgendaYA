/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendaya.model;

/**
 *
 * @author Carlita
 */
public class TipoEvento {
    
private final String id;
    private final String nombre;
    private final int duracionMinutos;
    private final boolean publico;
    private final boolean disponible;
    
    public TipoEvento(String id, String nombre, int duracionMinutos, boolean publico, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.duracionMinutos = duracionMinutos;
        this.publico = publico;
        this.disponible = disponible;
    }
     public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public boolean isPublico() {
        return publico;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
