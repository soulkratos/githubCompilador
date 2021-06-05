/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;


import java.util.ArrayList;
import codigo.TablaSimbolos;
import codigo.TablaSimbolosParser;
import java.util.List;

public class PruebaSimbolos {
    
     List<TablaSimbolos> lista;

    public PruebaSimbolos() {
       lista = new ArrayList<TablaSimbolos>();
       
       TablaSimbolos t = new TablaSimbolos("a","int");
       lista.add(t);
       TablaSimbolos tt = new TablaSimbolos("b","string");
       lista.add(tt);
       
       for(TablaSimbolos tabla : lista) {
           System.out.println(tabla.tipo);
           System.out.println(tabla.tipo);
           
       }
       
    }
    
    public boolean insertar(String var, String tipo) {
        TablaSimbolos t = new TablaSimbolos(var,tipo);
        lista.add(t);
        return true;
    }
    
    public void buscar(String var, String tipo){
        TablaSimbolosParser tS = new TablaSimbolosParser();
        
        List<String> errorSemanticoList= new ArrayList<String>();
        errorSemanticoList.add("la variable "+var+" ya se encuentra en la tabla de simbolos");
        if(lista.isEmpty()) {
              insertar(var,tipo);
        }
        else {
            boolean bandera=false;
            for(TablaSimbolos t : lista) {
            if(t.getVar().equals(var)){
                System.out.println("este simbolo ya se encuentra en la tabla de simbolos");
                bandera=true;
            }
          
        }
            if(bandera==false){
                 insertar(var,tipo);
            }
        }
        
    }
    
}
