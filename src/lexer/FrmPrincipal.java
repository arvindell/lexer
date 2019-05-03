/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Andru
 */
public class FrmPrincipal extends javax.swing.JFrame {

  /**
   * Creates new form FrmPrincipal
   */
  public FrmPrincipal() {
    initComponents();
    this.setLocationRelativeTo(null);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    btnAnalizar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtResultado = new javax.swing.JTextArea();
    jScrollPane2 = new javax.swing.JScrollPane();
    txtEntrada = new javax.swing.JTextArea();
    jLabel1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    btnAnalizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    btnAnalizar.setText("Analizar");
    btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAnalizarActionPerformed(evt);
      }
    });

    txtResultado.setColumns(20);
    txtResultado.setRows(5);
    jScrollPane1.setViewportView(txtResultado);

    txtEntrada.setColumns(20);
    txtEntrada.setRows(5);
    jScrollPane2.setViewportView(txtEntrada);

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel1.setText("Resultado");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219,
                    Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnAnalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(76, 76, 76))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizar)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277,
                        Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnAnalizarActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
    // TODO add your handling code here:
    File archivo = new File("archivo.txt");
    PrintWriter escribir;
    try {
      escribir = new PrintWriter(archivo);
      escribir.print(txtEntrada.getText());
      escribir.close();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
    }

    try {
      Reader lector = new BufferedReader(new FileReader("archivo.txt"));
      Lexer lexer = new Lexer(lector);
      String resultado = "";
      while (true) {
        Tokens token = lexer.yylex();
        if (token == null) {
          resultado += "Completado";
          txtResultado.setText(resultado);
          return;
        }
        switch (token) {
                    /*case ERROR:
                        resultado += "Error\n";
                        break;*/
          case Prog:
          case Var:
          case Proc:
          case Inicio:
          case Final:
          case Entero:
          case Real:
          case String:
          case Limpiar:
          case Vexy:
          case Leer:
          case Escribir:
          case Repite:
          case Hasta:
          case Mientras:
          case Si:
          case SiNo:
          case Ejecuta:
          case And:
          case Or:
          case Suma:
          case Resta:
          case Multiplicacion:
          case Division:
          case Igual:
          case MayorIgual:
          case Mayor:
          case MenorIgual:
          case Menor:
          case Diferente:
          case PuntoYComa:
          case CierraCorchete:
          case AbreCorchete:
          case Coma:
          case DosPuntos:
          case CierraParentesis:
          case AbreParentesis:
          case DosPuntosIgual:
          case Identificador:
          case Enteros:
          case Reales:
          case Cadena:
          case ERROR:
            resultado += lexer.lexeme + ": Es un " + token + "\n";
            System.out.println(token.getNumVal());
            break;
          default:
            resultado += "Token: " + token + "\n";
            break;
        }
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_btnAnalizarActionPerformed

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
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
          .getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(FrmPrincipal.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(FrmPrincipal.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(FrmPrincipal.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(FrmPrincipal.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new FrmPrincipal().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAnalizar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextArea txtEntrada;
  private javax.swing.JTextArea txtResultado;
  // End of variables declaration//GEN-END:variables
}