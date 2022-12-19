package laboratorio20;

public class SoldadoE extends Soldado {
	private int longitudEspada;
	public SoldadoE(String name, int Vida, int ataque, int defensa, String r) {
		super(name, Vida, ataque, defensa, r);
	}
	public void crearmuro() {
		int aumento;
		aumento =super.getNivelDefensa()+5;
		super.setNivelDefensa(aumento);
	}

}
