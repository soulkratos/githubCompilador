/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Principal {
    
    String raiz="D:/NetBeansProjects/COMPILADOR_PROYECTO/src/codigo";
    public void iniciar() throws Exception {
        
        String str =raiz+"/src/codigo/Lexer.flex";
        String strCup =raiz+"/src/codigo/LexerCup.flex";
        String[] rutaS = { "-parser","sintax",raiz+"/src/codigo/Sintax.cup"};
        generar(str,strCup,rutaS);
    }
    
    public void generar(String rutaLexico, String rutaCup, String[] rutaS) throws IOException, Exception {
        File archivo;
        archivo = new File(rutaLexico);
        jflex.Main.generate(archivo);
        
        archivo = new File(rutaCup);
        jflex.Main.generate(archivo);
        
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get(raiz+"/src/codigo/sym.java");
        if(Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        } 
       
        Files.move(
                Paths.get(raiz+"/sym.java"), 
                Paths.get(raiz+"/src/codigo/sym.java"));
       
        Path rutaSintax = Paths.get(raiz+"/src/codigo/sintax.java");
        if(Files.exists(rutaSintax)) {
            Files.delete(rutaSintax);
        } 
        
        Files.move(
                Paths.get(raiz+"/sintax.java"), 
                Paths.get(raiz+"/src/codigo/sintax.java"));
        
    }
}
