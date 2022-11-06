/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio09;

/**
 *
 * @author asus
 */
public class Soldado {
    private String nombre;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;
    private int fila;
    private int columna;
        
    //Constructores
    //No sabría como usarlos, a partir de la inicialiazación y aplicación al hashmap
    //Implica una nueva clase teórica, desde mi punto de vista
    
    /*public Soldado(String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int vidaActual, int velocidad) {
        this.nombre = nombre;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
        this.vidaActual = vidaActual;
        this.velocidad = velocidad;
    }

    public Soldado(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }*/

    //Unico constructor aplicable, para la creación de nuevos soldados
    public Soldado() {
    }
    
    //Setters
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setActitud(String actitud) {
        this.actitud = actitud;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
        
    //Getters

    public String getNombre() {
        return nombre;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getActitud() {
        return actitud;
    }

    public boolean isVive() {
        return vive;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    
        // Métodos Actitud
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
		setVive(false);
	}
        
    // Completar con otros métodos necesarios
    @Override
    public String toString() {
        return nombre + " : PV " + vidaActual +" Ataque: " + nivelAtaque + " Defensa: " + nivelDefensa;
    }
}
