/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio15;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author asus
 */
public class Mapa_Soldados {
    static Random r = new Random();
    private int fila;
    private int columna;
    private Soldado[][] tablero;
    private String terreno;
    
    public Mapa_Soldados(int a, int b, String terreno) {
        fila = a;
        columna = b;
        tablero = new Soldado[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                tablero[i][j] = null;
            }
	}
	this.terreno = terreno;
    }
    
    public String getTerreno() {
	return terreno;
    }
    
    public void setTerreno(String terreno) {
	this.terreno = terreno;
    }
	
    public void generaTerreRandom(ArrayList<String> a) {
        int aleatorio = r.nextInt(a.size());
	this.setTerreno(a.get(aleatorio));
    }
    
    public void mostrar() {
	for (int i = 0; i < tablero.length; i++)
            System.out.print("\t|"+i+"|");
        for (int i = 0; i < tablero.length; i++) {   
            System.out.println();
            System.out.print(" |"+i+"|");
        for (int j = 0; j < tablero[i].length; j++) {
		if (tablero[i][j] == null) {
                    System.out.print("\t_ ");
		} else {
                    System.out.print("\t" + tablero[i][j].getNivelVida() + tablero[i][j].getReino().substring(0,1));
		}    
            }
            System.out.println();    
	}
    }
	
    public void llenartablero(Soldado a) {
        int filat, columnat, i = 0;
        do {
            filat = r.nextInt(Ejercito.MAX);
            columnat = r.nextInt(Ejercito.MAX);
        } while (tablero[filat][columnat] != null);
        tablero[filat][columnat] = a;
        i++;
    }
    
    public Soldado[][] getTablero() {
	return tablero;
    }
	
    public Soldado getSoldado(int fila, int columna) {
	Soldado ejercitoobtenido = new Soldado();
	ejercitoobtenido = this.tablero[fila][columna];
	return ejercitoobtenido;
    }
	
    public void setSoldado(int fila, int columna, Soldado a) {
        this.tablero[fila][columna] = a;
    }
    
    public void setTablero(Soldado[][] tablero) {
	this.tablero = tablero;
    }
}
