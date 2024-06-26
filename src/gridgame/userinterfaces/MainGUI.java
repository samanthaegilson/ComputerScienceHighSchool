
package gridgame.userinterfaces;

/**
 * required imports
 */
import MainProgram.ProgramEngine;
import java.awt.event.KeyEvent;

/**
 * GUI.java - the user interface for the application
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class MainGUI extends javax.swing.JFrame 
{
    
    private ProgramEngine logic;

    // <editor-fold defaultstate="collapsed" desc="NetBeans Generated Code">

    /** Creates new form GUI */
    public MainGUI() {
        initComponents();
        command(0,null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        list1 = new java.awt.List();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Larger Map"));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(430, 10, 600, 630);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });
        jPanel2.setLayout(null);

        list1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                list1KeyPressed(evt);
            }
        });
        jPanel2.add(list1);
        list1.setBounds(10, 25, 400, 270);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 330, 420, 310);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Viewable Area"));
        jPanel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel3KeyPressed(evt);
            }
        });
        jPanel3.setLayout(null);
        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 10, 420, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        command(1,null);
    }//GEN-LAST:event_formWindowClosing

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        command(2,evt);
    }//GEN-LAST:event_formKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        command(2,evt);
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jPanel3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel3KeyPressed
        command(2,evt);
    }//GEN-LAST:event_jPanel3KeyPressed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        command(2,evt);
    }//GEN-LAST:event_jPanel2KeyPressed

    private void list1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_list1KeyPressed
        command(2,evt);
    }//GEN-LAST:event_list1KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables


    // </editor-fold>

    /**
     * commands for the gui to pass to the program logic class
     * @param index the specific command to pass
     */
    private void command(int index, KeyEvent event) {
        if      (index == 0) logic = new ProgramEngine(this,jPanel1,
                jPanel3,jPanel2,list1);
        else if (index == 1) logic.closing();
        else if (index == 2) logic.keyPress(event);
    }
    
}
