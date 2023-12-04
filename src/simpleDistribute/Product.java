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

public class Product extends javax.swing.JFrame {

    private final DefaultTableModel model;
    private final DbCon con = new DbCon();
    
    public Product() throws SQLException {
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
        txt_rate = new javax.swing.JTextField();
        txt_product = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        ddl_productCategory = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Product");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tbl_product.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Product", "Rate", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        if (tbl_product.getColumnModel().getColumnCount() > 0) {
            tbl_product.getColumnModel().getColumn(0).setPreferredWidth(15);
        }

        btn_add.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        txt_rate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rateActionPerformed(evt);
            }
        });

        txt_product.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Product Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Rate");

        btn_reset.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_delete.setText("Remove");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        ddl_productCategory.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ddl_productCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        ddl_productCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddl_productCategoryActionPerformed(evt);
            }
        });
        ddl_productCategory.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ddl_productCategoryPropertyChange(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Category");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(btn_add))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_rate)
                            .addComponent(txt_product, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(ddl_productCategory, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ddl_productCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_reset)
                    .addComponent(btn_update)
                    .addComponent(btn_delete))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Add Remove or Update Product");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rateActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        try {
            reset();
            clearTable();
            loadToTable();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            deleteProduct();
            clearTable();
            loadToTable();
            reset();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {
            updateProduct();
            clearTable();
            loadToTable();
            reset();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            addProduct();
            reset();
            clearTable();
            loadToTable();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
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

    private void ddl_productCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddl_productCategoryActionPerformed

    }//GEN-LAST:event_ddl_productCategoryActionPerformed

    private void ddl_productCategoryPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ddl_productCategoryPropertyChange

    }//GEN-LAST:event_ddl_productCategoryPropertyChange

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
                    new Product().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void loadToTable() throws SQLException{
        //String item = ddl_product.getSelectedItem().toString();
        
        String sql = "SELECT * FROM product;";
        ResultSet rs =  con.query(sql);
        Object[] row;
        int rowNumber=1;
        while(rs.next()){
            row = new Object[]{rowNumber,rs.getString("product_name"),rs.getString("product_rate"),rs.getString("product_category")};
            model.addRow(row);
            rowNumber++;
        }
        
    }
    
    private void addProduct(){
        int affected;
        
        String sql = "insert into `product`(`product_name`,`product_rate`,`product_category`) values ('" + txt_product.getText() + "', '" + txt_rate.getText() + "', '"+ddl_productCategory.getSelectedItem()+"');";
        affected = con.update(sql);
        
        if(affected==0){
            JOptionPane.showMessageDialog(this, "Something went wrong. Data have not inserted.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deleteProduct(){
        int affected = 0;
        int selectedRowIndex = tbl_product.getSelectedRow();
        
        String sql = "delete from `product` where `product_name`='" + model.getValueAt(selectedRowIndex, 1).toString() + "';";
        affected = con.update(sql);
        
        if(affected>0){
            JOptionPane.showMessageDialog(this, "Product Deleted.",
                                   "Success!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Something went wrong. Data have not deleted.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateProduct() throws SQLException{
        String product_id = null;
        ResultSet rs;
        int selectedRowIndex = tbl_product.getSelectedRow();
        
        String sql = "SELECT `product_id` FROM `product` WHERE `product_name`='" + model.getValueAt(selectedRowIndex, 1).toString() + "';";
        rs = con.query(sql);
        while(rs.next()){
            product_id = rs.getString("product_id");
        }
        
        int affected;
        sql = "UPDATE `product` SET `product_name`='" + txt_product.getText() + "', `product_rate`='" + txt_rate.getText() + "', `product_category`='"+ddl_productCategory.getSelectedItem()+"' WHERE `product_id`='" + product_id + "';";
        affected = con.update(sql);
        
        if(affected>0){
            JOptionPane.showMessageDialog(this, "Product Updated.",
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
        txt_product.setText("");
        txt_rate.setText("");
        btn_add.setEnabled(true);
        btn_delete.setEnabled(false);
        btn_update.setEnabled(false);
    }
    
    private void loadItems(){
        int selectedRowIndex = tbl_product.getSelectedRow();
        txt_product.setText(model.getValueAt(selectedRowIndex, 1).toString());
        txt_rate.setText(model.getValueAt(selectedRowIndex, 2).toString());
        ddl_productCategory.setSelectedItem(model.getValueAt(selectedRowIndex, 3).toString());
    }

        private void loadComboItems() throws SQLException{
        //Product Category
        
        String sql = "SELECT * FROM `product_category`;";
        ResultSet rs =  con.query(sql);
        while(rs.next()){
            ddl_productCategory.addItem(rs.getString("category_name"));
        }
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> ddl_productCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_product;
    private javax.swing.JTextField txt_product;
    private javax.swing.JTextField txt_rate;
    // End of variables declaration//GEN-END:variables
}
