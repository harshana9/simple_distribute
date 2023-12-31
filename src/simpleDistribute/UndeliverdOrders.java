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
import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UndeliverdOrders extends javax.swing.JFrame {
    
    private final DbCon con = new DbCon();
    private final Date date = new Date();

    public UndeliverdOrders() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        reset();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Day Report");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Undeliverd Orders Report");

        btnGenerateReport.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnGenerateReport.setText("Generate PDF");
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(2);
        jTextArea1.setText("This Report Gives List of all the orders which\nare not invoiced.\nThey can be either on stock or vehical stock.");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progressbar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btnGenerateReport)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerateReport)
                .addGap(91, 91, 91)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed
        try {
            pdf();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(UndeliverdOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerateReportActionPerformed

    public static void main(String args[]) {
        try {
            FlatDarkLaf.setup();
        } catch (Exception e) {
            System.out.println("Theme Setup Error: " + e);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UndeliverdOrders().setVisible(true);
            }
        });
    }
    
    public void pdf() throws SQLException, IOException{
        try {
            progressbar.setValue(5);
            
            progressbar.setValue(10);
            long msec = date.getTime();
            String fileName = "Undeliverd_Orders "+msec;
            String DEST = "./Reports/UndeliverdOrders/"+fileName+".pdf";
            PdfWriter writer;
            try (Document doc = new Document()) {
                writer = PdfWriter.getInstance(doc, new FileOutputStream(DEST));
                //setting font family, color
                Font fontTopic = new Font(Font.HELVETICA, 13, Font.BOLDITALIC, Color.RED);
                Font fontTblHead = new Font(Font.HELVETICA, 10, Font.BOLDITALIC);
                Font fontTblData = new Font(Font.HELVETICA, 9, Font.NORMAL);
                doc.open();
                //Add Content
                Paragraph topic = new Paragraph("Undeliverd Orders Report", fontTopic);
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
                PdfPTable table = new PdfPTable(5);
                table.setWidthPercentage(80);
                // setting column widths
                //table.setWidths(new float[] {0.3f, 0.1f, 0.1f, 0.1f, 0.05f, 0.1f, 0.1f, 0.1f, 0.05f,0.1f});
                //table.setWidths(new float[] {3, 1, 1, 2, 1, 1, 2, 1});
                table.setWidths(new float[] {1, 1, 1, 1, 1});
                PdfPCell cell = new PdfPCell();
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                
                // table headers
                cell.setPhrase(new Phrase("Order #", fontTblHead));
                table.addCell(cell);
                cell.setPhrase(new Phrase("Order Date", fontTblHead));
                table.addCell(cell);
                cell.setPhrase(new Phrase("Customer", fontTblHead));
                table.addCell(cell);
                cell.setPhrase(new Phrase("Route", fontTblHead));
                table.addCell(cell);
                cell.setPhrase(new Phrase("Sale", fontTblHead));
                table.addCell(cell);
                
                progressbar.setValue(20);
                con.connect();
                progressbar.setValue(22);
                String sql = "SELECT `proforma_invoice`.`invoice_number`, `proforma_invoice`.`invoice_date`, `proforma_invoice`.`customer_name`, `proforma_invoice`.`discounted_amount`, `customer`.`customer_route` FROM `proforma_invoice` LEFT JOIN `customer` ON `proforma_invoice`.`customer_name`=`customer`.`customer_name`;";
                ResultSet rs =  con.query(sql);
                progressbar.setValue(50);
                while(rs.next()){
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell.setPhrase(new Phrase(rs.getString("invoice_number"),fontTblData));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(rs.getString("invoice_date"),fontTblData));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(rs.getString("customer_name"),fontTblData));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(rs.getString("customer_route"),fontTblData));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(rs.getString("discounted_amount"),fontTblData));
                    table.addCell(cell);
                }
                con.close();
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
    
    public void reset(){
        /*jdate_NextDistributionFirstDate.setDate(date);
        jdate_NextDistributionLastDate.setDate(date);
        jdate_LastDistributionFirstDate.setDate(date);
        jdate_LastDistributionLastDate.setDate(date);*/
        /*txt_firstOrderNo.setText("");
        txt_lastOrderNo.setText("");*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JProgressBar progressbar;
    // End of variables declaration//GEN-END:variables
}
