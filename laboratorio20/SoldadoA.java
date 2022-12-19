package laboratorio20;

public class SoldadoA extends Soldado{
	private int num_flechas;

	public SoldadoA(String name, int Vida, int ataque, int defensa, String r, int numFlechas) {
		super(name, Vida, ataque, defensa, r);
		this.num_flechas=numFlechas;
	}


	//public SoldadoA(String name, int puntos_vida, String reino, int numFlechas) {
		// TODO Auto-generated constructor stub
	//}


	public void atacar(Soldado atacado){
		if (num_flechas<0) {
			System.out.println("No puede atacar por que no tiene flechas");
		} else {
			atacado.disminuirNivelVida(this.getNivelAtaque());
			num_flechas--;
		}

	}

}