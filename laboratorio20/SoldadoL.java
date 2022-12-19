/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio20;

/**
 *
 * @author asus
 */
public class SoldadoL extends Soldado{
    private int logintud_lanza;
    
    public SoldadoL(String name, int Vida, int ataque, int defensa, String r) {
	super(name, Vida, ataque, defensa, r);
    }
    
    public void Schiltrom (){
        int aumento;
	aumento =super.getNivelDefensa()+1;
	super.setNivelDefensa(aumento);
    }
}

