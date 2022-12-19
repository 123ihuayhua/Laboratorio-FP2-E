package laboratorio19;

import java.util.ArrayList;
import java.util.Random;

public class Mapa {
    static Random r = new Random();
    private int fila;
    private int columna;
    private Ejercito[][] tablero;
    private Soldado[][] tableroS;
    private String terreno;
        
    public Mapa(int a, int b, String terreno) {
        fila = a;
        columna = b;
        tablero = new Ejercito[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                tablero[i][j] = null;
            }
        }
        this.terreno = terreno;
    }
        
    public Mapa(int a, int b) {
        fila = a;
        columna = b;
        tableroS = new Soldado[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                tableroS[i][j] = null;
            }
        }
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
	
    public void mostrarS() {
	for (int i = 0; i < tableroS.length; i++) 
            System.out.print("\t|"+i+"|");
        for (int i = 0; i < tableroS.length; i++) {   
            System.out.println();
            System.out.print(" |"+i+"|");
            for (int j = 0; j < tableroS[i].length; j++) {
                if (tableroS[i][j] == null) {
                    System.out.print("\t_ ");
                } else {
                    System.out.print("\t" + tableroS[i][j].getReino().substring(0,1).toLowerCase()+tableroS[i][j].getNombre().substring(0,1));
                }
            }
            System.out.println();
	}
    }
		
    public void llenartableroS(Soldado a) {
	int filat, columnat, i = 0;
	do {
            filat = r.nextInt(Ejercito.MAX);
            columnat = r.nextInt(Ejercito.MAX);
	} while (tableroS[filat][columnat] != null);
            tableroS[filat][columnat] = a;
            i++;
	}
	
    public Ejercito getEjercito(int fila, int columna) {
	Ejercito ejercitoobtenido = new Ejercito();
	ejercitoobtenido = this.tablero[fila][columna];
	return ejercitoobtenido;
    }
	
    public void setEjercito(int fila, int columna, Ejercito a) {
	this.tablero[fila][columna] = a;
    }
	
    public void setTablero(Ejercito[][] tablero) {
	this.tablero = tablero;
    }
}

