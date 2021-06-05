/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import JFlex.Main;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author leoco
 */
public class Generador {

   public static void main(String[] args) throws Exception {
       String raizFake = "D:\\NetBeansProjects\\COMPILADOR_PROYECTO\\COMPILADOR_PROYECTO";
        String ruta1 = raizFake+"\\src\\codigo\\Lexer.flex";
        String ruta2 = raizFake+"\\src\\codigo\\LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", raizFake+"\\src\\codigo\\Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }

   public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        System.out.println("ruta s "+rutaS);
        java_cup.Main.main(rutaS);
        String raizFake = "D:\\NetBeansProjects\\COMPILADOR_PROYECTO\\COMPILADOR_PROYECTO";
        Path rutaSym = Paths.get(raizFake+"\\src\\codigo\\sym.java");
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        
        Files.move(Paths.get(raizFake+"\\sym.java"),
                Paths.get(raizFake+"\\src\\codigo\\sym.java")
        );
        
        Path rutaSin = Paths.get(raizFake+"\\src\\codigo\\Sintax.java");
        if(Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }
        Files.move(Paths.get(raizFake+"\\Sintax.java"),
                Paths.get(raizFake+"\\src\\codigo\\Sintax.java")
        ); 
    }

}
