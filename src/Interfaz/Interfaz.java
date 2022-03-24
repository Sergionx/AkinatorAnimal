/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import akinator.ArbolBinarioDesicion;
import akinator.Nodo;
import akinator.StringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Clase encargada de la interacción entre el usuarios y los datos
 * @author Sergionx
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public static ArbolBinarioDesicion arbolBinarioDesicion = new ArbolBinarioDesicion();
    public static Nodo pActual = null;
    public static Nodo nuevoAnimal = null;
    public static Nodo nuevaPregunta = null;
    
    public static boolean jugar = false; //Determina si estoy jugando o no
    public static boolean equivocacion = false; // Determina si no pude adivinar el animal
    public static boolean correccion = false; // Determina si estoy esperando lque caracteriza la diferencia entre los animales
    public static boolean respuestaCorreccion = false; // Determina si ya recibí dicha diferencia
    
    public Interfaz() {
        initComponents();
        String file = "src\\akinator\\InputInicial.csv";
        LeerCsvString(file);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LeerCsv = new javax.swing.JButton();
        Jugar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MensajeJugar = new javax.swing.JTextArea();
        EnviarRespuesta = new javax.swing.JButton();
        Respuesta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LeerCsv.setText("Leer csv");
        LeerCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeerCsvActionPerformed(evt);
            }
        });
        jPanel1.add(LeerCsv, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        Jugar.setText("Empezar a Jugar");
        Jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarActionPerformed(evt);
            }
        });
        jPanel1.add(Jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        MensajeJugar.setColumns(20);
        MensajeJugar.setRows(5);
        jScrollPane1.setViewportView(MensajeJugar);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 310, 150));

        EnviarRespuesta.setText("Enviar Respuesta");
        EnviarRespuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarRespuestaActionPerformed(evt);
            }
        });
        jPanel1.add(EnviarRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, -1, -1));
        jPanel1.add(Respuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
    * Lee un csv dado el camino (usado solamente en la inicializacion de la interfaz)
    * @author Sergionx
    */
    private  void LeerCsvString(String path){
        BufferedReader reader = null;
        String aux = "";
        try {
            reader = new BufferedReader(new FileReader(path));
            while ((aux = reader.readLine()) != null) {
                String[] line = aux.split(",");
                
                if (line.length == 0 || "Pregunta".equals(line[0]) ) {
                           continue;
                }
                arbolBinarioDesicion.Insertar(line[0].trim(), line[1].trim(), line[2].trim(), arbolBinarioDesicion.getRoot());
            }
            reader.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Asegúrese de que los datos que esté pasando sean correctos");
        }
    }
    
    /**
    * Lee un csv dado escogido con JFileCHooser
    * @author Sergionx
    */
    private void LeerCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeerCsvActionPerformed
        if (arbolBinarioDesicion.getRoot() != null) {
            arbolBinarioDesicion.setRoot(null);
        }
        
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(this);

        String aux = "";

        try {
            File abre = file.getSelectedFile();

            if(abre!=null)
            {
                FileReader archivos = new FileReader(abre);
                BufferedReader buffer = new BufferedReader(archivos);

                boolean first = true;
                boolean datos = false;
                while((aux = buffer.readLine())!= null)
                {
                  String[] line = aux.split(",");
                
                    if (line.length == 0 || "Pregunta".equals(line[0]) ) {
                               continue;
                    }
                    arbolBinarioDesicion.Insertar(line[0].trim(), line[1].trim(), line[2].trim(), arbolBinarioDesicion.getRoot());
                    }
                buffer.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Asegúrese de que los datos que esté pasando sean correctos");
        }
    }//GEN-LAST:event_LeerCsvActionPerformed
    
    /**
    * Imprime el mensaje inicial y activa la varabile jugar en true
    * @author Sergionx
    */
    private void JugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarActionPerformed
        MensajeJugar.setText("¿Estás listo para jugar una ronda? \n");
        jugar = true;
        
    }//GEN-LAST:event_JugarActionPerformed
    
    
    /**
    * Se encarga de simular la funcionalidad de akinator
    * @author Sergionx
    */
    private void EnviarRespuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarRespuestaActionPerformed
       String respuesta = Respuesta.getText();
        if (respuestaCorreccion) { //Recibo la respuesta a mi pregunta de correción
            if ("si".equals(respuesta.trim().toLowerCase())) {
                nuevaPregunta.setHijoIzq(pActual);
                nuevaPregunta.setHijoDer(nuevoAnimal);
            } else if ("no".equals(respuesta.trim().toLowerCase())) {
                nuevaPregunta.setHijoIzq(nuevoAnimal);
                nuevaPregunta.setHijoDer(pActual);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor escriba una respuesta valida");
                return;
            }
            
            Nodo padre = arbolBinarioDesicion.Padre(pActual, arbolBinarioDesicion.getRoot()); //Busco el padre del animal en el que fallé para cambiar su hijo
            if (padre.getHijoIzq().getData().equals(pActual.getData())) {
                padre.setHijoIzq(nuevaPregunta);
            } else {
                padre.setHijoDer(nuevaPregunta);
            }
           
            MensajeJugar.append("¡Muchas gracias!, ahora soy mucho más inteligente que antes. \n");
            respuestaCorreccion = false;
            Respuesta.setText("");
            jugar = false;
            return;
        }
       
       
        if (correccion) { // Pregunto qué caracteriza el nuevo animal
            MensajeJugar.append("Si el animal fuera un " + StringUtils.Capitalize(nuevoAnimal.getData()) + ", ¿cuál sería la respuesta a la pregunta \n");
            
            correccion = false;
            respuestaCorreccion = true;
            nuevaPregunta = new Nodo(respuesta);
            return;
        }
       
       if (equivocacion) { //No adivinó el animal
            nuevoAnimal = new Nodo(respuesta);
            MensajeJugar.append("¿Qué diferencia a un " + StringUtils.Capitalize(pActual.getData()) + 
                    " y un " + StringUtils.Capitalize(respuesta) + "? \n");
            
            equivocacion = false;
            correccion = true;
            Respuesta.setText("");
            return;
        }
        
        if (!jugar) { //El juego ya se terminó
            JOptionPane.showMessageDialog(null, "Necesita darle al botón de empezar a jugar para volver a jugar");
            return;
        }
       
        if ("".equals(MensajeJugar.getText())) {
            JOptionPane.showMessageDialog(null, "Necesita darle al botón de empezar a jugar primero");
            return;
        }
        
        if (arbolBinarioDesicion.getRoot() == null) { //No se ha cargado el arbol
            JOptionPane.showMessageDialog(null, "Asegúrese de leer un árbol antes de empezar a jugar");
            return;
        }

        if ("¿Estás listo para jugar una ronda? \n".equals(MensajeJugar.getText())) {
            if ("si".equals(respuesta.trim().toLowerCase())) {
                pActual = arbolBinarioDesicion.getRoot();
                String pregunta = "¿" + StringUtils.Capitalize(pActual.getData()) + "?\n";
                
                MensajeJugar.append(pregunta);
                Respuesta.setText("");
                return;
            } else if ("no".equals(respuesta.trim().toLowerCase())) {
                MensajeJugar.append("Vuelve cuando estés preparado para perder.");
                Respuesta.setText("");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor escriba una respuesta valida");
                Respuesta.setText("");
                return;
            }
        }
        
        if (arbolBinarioDesicion.isAnaimal(pActual)) {
            if ("si".equals(respuesta.trim().toLowerCase())) {
                MensajeJugar.append("¡Qué fácil, ponlo más difícil la próxima vez! \n");
                
                jugar = false;
                Respuesta.setText("");
                return;
            } else if ("no".equals(respuesta.trim().toLowerCase())) { //Agregar nuevo animal
                 MensajeJugar.append("¿Qué animal era? \n");
                 
                 Respuesta.setText("");
                 equivocacion = true;
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor escriba una respuesta valida");
                Respuesta.setText("");
                return;
            }
        }
        
        
        String pregunta;
        if ("si".equals(respuesta.trim().toLowerCase())) {
                pActual = pActual.getHijoDer();
                if (arbolBinarioDesicion.isAnaimal(pActual)) {
                    pregunta = "¿Es un " +  StringUtils.Capitalize(pActual.getData())+ "?\n";
                } else {
                    pregunta = "¿" +  StringUtils.Capitalize(pActual.getData()) + "?\n";
                }
                MensajeJugar.append(pregunta);
                
            } else if ("no".equals(respuesta.trim().toLowerCase())) {
                pActual = pActual.getHijoIzq();
                
                if (arbolBinarioDesicion.isAnaimal(pActual)) {
                    pregunta = "¿Es un " +  StringUtils.Capitalize(pActual.getData()) + "?\n";
                } else {
                    pregunta = "¿" +  StringUtils.Capitalize(pActual.getData()) + "?\n";                
                }
                MensajeJugar.append(pregunta);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor escriba una respuesta valida");
                return;
        }
        
        
        Respuesta.setText("");
    }//GEN-LAST:event_EnviarRespuestaActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EnviarRespuesta;
    private javax.swing.JButton Jugar;
    private javax.swing.JButton LeerCsv;
    private javax.swing.JTextArea MensajeJugar;
    private javax.swing.JTextField Respuesta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
