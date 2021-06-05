/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

public class TablaSimbolos {

    public String var;
    public String tipo;
    public String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TablaSimbolos(String var, String tipo) {
        this.var = var;
        this.tipo = tipo;
    }
   
     public TablaSimbolos(String var, String tipo, String valor) {
        this.var = var;
        this.tipo = tipo;
        this.valor= valor;
    }
    
    
}
