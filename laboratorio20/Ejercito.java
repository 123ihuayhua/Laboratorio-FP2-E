package laboratorio20;

import java.util.*;

public class Ejercito {
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();
    static final int MAX = 10;
    
    private String nombre_ejercito;
    private ArrayList<Soldado> misSoldadosL = new ArrayList<Soldado>();
    private ArrayList<Soldado> misSoldadosE = new ArrayList<Soldado>();
    private ArrayList<Soldado> misSoldadosA = new ArrayList<Soldado>();
    private ArrayList<Soldado> misSoldadosC = new ArrayList<Soldado>();
    private ArrayList<Soldado> misSoldados = new ArrayList<Soldado>();
    private String reino;
    private int fila;
    private int columna;
    private int num_soldados;
	
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
	
    public void eliminarsusSoldados() {
	this.misSoldados.clear();
    }
	
    public String getReino() {
	return reino;
    }
	
    public void addSoldadoAutogenerado(String reino) {
	int puntos_vida = r.nextInt(5) + 1;
        int puntos_ataque = r.nextInt(5) + 1;
        int puntos_defensa = r.nextInt(5) + 1;
	String nombre = "\nSoldado" + misSoldados.size();
	this.addSoldado(new Soldado(nombre, puntos_vida, puntos_ataque, puntos_defensa, reino));
    }
	
    public void addSoldadoAutogeneradoL(String reino) {
	int puntos_vida = r.nextInt(2) + 1;
        int puntos_ataque = r.nextInt(5) + 1;
        int puntos_defensa = r.nextInt(5) + 1;
	String nombre = "\nLancero\n" + misSoldados.size();
	misSoldadosE.add(new SoldadoE(nombre, puntos_vida, puntos_ataque, puntos_defensa, reino));
    }
    
    public void addSoldadoAutogeneradoE(String reino) {
	int puntos_vida = r.nextInt(1) + 3;
        int puntos_ataque = r.nextInt(5) + 1;
        int puntos_defensa = r.nextInt(5) + 1;
	String nombre = "\nEspadachin\n" + misSoldados.size();
	misSoldadosE.add(new SoldadoE(nombre, puntos_vida, puntos_ataque, puntos_defensa, reino));
    }
	
    public void addSoldadoAutogeneradoA(String reino) {
	int puntos_vida = r.nextInt(2) + 1;
        int puntos_ataque = r.nextInt(5) + 1;
        int puntos_defensa = r.nextInt(5) + 1;
	String nombre = "\nArquero\n" + misSoldados.size();
	misSoldadosA.add(new SoldadoA(nombre, puntos_vida, puntos_ataque, puntos_defensa, reino, 10));}
    public void addSoldadoAutogeneradoC(String reino) {
	int puntos_vida = r.nextInt(2) + 3;
        int puntos_ataque = r.nextInt(5) + 1;
        int puntos_defensa = r.nextInt(5) + 1;
	String nombre = "Caballero\n" + misSoldados.size();
	misSoldadosC.add(new SoldadoC(nombre, puntos_vida, puntos_ataque, puntos_defensa, reino));}
    public ArrayList<Integer> genNumSolXTipo() {
	ArrayList<Integer> numSoldadosTipo = new ArrayList<>();
	int num1, num2 = 1, num3 = 1, num4 = 1;
	num1 = r.nextInt(Ejercito.MAX)+1;
        if (num1 == 1 && num1 < Ejercito.MAX) {
            num2 = r.nextInt(Ejercito.MAX - num1)+1;
            if (num2 == 1 && num2 < Ejercito.MAX - num1) {
		num3 = r.nextInt(Ejercito.MAX - num1 - num2);
            }
            if (num3 == 1 && num3<Ejercito.MAX - num1 - num2) {
                num4 = r.nextInt(Ejercito.MAX - num1 - num2 - num3);
            } else {
		num3 = 1;
            }
	} else {
            num4 = 1;
	}
	numSoldadosTipo.add(num1);
	numSoldadosTipo.add(num2);
	numSoldadosTipo.add(num3);
        numSoldadosTipo.add(num4);
	return numSoldadosTipo;
    }
	
    public void generarSoldadosAleatorioXtipo(ArrayList<Integer> a, String reino) {
	int contador = 0;
	int puntos_vida,puntos_ataque,puntos_defensa;
	String numero_de_ejercito = nombre_ejercito.substring(nombre_ejercito.length() -1);
	for (int i = 0; i < a.get(0); i++) {//arqueros
            puntos_vida = r.nextInt(2) + 1;
            puntos_ataque = r.nextInt(5)+1;
            puntos_defensa = r.nextInt(5)+1;
            misSoldadosA.add(new SoldadoA("Arquero" + contador + "X" + numero_de_ejercito, puntos_vida, puntos_ataque, puntos_defensa, reino, 10 ));
            contador++;
	}
        for (int i = 0; i < a.get(1); i++) {//espadachines
            puntos_vida = r.nextInt(1) + 3;
            puntos_ataque = r.nextInt(5)+1;
            puntos_defensa = r.nextInt(5)+1;
            misSoldadosE.add(new SoldadoE("Espadachin" + contador + "X" + numero_de_ejercito, puntos_vida, puntos_ataque, puntos_defensa, reino));
            contador++;
	}	
        for (int i = 0; i < a.get(2); i++) {//caballero
            puntos_vida = r.nextInt(2) + 3;
            puntos_ataque = r.nextInt(5)+1;
            puntos_defensa = r.nextInt(5)+1;
            misSoldadosC.add(new SoldadoC("Caballero" + contador + "X" + numero_de_ejercito, puntos_vida, puntos_ataque, puntos_defensa, reino));
            contador++;
        }
        for (int i = 0; i < a.get(3); i++) {//lancero
            puntos_vida = r.nextInt(2) + 1;
            puntos_ataque = r.nextInt(5)+1;
            puntos_defensa = r.nextInt(5)+1;
            misSoldadosC.add(new SoldadoC("Lancero" + contador + "X" + numero_de_ejercito, puntos_vida, puntos_ataque, puntos_defensa, reino));
            contador++;
        }
    }
	
    public ArrayList<Soldado> getMisSoldadosE() {
	return misSoldadosE;
    }
	
    public ArrayList<Soldado> getMisSoldadosA() {
	return misSoldadosA;
    }
	
    public ArrayList<Soldado> getMisSoldadosC() {
	return misSoldadosC;
    }
    
    public ArrayList<Soldado> getMisSoldadosL() {
	return misSoldadosL;
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
	
    public String toString() {
	return "\t" + nombre_ejercito + ": " + reino + 
                "\n" +misSoldadosA + 
                "\n" +misSoldadosC + 
                "\n" +misSoldadosE + "\n";
    }
	
    public int getNum_soldados() {
	return num_soldados;
    }
	
    public int sumaNivelVida() {
	int suma = 0;
	suma = sumaNivelVidaA() + sumaNivelVidaC() + sumaNivelVidaE() + sumaNivelVidaL();
	return suma;
    }
	
    public int sumaNivelVidaE() {
	int suma = 0;
	for (int i = 0; i < this.getMisSoldadosE().size(); i++) {
            suma += misSoldadosE.get(i).getVidaActual();
        }
	return suma;
    }
	
    public int sumaNivelVidaA() {
	int suma = 0;
	for (int i = 0; i < this.getMisSoldadosA().size(); i++) {
            suma += misSoldadosA.get(i).getVidaActual();
	}
            return suma;
    }
	
    public int sumaNivelVidaC() {
	int suma = 0;
	for (int i = 0; i < this.getMisSoldadosC().size(); i++) {
            suma += misSoldadosC.get(i).getVidaActual();
	}
	return suma;
    }
    
    public int sumaNivelVidaL() {
	int suma = 0;
	for (int i = 0; i < this.getMisSoldadosL().size(); i++) {
            suma += misSoldadosL.get(i).getVidaActual();
	}
	return suma;
    }
    
    public void ordenarPorPuntosBurbuja() {
	for (int i = 1; i < misSoldados.size(); i++) {
            for (int j = 0; j < misSoldados.size() - i; j++) {
		if (misSoldados.get(j).getNivelVida() > misSoldados.get(j + 1).getNivelVida()) {
                    intercambiar(misSoldados, j, j + 1);
                }
            }
	}
    }
	
    public static void intercambiar(ArrayList<Soldado> a, int i, int j) {
	Soldado aux = new Soldado("provi");
	aux = a.get(i);
	a.set(i, a.get(j));
	a.set(j, aux);
    }
    public void ordenarPorPuntosInsercion() {
	int j, aux;
	Soldado sold_temp = new Soldado("provi");
	for (int i = 1; i < misSoldados.size(); i++) {
            sold_temp = misSoldados.get(i);
            aux = misSoldados.get(i).getNivelVida();
            j = i - 1;
            while (j >= 0 && aux < misSoldados.get(j).getNivelVida()) {
		misSoldados.set(j + 1, misSoldados.get(j));
		j--;
            }
            misSoldados.set(j + 1, sold_temp);
	}
    }
    public Soldado mayor_fila() {
	Soldado mayor = new Soldado();
	mayor = mayor_filaA();
	if (mayor_filaE().getVidaActual() > mayor_filaA().getVidaActual()) {
            if (mayor_filaE().getVidaActual() > mayor_filaC().getVidaActual()) {
		return mayor_filaE();
            } else {
		return mayor_filaC();
            }
	} else {
            if (mayor_filaA().getVidaActual() > mayor_filaC().getVidaActual()) {
		return mayor_filaA();
            } else {
		return mayor_filaC();
            }
	}
    }
	
    public Soldado mayor_filaE() {
	int mayor = 0, indice = 0;
	for (int i = 0; i < misSoldadosE.size(); i++) {
            if (misSoldadosE.get(i).getNivelVida() > mayor) {
		mayor = misSoldadosE.get(i).getNivelVida();
		indice = i;
            }
	}
	return misSoldadosE.get(indice);
    }
	
    public Soldado mayor_filaA() {
	int mayor = 0, indice = 0;
	for (int i = 0; i < misSoldadosA.size(); i++) {
            if (misSoldadosA.get(i).getNivelVida() > mayor) {
		mayor = misSoldadosA.get(i).getNivelVida();
		indice = i;
            }
	}
	return misSoldadosA.get(indice);
    }
	
    public Soldado mayor_filaC() {
	int mayor = 0, indice = 0;
	for (int i = 0; i < misSoldadosC.size(); i++) {
            if (misSoldadosC.get(i).getNivelVida() > mayor) {
                mayor = misSoldadosC.get(i).getNivelVida();
		indice = i;
            }
	}
	return misSoldadosC.get(indice);
    }
    
    public Soldado mayor_filaL() {
	int mayor = 0, indice = 0;
	for (int i = 0; i < misSoldadosL.size(); i++) {
            if (misSoldadosL.get(i).getNivelVida() > mayor) {
                mayor = misSoldadosL.get(i).getNivelVida();
		indice = i;
            }
	}
	return misSoldadosL.get(indice);
    }
}
