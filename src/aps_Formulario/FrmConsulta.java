/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_Formulario;

import aps_dados.DAL.ClienteDAO;
import aps_dados.DAL.tudoDAO;
import aps_dados.model.Capturar;
import aps_dados.model.Cliente;
import aps_dados.model.Controle;
import aps_dados.model.Endereco;
import aps_dados.model.Insertion;
import aps_dados.model.Merge;
import aps_dados.model.Pedido;
import aps_dados.model.Quick;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.lang.Math;
import java.text.DecimalFormat;

/**
 *
 * @author muril
 */
public class FrmConsulta extends javax.swing.JFrame {

    /**
     * Creates new form FrmConsulta
     */
    public FrmConsulta(java.awt.Frame parent, boolean modal) {
        initComponents();
    }
    
    
    void preencherTabela(List<Cliente> pesquisarPorNome)
    {
        //tblPesquisaPessoas.setModel(new DefaultTableModel(new Object[][]{}, new String[] {"ID", "NOME", "RG", "CPF"}));
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        
        pesquisarPorNome.forEach((Cliente p) -> {
            modelo.addRow(new Object[]
            {
                "",p.getNm_Cliente(), p.getNr_Cpf(), p.getNr_Tel()
            });
        });
    }
    
    void preencheTabela()
    {
        DecimalFormat f = new DecimalFormat("#.##");
        //tblPesquisaPessoas.setModel(new DefaultTableModel(new Object[][]{}, new String[] {"ID", "NOME", "RG", "CPF"}));
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        
        tudoDAO.pedido();
        
        
        
        /*List<Cliente> clientes = tudoDAO.clientes;
        List<Endereco> enderecos = tudoDAO.enderecos;
        List<Pedido> pedidos = tudoDAO.pedidos;*/
        
        for (int i = 0; i < tudoDAO.captura.size(); i++) {
            
            Capturar cap = (Capturar) tudoDAO.captura.get(i);
            
            /*Cliente cliente =  clientes.get(i);
>>>>>>> c850a035f41745ade7cf4530b75d3b1ede13a0ca
            Endereco endereco = enderecos.get(i);
            Pedido pedid = pedidos.get(i);*/
            
             modelo.addRow(new Object[]
            {
                cap.getID_Pedido(), cap.getNm_Cliente() , cap.getNm_Rua() , cap.getNm_Bairro() , cap.getNr_Lat() , cap.getNr_Lon() , f.format(cap.getNr_Distancia())+"km", "Sorocaba"
            });
            
            
            
            
        }
        
    }
    void MergeOrganizate(){
        DecimalFormat f = new DecimalFormat("#.##");
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        
        tudoDAO.pedido();
        long tinicial = System.currentTimeMillis();
        Merge.sort(tudoDAO.captura);
        long tfinal = System.currentTimeMillis();
        lbTimeMarge.setText(String.valueOf(tfinal-tinicial));
        
        for (int i = 0; i < tudoDAO.captura.size(); i++) {
            
            Capturar cap = (Capturar) tudoDAO.captura.get(i);
            
             modelo.addRow(new Object[]
            {
                cap.getID_Pedido(), cap.getNm_Cliente() , cap.getNm_Rua() , cap.getNm_Bairro() , cap.getNr_Lat() , cap.getNr_Lon() , f.format(cap.getNr_Distancia())+"km", "Sorocaba"
            });

        }
    }
    void QuickOrganizate()
    {
        DecimalFormat f = new DecimalFormat("#.##");
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        
        tudoDAO.pedido();
        long tinicial = System.currentTimeMillis();
        Quick.sort(tudoDAO.captura);
        long tfinal = System.currentTimeMillis();
        lbTimeQuick.setText(String.valueOf(tfinal-tinicial));
        for (int i = 0; i < tudoDAO.captura.size(); i++) {
            
            Capturar cap = (Capturar) tudoDAO.captura.get(i);
            
             modelo.addRow(new Object[]
            {
                cap.getID_Pedido(), cap.getNm_Cliente() , cap.getNm_Rua() , cap.getNm_Bairro() , cap.getNr_Lat() , cap.getNr_Lon() , f.format(cap.getNr_Distancia())+"km" , "Sorocaba"
            });

        }
    }
    void InsertionOrganizate(){
        DecimalFormat f = new DecimalFormat("#.##");
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        
        tudoDAO.pedido();
        long tinicial = System.currentTimeMillis();
        Insertion.sort(tudoDAO.captura);
        long tfinal = System.currentTimeMillis();
        lbTimeInsertion.setText(String.valueOf(tfinal-tinicial));
        for (int i = 0; i < tudoDAO.captura.size(); i++) {
            
            Capturar cap = (Capturar) tudoDAO.captura.get(i);
            
             modelo.addRow(new Object[]
            {
                cap.getID_Pedido(), cap.getNm_Cliente() , cap.getNm_Rua() , cap.getNm_Bairro() , cap.getNr_Lat() , cap.getNr_Lon() , f.format(cap.getNr_Distancia())+"km", "Sorocaba"
            });

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

        jPanel1 = new javax.swing.JPanel();
        btnPesquisarCliente = new javax.swing.JButton();
        btnMerge = new javax.swing.JButton();
        btnQuick = new javax.swing.JButton();
        btnInsertion = new javax.swing.JButton();
        lbTimeMarge = new javax.swing.JLabel();
        lbTimeQuick = new javax.swing.JLabel();
        lbTimeInsertion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnPesquisarCliente.setText("Pesquisar");
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteActionPerformed(evt);
            }
        });

        btnMerge.setText("Merge");
        btnMerge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMergeActionPerformed(evt);
            }
        });

        btnQuick.setText("Quick");
        btnQuick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickActionPerformed(evt);
            }
        });

        btnInsertion.setText("Insertion");
        btnInsertion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertionActionPerformed(evt);
            }
        });

        lbTimeMarge.setText("Time");

        lbTimeQuick.setText("Time");

        lbTimeInsertion.setText("Time");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMerge, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTimeMarge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuick, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTimeQuick))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTimeInsertion)
                    .addComponent(btnInsertion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMerge)
                    .addComponent(btnQuick)
                    .addComponent(btnInsertion)
                    .addComponent(btnPesquisarCliente))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTimeMarge)
                    .addComponent(lbTimeQuick)
                    .addComponent(lbTimeInsertion))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(220, 480));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(220, 480));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº Pedido", "Nome ", "Rua", "Bairro", "Latitude", "Longitude", "Distância", "Cidade"
            }
        ));
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(220);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(220);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteActionPerformed
        /*
        Controle controle = new Controle();
        Cliente cliente = new Cliente();
        cliente.setNm_Cliente(txfNome.getText());
        List<Cliente> pesquisarPorNome = controle.pesquisarPorNome(cliente);
        if (pesquisarPorNome != null)
        {
        preencherTabela(pesquisarPorNome);
        }
         */
        
        preencheTabela();
        
    }//GEN-LAST:event_btnPesquisarClienteActionPerformed

    private void btnMergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMergeActionPerformed

        MergeOrganizate();
    }//GEN-LAST:event_btnMergeActionPerformed

    private void btnQuickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickActionPerformed
        QuickOrganizate();
    }//GEN-LAST:event_btnQuickActionPerformed

    private void btnInsertionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertionActionPerformed
        InsertionOrganizate();
        
    }//GEN-LAST:event_btnInsertionActionPerformed

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
            java.util.logging.Logger.getLogger(FrmConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmConsulta dialog = new FrmConsulta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertion;
    private javax.swing.JButton btnMerge;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnQuick;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbTimeInsertion;
    private javax.swing.JLabel lbTimeMarge;
    private javax.swing.JLabel lbTimeQuick;
    // End of variables declaration//GEN-END:variables
}
