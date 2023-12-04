package simpleDistribute;

import com.formdev.flatlaf.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;


public class Invoice extends javax.swing.JFrame {

    private final DefaultTableModel model;
    private final DbCon con = new DbCon();
    private final Date date = new Date();
    
    public Invoice() throws SQLException {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        con.connect();
        
        model = (DefaultTableModel)tbl_items.getModel();
        loadComboItems();
        resetForm();
        txt_proformaInvoiceNo2.requestFocus();
        
        Color btnColor = new Color(0,27,94);
        
        btnLoadProforma2.setForeground(btnColor);
        btn_add.setForeground(btnColor);
        btn_autoDiscount.setForeground(btnColor);
        btn_delete.setForeground(btnColor);
        btn_manualDiscount.setForeground(btnColor);
        btn_reset.setForeground(btnColor);
        btn_save.setForeground(btnColor);
        btn_update.setForeground(btnColor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_items = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_invoice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_vat_no = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_address = new javax.swing.JTextArea();
        btn_save = new javax.swing.JButton();
        jdate_date = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        txt_discount = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_customer = new javax.swing.JTextField();
        txt_proformaDate = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btn_autoDiscount = new javax.swing.JButton();
        btn_manualDiscount = new javax.swing.JButton();
        txt_discountRate = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        ddl_discountCategory = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
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
        btn_editRate = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        txt_freeI = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_priceCalc = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
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
        jPanel5 = new javax.swing.JPanel();
        txt_proformaInvoiceNo2 = new javax.swing.JTextField();
        btnLoadProforma2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Order");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tbl_items.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Product Name", "Qty", "Rate", "Amount", "Free lssue", "Discount Rate", "Product Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_items.setName(""); // NOI18N
        tbl_items.getTableHeader().setReorderingAllowed(false);
        tbl_items.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tbl_itemsComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                tbl_itemsComponentRemoved(evt);
            }
        });
        tbl_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_itemsMouseClicked(evt);
            }
        });
        tbl_items.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_itemsPropertyChange(evt);
            }
        });
        tbl_items.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tbl_itemsVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_items);
        if (tbl_items.getColumnModel().getColumnCount() > 0) {
            tbl_items.getColumnModel().getColumn(0).setPreferredWidth(20);
            tbl_items.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_items.getColumnModel().getColumn(2).setPreferredWidth(30);
            tbl_items.getColumnModel().getColumn(3).setPreferredWidth(40);
            tbl_items.getColumnModel().getColumn(4).setPreferredWidth(40);
            tbl_items.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Invoice No ");

        txt_invoice.setEditable(false);
        txt_invoice.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Date");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Customer Address");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Customer VAT No");

        txt_vat_no.setEditable(false);
        txt_vat_no.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txt_address.setEditable(false);
        txt_address.setColumns(20);
        txt_address.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_address.setRows(5);
        jScrollPane2.setViewportView(txt_address);

        btn_save.setBackground(new java.awt.Color(204, 255, 204));
        btn_save.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_save.setText("Save");
        btn_save.setEnabled(false);
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        jdate_date.setForeground(new java.awt.Color(255, 255, 255));
        jdate_date.setEnabled(false);
        jdate_date.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Discount");

        txt_discount.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_discount.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Customer");

        txt_customer.setEditable(false);
        txt_customer.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txt_proformaDate.setEditable(false);
        txt_proformaDate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Proforma Date");

        btn_autoDiscount.setBackground(new java.awt.Color(204, 255, 255));
        btn_autoDiscount.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_autoDiscount.setText("Auto Discount");
        btn_autoDiscount.setEnabled(false);
        btn_autoDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_autoDiscountActionPerformed(evt);
            }
        });

        btn_manualDiscount.setBackground(new java.awt.Color(204, 255, 255));
        btn_manualDiscount.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_manualDiscount.setText("Manual Discount");
        btn_manualDiscount.setEnabled(false);
        btn_manualDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manualDiscountActionPerformed(evt);
            }
        });

        txt_discountRate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_discountRate.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Discount Rate");

        ddl_discountCategory.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ddl_discountCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        ddl_discountCategory.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Product Category");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_discountRate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel23))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(ddl_discountCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_manualDiscount))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_proformaDate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jdate_date, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_discount, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(txt_vat_no)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(btn_autoDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_vat_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(117, 117, 117)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_invoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdate_date, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_proformaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_manualDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_discountRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ddl_discountCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_autoDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ddl_product.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ddl_product.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        ddl_product.setEnabled(false);
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
        ddl_product.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ddl_productKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Product");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Qty");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Rate");

        txt_qty.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_qty.setEnabled(false);
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
        txt_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_qtyKeyPressed(evt);
            }
        });

        txt_rate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_rate.setEnabled(false);

        btn_add.setBackground(new java.awt.Color(204, 255, 204));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_add.setText("Add");
        btn_add.setEnabled(false);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        txt_price.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_price.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Amount");

        btn_editRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_editRate.setText("E");
        btn_editRate.setEnabled(false);
        btn_editRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editRateActionPerformed(evt);
            }
        });

        btn_reset.setBackground(new java.awt.Color(255, 255, 204));
        btn_reset.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.setEnabled(false);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(204, 255, 204));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_update.setText("Update");
        btn_update.setEnabled(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        txt_freeI.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_freeI.setEnabled(false);
        txt_freeI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_freeIKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Free lssue");

        btn_priceCalc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_priceCalc.setText("Calculate");
        btn_priceCalc.setEnabled(false);
        btn_priceCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_priceCalcActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(255, 204, 204));
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_delete.setText("Remove");
        btn_delete.setEnabled(false);
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
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_itemsLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_itemsLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
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
                                .addComponent(btn_editRate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_qty)
                            .addComponent(ddl_product, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel_itemsLayout.createSequentialGroup()
                                .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_priceCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel_itemsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_itemsLayout.setVerticalGroup(
            panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_itemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ddl_product, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(btn_editRate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_priceCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_freeI)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(panel_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addContainerGap())
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
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Create Order");

        txt_proformaInvoiceNo2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_proformaInvoiceNo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_proformaInvoiceNo2KeyPressed(evt);
            }
        });

        btnLoadProforma2.setBackground(new java.awt.Color(204, 255, 204));
        btnLoadProforma2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLoadProforma2.setText("Load Proforma Invoice");
        btnLoadProforma2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadProforma2ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Proforma Invoice No ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_proformaInvoiceNo2)
                .addGap(18, 18, 18)
                .addComponent(btnLoadProforma2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_proformaInvoiceNo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(10, Short.MAX_VALUE))
            .addComponent(btnLoadProforma2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panel_items, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_items, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_qtyActionPerformed

    }//GEN-LAST:event_txt_qtyActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            calculatePrice();
            addItem();
            
            reset();
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editRateActionPerformed
        txt_rate.setEditable(true);
    }//GEN-LAST:event_btn_editRateActionPerformed

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
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ddl_productActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {
            calculatePrice();
            int rowNumber = removeItem();
            updateItem(rowNumber);
            
            reset();
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }   
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
        try {
            if(!"".equals(txt_discountRate.getText()) && ddl_discountCategory.getSelectedItem()==""){
                JOptionPane.showMessageDialog(this, "Select Category and click button to calculate discount.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(!"".equals(txt_discountRate.getText()) && "".equals(txt_discount.getText())){
                JOptionPane.showMessageDialog(this, "Click manual discount button to calculate discount for given rate.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(tbl_items.getRowCount()<=0){
                JOptionPane.showMessageDialog(this, "Threre is nothing in the ordrd items.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                saveToDatabase();
                reset();
                resetForm();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProformaInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con.close();
    }//GEN-LAST:event_formWindowClosing

    private void tbl_itemsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_itemsPropertyChange
        
    }//GEN-LAST:event_tbl_itemsPropertyChange

    private void tbl_itemsVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tbl_itemsVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_itemsVetoableChange

    private void tbl_itemsComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tbl_itemsComponentAdded

    }//GEN-LAST:event_tbl_itemsComponentAdded

    private void tbl_itemsComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tbl_itemsComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_itemsComponentRemoved

    private void txt_qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_qtyKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            calculatePrice();
            txt_freeI.requestFocus();
        }
    }//GEN-LAST:event_txt_qtyKeyPressed

    private void txt_freeIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_freeIKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){    
            try {
                if(btn_update.isEnabled()){
                    calculatePrice();
                    int rowNumber = removeItem();
                    updateItem(rowNumber);
                    
                    reset();
                }
                else{
                    calculatePrice();
                    addItem();
                    
                    reset();
                }
                ddl_product.requestFocus();
            } catch (SQLException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txt_freeIKeyPressed

    private void ddl_productKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ddl_productKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            txt_qty.requestFocus();
        }
    }//GEN-LAST:event_ddl_productKeyPressed

    private void btnLoadProforma2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadProforma2ActionPerformed
        try {
            loadProforma();
        } catch (SQLException ex) {
            Logger.getLogger(Invoice_old.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoadProforma2ActionPerformed

    private void txt_proformaInvoiceNo2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_proformaInvoiceNo2KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                loadProforma();
            } catch (SQLException ex) {
                Logger.getLogger(Invoice_old.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txt_proformaInvoiceNo2KeyPressed

    private void btn_autoDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_autoDiscountActionPerformed
        calculateDiscount();
    }//GEN-LAST:event_btn_autoDiscountActionPerformed

    private void btn_manualDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manualDiscountActionPerformed
        calculateManualDiscount();
    }//GEN-LAST:event_btn_manualDiscountActionPerformed


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
                    new Invoice().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }
        });
        
    }
    
    private String getProductDiscountRate(String product) throws SQLException{
        String sql = "SELECT `discount_rate` FROM `product` LEFT JOIN `product_category` ON `product`.`product_category`=`product_category`.`category_name` WHERE `product`.`product_name`='"+product+"';";
        ResultSet rs = con.query(sql);
        if(rs.next()){
            return rs.getString("discount_rate");
        }
        else{
            return "0";
        }
    }
    
    private String getProductCategory(String product) throws SQLException{
        String sql = "SELECT `product_category` FROM `product` WHERE `product`.`product_name`='"+product+"';";
        ResultSet rs = con.query(sql);
        if(rs.next()){
            return rs.getString("product_category");
        }
        else{
            return "";
        }
    }
    
    private Object[] createTableRowObject(int rowNumber) throws SQLException{
        if(rowNumber<0){
            rowNumber = model.getRowCount()+1;
        }
        Object[] row = new Object[]{rowNumber,ddl_product.getSelectedItem(),txt_qty.getText(),txt_rate.getText(),txt_price.getText(),txt_freeI.getText(),getProductDiscountRate(ddl_product.getSelectedItem().toString()),getProductCategory(ddl_product.getSelectedItem().toString())};
        return row;
    }
    
    private void addItem() throws SQLException{
        //this uses with -10 param when new item ading
        //crateTableRowObject method take row number as param
        boolean newItem=true;
        for (int i = 0; i < tbl_items.getRowCount(); i++) {
            if(model.getValueAt(i, 1)==ddl_product.getSelectedItem()){
                newItem=false;
                break;
            }
        }
        if(newItem){
            model.addRow(createTableRowObject(-10));
        }
        else{
            JOptionPane.showMessageDialog(this, "This product alrady in the invoice. Please update it if you need to change the amount.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadItems(){
        int selectedRowIndex = tbl_items.getSelectedRow();
        ddl_product.setSelectedItem(model.getValueAt(selectedRowIndex, 1).toString());
        txt_qty.setText(model.getValueAt(selectedRowIndex, 2).toString());
        txt_rate.setText(model.getValueAt(selectedRowIndex, 3).toString());
        txt_price.setText(model.getValueAt(selectedRowIndex, 4).toString());
        txt_freeI.setText(model.getValueAt(selectedRowIndex, 5).toString());
        //ddl_discountCategory.setSelectedItem(model.getValueAt(selectedRowIndex, 7).toString());
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
        
        //Product Category
        sql = "SELECT * FROM `product_category`;";
        rs =  con.query(sql);
        ddl_discountCategory.removeAllItems();
        ddl_discountCategory.addItem("");
        while(rs.next()){
            ddl_discountCategory.addItem(rs.getString("category_name"));
        }
    }
    
    private void loadRate() throws SQLException{
        String item = ddl_product.getSelectedItem().toString();
        
        String sql = "SELECT * FROM `product` WHERE `product_name`='"+item+"';";
        ResultSet rs =  con.query(sql);
        while(rs.next()){
            txt_rate.setText(rs.getString("product_rate"));
        }
        
    }
    
    private int removeItem(){
        int rowNumber = tbl_items.getSelectedRow();
        model.removeRow(rowNumber);
        return rowNumber;
    }
    
    private void updateItem(int rowNumber) throws SQLException{
        model.insertRow(rowNumber, createTableRowObject(rowNumber+1));
    }
    
    private void arrangeTableRowNumbers(){
        for (int i = 0; i < tbl_items.getRowCount(); i++) {
            model.setValueAt(i+1, i, 0);
        }
    }
    
    private void calculateSummery(){
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
            double totalAmount = 0;
            for (int i = 0; i < tbl_items.getRowCount(); i++) {
                product = (String) model.getValueAt(i, 1);
                qty = (String) model.getValueAt(i, 2);
                rate = (String) model.getValueAt(i, 3);
                price = (String) model.getValueAt(i, 4);
                freei = (String) model.getValueAt(i, 5);
                totalAmount+=Double.parseDouble((String) model.getValueAt(i, 4));
                sql = "call update_proforma_items('"+invoiceNo+"','"+product+"','"+qty+"','"+rate+"','"+price+"','"+freei+"');";
                System.out.println(sql);
                //how to retive single value from a query
                if(con.singleReturnQuery(sql)==0){
                    JOptionPane.showMessageDialog(this, "Someting went wrong. Items not updated.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
                    affected=0;
                    break;
                }
                else{
                    affected++;
                }
            }
            
            if(affected>0){
                affected=0;
                double discount = Double.parseDouble(txt_discount.getText());
                double discountedAmount = totalAmount-discount;
                sql="UPDATE `invoice` SET `total_amount`='"+totalAmount+"', `discounted_amount`='"+discountedAmount+"', `discount_amount`='"+discount+"' WHERE `invoice_number`='"+invoiceNo+"';";
                System.out.println(sql);
                affected+=con.update(sql);
                
                sql = "CALL proforma_to_invoice('"+invoiceNo+"','"+strDate+"');";
                if(con.singleReturnQuery(sql)==1){
                    JOptionPane.showMessageDialog(this, "Invoice Created.",
                                   "Success!", JOptionPane.INFORMATION_MESSAGE);   
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Someting went wrong. Items not updated.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void calculateDiscount(){
        float discount=0;
        for (int i = 0; i < tbl_items.getRowCount(); i++) {
            float rate = Float.parseFloat((String) model.getValueAt(i, 6));
            float amount = Float.parseFloat((String) model.getValueAt(i, 4));
            discount += amount * rate / 100;
        }
        txt_discount.setText(String.valueOf(discount));
    }
    
    private void calculateManualDiscount(){
        float discount=0;
        float rate = 0;
        boolean inputValid = true;
        String category;
        
        try {
            rate = Float.parseFloat(txt_discountRate.getText());
        } catch (Exception e) {
            inputValid=false;
            JOptionPane.showMessageDialog(this, "Enter Valid Discount Rate",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        category = (String) ddl_discountCategory.getSelectedItem();
        if("".equals(category)){
            inputValid=false;
            JOptionPane.showMessageDialog(this, "Select applicable product category for discount.",
                                   "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if(inputValid){
            for (int i = 0; i < tbl_items.getRowCount(); i++) {
                if(category.equals(model.getValueAt(i, 7))){
                    //System.out.println(model.getValueAt(i, 7));
                    float amount = Float.parseFloat((String) model.getValueAt(i, 4));
                    discount += amount * rate / 100;
                }
            }
            txt_discount.setText(String.valueOf(discount));
        }
    }
    
    private void reset(){
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
        
    public boolean resetForm() throws SQLException{
        model.setRowCount(0);
        reset();
        txt_invoice.setText("");
        txt_customer.setText("");
        txt_address.setText("");
        txt_vat_no.setText("");
        txt_discount.setText("");
        txt_proformaDate.setText("");
        jdate_date.setDate(date);
        txt_proformaInvoiceNo2.setText("");
        txt_discount.setText("");
        txt_discountRate.setText("");
        ddl_discountCategory.setSelectedIndex(0);
        
        btnLoadProforma2.setEnabled(true);
        txt_proformaInvoiceNo2.setEnabled(true);
        
        btn_add.setEnabled(false);
        btn_reset.setEnabled(false);
        btn_priceCalc.setEnabled(false);
        btn_manualDiscount.setEnabled(false);
        btn_autoDiscount.setEnabled(false);
        btn_save.setEnabled(false);
        btn_reset.setEnabled(false);
        btn_editRate.setEnabled(false);
        txt_price.setEnabled(false);
        txt_rate.setEnabled(false);
        txt_qty.setEnabled(false);
        txt_freeI.setEnabled(false);
        txt_discountRate.setEnabled(false);
        txt_discount.setEnabled(false);
        ddl_product.setEnabled(false);
        ddl_discountCategory.setEnabled(false);
        jdate_date.setEnabled(false);
        
        return true;
    }
    
    /*private int nextInvoiceNo() throws SQLException{
        String sql="SELECT `invoice_number` FROM `proforma_invoice` UNION SELECT `invoice_number` FROM `invoice` ORDER BY `invoice_number` DESC LIMIT 1;";
        return (con.singleReturnQuery(sql))+1;
    }*/
    
    public void loadProforma() throws SQLException{
        String proformaInvoiceNo = txt_proformaInvoiceNo2.getText();
        
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
            txt_discount.setText(rs.getString("discount_amount"));
        }

        sql = "SELECT * FROM `proforma_invoiceitems` WHERE `invoice_id`='"+proformaInvoiceNo+"';";
        rs =  con.query(sql);
        Object[] row;
        int rowNumber=1;
        while(rs.next()){
            row = new Object[]{rowNumber,rs.getString("product_name"),rs.getString("qty"),rs.getString("rate"),rs.getString("price"),rs.getString("free_i"),getProductDiscountRate(rs.getString("product_name")),getProductCategory(rs.getString("product_name"))};
            model.addRow(row);
            rowNumber++;
        }
        
        txt_proformaInvoiceNo2.setEnabled(false);
        btnLoadProforma2.setEnabled(false);
        btn_add.setEnabled(true);
        btn_reset.setEnabled(true);
        btn_manualDiscount.setEnabled(true);
        btn_autoDiscount.setEnabled(true);
        btn_save.setEnabled(true);
        btn_reset.setEnabled(true);
        btn_priceCalc.setEnabled(true);
        btn_editRate.setEnabled(true);
        txt_price.setEnabled(true);
        txt_rate.setEnabled(true);
        txt_qty.setEnabled(true);
        txt_freeI.setEnabled(true);
        txt_discountRate.setEnabled(true);
        txt_discount.setEnabled(true);
        ddl_product.setEnabled(true);
        ddl_discountCategory.setEnabled(true);
        jdate_date.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadProforma2;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_autoDiscount;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_editRate;
    private javax.swing.JButton btn_manualDiscount;
    private javax.swing.JButton btn_priceCalc;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_summery;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> ddl_discountCategory;
    private javax.swing.JComboBox<String> ddl_product;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private com.toedter.calendar.JDateChooser jdate_date;
    private javax.swing.JLabel lbl_numberProducts;
    private javax.swing.JLabel lbl_sales;
    private javax.swing.JLabel lbl_totFreeI;
    private javax.swing.JLabel lbl_totQty;
    private javax.swing.JPanel panel_items;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTextArea txt_address;
    private javax.swing.JTextField txt_customer;
    private javax.swing.JTextField txt_discount;
    private javax.swing.JTextField txt_discountRate;
    private javax.swing.JTextField txt_freeI;
    private javax.swing.JTextField txt_invoice;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_proformaDate;
    private javax.swing.JTextField txt_proformaInvoiceNo2;
    private javax.swing.JTextField txt_qty;
    private javax.swing.JTextField txt_rate;
    private javax.swing.JTextField txt_vat_no;
    // End of variables declaration//GEN-END:variables
}
