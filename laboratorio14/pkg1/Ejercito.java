/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio14.pkg1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class Ejercito {
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();
    
    public String nombre_ejercito;
    public ArrayList<Soldado> misSoldados = new ArrayList<Soldado>();
    public String reino;
    public int fila;
    public int columna;
    public int num_soldados;
    public static final int MAX = 10;
    
    public Ejercito(String nombre_ejercito, String reino) {
        this.nombre_ejercito = nombre_ejercito;
	this.reino = reino;
    }
	
    public String getNombre_ejercito() {
	return nombre_ejercito;
    }

    public Ejercito() {
    }
	
    public void generarEjercitoAleatorio(String reino) {
        int aleatorio;
	aleatorio = r.nextInt(MAX) + 1;
	for (int i = 1; i < aleatorio; i++) {
            this.addSoldadoAutogenerado(reino);
            this.reino = reino;
            num_soldados++;
        }
    }

    public void eliminarsusSoldados(){
        this.misSoldados.clear();
    }
    
    public String getReino() {
	return reino;
    }
	
    public void addSoldadoAutogenerado(String reino) {
	int puntos_vida = r.nextInt(5) + 1;
	String nombre = "Soldado" + misSoldados.size();
	this.addSoldado(new Soldado(nombre, puntos_vida, reino));
    }
	
    public void addSoldado(Soldado a) {
	if (misSoldados.size() == Ejercito.MAX) {
	System.out.println("\nYa no puede agregar mas soldados\n");
        } else {
            misSoldados.add(a);
	}
    }
	
    public void subirNivelVidaEjercito() {
        for (Soldado soldado : misSoldados) {
            soldado.addNivelactualvida();
        }
    }
	
    @Override
    public String toString() {
        return reino + "\t\n"+nombre_ejercito + ": "  + "\n" + misSoldados + "\n";
    }
	
    public int getNum_soldados() {
	return num_soldados;
    }
	
    public int sumaNivelVida() {
        int suma = 0;
        for (int i = 0; i < this.getNum_soldados(); i++) {
            suma += misSoldados.get(i).getVidaActual();
        }
        return suma;
    }
}
