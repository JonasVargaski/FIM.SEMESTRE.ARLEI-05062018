/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.Dao;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vo.Usuario;

/**
 *
 * @author jonas
 */
public class Login extends javax.swing.JFrame {

    Usuario user = null;

    public Login() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_sair = new javax.swing.JButton();
        lb_erro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_senha = new javax.swing.JPasswordField();
        tf_email = new javax.swing.JTextField();
        bt_acessar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_sair.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.setBorderPainted(false);
        bt_sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_sair.setFocusCycleRoot(true);
        bt_sair.setMargin(new java.awt.Insets(3, 14, 2, 14));
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        getContentPane().add(bt_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 340, 120, 50));

        lb_erro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_erro.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lb_erro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 190, 20));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setText("Email.:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 81, 37));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setText("Senha.:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 71, 36));

        tf_senha.setText("123");
        getContentPane().add(tf_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 210, 30));

        tf_email.setText("jonasvargaski@hotmail.com");
        tf_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_emailActionPerformed(evt);
            }
        });
        getContentPane().add(tf_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 210, 30));

        bt_acessar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bt_acessar.setText("Acessar");
        bt_acessar.setBorder(null);
        bt_acessar.setBorderPainted(false);
        bt_acessar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_acessar.setFocusCycleRoot(true);
        bt_acessar.setMargin(new java.awt.Insets(3, 14, 2, 14));
        bt_acessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_acessarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_acessar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 114, 50));

        jLabel5.setForeground(new java.awt.Color(51, 0, 255));
        jLabel5.setText("Novo Usuario? Cadastre-se.");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel5FocusGained(evt);
            }
        });
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 170, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/login.PNG"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 450, 530));

        setSize(new java.awt.Dimension(466, 550));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_acessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_acessarActionPerformed
        login();
    }//GEN-LAST:event_bt_acessarActionPerformed

    private void tf_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_emailActionPerformed

    private void jLabel5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel5FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5FocusGained

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        if (verificaConexao()) {
            dispose();
            new Cadastro().setVisible(true);
        }
    }//GEN-LAST:event_jLabel5MouseClicked
    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bt_sairActionPerformed
    private void login() {
        String email = tf_email.getText();
        String senha = tf_senha.getText();
        if (email.length() < 8) {
            lb_erro.setText("Informe um e-mail válido...");
            return;
        }
        if (senha.length() < 3) {
            lb_erro.setText("");
            lb_erro.setText("Informe uma senha válida...");
            return;
        }
        if (verificaConexao()) {
            Integer id_user = new Dao().validaLogin(email, senha);
            if (id_user == null) {
                lb_erro.setText("Usuario ou Senha Incorretos...");
                return;
            }
            dispose();
            new Principal(new Dao().buscaUsuario(id_user)).setVisible(true);
        }
    }

    public boolean verificaConexao() {
       /* URLConnection connection;
        try {
            connection = new URL("http://www.google.com.br").openConnection();
            connection.connect();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "VERIFICAR CONEXÃO COM A INTERNET !");
            return false;
        }
*/
       return true;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_acessar;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lb_erro;
    private javax.swing.JTextField tf_email;
    private javax.swing.JPasswordField tf_senha;
    // End of variables declaration//GEN-END:variables
}