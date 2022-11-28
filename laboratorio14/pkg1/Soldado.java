/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio14.pkg1;

/**
 *
 * @author asus
 */
public class Soldado {
    public String nombre;
    public int NivelAtaque;
    public int NivelDefensa;
    public int NivelVida;
    public int vidaActual;
    public int velocidad;
    public String actitud;
    public boolean vive;
    public int fila;
    public int columna;
    public String Reino;
    public static int cantidad_total_solda;
    public static int cantidad_total_a;
    public static int cantidad_total_b;
    public static final int MAX = 10;

    public Soldado(String a, int b, String c) {
        nombre = a;
        NivelVida = b;
        this.setVidaActual(NivelVida);
	this.setReino(c);
    }

    public Soldado() {
    }
    
    //Constructores
    public Soldado(String n) {
	nombre = n;
    }
	
    public Soldado(String a, int b, int c) {
	nombre = a;
	NivelVida = b;
	NivelAtaque = c;
	this.setVidaActual(NivelVida);
    }
    
    public String getNombre() {
	return nombre;
    }
	
    public void setNombre(String nombre) {
	this.nombre = nombre;
    }
    
    public int getNivelAtaque() {   
        return NivelAtaque;
    }
	
    public void setNivelAtaque(int NivelAtaque) {
	this.NivelAtaque = NivelAtaque;
    }
	
    public int getNivelDefensa() {
	return NivelDefensa;
    }
    
    public void setNivelDefensa(int NivelDefensa) {
        this.NivelDefensa = NivelDefensa;
    }
    
    public int getVelocidad() {
        return velocidad;
    }
	
    public void setVelocidad(int velocidad) {
	this.velocidad = velocidad;
    }
	
    public int getNivelVida() {
        return NivelVida;
    }
	
    public void setNivelVida(int NivelVida) {
	this.NivelVida = NivelVida;
    }
	
    public int getVidaActual() {
	return vidaActual;
    }
	
    public void setVidaActual(int a) {
	vidaActual = a;
    }
    
    public void setFila(int f) {
	fila = f;
    }
	
    public void setColumna(int c) {
	columna = c;
    }
	
    public int getFila() {
	return fila;
    }
    
    public int getColumna() {
	return columna;
    }
	
    public void atacar() {
	avanzar();
    }
	
    public void defender() {
        velocidad = 0;
    }
    
    public void avanzar() {
	velocidad += 1;
    }
	
    public void retroceder() {
	if (velocidad > 0) {
            defender();
        }
        if (velocidad == 0) {
            velocidad -= 1;
	}
    }
	
    public void ser_atacado() {
        vidaActual -= 1;
        if (vidaActual == 0) {
            morir();
	}
    }
	
    public void huir() {
        velocidad += 2;
    }
	
    public void morir() {
        vive = false;
    }
	
    public String getReino() {
        return Reino;
    }
	
    public void addNivelactualvida() {
	vidaActual++;
    }

    public void setReino(String Reino) {
	this.Reino = Reino;
    }
	
//Metodos de clase
    public static int getCantidad_total_solda() {
        return cantidad_total_solda;
    }
    
    public static void setCantidad_total_solda(int cantidad_total_solda) {
	Soldado.cantidad_total_solda = cantidad_total_solda;
    }
	
    public static int getCantidad_total_a() {
	return cantidad_total_a;
    }
    
    public static void setCantidad_total_a(int cantidad_total_a) {
	Soldado.cantidad_total_a = cantidad_total_a;
    }

    public static int getCantidad_total_b() {
	return cantidad_total_b;
    }
	
    public static void setCantidad_total_b(int cantidad_total_b) {
	Soldado.cantidad_total_b = cantidad_total_b;
    }
	
    public static void addCantidadTotalSoldados() {
	cantidad_total_solda++;
    }
    
    public static void disminuirCantidadTotalsoldados() {
	cantidad_total_solda--;
    }
    	
    public static void addCantidadSoldad_a() {
	cantidad_total_a++;
    }
	
    public static void disminuirCantidadSoldad_a() {
	cantidad_total_a--;
    }
	
    public static void addCantidadSoldad_b() {
	cantidad_total_b++;
    }
    
    public static void disminuirCantidadSoldad_b() {
        cantidad_total_b--;
    }
	
    // Completar con otros métodos necesarios
    @Override
    public String toString() {
        return "\t\n"+nombre + " Nivel de Vida: " + NivelVida + " Vida Actual: "+ vidaActual;
    }
}
