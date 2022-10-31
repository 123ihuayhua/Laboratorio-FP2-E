/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio07;

/**
 *
 * @author asus
 */
public class Soldado {
    
    private String nombre;
    private int fila;
    private int columna;
    private int puntos_de_vida;
    private String setEquipo;

    // Metodos mutadores
    public void setPuntos_Vida(int a) {
        puntos_de_vida = a;
    }
    public void setNombre(String n) {
        nombre = n;
    }
    public void setFila(int f) {
        fila = f;
    }
    public void setColumna(int c) {
        columna = c;
    }
    
    // Metodos accesores
    public String getNombre() {
        return nombre;
    }
    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    public int getPuntos_Vida() {
        return puntos_de_vida;
    }
    public String setEquipo() {
        return setEquipo;
    }
    
    // Completar con otros métodos necesarios
    public String toString() {
        return nombre + " : PV " + puntos_de_vida;
    }
    public String setEquipo(boolean team) {
        return nombre + " : PV "+ setEquipo;
    }

}
