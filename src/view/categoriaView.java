/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package view;

import dao.CategoriaDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.categoria;

/**
 *
 * @author Matheus
 */
public class categoriaView extends javax.swing.JFrame {

    /** Creates new form categoriaView */
    public categoriaView() {
        initComponents();
        try {
            readTable();
        } catch (SQLException ex) {
            Logger.getLogger(categoriaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void readTable() throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        Connection conexao = new Conexao().getConnection();
        CategoriaDAO categoriabanco = new CategoriaDAO(conexao);
        for(categoria p: categoriabanco.selectALL()){
            modelo.addRow(new Object[]{
                p.getCod_categoria(),
                p.getDesc_categoria()
            });
        }
    }
    public void readDesc(String desc) throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        Connection conexao = new Conexao().getConnection();
        CategoriaDAO categoriabanco = new CategoriaDAO(conexao);
        for(categoria c: categoriabanco.readDesc(desc)){
            modelo.addRow(new Object[]{
                c.getCod_categoria(),
                c.getDesc_categoria()
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

        jTextFieldCatego = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDesc = new javax.swing.JTextField();
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

        jTextFieldCatego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCategoActionPerformed(evt);
            }
        });

        jLabel1.setText("COD");

        jLabel2.setText("DESCRICAO");

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
                "COD", "DESCRICAO"
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
        jLabel3.setText("CATEGORIA");

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
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CADASTRAR)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldCatego, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(ATUALIZAR)
                        .addGap(18, 18, 18)
                        .addComponent(DELETAR)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBusca)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
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
                    .addComponent(jTextFieldCatego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CADASTRAR)
                    .addComponent(ATUALIZAR)
                    .addComponent(DELETAR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBusca))
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CADASTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CADASTRARActionPerformed
        if(jTextFieldCatego.getText().isEmpty() || jTextFieldDesc.getText().isEmpty() ){
             JOptionPane.showMessageDialog(null,"CAMPO VAZIO");
        }else{
            int cod = Integer.parseInt(jTextFieldCatego.getText());
            String desc = jTextFieldDesc.getText();
        
        
            categoria categoria_tela = new categoria(cod,desc);
        
            try {
                //categoriabanco precisa da conexao com o banco pra inserir
                Connection conexao = new Conexao().getConnection();
                CategoriaDAO categoriabanco = new CategoriaDAO(conexao);
                boolean existir = categoriabanco.validar(categoria_tela);
                if(existir){
                    JOptionPane.showMessageDialog(null,"Codigo de categoria ja cadastrado");
                }
                
                categoriabanco.insert(categoria_tela);
                JOptionPane.showMessageDialog(null,"Categoria cadastrada com sucesso!!!");
                readTable();
                jTextFieldDesc.setText("");
                jTextFieldCatego.setText("");


            } catch (SQLException ex) {
                Logger.getLogger(categoriaView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        
            
    }//GEN-LAST:event_CADASTRARActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         if(jTable1.getSelectedRow() != -1){
            jTextFieldCatego.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            jTextFieldDesc.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() != -1){
            jTextFieldCatego.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            jTextFieldDesc.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());

        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void ATUALIZARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATUALIZARActionPerformed
         if(jTextFieldCatego.getText().isEmpty() || jTextFieldDesc.getText().isEmpty() ){
             JOptionPane.showMessageDialog(null,"CAMPO VAZIO");
        }else{
            
        
        
            categoria categoria_tela = new categoria();
            categoria_tela.setCod_categoria(Integer.parseInt(jTextFieldCatego.getText()));
            categoria_tela.setDesc_categoria(jTextFieldDesc.getText());
        
            try {
                //categoriabanco precisa da conexao com o banco pra inserir
                Connection conexao = new Conexao().getConnection();
                CategoriaDAO categoriabanco = new CategoriaDAO(conexao);
            
                categoriabanco.update(categoria_tela);
                JOptionPane.showMessageDialog(null,"Categoria atualizada com sucesso!!!");
                readTable();
                jTextFieldDesc.setText("");
                jTextFieldCatego.setText("");
               

            } catch (SQLException ex) {
                Logger.getLogger(categoriaView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }//GEN-LAST:event_ATUALIZARActionPerformed

    private void jTextFieldCategoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCategoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldCategoActionPerformed

    private void DELETARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETARActionPerformed
        // TODO add your handling code here:
         if(jTextFieldCatego.getText().isEmpty() || jTextFieldDesc.getText().isEmpty() ){
             JOptionPane.showMessageDialog(null,"CAMPO VAZIO");
        }else{
            
        
        
            categoria categoria_tela = new categoria();
            categoria_tela.setCod_categoria(Integer.parseInt(jTextFieldCatego.getText()));
            categoria_tela.setDesc_categoria(jTextFieldDesc.getText());
        
            try {
                //categoriabanco precisa da conexao com o banco pra inserir
                Connection conexao = new Conexao().getConnection();
                CategoriaDAO categoriabanco = new CategoriaDAO(conexao);
            
                categoriabanco.delete(categoria_tela);
                JOptionPane.showMessageDialog(null,"Categoria removida com sucesso!!!");
                readTable();
                jTextFieldDesc.setText("");
                jTextFieldCatego.setText("");
               

            } catch (SQLException ex) {
                Logger.getLogger(categoriaView.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(categoriaView.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(categoriaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(categoriaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(categoriaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(categoriaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new categoriaView().setVisible(true);
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
    private javax.swing.JTextField jTextFieldCatego;
    private javax.swing.JTextField jTextFieldDesc;
    // End of variables declaration//GEN-END:variables

}
