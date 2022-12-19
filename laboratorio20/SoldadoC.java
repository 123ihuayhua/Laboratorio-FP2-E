package laboratorio20;


import java.util.*;
/**
 *
 * @author TOSHIBA
 */
public class SoldadoC extends Soldado{
	private String []armas={"espada","lanza"};
	private String arma;

	public SoldadoC(String name, int Vida, int ataque, int defensa, String r) {
		super(name, Vida, ataque, defensa, r);
	}
	public void montar(){
		this.arma=armas[1];
	}
	public void desmontar(){
		this.arma=armas[2];
	}
	public void envestir(Soldado atacado){
		this.atacar();
		if (this.arma.equals(armas[1])) {
			atacar(atacado);
			atacar(atacado);
		}else if(this.arma.equals(armas[2])){
			atacar(atacado);
			atacar(atacado);
			atacar(atacado);
		}


	}

}