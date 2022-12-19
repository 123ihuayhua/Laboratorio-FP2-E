package laboratorio20;

public class Soldado {

    private String nombre;
    private int NivelAtaque;
    private int NivelDefensa;
    private int NivelVida;
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;
    private int fila;
    private int columna;
    private String Reino;
    public static final int MAX = 10;

    public Soldado(String a, int b, int c, int d, String e) {
        nombre = a;
        NivelVida = b;
        this.setVidaActual(NivelVida);
        NivelAtaque = c;
        NivelDefensa = d;
        this.setReino(e);
        }
    
    public Soldado() {
    }
    
    //Constructores
    public Soldado(String n) {
        nombre = n;
    }
    public Soldado(String a, int b, int c) {
        nombre = a;
        NivelVida = b;
        NivelAtaque = c;
        this.setVidaActual(NivelVida);
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNivelAtaque() {
        return NivelAtaque;
    }
    public void setNivelAtaque(int NivelAtaque) {
        this.NivelAtaque = NivelAtaque;
    }
    public int getNivelDefensa() {
        return NivelDefensa;
    }
    public void setNivelDefensa(int NivelDefensa) {
        this.NivelDefensa = NivelDefensa;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    public int getNivelVida() {
        return NivelVida;
    }
    public void setNivelVida(int NivelVida) {
        this.NivelVida = NivelVida;
    }
    public int getVidaActual() {
        return vidaActual;
    }
    public void setVidaActual(int a) {
        vidaActual = a;
    }
    public void setFila(int f) {
        fila = f;
    }
    public void setColumna(int c) {
        columna = c;
    }
    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    public void atacar() {
        avanzar();
    }
    public void atacar(Soldado a){
        avanzar();
        a.disminuirNivelVida(this.getNivelAtaque());
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
        vive = false;
    }
    public String getReino() {
        return Reino;
    }
    public void addNivelactualvida() {
        vidaActual++;
    }
    public void setReino(String Reino) {
        this.Reino = Reino;
    }
    public void disminuirNivelVida(int ataque){
        this.vidaActual = this.vidaActual-ataque;

    }
    
    // Completar con otros m�todos necesarios
    @Override
    public String toString() {
        return nombre + " NVA : " + vidaActual + " NA: " + NivelAtaque + " ND: " + NivelDefensa +"\n";
    }
}
