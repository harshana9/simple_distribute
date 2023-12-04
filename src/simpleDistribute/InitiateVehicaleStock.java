package simpleDistribute;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InitiateVehicaleStock extends javax.swing.JFrame {

    private final DefaultTableModel model;
    private final DbCon con = new DbCon();

    public InitiateVehicaleStock() throws SQLException {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        con.connect();
        
        model = (DefaultTableModel)tblInventory.getModel();
        loadToTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdoGrp_action = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventory = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rdo_keepNullValuesUnchanged = new javax.swing.JRadioButton();
        rdo_setNullValuesToZero = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Initiate Vehicale Stock");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tblInventory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Current Stock Value", "New Stock Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInventory);

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vehicle Stock Initiation");

        rdoGrp_action.add(rdo_keepNullValuesUnchanged);
        rdo_keepNullValuesUnchanged.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdo_keepNullValuesUnchanged.setSelected(true);
        rdo_keepNullValuesUnchanged.setText("Don't Change unassigned values ");

        rdoGrp_action.add(rdo_setNullValuesToZero);
        rdo_setNullValuesToZero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdo_setNullValuesToZero.setText("Initialize unassigned values to 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdo_setNullValuesToZero)
                    .addComponent(rdo_keepNullValuesUnchanged))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdo_keepNullValuesUnchanged)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdo_setNullValuesToZero)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSave)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            saveToDatabase();
            reset();
            loadToTable();
        } catch (SQLException ex) {
            Logger.getLogger(InitiateVehicaleStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con.close();
    }//GEN-LAST:event_formWindowClosing

    private void tblInventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventoryMouseClicked
        int selectedRowIndex = tblInventory.getSelectedRow();
        int adjestment = 0;
        String message = model.getValueAt(selectedRowIndex, 0).toString() + "["+model.getValueAt(selectedRowIndex, 1).toString()+"]";
        String result = (String)JOptionPane.showInputDialog(
           this,
           message, 
           "Enter Adjestment",            
           JOptionPane.PLAIN_MESSAGE,
           null,            
           null, 
           null
        );
        if(result != null && result.length() > 0){
            try {
                adjestment = Integer.parseInt(result);
                model.setValueAt(adjestment, selectedRowIndex, 2);
            } catch (Exception e) {}
        }
        else{
            model.setValueAt(null, selectedRowIndex, 2);
        }
        
    }//GEN-LAST:event_tblInventoryMouseClicked

    public static void main(String args[]) {
        try {
            FlatDarkLaf.setup();
        } catch (Exception e) {
            System.out.println("Theme Setup Error: " + e);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InitiateVehicaleStock().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(InitiateVehicaleStock.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void loadToTable() throws SQLException{
        //String item = ddl_product.getSelectedItem().toString();
        
        String sql = "SELECT `product`.`product_name`,`vehicle_stock` FROM `product`;";
        ResultSet rs =  con.query(sql);
        Object[] row;
        while(rs.next()){
            row = new Object[]{rs.getString("product_name"),rs.getString("vehicle_stock"),""};
            model.addRow(row);
        }
        
    }
        
    private void saveToDatabase() throws SQLException{
        String sql;
        int affected=0;
        

        String product;
        String strStock;
        int intStock;

        for (int i = 0; i < tblInventory.getRowCount(); i++) {
            
            product = (String) model.getValueAt(i, 0);
            try {
                //System.out.println(model.getValueAt(i, 2).getClass());
                intStock = Integer.parseInt(model.getValueAt(i, 2).toString());
                strStock = model.getValueAt(i, 2).toString();
            } catch (Exception e) {
                //System.out.println("N/A");
                strStock = "";
            }
            
            if("".equals(strStock)){
                if(rdo_keepNullValuesUnchanged.isSelected()){
                    strStock = (String) model.getValueAt(i, 1);
                }
                else if(rdo_setNullValuesToZero.isSelected()){
                    strStock = "0";
                }
            }
            sql = "UPDATE `product` SET `vehicle_stock`="+strStock+" WHERE `product_name`='"+product+"';";
            affected+=con.update(sql);
        }
        
        if(affected>0){
            JOptionPane.showMessageDialog(this, "Vehicle Stock Initiated",
                               "Success!", JOptionPane.INFORMATION_MESSAGE);   
        }
        else{
            JOptionPane.showMessageDialog(this, "Vehicle Stock not Initiated. Please check your inputs again.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void reset(){
        model.setRowCount(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup rdoGrp_action;
    private javax.swing.JRadioButton rdo_keepNullValuesUnchanged;
    private javax.swing.JRadioButton rdo_setNullValuesToZero;
    private javax.swing.JTable tblInventory;
    // End of variables declaration//GEN-END:variables
}