/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import java.util.List;
import codigo.TablaSimbolosParser;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;


/**
 *
 * @author leoco
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void crearArchivo(String str, String nombreArchivo, String path, String extension){
             try {
     FileWriter myWriter = new FileWriter(path+"\\"+nombreArchivo+extension);
      myWriter.write(str);
      myWriter.close();
      System.out.println("creacion de rchivo exitoso");
    } catch (IOException e) {
      System.out.println("ocurrio un error");
      e.printStackTrace();
    }
    }
    public void analisisSintactico(String str) {
       String analisisSintactico="";

            Sintax s = new Sintax(new codigo.LexerCup(new StringReader(str)));
        try {
            s.parse();
            analisisSintactico="Analisis realizado correctamente";
            //jTextArea1.setText("Analisis realizado correctamente ");
           // jTextArea1.setForeground(new Color(25,111,61));
           
          
            String extra="\n";
           
           TablaSimbolosParser sT = s.tS;
           List<TablaSimbolos> listaT = sT.lista;
           int cont=0;
           for(TablaSimbolos t : listaT){
               extra= extra+" "+cont+" simbolo: "+t.var+" tipo: "+t.tipo+" valor: "+ t.valor+" \n";
               cont++;
           }
          List<String> listaErrorSemantico = sT.errorSemanticoList;
           for(String c : listaErrorSemantico) {
               extra= extra + " "+c+ " \n";
           }
           
           List<String> codigoObjeto= sT.getResultado();
          String codigo_objeto="";
           for(String cObj : codigoObjeto){
               codigo_objeto= codigo_objeto + " "+cObj +" \n";
           }
           
             Path rutaFake = Paths.get("C:\\PAGINA_UMG.html");
         if(Files.exists(rutaFake)) {
            Files.delete(rutaFake);
        } 
         crearArchivo(codigo_objeto,"PAGINA_UMG","C:\\PAGINA_UMG\\",".html");
           txt_Resultado2.setText(analisisSintactico+extra+"\n");
           txt_Resultado2.setForeground(new Color(25,111,61));
        } catch (Exception ex) {
           Symbol sym = s.getS();
     
           analisisSintactico="Error de sintaxis en la linea: "+(sym.right+1) + " Columna: "+(sym.left+1)+" Texto: \""+ sym.value +"\" ";
          txt_Resultado2.setText(analisisSintactico);
          txt_Resultado2.setForeground(Color.RED);
          ex.printStackTrace();
        }
    }
    
    private void analizarLexico() throws IOException{
       int cont=1;
       String expr= (String) txt_Resultado1.getText();
       Lexer lexer = new Lexer(new StringReader(expr));
       String resultado = "LINEA: "+cont+" \nSIMBOLO:\n";
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    resultado += "\n" + "  ------- FIN ANALIZADOR LEXICO ------- " + "\n" + "\n";
                    txt_Resultado2.setText(resultado);
                    return;
                }
                switch(tokens){
                    case error:
                        resultado += lexer.lexeme + " ERROR LEXICO: SIMBOLO NO DEFINIDO O NO EXISTE= " + lexer.lexeme + "\n";
                        break;
                        
                    case HTML_INICIO:
                    case HTML_FIN:
                    case HEADER_INICIO:
                    case HEADER_FIN:
                    case TITLE:
                    case BODY_INICIO:
                    case BODY_FIN:
                    case TABLE_INICIO:
                    case TABLE_FIN:
                    case ROW_INICIO:
                    case ROW_FIN:
                    case LIST_INICIO:
                    case LIST_FIN:
                    case IMAGE_INICIO:
                    case IMAGE_FIN:
                    case Signo_Igual:
                    case SIGNO_SUMA:
                    case SIGNO_RESTA:
                    case SIGNO_MULTIPLICACION:
                    case AbreParentesis:
                    case CierraParentesis:
                    case Numero:
                    case Numero_Decimal:
                    case Titulo_Encabezado:
                    case Email:
                    case Link:
                    case ETIQUETA_ALTURA:
                    case ETIQUETA_ANCHO:
                    case ETIQUETA_ENLACE:
                    case ETIQUETA_COLUMNA:
                    case ETIQUETA_NEGRITA:
                    case ETIQUETA_IMPRIMIR:
                    case ETIQUETA_BORDE:
                    case ETIQUETA_PRUEBA:
                    case NOMBRE:
                    case COMILLA:
                    case TEXTO:
                    case DOS_PUNTOS:
                    case IMAGEN_FOTO:
                    case PUNTO_COMA:
                    case LISTA:
                    case COMA:
                            
                        resultado += lexer.lexeme + ": Token Identificado  " + tokens + "\n";
                        break;
                    default:
                        resultado += ":Token: " + tokens + "\n";
                        break;
                    }
                        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Analizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Resultado1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_Resultado2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_Analizar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_Analizar.setText("Abrir Texto");
        btn_Analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnalizarActionPerformed(evt);
            }
        });

        txt_Resultado1.setColumns(20);
        txt_Resultado1.setRows(5);
        jScrollPane1.setViewportView(txt_Resultado1);

        txt_Resultado2.setColumns(20);
        txt_Resultado2.setRows(5);
        jScrollPane3.setViewportView(txt_Resultado2);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setText("Analizar Lexico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("BRAYAN LEONARDO CORDOVA GARCIA ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("2490-14-15679");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/download.jpg"))); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/download.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setText("COMPILADOR");

        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setText("Analizar Sintactico Semantico");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addComponent(btn_Analizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btn_Analizar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AnalizarActionPerformed
        //boton abrir
        
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try {
            
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txt_Resultado1.setText(ST);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_AnalizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //boton lexico
        
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        analisisSintactico(txt_Resultado1.getText());
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Analizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txt_Resultado1;
    private javax.swing.JTextArea txt_Resultado2;
    // End of variables declaration//GEN-END:variables
}
