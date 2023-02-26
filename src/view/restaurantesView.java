/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package view;

import dao.RestaurantesDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.restaurantes;

/**
 *
 * @author Matheus
 */
public class restaurantesView extends javax.swing.JFrame {

    /** Creates new form categoriaView */
    public restaurantesView() {
        initComponents();
        try {
            readTable();
        } catch (SQLException ex) {
            Logger.getLogger(restaurantesView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void readTable() throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        Connection conexao = new Conexao().getConnection();
        RestaurantesDAO restaurantesabanco = new RestaurantesDAO(conexao);
        for(restaurantes p: restaurantesabanco.selectALL()){
            modelo.addRow(new Object[]{
                p.getNome_restaurante(),
                p.getDt_criacao()
            });
        }
    }
    public void readDesc(String desc) throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        Connection conexao = new Conexao().getConnection();
        RestaurantesDAO restaurantesabanco = new RestaurantesDAO(conexao);
        for(restaurantes p: restaurantesabanco.readDesc(desc)){
            modelo.addRow(new Object[]{
                p.getNome_restaurante(),
                p.getDt_criacao()
            });
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CADASTRAR = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ATUALIZAR = new javax.swing.JButton();
        DELETAR = new javax.swing.JButton();
        jTextFieldBusca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonBusca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("Data_Criacao");

        CADASTRAR.setText("Salvar");
        CADASTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CADASTRARActionPerformed(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NOME", "DATA"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        ATUALIZAR.setText("Atualizar");
        ATUALIZAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATUALIZARActionPerformed(evt);
            }
        });

        DELETAR.setText("Deletar");
        DELETAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETARActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("RESTAURANTES");

        jButtonBusca.setText("Buscar");
        jButtonBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldData))
                .addGap(322, 322, 322))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBusca)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(CADASTRAR)
                        .addGap(34, 34, 34)
                        .addComponent(ATUALIZAR)
                        .addGap(18, 18, 18)
                        .addComponent(DELETAR)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CADASTRAR)
                    .addComponent(ATUALIZAR)
                    .addComponent(DELETAR))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBusca))
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CADASTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CADASTRARActionPerformed
        if(jTextFieldNome.getText().isEmpty() || jTextFieldData.getText().isEmpty() ){
             JOptionPane.showMessageDialog(null,"CAMPO VAZIO");
        }else{
            String nome = jTextFieldNome.getText();
            String data = jTextFieldData.getText();
        
        
            restaurantes restaurantes_tela = new restaurantes(nome,data);
        
            try {
                //categoriabanco precisa da conexao com o banco pra inserir
                Connection conexao = new Conexao().getConnection();
                RestaurantesDAO restaurantesabanco = new RestaurantesDAO(conexao);
                boolean existir = restaurantesabanco.validar(restaurantes_tela);
                if(existir){
                    JOptionPane.showMessageDialog(null,"Restaurante ja cadastrado");
                }
                
                restaurantesabanco.insert(restaurantes_tela);
                JOptionPane.showMessageDialog(null,"Restaurante cadastrado com sucesso!!!");
                readTable();
                jTextFieldData.setText("");
                jTextFieldNome.setText("");


            } catch (SQLException ex) {
                Logger.getLogger(restaurantesView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        
            
    }//GEN-LAST:event_CADASTRARActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         if(jTable1.getSelectedRow() != -1){
            jTextFieldNome.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            jTextFieldData.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() != -1){
            jTextFieldNome.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            jTextFieldData.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());

        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void ATUALIZARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATUALIZARActionPerformed
         if(jTextFieldNome.getText().isEmpty() || jTextFieldData.getText().isEmpty() ){
             JOptionPane.showMessageDialog(null,"CAMPO VAZIO");
        }else{
            
            String nome = jTextFieldNome.getText();
            String data = jTextFieldData.getText();
        
        
            restaurantes restaurantes_tela = new restaurantes(nome,data);
        
            try {
                //categoriabanco precisa da conexao com o banco pra inserir
                Connection conexao = new Conexao().getConnection();
                RestaurantesDAO restaurantesabanco = new RestaurantesDAO(conexao);
            
                restaurantesabanco.update(restaurantes_tela);
                JOptionPane.showMessageDialog(null,"Restaurante atualizado com sucesso!!!");
                readTable();
                jTextFieldData.setText("");
                jTextFieldNome.setText("");
               

            } catch (SQLException ex) {
                Logger.getLogger(restaurantesView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }//GEN-LAST:event_ATUALIZARActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void DELETARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETARActionPerformed
        // TODO add your handling code here:
        if(jTextFieldNome.getText().isEmpty() || jTextFieldData.getText().isEmpty() ){
             JOptionPane.showMessageDialog(null,"CAMPO VAZIO");
        }else{
            
           String nome = jTextFieldNome.getText();
            String data = jTextFieldData.getText();
        
        
            restaurantes restaurantes_tela = new restaurantes(nome,data);
        
            try {
                //categoriabanco precisa da conexao com o banco pra inserir
                Connection conexao = new Conexao().getConnection();
                RestaurantesDAO restaurantesabanco = new RestaurantesDAO(conexao);;
            
                restaurantesabanco.delete(restaurantes_tela);
                JOptionPane.showMessageDialog(null,"Restaurante removido com sucesso!!!");
                readTable();
                jTextFieldData.setText("");
                jTextFieldNome.setText("");
               

            } catch (SQLException ex) {
                Logger.getLogger(restaurantesView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }//GEN-LAST:event_DELETARActionPerformed

    private void jButtonBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscaActionPerformed
        if(jTextFieldBusca.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"CAMPO VAZIO");
        }
        else{
           try {
            readDesc(jTextFieldBusca.getText());
        } catch (SQLException ex) {
            Logger.getLogger(restaurantesView.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        
    }//GEN-LAST:event_jButtonBuscaActionPerformed

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
            java.util.logging.Logger.getLogger(restaurantesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(restaurantesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(restaurantesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(restaurantesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new restaurantesView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATUALIZAR;
    private javax.swing.JButton CADASTRAR;
    private javax.swing.JButton DELETAR;
    private javax.swing.JButton jButtonBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

}