/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio12;

import java.util.Iterator;
import static laboratorio12.VideoJuego9.ejercito1;
import static laboratorio12.VideoJuego9.ejercito2;
import static laboratorio12.VideoJuego9.generar_HasMap;
import static laboratorio12.VideoJuego9.mostrar_Hasmap;
import static laboratorio12.VideoJuego9.mostrar_tabla;
import static laboratorio12.VideoJuego9.sc;
import static laboratorio12.VideoJuego9.tablero;

/**
 *
 * @author asus
 */
public class Configuracione_2 {
    
    public static void AgregarSoldado(){
        System.out.println("Ejercito que quiere agregar soldados: ");
        String equipo = sc.next();
        if (equipo.equals("1")) {
            if (ejercito1.size()== 10) {
            System.out.println("No puede agregar más soldados");
            System.out.println("Capacidad maxima");
            }else{
            System.out.println("Soldado Agregado: ");
            generar_HasMap(ejercito1,ejercito1.size()+1,"1");
            mostrar_Hasmap(ejercito1);
            }   
        }else if (equipo.equals("2")) {
            if (ejercito2.size()==10) {
            System.out.println("No puede agregar más soldados");
            System.out.println("Capacidad maxima");
            }else{
            System.out.println("Soldado Agregado: ");
            generar_HasMap(ejercito2,ejercito2.size()+1,"2");
            mostrar_Hasmap(ejercito2);
            }
        }
    }
    
    public static void QuitarSoldado(){
        System.out.println("Ejercito que quiere quitar soldados: ");
        String equipo = sc.next();
        if (equipo.equals("1")) {
            if (ejercito1.size() == 1) {
            System.out.println("No puede quitar más soldados");
            System.out.println("La cantidad de soldados seria = 0 ");
            }else{
            System.out.println("Soldado Quitado: ");
            generar_HasMap(ejercito1,ejercito1.size()-1,"1");
            mostrar_Hasmap(ejercito1);
            }   
        }else if (equipo.equals("2")) {
            if (ejercito2.size() == 1) {
            System.out.println("No puede quitar más soldados");
            System.out.println("La cantidad de soldados seria = 0");
            }else{
            System.out.println("Soldado Quitado: ");
            generar_HasMap(ejercito2,(ejercito2.size())-1,"2");
            mostrar_Hasmap(ejercito2);
            }
        }
    }
    
    public static void ClonarSoldado(){
        System.out.println("Ejercito que quiere clonar soldado: ");
        String equipo = sc.next();
        if (equipo.equals("1")) {
            mostrar_Hasmap(ejercito1);
            System.out.println("Seleccione un soldado: ");
            Integer soldado = Integer.parseInt(sc.next());
            if (ejercito1.containsKey(soldado)&&ejercito1.size()<10) {
                Soldado soldado_copy = new Soldado();
                Soldado soldado_origin = ejercito1.get(soldado);
                soldado_copy.setNombre("Soldado" + ejercito1.size() + 'X' + equipo);
                soldado_copy.setNivelVida(soldado_origin.getNivelVida());
                soldado_copy.setVidaActual(soldado_origin.getVidaActual());
                soldado_copy.setNivelAtaque(soldado_origin.getNivelAtaque());
                soldado_copy.setNivelDefensa(soldado_origin.getNivelDefensa());
                ejercito1.put(ejercito1.size(), soldado_copy);
                mostrar_Hasmap(ejercito1);
            }
        }
        
        if (equipo.equals("2")) {
            mostrar_Hasmap(ejercito2);
            System.out.println("Seleccione un soldado: ");
            Integer soldado = Integer.parseInt(sc.next());
            if (ejercito2.containsKey(soldado)&&ejercito2.size()<10) {
                Soldado soldado_copy = new Soldado();
                Soldado soldado_origin = ejercito2.get(soldado);
                soldado_copy.setNombre("Soldado" + ejercito2.size() + 'X' + equipo);
                soldado_copy.setNivelVida(soldado_origin.getNivelVida());
                soldado_copy.setVidaActual(soldado_origin.getVidaActual());
                soldado_copy.setNivelAtaque(soldado_origin.getNivelAtaque());
                soldado_copy.setNivelDefensa(soldado_origin.getNivelDefensa());
                ejercito2.put(ejercito2.size(), soldado_copy);
                mostrar_Hasmap(ejercito2);
            }
        }
    }
    
    public static void ModificarSoldado(){
        System.out.println("Ejercito que quiere modificar soldado: ");
        String equipo = sc.next();
        if (equipo.equals("1")) {
            mostrar_Hasmap(ejercito1);
            System.out.println("Seleccione un soldado: ");
            Integer soldado = Integer.parseInt(sc.next());
            if (ejercito1.containsKey(soldado)) {
                Soldado sold = ejercito1.get(soldado);
                System.out.println("Ingese nuevo valor para Nivel de Vida: ");
                sold.setNivelVida(Integer.parseInt(sc.next()));
                System.out.println("Ingese nuevo valor para Nivel de Ataque: ");
                sold.setNivelAtaque(Integer.parseInt(sc.next()));
                System.out.println("Ingrese nuevo para Nivel de Defensa");
                sold.setNivelDefensa(Integer.parseInt(sc.next()));
                mostrar_Hasmap(ejercito1);
            }
        }
        
        if (equipo.equals("2")) {
            mostrar_Hasmap(ejercito2);
            System.out.println("Seleccione un soldado: ");
            Integer soldado = Integer.parseInt(sc.next());
            if (ejercito2.containsKey(soldado)) {
                Soldado sold = ejercito2.get(soldado);
                System.out.println("Ingese nuevo valor para Nivel de Vida: ");
                sold.setNivelVida(Integer.parseInt(sc.next()));
                System.out.println("Ingese nuevo valor para Nivel de Ataque: ");
                sold.setNivelAtaque(Integer.parseInt(sc.next()));
                System.out.println("Ingrese nuevo para Nivel de Defensa");
                sold.setNivelDefensa(Integer.parseInt(sc.next()));
                mostrar_Hasmap(ejercito2);
            }
        }
    }
    
    public static void CompararSoldados(){
        System.out.println("Ejercito que quiere modificar soldado: ");
        String equipo = sc.next();
        if (equipo.equals("1")) {
            mostrar_Hasmap(ejercito1);
            System.out.println("Seleccione un soldado: ");
            Integer soldado = Integer.parseInt(sc.next());
            System.out.println("Seleccione otro soldado: ");
            Integer soldado1 = Integer.parseInt(sc.next());
            Soldado a = ejercito1.get(soldado);
            Soldado b = ejercito1.get(soldado1);
            if (ejercito1.containsKey(soldado)) {
                if(a.hashCode() > b.hashCode()){
                    System.out.println("El soldado seleccionado es mayor al comparado.");
                }else if (a.hashCode() == b.hashCode()){
                    System.out.println("Son soldados iguales");
                }else{
                    System.out.println("El soldado seleccionado no es mayor al comparado.");
                }
            }
        }
        
        if (equipo.equals("2")) {
            mostrar_Hasmap(ejercito2);
            System.out.println("Seleccione un soldado: ");
            Integer soldado = Integer.parseInt(sc.next());
            System.out.println("Seleccione otro soldado: ");
            Integer soldado1 = Integer.parseInt(sc.next());
            Soldado a = ejercito2.get(soldado);
            Soldado b = ejercito2.get(soldado1);
            if (ejercito2.containsKey(soldado)) {
                if(a.hashCode() > b.hashCode()){
                    System.out.println("El soldado seleccionado es mayor al comparado.");
                }else if (a.hashCode() == b.hashCode()){
                    System.out.println("Son soldados iguales");
                }else{
                    System.out.println("El soldado seleccionado no es mayor al comparado.");
                }
            }
        }
    }
    
    public static void CambiarPosicion(){
        mostrar_tabla(tablero);
        System.out.println("Ingrese coordenadas del soldado 1 (COL FIL): ");
        Vector2D a = new Vector2D(sc.nextInt(),sc.nextInt());
        System.out.println("Ingrese coordenadas del soldado 2 (COL FIL): ");
        Vector2D b = new Vector2D(sc.nextInt(),sc.nextInt());
        if(tablero[a.y][a.x] != null && tablero[b.y][b.x]!=null){
            Soldado s1 = tablero[a.y][a.x];
            Soldado s2 = tablero[b.y][b.x];
            s1.setFila(b.y);
            s1.setColumna(b.x);
            s2.setFila(a.y);
            s2.setColumna(a.x);
            tablero[a.y][a.x]=s2;
            tablero[b.y][b.x]=s1;
            mostrar_tabla(tablero);
        }else{
        
        }
    }
    
    public static void VerSoldado(){
        System.out.println("Ejercito del soldado que quiere ver: ");
        String equipo = sc.next();
        if (equipo.equals("1")) {
            System.out.println("Seleccione un soldado: ");
            Integer soldado = Integer.parseInt(sc.next());
            Soldado a = ejercito1.get(soldado);
            if (ejercito1.containsKey(soldado)) {
                System.out.println(a.toString());
            }
        }
        
        if (equipo.equals("2")) {
            System.out.println("Seleccione un soldado: ");
            Integer soldado = Integer.parseInt(sc.next());
            Soldado a = ejercito2.get(soldado);
            if (ejercito2.containsKey(soldado)) {
                System.out.println(a.toString());
            }
        }
    }
    
    public static void VerEjercito(){
        System.out.println("Seleccione ejercito que quiere ver: ");
        String equipo = sc.next();
        if (equipo.equals("1")) {
            mostrar_Hasmap(ejercito1);
        }else if (equipo.equals("2")) {
            mostrar_Hasmap(ejercito2);
        }
    }
    
    public static void SumarNiveles(){
        System.out.println("Seleccione ejercito que quiere ver: ");
        String equipo = sc.next();
        if (equipo.equals("1")) {
            mostrar_Hasmap(ejercito1);
            Iterator<Soldado> it = ejercito1.values().iterator();
            Soldado sp = it.next();
            while(it.hasNext()){
                sp = sp.add(it.next());
            }
            System.out.println(sp);
        }else if (equipo.equals("2")) {
            mostrar_Hasmap(ejercito2);
            Iterator<Soldado> it = ejercito2.values().iterator();
            Soldado sp = it.next();
            while(it.hasNext()){
                sp = sp.add(it.next());
            }
            System.out.println(sp);
        }
    }
}
