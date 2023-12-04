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

public class Customer extends javax.swing.JFrame {

    private final DefaultTableModel model;
    private final DbCon con = new DbCon();
    
    public Customer() throws SQLException {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        con.connect();
        
        model = (DefaultTableModel)tbl_product.getModel();
        loadToTable();
        loadComboItems();
        reset();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_product = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        txt_vat_no = new javax.swing.JTextField();
        txt_customer_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_address = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        ddl_route = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tbl_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Customer", "Address", "VAT No", "Route"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_productMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_product);

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        txt_vat_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vat_noActionPerformed(evt);
            }
        });

        jLabel1.setText("Customer Name");

        jLabel2.setText("Address");

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("Remove");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel4.setText("VAT No");

        txt_address.setColumns(20);
        txt_address.setRows(5);
        jScrollPane2.setViewportView(txt_address);

        jLabel5.setText("Route");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_vat_no)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_customer_name, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ddl_route, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ddl_route, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_vat_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_reset)
                    .addComponent(btn_update)
                    .addComponent(btn_delete))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Add Remove or Update Customer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_vat_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vat_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_vat_noActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        try {
            reset();
            clearTable();
            loadToTable();
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            deleteProduct();
            clearTable();
            loadToTable();
            reset();
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {
            updateProduct();
            clearTable();
            loadToTable();
            reset();
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            addProduct();
            reset();
            clearTable();
            loadToTable();
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void tbl_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productMouseClicked
        loadItems();
        btn_add.setEnabled(false);
        btn_update.setEnabled(true);
        btn_delete.setEnabled(true);
    }//GEN-LAST:event_tbl_productMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con.close();
    }//GEN-LAST:event_formWindowClosing

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
                    new Customer().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void loadToTable() throws SQLException{
        //String item = ddl_product.getSelectedItem().toString();
        
        String sql = "SELECT * FROM `customer`;";
        ResultSet rs =  con.query(sql);
        Object[] row;
        int rowNumber=1;
        while(rs.next()){
            row = new Object[]{rowNumber,rs.getString("customer_name"),rs.getString("customer_address"),rs.getString("customer_vat_no"),rs.getString("customer_route")};
            model.addRow(row);
            rowNumber++;
        }
        
    }
    
    private void addProduct(){
        int affected;
        
        String sql = "insert into `customer`(`customer_name`,`customer_address`,`customer_vat_no`,`customer_route`) values ('" + txt_customer_name.getText() + "', NULLIF('" + txt_address.getText() + "', ''), NULLIF('" + txt_vat_no.getText() + "', ''), '"+ddl_route.getSelectedItem()+"');";
        affected = con.update(sql);
        
        if(affected==0){
            JOptionPane.showMessageDialog(this, "Something went wrong. Data have not inserted.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deleteProduct(){
        int affected = 0;
        int selectedRowIndex = tbl_product.getSelectedRow();
        
        String sql = "delete from `customer` where `customer_name`='" + model.getValueAt(selectedRowIndex, 1).toString() + "';";
        affected=con.update(sql);
        
        if(affected>0){
            JOptionPane.showMessageDialog(this, "Customer Deleted.",
                                   "Success!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Something went wrong. Data have not deleted.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateProduct() throws SQLException{
        String customer_id = null;
        ResultSet rs;
        
        int selectedRowIndex = tbl_product.getSelectedRow();
        
        String sql = "SELECT `customerid` FROM `customer` WHERE `customer_name`='" + model.getValueAt(selectedRowIndex, 1).toString() + "';";
        rs = con.query(sql);
        
        while(rs.next()){
            customer_id = rs.getString("customerid");
        }
        
        int affected;
        sql = "UPDATE `customer` SET `customer_name`='" + txt_customer_name.getText() + "', `customer_address`=NULLIF('" + txt_address.getText() + "', ''), `customer_vat_no`=NULLIF('" + txt_vat_no.getText() + "', ''), `customer_route`='"+ddl_route.getSelectedItem()+"' WHERE `customerid`='" + customer_id + "';";
        
        affected = con.update(sql);
        
        if(affected>0){
            JOptionPane.showMessageDialog(this, "Customer Updated.",
                                   "Success!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Something went wrong. Data have not updated.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    private void clearTable(){
        model.setRowCount(0);
    }
    
    private void reset(){
        txt_customer_name.setText("");
        txt_address.setText("");
        txt_vat_no.setText("");
        btn_add.setEnabled(true);
        btn_delete.setEnabled(false);
        btn_update.setEnabled(false);
    }
    
    private void loadItems(){
        int selectedRowIndex = tbl_product.getSelectedRow();
        try{
            txt_customer_name.setText(model.getValueAt(selectedRowIndex, 1).toString());
        }
        catch(Exception e){
            txt_customer_name.setText("");
        }
        
        try{
            txt_address.setText(model.getValueAt(selectedRowIndex, 2).toString());
        }
        catch(Exception e){
            txt_address.setText("");
        }
        
        try{
            txt_vat_no.setText(model.getValueAt(selectedRowIndex, 3).toString());
        }
        catch(Exception e){
            txt_vat_no.setText("");
        }
        
        try{
            ddl_route.setSelectedItem(model.getValueAt(selectedRowIndex, 4));
        }
        catch(Exception e){
            ddl_route.setSelectedIndex(0);
        }
    }
    
    private void loadComboItems() throws SQLException{
        //Route
        
        String sql = "SELECT `route` FROM `customer_route`;";
        ResultSet rs =  con.query(sql);
        while(rs.next()){
            ddl_route.addItem(rs.getString("route"));
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> ddl_route;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_product;
    private javax.swing.JTextArea txt_address;
    private javax.swing.JTextField txt_customer_name;
    private javax.swing.JTextField txt_vat_no;
    // End of variables declaration//GEN-END:variables
}
