package simpleDistribute;

import com.formdev.flatlaf.*;
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


public class Invoice_old extends javax.swing.JFrame {

    private final DefaultTableModel model;
    private final DbCon con = new DbCon();
    private final Date date = new Date();
    
    public Invoice_old() throws SQLException {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        con.connect();
        
        model = (DefaultTableModel)tbl_items.getModel();
        loadComboItems();
        reset();
        resetForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_items = new javax.swing.JPanel();
        ddl_product = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_qty = new javax.swing.JTextField();
        txt_rate = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        txt_price = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        txt_freeI = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_priceCalc = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_items = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_invoice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_vat_no = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_address = new javax.swing.JTextArea();
        btn_save = new javax.swing.JButton();
        jdate_date = new com.toedter.calendar.JDateChooser();
        txt_customer = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_proformaDate = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_summery = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_numberProducts = new javax.swing.JLabel();
        lbl_totQty = new javax.swing.JLabel();
        lbl_sales = new javax.swing.JLabel();
        lbl_totFreeI = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txt_proformaInvoiceNo = new javax.swing.JTextField();
        btnLoadProforma = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Invoice");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        ddl_product.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        ddl_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddl_productActionPerformed(evt);
            }
        });
        ddl_product.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ddl_productPropertyChange(evt);
            }
        });

        jLabel1.setText("Product");

        jLabel2.setText("Qty");

        jLabel3.setText("Rate");

        txt_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qtyActionPerformed(evt);
            }
        });
        txt_qty.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_qtyPropertyChange(evt);
            }
        });

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jLabel4.setText("Amount");

        jButton1.setText("E");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jLabel5.setText("Free lssue");

        btn_priceCalc.setText("Calculate");
        btn_priceCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_priceCalcActionPerformed(evt);
            }
        });

        btn_delete.setText("Remove");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_itemsLayout = new javax.swing.GroupLayout(panel_items);
        panel_items.setLayout(panel_itemsLayout);
        panel_itemsLayout.setHorizontalGroup(
            panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_itemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_itemsLayout.createSequentialGroup()
                        .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_itemsLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_freeI)
                            .addGroup(panel_itemsLayout.createSequentialGroup()
                                .addComponent(txt_rate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_qty)
                            .addComponent(ddl_product, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel_itemsLayout.createSequentialGroup()
                                .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_priceCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel_itemsLayout.createSequentialGroup()
                        .addComponent(btn_reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add)))
                .addContainerGap())
        );
        panel_itemsLayout.setVerticalGroup(
            panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_itemsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ddl_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btn_priceCalc)
                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_freeI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reset)
                    .addComponent(btn_delete)
                    .addComponent(btn_update)
                    .addComponent(btn_add)))
        );

        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Product Name", "Qty", "Rate", "Amount", "Free lssue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_items.setName(""); // NOI18N
        tbl_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_itemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_items);

        jLabel10.setText("Invoice No ");

        txt_invoice.setEditable(false);

        jLabel11.setText("Customer");

        jLabel12.setText("Date");

        jLabel13.setText("Customer Address");

        jLabel15.setText("Customer VAT No");

        txt_vat_no.setEditable(false);

        txt_address.setEditable(false);
        txt_address.setColumns(20);
        txt_address.setRows(5);
        jScrollPane2.setViewportView(txt_address);

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        jdate_date.setForeground(new java.awt.Color(255, 255, 255));

        txt_customer.setEditable(false);

        jLabel17.setText("Proforma Date");

        txt_proformaDate.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel17)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdate_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_invoice, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(txt_customer, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(txt_proformaDate, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_save, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_vat_no, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txt_invoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txt_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txt_proformaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_vat_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addComponent(jdate_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_save))
        );

        btn_summery.setText("Summery");
        btn_summery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_summeryActionPerformed(evt);
            }
        });

        jLabel6.setText("Number of Products");

        jLabel7.setText("Total Quntity");

        jLabel8.setText("Sales");

        jLabel9.setText("Total Free lssues");

        lbl_numberProducts.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbl_numberProducts.setText("jLabel10");

        lbl_totQty.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbl_totQty.setText("jLabel11");

        lbl_sales.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbl_sales.setText("jLabel12");

        lbl_totFreeI.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbl_totFreeI.setText("jLabel13");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_numberProducts)
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_totQty)
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_sales)
                .addGap(42, 42, 42)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_totFreeI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btn_summery)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lbl_numberProducts)
                        .addComponent(jLabel7)
                        .addComponent(lbl_totQty)
                        .addComponent(jLabel8)
                        .addComponent(lbl_totFreeI)
                        .addComponent(lbl_sales)
                        .addComponent(btn_summery)))
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Create Invoice");

        jLabel16.setText("Proforma Invoice No ");

        btnLoadProforma.setText("Load Proforma Invoice");
        btnLoadProforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadProformaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_proformaInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadProforma)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_proformaInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadProforma))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(panel_items, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_items, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_qtyActionPerformed

    }//GEN-LAST:event_txt_qtyActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        calculatePrice();
        addItem();
        reset();
    }//GEN-LAST:event_btn_addActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txt_rate.setEditable(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemsMouseClicked
        loadItems();
        btn_add.setEnabled(false);
        btn_update.setEnabled(true);
        btn_delete.setEnabled(true);
    }//GEN-LAST:event_tbl_itemsMouseClicked

    private void ddl_productPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ddl_productPropertyChange

    }//GEN-LAST:event_ddl_productPropertyChange

    private void ddl_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddl_productActionPerformed
        try {
            loadRate();
        } catch (SQLException ex) {
            Logger.getLogger(Invoice_old.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ddl_productActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        calculatePrice();
        int rowNumber = removeItem();
        updateItem(rowNumber);
        reset();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void txt_qtyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_qtyPropertyChange
        
    }//GEN-LAST:event_txt_qtyPropertyChange

    private void btn_priceCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_priceCalcActionPerformed
        calculatePrice();
    }//GEN-LAST:event_btn_priceCalcActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        removeItem();
        arrangeTableRowNumbers();
        reset();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_summeryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_summeryActionPerformed
        calculateSummery();
    }//GEN-LAST:event_btn_summeryActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        saveToDatabase();
        try {
            resetForm();
        } catch (SQLException ex) {
            Logger.getLogger(Invoice_old.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btnLoadProformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadProformaActionPerformed
        try {
            loadProforma();  
        } catch (SQLException ex) {
            Logger.getLogger(Invoice_old.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoadProformaActionPerformed

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
                    new Invoice_old().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Invoice_old.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }
        });
        
    }
    
    private Object[] createTableRowObject(int rowNumber){
        if(rowNumber<0){
            rowNumber = model.getRowCount()+1;
        }
        Object[] row = new Object[]{rowNumber,ddl_product.getSelectedItem(),txt_qty.getText(),txt_rate.getText(),txt_price.getText(),txt_freeI.getText()};
        return row;
    }
    
    private void addItem(){
        //this uses with -10 param when new item ading
        //crateTableRowObject method take row number as param
        model.addRow(createTableRowObject(-10));
    }
    
    private void loadItems(){
        int selectedRowIndex = tbl_items.getSelectedRow();
        ddl_product.setSelectedItem(model.getValueAt(selectedRowIndex, 1).toString());
        txt_qty.setText(model.getValueAt(selectedRowIndex, 2).toString());
        txt_rate.setText(model.getValueAt(selectedRowIndex, 3).toString());
        txt_price.setText(model.getValueAt(selectedRowIndex, 4).toString());
        txt_freeI.setText(model.getValueAt(selectedRowIndex, 5).toString());
    }
    
    private void calculatePrice(){
        float price;
        float qty;
        float rate;
        float freeI;
        
        try {
            freeI = Float.parseFloat(txt_freeI.getText());
        } catch (Exception e) {
            freeI = 0;
            txt_freeI.setText(String.valueOf(freeI));
        }
        
        try {
            qty = Float.parseFloat(txt_qty.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Quentity Not set.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
            qty = 0;
            txt_qty.setText(String.valueOf(qty));
        }
        
        try {
            rate = Float.parseFloat(txt_rate.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Rate Not set.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
            rate = 0;
            txt_rate.setText(String.valueOf(rate));
        }
        
        price = qty*rate;
        txt_price.setText(String.valueOf(price));
    }
    
    private void loadComboItems() throws SQLException{
        //Product
        
        String sql = "SELECT * FROM `product`;";
        ResultSet rs =  con.query(sql);
        while(rs.next()){
            ddl_product.addItem(rs.getString("product_name"));
        }
        
        /*//Customer
        sql = "SELECT * FROM `customer`;";
        rs =  con.query(sql);
        while(rs.next()){
            ddl_customer.addItem(rs.getString("customer_name"));
        }
        */
    }
    
    private void loadRate() throws SQLException{
        String item = ddl_product.getSelectedItem().toString();
        
        String sql = "SELECT * FROM `product` WHERE `product_name`='"+item+"';";
        ResultSet rs =  con.query(sql);
        while(rs.next()){
            txt_rate.setText(rs.getString("product_rate"));
        }
        
    }
    
    /*private void loadCustomerData() throws SQLException{
        String customer = ddl_customer.getSelectedItem().toString();
        
        String sql = "SELECT * FROM `customer` WHERE `customer_name`='"+customer+"';";
        ResultSet rs =  con.query(sql);
        while(rs.next()){
            txt_address.setText(rs.getString("customer_address"));
            txt_vat_no.setText(rs.getString("customer_vat_no"));
        }
        
    }*/
    
    public void reset(){
        tbl_items.clearSelection();
        txt_price.setText("");
        txt_qty.setText("");
        txt_rate.setText("");
        txt_freeI.setText("");
        ddl_product.setSelectedIndex(0);
        btn_add.setEnabled(true);
        btn_delete.setEnabled(false);
        btn_update.setEnabled(false);
        txt_rate.setEditable(false);
        txt_price.setEditable(false);
        lbl_numberProducts.setText("");
        lbl_sales.setText("");
        lbl_totFreeI.setText("");
        lbl_totQty.setText("");
        //jdate_date.setDate(date);
    }
    
    public int removeItem(){
        int rowNumber = tbl_items.getSelectedRow();
        model.removeRow(rowNumber);
        return rowNumber;
    }
    
    public void updateItem(int rowNumber){
        model.insertRow(rowNumber, createTableRowObject(rowNumber+1));
    }
    
    public void arrangeTableRowNumbers(){
        for (int i = 0; i < tbl_items.getRowCount(); i++) {
            model.setValueAt(i+1, i, 0);
        }
    }
    
    public void calculateSummery(){
        float totSales=0;
        float totQty=0;
        float totFreeI=0;
        int numProducts=0;
        
        for (int i = 0; i < tbl_items.getRowCount(); i++) {
            numProducts ++;
            totQty += Float.parseFloat((String) model.getValueAt(i, 2));
            totSales += Float.parseFloat((String) model.getValueAt(i, 4));
            totFreeI += Float.parseFloat((String) model.getValueAt(i, 5));
        }
        
        lbl_numberProducts.setText(String.valueOf(numProducts));
        lbl_sales.setText(String.valueOf(totSales));
        lbl_totFreeI.setText(String.valueOf(totFreeI));
        lbl_totQty.setText(String.valueOf(totQty));
    }
    
    private void saveToDatabase(){
        Date date = jdate_date.getDate();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = formatter.format(date); 
        String invoiceNo=txt_invoice.getText();
        
        String sql;
        int affected=0;
        
        sql ="call delete_all_items_of_proformainvoice('"+invoiceNo+"');";
        if(con.singleReturnQuery(sql)==1){
            String product;
            String qty;
            String rate;
            String price;
            String freei;
            for (int i = 0; i < tbl_items.getRowCount(); i++) {
                product = (String) model.getValueAt(i, 1);
                qty = (String) model.getValueAt(i, 2);
                rate = (String) model.getValueAt(i, 3);
                price = (String) model.getValueAt(i, 4);
                freei = (String) model.getValueAt(i, 5);
                sql = "call update_proforma_items('"+invoiceNo+"','"+product+"','"+qty+"','"+rate+"','"+price+"','"+freei+"');";
                System.out.println("Hello2");
                //how to retive single value from a query
                if(con.singleReturnQuery(sql)==0){
                    JOptionPane.showMessageDialog(this, "Someting went wrong. Items not updated.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
                    affected=0;
                    break;
                }
                else{
                    affected=1;
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Someting went wrong. Items not updated.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
           
        if(affected>0){
            System.out.println("Hello");
            sql = "CALL proforma_to_invoice('"+invoiceNo+"','"+strDate+"');";
            if(con.singleReturnQuery(sql)==1){
                JOptionPane.showMessageDialog(this, "Invoice Created.",
                               "Success!", JOptionPane.INFORMATION_MESSAGE);   
            }
        }
    }
    
    
    public void loadProforma() throws SQLException{
        String proformaInvoiceNo = txt_proformaInvoiceNo.getText();
        
        String sql = "SELECT * FROM `proforma_invoice` WHERE `invoice_number`='"+proformaInvoiceNo+"';";
        ResultSet rs =  con.query(sql);
        //Object[] row;
        //int rowNumber=1;
        while(rs.next()){
            //row = new Object[]{rowNumber,rs.getString("customer_name"),rs.getString("customer_address"),rs.getString("customer_vat_no")};
            //model.addRow(row);
            //rowNumber++;
            txt_invoice.setText(rs.getString("invoice_number"));
            txt_customer.setText(rs.getString("customer_name"));
            txt_proformaDate.setText(rs.getString("invoice_date"));
            txt_address.setText(rs.getString("invoice_address"));
            txt_vat_no.setText(rs.getString("customer_vat_no"));
        }

        sql = "SELECT * FROM `proforma_invoiceitems` WHERE `invoice_id`='"+proformaInvoiceNo+"';";
        rs =  con.query(sql);
        Object[] row;
        int rowNumber=1;
        while(rs.next()){
            row = new Object[]{rowNumber,rs.getString("product_name"),rs.getString("qty"),rs.getString("rate"),rs.getString("price"),rs.getString("free_i")};
            model.addRow(row);
            rowNumber++;
        }
        
        txt_proformaInvoiceNo.setEnabled(false);
        btnLoadProforma.setEnabled(false);
    }
    
    public boolean resetForm() throws SQLException{
        model.setRowCount(0);
        reset();
        txt_invoice.setText("");
        txt_customer.setText("");
        txt_address.setText("");
        txt_vat_no.setText("");
        txt_proformaDate.setText("");
        jdate_date.setDate(date);
        txt_proformaInvoiceNo.setText("");
        
        txt_proformaInvoiceNo.setEditable(true);
        btnLoadProforma.setEnabled(true);
        txt_proformaInvoiceNo.setEnabled(true);
        btnLoadProforma.setEnabled(true);
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadProforma;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_priceCalc;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_summery;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> ddl_product;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdate_date;
    private javax.swing.JLabel lbl_numberProducts;
    private javax.swing.JLabel lbl_sales;
    private javax.swing.JLabel lbl_totFreeI;
    private javax.swing.JLabel lbl_totQty;
    private javax.swing.JPanel panel_items;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTextArea txt_address;
    private javax.swing.JTextField txt_customer;
    private javax.swing.JTextField txt_freeI;
    private javax.swing.JTextField txt_invoice;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_proformaDate;
    private javax.swing.JTextField txt_proformaInvoiceNo;
    private javax.swing.JTextField txt_qty;
    private javax.swing.JTextField txt_rate;
    private javax.swing.JTextField txt_vat_no;
    // End of variables declaration//GEN-END:variables
}
