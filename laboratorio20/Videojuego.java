package laboratorio20;


import java.util.*;
/**
 *
 * @author TOSHIBA
 */
public class Videojuego {
    static Random r = new Random();
    static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {
	String rpta;
	ArrayList<String> reinos = new ArrayList<String>();
	reinos.add("Inglaterra");
	reinos.add("Francia");
	reinos.add("Castilla");
	reinos.add("Moros");
	reinos.add("Sacro imperio Romano");
	
        while (true) {
            System.out.println("Desea generar un tablero aleatorio y/n");
            rpta = sc.next();
            if (rpta.equals("n")) {
		break;
            }
            int indiceRandomReino;
            String reinoElegido1, reinoElegido2;
            //Ejercito 1
            indiceRandomReino = r.nextInt(reinos.size());
            reinoElegido1 = reinos.get(indiceRandomReino);
            Ejercito ejercito1 = new Ejercito("Ejercito1", reinoElegido1);
            ArrayList<Integer> numSodladoTipo = ejercito1.genNumSolXTipo();
            System.out.println(numSodladoTipo);
            ejercito1.generarSoldadosAleatorioXtipo(numSodladoTipo, reinoElegido1);
            
            //Ejercito 2
            indiceRandomReino = r.nextInt(reinos.size());
            reinoElegido2 = reinos.get(indiceRandomReino);
            Ejercito ejercito2 = new Ejercito("Ejercito2", reinoElegido2);
            numSodladoTipo = ejercito2.genNumSolXTipo();
            ejercito2.generarSoldadosAleatorioXtipo(numSodladoTipo, reinoElegido2);
            
            //Mapas y llenado 
            Mapa tablero_soldados = new Mapa(10, 10);
            llenartabler(ejercito1, tablero_soldados);
            llenartabler(ejercito2, tablero_soldados);
            System.out.println(" ");
            tablero_soldados.mostrarS();

            //Imprimir ejércitos
            System.out.println(ejercito1);
            System.out.println(ejercito2);
            
            //Ordenamiento
            System.out.println("\nORDENAMIENTO POR PUNTOS BURBUJA: ");
            ejercito1.ordenarPorPuntosBurbuja();
            System.out.println("\nORDENAMIENTO POR INSERCION: ");
            ejercito2.ordenarPorPuntosInsercion();
            
            //Información
            System.out.println("\nMAYOR SOLDADO (VIDA): ");
            System.out.println("Soldado con mayor PV: Ejercito 1 -> " + ejercito1.mayor_fila());
            System.out.println("Soldado con mayor PV: Ejercito 2 -> " + ejercito2.mayor_fila());
            promedioPuntosVidaA(ejercito1);
            promedioPuntosVidaB(ejercito2);
            
            //Ganador 
            System.out.println();
            metricaTotalPuntosVida(ejercito1, ejercito2);
	}
    }
	
    public static void llenartabler(Ejercito a, Mapa b) {
	for (int i = 0; i < a.getMisSoldadosE().size(); i++) {
            b.llenartableroS(a.getMisSoldadosE().get(i));
        }
        for (int i = 0; i < a.getMisSoldadosC().size(); i++) {
            b.llenartableroS(a.getMisSoldadosC().get(i));
	}
	for (int i = 0; i < a.getMisSoldadosA().size(); i++) {
            b.llenartableroS(a.getMisSoldadosA().get(i));
	}
    }
    
    public static void promedioPuntosVidaA(Ejercito a){
        int suma = a.sumaNivelVida();
        int cant_soldados = a.getMisSoldadosA().size() + a.getMisSoldadosC().size()+a.getMisSoldadosE().size();
        double prom = suma/cant_soldados;
        System.out.println("PROMEDIO DE PV " + a.getReino() + " -> " + prom);
    }
    
    public static void promedioPuntosVidaB(Ejercito b){
        int suma = b.sumaNivelVida();
        int cant_soldados = b.getMisSoldadosA().size() + b.getMisSoldadosC().size()+b.getMisSoldadosE().size();
        double prom = suma/cant_soldados;
        System.out.println("PROMEDIO DE PV " + b.getReino() + " -> " + prom);
    }
    
    public static void metricaTotalPuntosVida(Ejercito a, Ejercito b) {
	if (a.sumaNivelVida() > b.sumaNivelVida()) {
            System.out.println("GANADOR REINO: " + a.getReino() + " MAYOR PUNTOS DE VIDA EN TOTAL -> " + a.sumaNivelVida());
        } else if (a.sumaNivelVida() < b.sumaNivelVida()) {
            System.out.println("GANADOR REINO: " + b.getReino() + " MAYOR PUNTOS DE VIDA EN TOTAL -> " + b.sumaNivelVida());
        } else {
            System.out.println("NO HAY GANADOR ES UN EMPATE: ");
            System.out.println("REINO -> " + a.getReino() + "PVT: " + a.sumaNivelVida());
            System.out.println("REINO -> " + b.getReino() + "PVT: " + b.sumaNivelVida());
        }
    }
}