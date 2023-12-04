package simpleDistribute;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SimpleDistribute extends javax.swing.JFrame {

    public SimpleDistribute() {
        initComponents();
        setMaximized(true);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        java.net.URL imgURL = getClass().getResource("background.jpg");
        ImageIcon icon=new ImageIcon(imgURL);
        Image img=icon.getImage();
        desktop = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(img,0,0,getWidth(),getHeight(),this);
            }
        };
        pnl_QuickAccess = new javax.swing.JPanel();
        btn_newOrder = new javax.swing.JButton();
        btn_newInvoice = new javax.swing.JButton();
        btn_bulkInvoice = new javax.swing.JButton();
        btn_products = new javax.swing.JButton();
        btn_customers = new javax.swing.JButton();
        btn_stockAdjestment = new javax.swing.JButton();
        btn_dispatchGuide = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnu_exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnu_proformaInvoice = new javax.swing.JMenuItem();
        mnu_newInvoice = new javax.swing.JMenuItem();
        mnu_bulkInvoicing = new javax.swing.JMenuItem();
        mnu_selectionDispatch = new javax.swing.JMenu();
        mnu_bulkDispatch = new javax.swing.JMenuItem();
        mnu_dispachSelection = new javax.swing.JMenuItem();
        mnu_dispatchHistory = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mnu_undeliverdOrders = new javax.swing.JMenuItem();
        mnu_stockAdjestment = new javax.swing.JMenu();
        mnu_updateInventory = new javax.swing.JMenuItem();
        mnu_inventoryInitiate = new javax.swing.JMenuItem();
        mnu_InitiateVehicleStock = new javax.swing.JMenuItem();
        mnuQuickAccess = new javax.swing.JMenu();
        mnu_customer = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuProduct = new javax.swing.JMenuItem();
        mnu_productCategory = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu7 = new javax.swing.JMenu();
        mnu_userManual = new javax.swing.JMenuItem();
        mnu_about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple Distribute");

        pnl_QuickAccess.setBackground(new java.awt.Color(255, 255, 255));

        btn_newOrder.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_newOrder.setText("New Order");
        btn_newOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newOrderActionPerformed(evt);
            }
        });

        btn_newInvoice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_newInvoice.setText("New Invoice");
        btn_newInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newInvoiceActionPerformed(evt);
            }
        });

        btn_bulkInvoice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_bulkInvoice.setText("Bulk Invoiceing");
        btn_bulkInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bulkInvoiceActionPerformed(evt);
            }
        });

        btn_products.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_products.setText("Products");
        btn_products.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_productsActionPerformed(evt);
            }
        });

        btn_customers.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_customers.setText("Customer");
        btn_customers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customersActionPerformed(evt);
            }
        });

        btn_stockAdjestment.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_stockAdjestment.setText("Stock Adjestments");
        btn_stockAdjestment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stockAdjestmentActionPerformed(evt);
            }
        });

        btn_dispatchGuide.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_dispatchGuide.setText("Dispatch");
        btn_dispatchGuide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dispatchGuideActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_QuickAccessLayout = new javax.swing.GroupLayout(pnl_QuickAccess);
        pnl_QuickAccess.setLayout(pnl_QuickAccessLayout);
        pnl_QuickAccessLayout.setHorizontalGroup(
            pnl_QuickAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_QuickAccessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_QuickAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_stockAdjestment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(btn_customers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_bulkInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_products, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_newOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_newInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_dispatchGuide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_QuickAccessLayout.setVerticalGroup(
            pnl_QuickAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_QuickAccessLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_newOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_newInvoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_bulkInvoice)
                .addGap(30, 30, 30)
                .addComponent(btn_products)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_customers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_stockAdjestment)
                .addGap(33, 33, 33)
                .addComponent(btn_dispatchGuide)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        desktop.setLayer(pnl_QuickAccess, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnl_QuickAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnl_QuickAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenu1.setText("File");

        mnu_exit.setText("Exit");
        mnu_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnu_exitMouseClicked(evt);
            }
        });
        mnu_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_exitActionPerformed(evt);
            }
        });
        jMenu1.add(mnu_exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Invoice");

        mnu_proformaInvoice.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnu_proformaInvoice.setText("New Order");
        mnu_proformaInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_proformaInvoiceActionPerformed(evt);
            }
        });
        jMenu2.add(mnu_proformaInvoice);

        mnu_newInvoice.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnu_newInvoice.setText("New Invoice");
        mnu_newInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_newInvoiceActionPerformed(evt);
            }
        });
        jMenu2.add(mnu_newInvoice);

        mnu_bulkInvoicing.setText("Bulk Invoicing");
        mnu_bulkInvoicing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_bulkInvoicingActionPerformed(evt);
            }
        });
        jMenu2.add(mnu_bulkInvoicing);

        jMenuBar1.add(jMenu2);

        mnu_selectionDispatch.setText("Dispatch");

        mnu_bulkDispatch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnu_bulkDispatch.setText("Dispatch");
        mnu_bulkDispatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_bulkDispatchActionPerformed(evt);
            }
        });
        mnu_selectionDispatch.add(mnu_bulkDispatch);

        mnu_dispachSelection.setText("Selection Dispatch");
        mnu_dispachSelection.setEnabled(false);
        mnu_dispachSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_dispachSelectionActionPerformed(evt);
            }
        });
        mnu_selectionDispatch.add(mnu_dispachSelection);

        mnu_dispatchHistory.setText("Dispatch History");
        mnu_dispatchHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_dispatchHistoryActionPerformed(evt);
            }
        });
        mnu_selectionDispatch.add(mnu_dispatchHistory);

        jMenuBar1.add(mnu_selectionDispatch);

        jMenu6.setText("Report");

        mnu_undeliverdOrders.setText("Undeliverd Orders");
        mnu_undeliverdOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_undeliverdOrdersActionPerformed(evt);
            }
        });
        jMenu6.add(mnu_undeliverdOrders);

        jMenuBar1.add(jMenu6);

        mnu_stockAdjestment.setText("Stock");

        mnu_updateInventory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnu_updateInventory.setText("Stock Adjestment");
        mnu_updateInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_updateInventoryActionPerformed(evt);
            }
        });
        mnu_stockAdjestment.add(mnu_updateInventory);

        mnu_inventoryInitiate.setText("Stock Initiate");
        mnu_inventoryInitiate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_inventoryInitiateActionPerformed(evt);
            }
        });
        mnu_stockAdjestment.add(mnu_inventoryInitiate);

        mnu_InitiateVehicleStock.setText("Initiate Stock in Vehicle");
        mnu_InitiateVehicleStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_InitiateVehicleStockActionPerformed(evt);
            }
        });
        mnu_stockAdjestment.add(mnu_InitiateVehicleStock);

        jMenuBar1.add(mnu_stockAdjestment);

        mnuQuickAccess.setText("Customer");

        mnu_customer.setText("Customer");
        mnu_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_customerActionPerformed(evt);
            }
        });
        mnuQuickAccess.add(mnu_customer);

        jMenuItem1.setText("Customer Route");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuQuickAccess.add(jMenuItem1);

        jMenuBar1.add(mnuQuickAccess);

        jMenu3.setText("Product");

        mnuProduct.setText("Product");
        mnuProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProductActionPerformed(evt);
            }
        });
        jMenu3.add(mnuProduct);

        mnu_productCategory.setText("Product Category");
        mnu_productCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_productCategoryActionPerformed(evt);
            }
        });
        jMenu3.add(mnu_productCategory);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Setup");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Quick Accss Buttons");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu4);

        jMenu7.setText("Help");

        mnu_userManual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mnu_userManual.setText("User Manual");
        jMenu7.add(mnu_userManual);

        mnu_about.setText("About");
        jMenu7.add(mnu_about);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnu_newInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_newInvoiceActionPerformed
        invoice();
    }//GEN-LAST:event_mnu_newInvoiceActionPerformed

    private void mnu_proformaInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_proformaInvoiceActionPerformed
        peroformaInvoice();
    }//GEN-LAST:event_mnu_proformaInvoiceActionPerformed

    private void mnu_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_customerActionPerformed
        customer();
    }//GEN-LAST:event_mnu_customerActionPerformed

    private void mnu_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnu_exitMouseClicked
        
    }//GEN-LAST:event_mnu_exitMouseClicked

    private void mnu_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnu_exitActionPerformed

    private void mnu_bulkDispatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_bulkDispatchActionPerformed
        dispatchGuide();
    }//GEN-LAST:event_mnu_bulkDispatchActionPerformed

    private void mnu_updateInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_updateInventoryActionPerformed
        stockAdjest();
    }//GEN-LAST:event_mnu_updateInventoryActionPerformed

    private void mnuProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProductActionPerformed
        product();
    }//GEN-LAST:event_mnuProductActionPerformed

    private void mnu_inventoryInitiateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_inventoryInitiateActionPerformed
        InitiateInventory inventory = null;
        try {
            inventory = new InitiateInventory();
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDistribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        inventory.setAlwaysOnTop( true );
        inventory.setVisible(true);
    }//GEN-LAST:event_mnu_inventoryInitiateActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CustomerRoute route = null;
        try {
            route = new CustomerRoute();
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDistribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        route.setAlwaysOnTop( true );
        route.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnu_bulkInvoicingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_bulkInvoicingActionPerformed
        bulkInvoice();
    }//GEN-LAST:event_mnu_bulkInvoicingActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        if(pnl_QuickAccess.isVisible()){
            pnl_QuickAccess.setVisible(false);
            mnuQuickAccess.setSelected(false);
        }
        else{
            pnl_QuickAccess.setVisible(true);
            mnuQuickAccess.setSelected(true);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void btn_newOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newOrderActionPerformed
        peroformaInvoice();
    }//GEN-LAST:event_btn_newOrderActionPerformed

    private void btn_newInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newInvoiceActionPerformed
        invoice();
    }//GEN-LAST:event_btn_newInvoiceActionPerformed

    private void btn_customersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customersActionPerformed
        customer();
    }//GEN-LAST:event_btn_customersActionPerformed

    private void btn_bulkInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bulkInvoiceActionPerformed
        bulkInvoice();
    }//GEN-LAST:event_btn_bulkInvoiceActionPerformed

    private void btn_productsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productsActionPerformed
        product();
    }//GEN-LAST:event_btn_productsActionPerformed

    private void btn_dispatchGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dispatchGuideActionPerformed
        dispatchGuide();
    }//GEN-LAST:event_btn_dispatchGuideActionPerformed

    private void btn_stockAdjestmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stockAdjestmentActionPerformed
        stockAdjest();
    }//GEN-LAST:event_btn_stockAdjestmentActionPerformed

    private void mnu_productCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_productCategoryActionPerformed
        productCategory();
    }//GEN-LAST:event_mnu_productCategoryActionPerformed

    private void mnu_InitiateVehicleStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_InitiateVehicleStockActionPerformed
        InitiateVehicaleStock vehicleStock = null;
        try {
            vehicleStock = new InitiateVehicaleStock();
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDistribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        vehicleStock.setAlwaysOnTop( true );
        vehicleStock.setVisible(true);
    }//GEN-LAST:event_mnu_InitiateVehicleStockActionPerformed

    private void mnu_undeliverdOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_undeliverdOrdersActionPerformed
        UndeliverdOrders undeliverOrders = null;
        undeliverOrders = new UndeliverdOrders();
        undeliverOrders.setAlwaysOnTop( true );
        undeliverOrders.setVisible(true);
    }//GEN-LAST:event_mnu_undeliverdOrdersActionPerformed

    private void mnu_dispachSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_dispachSelectionActionPerformed
        try {
            SelectionDispatch selectionDispatch = null;
            selectionDispatch = new SelectionDispatch();
            selectionDispatch.setAlwaysOnTop( true );
            selectionDispatch.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDistribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnu_dispachSelectionActionPerformed

    private void mnu_dispatchHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_dispatchHistoryActionPerformed
        DispatchHistory dispatchHistory = null;
        dispatchHistory = new DispatchHistory();
        dispatchHistory.setAlwaysOnTop( true );
        dispatchHistory.setVisible(true);
    }//GEN-LAST:event_mnu_dispatchHistoryActionPerformed

    public static void main(String args[]) {
        try {
            FlatDarkLaf.setup();
        } catch (Exception e) {
            System.out.println("Theme Setup Error: " + e);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimpleDistribute().setVisible(true);              
            }
        });
        
    }
    
    public void setMaximized(boolean maximized){
        if(maximized){
            DisplayMode mode = this.getGraphicsConfiguration().getDevice().getDisplayMode();
            Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
            this.setMaximizedBounds(new Rectangle(
                    mode.getWidth() - insets.right - insets.left, 
                    mode.getHeight() - insets.top - insets.bottom
            ));
            this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        }else{
            this.setExtendedState(JFrame.NORMAL);
        }
    }
    
    public void peroformaInvoice(){
        ProformaInvoice proformaInvoice;
        try {
            proformaInvoice = new ProformaInvoice();
            proformaInvoice.setAlwaysOnTop(true);
            proformaInvoice.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDistribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void invoice(){
        Invoice invoice;
        try {
            invoice = new Invoice();
            invoice.setAlwaysOnTop( true );
            //desktop.add(invoice);
            invoice.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDistribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void customer(){
        Customer customer;
        try {
            customer = new Customer();
            customer.setAlwaysOnTop( true );
            customer.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDistribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void bulkInvoice(){
        BulkInvoiceing bulkinvoice = null;
        try {
            bulkinvoice = new BulkInvoiceing();
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDistribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        bulkinvoice.setAlwaysOnTop( true );
        bulkinvoice.setVisible(true);
    }
    
    public void product(){
        Product product;
        try {
            product = new Product();
            product.setAlwaysOnTop( true );
            product.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDistribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stockAdjest(){
        StockAdjestment stockAdjestment = null;
        try {
            stockAdjestment = new StockAdjestment();
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDistribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        stockAdjestment.setAlwaysOnTop(true);
        stockAdjestment.setVisible(true);
    }
    
    public void dispatchGuide(){
        BulkDispacth dayReport;
        dayReport = new BulkDispacth();
        dayReport.setAlwaysOnTop( true );
        dayReport.setVisible(true);
    }
    
    public void productCategory(){
        ProductCategory prodCat;
        try {
            prodCat = new ProductCategory();
            prodCat.setAlwaysOnTop( true );
            prodCat.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDistribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bulkInvoice;
    private javax.swing.JButton btn_customers;
    private javax.swing.JButton btn_dispatchGuide;
    private javax.swing.JButton btn_newInvoice;
    private javax.swing.JButton btn_newOrder;
    private javax.swing.JButton btn_products;
    private javax.swing.JButton btn_stockAdjestment;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mnuProduct;
    private javax.swing.JMenu mnuQuickAccess;
    private javax.swing.JMenuItem mnu_InitiateVehicleStock;
    private javax.swing.JMenuItem mnu_about;
    private javax.swing.JMenuItem mnu_bulkDispatch;
    private javax.swing.JMenuItem mnu_bulkInvoicing;
    private javax.swing.JMenuItem mnu_customer;
    private javax.swing.JMenuItem mnu_dispachSelection;
    private javax.swing.JMenuItem mnu_dispatchHistory;
    private javax.swing.JMenuItem mnu_exit;
    private javax.swing.JMenuItem mnu_inventoryInitiate;
    private javax.swing.JMenuItem mnu_newInvoice;
    private javax.swing.JMenuItem mnu_productCategory;
    private javax.swing.JMenuItem mnu_proformaInvoice;
    private javax.swing.JMenu mnu_selectionDispatch;
    private javax.swing.JMenu mnu_stockAdjestment;
    private javax.swing.JMenuItem mnu_undeliverdOrders;
    private javax.swing.JMenuItem mnu_updateInventory;
    private javax.swing.JMenuItem mnu_userManual;
    private javax.swing.JPanel pnl_QuickAccess;
    // End of variables declaration//GEN-END:variables

    private Object getCalss() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
