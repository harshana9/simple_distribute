package simpleDistribute;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BulkInvoiceing extends javax.swing.JFrame {

    private final DefaultTableModel model;
    private final DbCon con = new DbCon();
    private final Date date = new Date();
    
    public BulkInvoiceing() throws SQLException {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        con.connect();
        
        model = (DefaultTableModel)tbl_order.getModel();
        
        Color btnColor = new Color(0,27,94);
        btn_load.setForeground(btnColor);
        btn_createInvoices.setForeground(btnColor);
        
        reset();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_order = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_load = new javax.swing.JButton();
        txt_lastOrder = new javax.swing.JTextField();
        txt_firstOrder = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jdate_date = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        chk_allOrders = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        btn_createInvoices = new javax.swing.JButton();
        btn_selectAll = new javax.swing.JButton();
        btn_deselectAll = new javax.swing.JButton();

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

        tbl_order.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "Order #", "Customer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_order.getTableHeader().setReorderingAllowed(false);
        tbl_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_orderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_order);
        if (tbl_order.getColumnModel().getColumnCount() > 0) {
            tbl_order.getColumnModel().getColumn(0).setPreferredWidth(15);
        }

        btn_load.setBackground(new java.awt.Color(204, 255, 255));
        btn_load.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_load.setText("Load");
        btn_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadActionPerformed(evt);
            }
        });

        txt_lastOrder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_lastOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lastOrderActionPerformed(evt);
            }
        });

        txt_firstOrder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("First Order Number");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Last Order Number");

        jdate_date.setForeground(new java.awt.Color(255, 255, 255));
        jdate_date.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Invoice Date");

        chk_allOrders.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chk_allOrders.setSelected(true);
        chk_allOrders.setText("Load all uninvoiced orders");
        chk_allOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_allOrdersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_firstOrder))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chk_allOrders)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_lastOrder)
                            .addComponent(jdate_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_load, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_firstOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_lastOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdate_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_allOrders)
                .addGap(10, 10, 10)
                .addComponent(btn_load, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Create Invoices for Many Orders Once");

        btn_createInvoices.setBackground(new java.awt.Color(204, 255, 204));
        btn_createInvoices.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_createInvoices.setText("Create Invoices");
        btn_createInvoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createInvoicesActionPerformed(evt);
            }
        });

        btn_selectAll.setText("Select All");
        btn_selectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectAllActionPerformed(evt);
            }
        });

        btn_deselectAll.setText("Select All");
        btn_deselectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deselectAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_selectAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_deselectAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_createInvoices))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_selectAll, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_createInvoices, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btn_deselectAll, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_lastOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lastOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastOrderActionPerformed

    private void btn_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadActionPerformed
        try {
            clearTable();
            loadToTable();
        } catch (SQLException ex) {
            Logger.getLogger(BulkInvoiceing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_loadActionPerformed

    private void tbl_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_orderMouseClicked
        //loadItems();
        //btn_load.setEnabled(false);
    }//GEN-LAST:event_tbl_orderMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con.close();
    }//GEN-LAST:event_formWindowClosing

    private void btn_selectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectAllActionPerformed
        selectAll();
    }//GEN-LAST:event_btn_selectAllActionPerformed

    private void btn_createInvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createInvoicesActionPerformed
        try {
            createInvoices();
            reset();
            clearTable();
        } catch (SQLException ex) {
            Logger.getLogger(BulkInvoiceing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_createInvoicesActionPerformed

    private void btn_deselectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deselectAllActionPerformed
        deselectAll();
    }//GEN-LAST:event_btn_deselectAllActionPerformed

    private void chk_allOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_allOrdersActionPerformed
        if(chk_allOrders.isSelected()){
            try {
                /*txt_firstOrder.setText("");
                txt_lastOrder.setText("");*/
                txt_firstOrder.setEnabled(false);
                txt_lastOrder.setEnabled(false);
                setAllOrdersRange();
            } catch (SQLException ex) {
                Logger.getLogger(BulkInvoiceing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            txt_firstOrder.setEnabled(true);
            txt_lastOrder.setEnabled(true);
        }
    }//GEN-LAST:event_chk_allOrdersActionPerformed

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
                    new BulkInvoiceing().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(BulkInvoiceing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void loadToTable() throws SQLException{
        int firstOrder=0;
        try {
            firstOrder = Integer.parseInt(txt_firstOrder.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter valid first order number.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        int lastOrder=0;
        try {
            lastOrder = Integer.parseInt(txt_lastOrder.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You haven't given any valid last order number. System will retrive all orders from start number.",
                                   "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        
        String sql=null;
        
        if(firstOrder>0 && lastOrder>=firstOrder){
            sql = "SELECT `invoice_number`,`customer_name` FROM `proforma_invoice` WHERE `invoice_number`>='"+firstOrder+"' AND `invoice_number`<='"+lastOrder+"';";
        }
        else if (firstOrder>0 && lastOrder==0){
            sql = "SELECT `invoice_number`,`customer_name` FROM `proforma_invoice` WHERE `invoice_number`>='"+firstOrder+"';";
        }
        //System.out.println(sql);
        if(null!=sql){
            ResultSet rs =  con.query(sql);
            Object[] row;
            //int rowNumber=1;
            while(rs.next()){
                row = new Object[]{false,rs.getString("invoice_number"),rs.getString("customer_name")};
                model.addRow(row);
                //rowNumber++;
            }
        }
    }
    
    private void selectAll(){
        for (int i = 0; i < tbl_order.getRowCount(); i++) {
            tbl_order.setValueAt(true, i, 0);
        }
    }
    
    private void deselectAll(){
        for (int i = 0; i < tbl_order.getRowCount(); i++) {
            tbl_order.setValueAt(false, i, 0);
        }
    }
    
    private void createInvoices(){
        int affected=0;
        String invoiceNo = null;
        String sql;
        
        for (int i = 0; i < tbl_order.getRowCount(); i++) {
            invoiceNo=tbl_order.getValueAt(i, 1).toString();
            Date date = jdate_date.getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            String strDate = formatter.format(date);
            sql = "CALL proforma_to_invoice('"+invoiceNo+"','"+strDate+"');";
            if(con.singleReturnQuery(sql)==1){
                affected++;
            }
            else{
                String msg = "Something went wrong. Invoice for order no: "+invoiceNo+" could not created!.";
                JOptionPane.showMessageDialog(this, msg,
                                   "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(affected==0){
            JOptionPane.showMessageDialog(this, "Something went wrong. Data have not inserted.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
    }  
    
    private void clearTable(){
        model.setRowCount(0);
    }
    
    private void reset() throws SQLException{
        /*txt_firstOrder.setText("");
        txt_lastOrder.setText("");*/
        jdate_date.setDate(date);
        txt_firstOrder.setEnabled(false);
        txt_lastOrder.setEnabled(false);
        setAllOrdersRange();
        //btn_load.setEnabled(true);
        //btn_delete.setEnabled(false);
        //btn_update.setEnabled(false);
    }
    
    private  void setAllOrdersRange() throws SQLException{
        String sql = "SELECT MIN(`invoice_number`) AS `first_invoice_no`, MAX(`invoice_number`) AS `last_invoice_no` FROM `proforma_invoice`;";
        ResultSet rs =  con.query(sql);
        if(rs.next()){
            txt_firstOrder.setText(rs.getString("first_invoice_no"));
            txt_lastOrder.setText(rs.getString("last_invoice_no"));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_createInvoices;
    private javax.swing.JButton btn_deselectAll;
    private javax.swing.JButton btn_load;
    private javax.swing.JButton btn_selectAll;
    private javax.swing.JCheckBox chk_allOrders;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdate_date;
    private javax.swing.JTable tbl_order;
    private javax.swing.JTextField txt_firstOrder;
    private javax.swing.JTextField txt_lastOrder;
    // End of variables declaration//GEN-END:variables
}
