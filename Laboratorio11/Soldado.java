/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio11;

/**
 *
 * @author asus
 */
public class Soldado {
    private String nombre;
    private int NivelAtaque;
    private int NivelDefensa;
    private int NivelVida;
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;
    private int fila;
    private int columna; 
    
    public Soldado(){

	}
    //Constructores
    public Soldado(String n) {
	nombre = n;
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
	public Soldado(String a, int b) {
		nombre = a;
		NivelAtaque = b;
	}
	public Soldado(String a, int b, int c) {
		nombre = a;
		NivelAtaque = b;
		NivelDefensa = c;
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
	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
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
	// Completar con otros métodos necesarios
	@Override
	public String toString() {
		return nombre + " : PV " + vidaActual +" Ataque: " + NivelAtaque + " Defensa: " + NivelDefensa ;
	}
}
