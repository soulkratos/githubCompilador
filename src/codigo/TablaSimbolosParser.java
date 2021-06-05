/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;
import java.util.List;


public class TablaSimbolosParser {
     List<TablaSimbolos> lista=new ArrayList<TablaSimbolos>();
List<String> errorSemanticoList= new ArrayList<String>();
String operador="";
String tipo="";   
String sid="";
String scalculo="";

    public String getScalculo() {
       
            return scalculo; 
     
       
    }

    public void setScalculo(String scalculo) {
        this.scalculo = scalculo;
    }

    

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }


    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }


List<String> resultado= new ArrayList<String>();

    public List<String> getResultado() {
        return resultado;
    }

    public void setResultado(List<String> resultado) {
        this.resultado = resultado;
    }

    

    public List<TablaSimbolos> getLista() {
        return lista;
    }

    public void setLista(List<TablaSimbolos> lista) {
        this.lista = lista;
    }

    public List<String> getErrorSemanticoList() {
        return errorSemanticoList;
    }

    public void setErrorSemanticoList(List<String> errorSemanticoList) {
        this.errorSemanticoList = errorSemanticoList;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

  
 public boolean insertar(String var, String tipo) {
        TablaSimbolos t = new TablaSimbolos(var,tipo);
        lista.add(t);
        return true;
    }

public void buscar(String var, String tipo){
        if(lista.isEmpty()) {
              insertar(var,tipo);
        }
        else {
            boolean bandera=false;
            for(TablaSimbolos t : lista) {
            if(t.getVar().equals(var)){
                System.out.println("este simbolo ya se encuentra en la tabla de simbolos");
                errorSemanticoList.add("Error la variable "+var+" ya se encuentra en la tabla de simbolos");
                bandera=true; 
            }
          
        }
            if(bandera==false){
                 insertar(var,tipo);
            }
        }
        
    }

public void asignar(String var, String valor) {
    boolean bandera=false;
    
     for(TablaSimbolos t : lista) {
            if(t.getVar().equals(var)){
                
              t.setValor(valor);
              bandera=true;
            }
          
        }
     String tipoS="";
   if(bandera==false) {
       double d = Double.parseDouble(valor);
       if(d== Math.floor(d)) {
           tipoS="Integer";
       }
       else {
           tipoS="Float";
       }
       TablaSimbolos t = new TablaSimbolos(var,tipoS,valor);
        lista.add(t);
   }  
}

public String calculo(String a, String op, String b) {
    double n1= Double.parseDouble(a);
    double n2= Double.parseDouble(b);
    double result=0;
 String resultadoStr="";
  boolean bandera=false;
    switch(op) {
        case "+":  result = n1+n2;   break;
         case "-":  result = n1-n2;   break;
          case "*":  result = n1*n2;   break;
           case "/": if(n2!=0) {result = n1/n2;} else { bandera=true;}   break;
    }   
if(bandera==false) {
     resultadoStr = String.valueOf(result);
      setScalculo(resultadoStr);
    setSid(resultadoStr);
}   
else {
    resultadoStr= "0";
    this.errorSemanticoList.add("error: division entre 0");
 
}
  
 
    return resultadoStr;
}

public String tLista(String str) {
    String[] list = str.split(",");
    String acumulado="";
    for(String l : list){
        acumulado=acumulado+"<li>"+l+"</li>";
    }
    return acumulado;
}


}
