/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.ClienteTableModel;
import relatorio.RelatorioControlador;
import vo.Controlador;
import vo.Usuario;

/**
 *
 * @author jonas
 */
public class Principal extends javax.swing.JFrame implements Runnable {

    Usuario user = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Time time_atual = new Time(123);

    List<Controlador> listaControladores = new ArrayList();
    List<Controlador> dados_controladores = new ArrayList();

    public Principal(Usuario user) {

        Thread atualisatela = new Thread(this);
        atualisatela.start();

        this.user = user;
        initComponents();

        this.setTitle("Sistema de Monitoramento @> " + user.getNome().toUpperCase());
        listaControladores.addAll(new dao.Dao().buscaNSRelacionados(user.getId()));

        for (Controlador e : listaControladores) {
            Integer ns = e.getNumero_serie();
            cb_selecao_controlador.addItem("NS " + ns);
        }
    }

    public void atualisaInformacoes() {
            if (listaControladores.size() != 0) {
            Controlador controlador = new Controlador();
            controlador = listaControladores.get(cb_selecao_controlador.getSelectedIndex()); // pega o controlador selecionado no combobox
            controlador = new dao.Dao().dadosConstroladorTempoReal(controlador.getNumero_serie()); // busca dados somente do id 1, para atualizar tempo real

            time_atual.setTime(new Date().getTime());
            if (time_atual.getMinutes() <= controlador.getTime().getMinutes() && time_atual.getHours() == controlador.getTime().getHours()) { // verifica se o equipamento esta conectado ao wiifi
                lb_img_wifi.setVisible(true);
            } else {
                lb_img_wifi.setVisible(false);
            }
            lb_hora.setText(controlador.getTime().toString());
            lb_img_buzzer.setVisible(controlador.getAlarme().equalsIgnoreCase("ligado") ? true : false);
            lb_img_ventoinha.setVisible(controlador.getVentoinha().equalsIgnoreCase("ligado") ? true : false);
            lb_temp.setText(controlador.getTemp().toString());
            lb_temp_ajst.setText(controlador.getTemp_ajst().toString());
            lb_umid.setText(controlador.getUmid().toString());
            lb_umid_ajst.setText(controlador.getUmid_ajst().toString());

            dados_controladores.clear(); // limpa dados da tabela
            if (jd_dt_fim.getDate() == null || jd_dt_inicio.getDate() == null) { // verifica se os campos foram preenchidos
                dados_controladores.addAll(new dao.Dao().dadosConstrolador(controlador.getNumero_serie())); // busca dados novos na tabela;
            } else {
                String data_inicio = sdf.format(jd_dt_inicio.getDate());
                String data_fim = sdf.format(jd_dt_fim.getDate());
                dados_controladores.addAll(new dao.Dao().dadosConstrolador(controlador.getNumero_serie(), data_fim, data_inicio)); // busca utilizando os filtros de data.
            }
        }
    }
    
    private void geraRelatorio(){
       if(!dados_controladores.isEmpty()){
        new RelatorioControlador(dados_controladores , user);
       return; 
       }
        JOptionPane.showMessageDialog(null, "Por favor, Selecione um Controlador");
    }
    private void atualisaTabela() {
        ((AbstractTableModel) tb_cliente.getModel()).fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_logged = new javax.swing.JLabel();
        cb_selecao_controlador = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_cliente = new javax.swing.JTable();
        jd_dt_inicio = new com.toedter.calendar.JDateChooser();
        jd_dt_fim = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lb_temp = new javax.swing.JLabel();
        lb_umid = new javax.swing.JLabel();
        lb_umid_ajst = new javax.swing.JLabel();
        lb_temp_ajst = new javax.swing.JLabel();
        lb_hora = new javax.swing.JLabel();
        lb_img_ventoinha = new javax.swing.JLabel();
        lb_img_buzzer = new javax.swing.JLabel();
        lb_img_wifi = new javax.swing.JLabel();
        lb_imagen_controlador = new javax.swing.JLabel();
        bt_gera_pdf = new javax.swing.JButton();
        lb_img_fund = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(243, 243, 243));
        getContentPane().setLayout(null);

        user_logged.setFont(new java.awt.Font("Yu Gothic Light", 0, 14)); // NOI18N
        user_logged.setForeground(new java.awt.Color(0, 153, 0));
        getContentPane().add(user_logged);
        user_logged.setBounds(920, 526, 169, 17);

        cb_selecao_controlador.setToolTipText("");
        cb_selecao_controlador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_selecao_controladorItemStateChanged(evt);
            }
        });
        cb_selecao_controlador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_selecao_controladorMouseClicked(evt);
            }
        });
        getContentPane().add(cb_selecao_controlador);
        cb_selecao_controlador.setBounds(650, 20, 128, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Selecionar Controlador.:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(477, 20, 160, 20);

        bt_novo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_novo.setText("Gerenciar");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });
        getContentPane().add(bt_novo);
        bt_novo.setBounds(800, 20, 90, 23);

        tb_cliente.setModel(new ClienteTableModel(dados_controladores)
        );
        jScrollPane1.setViewportView(tb_cliente);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 262, 916, 230);
        getContentPane().add(jd_dt_inicio);
        jd_dt_inicio.setBounds(720, 230, 100, 20);
        getContentPane().add(jd_dt_fim);
        jd_dt_fim.setBounds(600, 230, 100, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Data Inicial");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(600, 210, 100, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Data Final");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(720, 210, 100, 15);

        lb_temp.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lb_temp.setForeground(new java.awt.Color(255, 0, 0));
        lb_temp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_temp.setText("000");
        getContentPane().add(lb_temp);
        lb_temp.setBounds(50, 80, 100, 50);

        lb_umid.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lb_umid.setForeground(new java.awt.Color(0, 153, 255));
        lb_umid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_umid.setText("000");
        getContentPane().add(lb_umid);
        lb_umid.setBounds(240, 70, 100, 70);

        lb_umid_ajst.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lb_umid_ajst.setForeground(new java.awt.Color(153, 153, 153));
        lb_umid_ajst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_umid_ajst.setText("000");
        getContentPane().add(lb_umid_ajst);
        lb_umid_ajst.setBounds(270, 140, 50, 30);

        lb_temp_ajst.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lb_temp_ajst.setForeground(new java.awt.Color(153, 153, 153));
        lb_temp_ajst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_temp_ajst.setText("000");
        getContentPane().add(lb_temp_ajst);
        lb_temp_ajst.setBounds(70, 140, 50, 30);

        lb_hora.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_hora.setForeground(new java.awt.Color(255, 255, 255));
        lb_hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_hora.setText("00:00:00");
        getContentPane().add(lb_hora);
        lb_hora.setBounds(290, 10, 110, 30);

        lb_img_ventoinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ventoinha.png"))); // NOI18N
        getContentPane().add(lb_img_ventoinha);
        lb_img_ventoinha.setBounds(20, 10, 30, 30);

        lb_img_buzzer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buzzer.png"))); // NOI18N
        lb_img_buzzer.setPreferredSize(new java.awt.Dimension(30, 25));
        getContentPane().add(lb_img_buzzer);
        lb_img_buzzer.setBounds(70, 10, 40, 30);

        lb_img_wifi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/wiif.png"))); // NOI18N
        lb_img_wifi.setText("  ");
        getContentPane().add(lb_img_wifi);
        lb_img_wifi.setBounds(110, 10, 30, 30);

        lb_imagen_controlador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_imagen_controlador.setForeground(new java.awt.Color(153, 153, 153));
        lb_imagen_controlador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/main_ok.png"))); // NOI18N
        lb_imagen_controlador.setText("22:55:32");
        lb_imagen_controlador.setPreferredSize(new java.awt.Dimension(400, 240));
        getContentPane().add(lb_imagen_controlador);
        lb_imagen_controlador.setBounds(10, 10, 400, 240);

        bt_gera_pdf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_gera_pdf.setText("Gera PDF");
        bt_gera_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gera_pdfActionPerformed(evt);
            }
        });
        getContentPane().add(bt_gera_pdf);
        bt_gera_pdf.setBounds(800, 60, 90, 30);

        lb_img_fund.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_img_fund.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/39cb08d519356d0eee057dd67ef1f610.jpg"))); // NOI18N
        lb_img_fund.setText(" ");
        lb_img_fund.setPreferredSize(new java.awt.Dimension(850, 538));
        getContentPane().add(lb_img_fund);
        lb_img_fund.setBounds(0, 0, 920, 500);

        setSize(new java.awt.Dimension(934, 534));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        this.dispose();
        new CadastroControlador(user).setVisible(true);
    }//GEN-LAST:event_bt_novoActionPerformed

    private void cb_selecao_controladorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_selecao_controladorMouseClicked

    }//GEN-LAST:event_cb_selecao_controladorMouseClicked

    private void cb_selecao_controladorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_selecao_controladorItemStateChanged

        atualisaInformacoes();
        atualisaTabela();

    }//GEN-LAST:event_cb_selecao_controladorItemStateChanged

    private void bt_gera_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gera_pdfActionPerformed
        geraRelatorio();
    }//GEN-LAST:event_bt_gera_pdfActionPerformed
    /**/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_gera_pdf;
    private javax.swing.JButton bt_novo;
    private javax.swing.JComboBox<String> cb_selecao_controlador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jd_dt_fim;
    private com.toedter.calendar.JDateChooser jd_dt_inicio;
    private javax.swing.JLabel lb_hora;
    private javax.swing.JLabel lb_imagen_controlador;
    private javax.swing.JLabel lb_img_buzzer;
    private javax.swing.JLabel lb_img_fund;
    private javax.swing.JLabel lb_img_ventoinha;
    private javax.swing.JLabel lb_img_wifi;
    private javax.swing.JLabel lb_temp;
    private javax.swing.JLabel lb_temp_ajst;
    private javax.swing.JLabel lb_umid;
    private javax.swing.JLabel lb_umid_ajst;
    private javax.swing.JTable tb_cliente;
    private javax.swing.JLabel user_logged;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                atualisaInformacoes();
                atualisaTabela();
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
