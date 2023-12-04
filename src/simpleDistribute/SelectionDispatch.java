package simpleDistribute;

import com.formdev.flatlaf.FlatDarkLaf;
import com.lowagie.text.Chunk;
import java.awt.Color;
import com.lowagie.text.Paragraph;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class SelectionDispatch extends javax.swing.JFrame {
    
    private final DbCon con = new DbCon();
    private final Date date = new Date();
    private final DefaultTableModel model;

    public SelectionDispatch() throws SQLException {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        model = (DefaultTableModel)tbl_Invoice.getModel();
        
        con.connect();
        
        reset();
        loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnGenerateReport = new javax.swing.JButton();
        progressbar = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Invoice = new javax.swing.JTable();
        btn_selectAll = new javax.swing.JButton();
        btn_deselectAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Day Report");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Selection Dispatch");

        btnGenerateReport.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnGenerateReport.setText("Dispatch & Generate PDF");
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(2);
        jTextArea1.setText("* Please enter all finalized invoices belongs to proformas of last destibution before generate\nreport.");
        jScrollPane1.setViewportView(jTextArea1);

        tbl_Invoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "Invoice #", "Date", "Route", "Customer", "Sale"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_Invoice);
        if (tbl_Invoice.getColumnModel().getColumnCount() > 0) {
            tbl_Invoice.getColumnModel().getColumn(0).setPreferredWidth(15);
        }

        btn_selectAll.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_selectAll.setText("Select All");
        btn_selectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectAllActionPerformed(evt);
            }
        });

        btn_deselectAll.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_deselectAll.setText("Deselect All");
        btn_deselectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deselectAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progressbar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_selectAll, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_deselectAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(btnGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerateReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_selectAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_deselectAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed
        try {
            pdf();
            reset();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(SelectionDispatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerateReportActionPerformed

    private void btn_selectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectAllActionPerformed
        selectAll();
    }//GEN-LAST:event_btn_selectAllActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con.close();
    }//GEN-LAST:event_formWindowClosing

    private void btn_deselectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deselectAllActionPerformed
        deselectAll();
    }//GEN-LAST:event_btn_deselectAllActionPerformed

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
                    new SelectionDispatch().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SelectionDispatch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void pdf() throws SQLException, IOException{
        try {
            progressbar.setValue(5);
            long msec = date.getTime();
            String fileName = "Dispach_Summery "+msec;
            String DEST = "./Reports/"+fileName+".pdf";
            PdfWriter writer;
            try (Document doc = new Document()) {
                writer = PdfWriter.getInstance(doc, new FileOutputStream(DEST));
                //setting font family, color
                Font fontTopic = new Font(Font.HELVETICA, 13, Font.BOLDITALIC, Color.RED);
                Font fontTblHead = new Font(Font.HELVETICA, 7, Font.BOLDITALIC);
                Font fontTblData = new Font(Font.HELVETICA, 9, Font.NORMAL);
                doc.open();
                //Add Content
                Paragraph topic = new Paragraph("Dispatch Summery Report", fontTopic);
                topic.setAlignment(Element.ALIGN_CENTER);
                topic.getFont().setStyle(Font.UNDERLINE);
                doc.add(topic);
                
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                var dt = new Paragraph("Date: "+String.valueOf(formatter.format(date)),fontTblData);
                dt.setAlignment(Element.ALIGN_LEFT);
                doc.add(dt);
                
                progressbar.setValue(15);
                //Blank Line
                doc.add( Chunk.NEWLINE );
                
                //Table
                PdfPTable table = new PdfPTable(4);
                table.setWidthPercentage(80);
                // setting column widths
                table.setWidths(new float[] {3, 1, 1, 1});
                PdfPCell cell = new PdfPCell();
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                
                // table headers
                cell.setPhrase(new Phrase("Product", fontTblHead));
                table.addCell(cell);
                cell.setPhrase(new Phrase("Stock in vehical", fontTblHead));
                table.addCell(cell);
                cell.setPhrase(new Phrase("Next Order Qty", fontTblHead));
                table.addCell(cell);
                cell.setPhrase(new Phrase("Aloctd. dispatch", fontTblHead));
                table.addCell(cell);

                
                progressbar.setValue(20);
                //List<User> users = getListOfUsers();
                
                progressbar.setValue(22);
                //String sql = "CALL dispatch_report('"+last_distribute_proforma_date_first+"','"+last_distribute_proforma_date_last+"','"+next_distribute_proforma_date_first+"','"+next_distribute_proforma_date_last+"');";
                String sql = "CALL dispatch_guide('"+"', '"+"');";
                ResultSet rs =  con.query(sql);
                progressbar.setValue(50);
                while(rs.next()){
                    //for(int i=0; i<20; i++){
                    //price=rs.getString("price").split
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(new Phrase(rs.getString("product_name"),fontTblData));
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    //table.addCell(cell);
                    /*cell.setPhrase(new Phrase(String.valueOf(rs.getInt("last_proforma_dispatch")),fontTblData));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(String.valueOf(rs.getInt("last_invoiced_distribution")),fontTblData));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(rs.getString("last_invoiced_sale"),fontTblData));
                    table.addCell(cell);*/
                    cell.setPhrase(new Phrase(String.valueOf(rs.getInt("vehicle_stock")),fontTblData));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(String.valueOf(rs.getInt("qty")),fontTblData));
                    table.addCell(cell);
                    /*cell.setPhrase(new Phrase(rs.getString("next_estimated_sale"),fontTblData));
                    table.addCell(cell);*/
                    cell.setPhrase(new Phrase(String.valueOf(rs.getInt("next_dispatch")),fontTblData));
                    table.addCell(cell);
                    //}
                }
                
                //doc.open();
                // adding table to document
                doc.add(table);
                progressbar.setValue(95);
            }
            writer.close();  
            
            if (Desktop.isDesktopSupported()) {
                File myFile = new File(DEST);
                Desktop.getDesktop().open(myFile);
            }
            progressbar.setValue(100);
        } catch (DocumentException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private void loadTable() throws SQLException{
        String sql = "SELECT `proforma_invoice`.`invoice_number`, `proforma_invoice`.`invoice_date`, `proforma_invoice`.`customer_name`, `proforma_invoice`.`discounted_amount`, `customer`.`customer_route` FROM `proforma_invoice` LEFT JOIN `customer` ON `proforma_invoice`.`customer_name`=`customer`.`customer_name`;";
        ResultSet rs =  con.query(sql);
        Object[] row;
        while(rs.next()){
            row = new Object[]{false,rs.getString("invoice_number"),rs.getString("invoice_date"),rs.getString("customer_route"),rs.getString("customer_name"),rs.getString("discounted_amount")};
            model.addRow(row);
        }
    }
    
    private void selectAll(){
        for (int i = 0; i < tbl_Invoice.getRowCount(); i++) {
            tbl_Invoice.setValueAt(true, i, 0);
        }
    }
    
    private void deselectAll(){
        for (int i = 0; i < tbl_Invoice.getRowCount(); i++) {
            tbl_Invoice.setValueAt(false, i, 0);
        }
    }
    
    public void reset() throws SQLException{
        model.setRowCount(0);
        loadTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JButton btn_deselectAll;
    private javax.swing.JButton btn_selectAll;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JProgressBar progressbar;
    private javax.swing.JTable tbl_Invoice;
    // End of variables declaration//GEN-END:variables
}
