/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package superpos;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Win10
 */
public class product extends javax.swing.JFrame {

    public void productLogs2() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        String date = dtf.format(now);
        String time = dtf1.format(now2);
        String product = txtpro.getText();
        int productCode = Integer.parseInt(txtbarcode.getText());
        String status = "DELETED";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/superpos", "root", "your_password");
            pst = con1.prepareStatement("insert into product_logs (Product, PCode, date, time, Status) values(?,?,?,?,?)");
            //it gets the data in the boxes and puts it in the table (column, box data) 
            pst.setString(1, product);
            pst.setInt(2, productCode);
            pst.setString(3, date);
            pst.setString(4, time);
            pst.setString(5, status);
            pst.executeUpdate();
            table_update();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void productLogs() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        String date = dtf.format(now);
        String time = dtf1.format(now2);
        String product = txtpro.getText();
        int productCode = Integer.parseInt(txtbarcode.getText());
        String status = "ADDED";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/superpos", "root", "your_password");
            pst = con1.prepareStatement("insert into product_logs (Product, PCode, date, time, Status) values(?,?,?,?,?)");
            //it gets the data in the boxes and puts it in the table (column, box data) 
            pst.setString(1, product);
            pst.setInt(2, productCode);
            pst.setString(3, date);
            pst.setString(4, time);
            pst.setString(5, status);
            pst.executeUpdate();
            table_update();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void productBin() {
        // TODO add your handling code here:
        String product = txtpro.getText();
        String description = txtdesc.getText();
        String category = jLabel1.getText();
        String brand = jLabel2.getText();
        int costp = Integer.parseInt(txtcostp.getText());
        int retailp = Integer.parseInt(txtretailp.getText());
        int qty = Integer.parseInt(txtqty.getText());
        int barcode = Integer.parseInt(txtbarcode.getText());
        String status = txtstatus.getSelectedItem().toString();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/superpos", "root", "your_password");
            pst = con1.prepareStatement("insert into product_bin (product, description, cat_id, brand_id,  cost_price, retail_price, qty, barcode, status) values(?,?,?,?,?,?,?,?,?)");
            //it gets the data in the boxes and puts it in the table (column, box data) 
            pst.setString(1, product);
            pst.setString(2, description);
            pst.setString(3, category);
            pst.setString(4, brand);
            pst.setInt(5, costp);
            pst.setInt(6, retailp);
            pst.setInt(7, qty);
            pst.setInt(8, barcode);
            pst.setString(9, status);

            //Enter the data in the table
            pst.executeUpdate();
            table_update();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public product() {
        initComponents();
        // updates the table before starting
        table_update();
        s();
        ss();
        category();
        brand();
        TableColumnModel tcm = jTable1.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
        txtbarcode.setEditable(false);
        Random randNum = new Random();
        Set<Integer>set = new LinkedHashSet<Integer>();
        while (set.size() < 5) {
         set.add(randNum.nextInt(5)+1);
         
      }
        

    }
    int random_int;
    Connection con1;
    PreparedStatement pst;
    

    // this class loads the records from "category". 
    public class CategoryItem {

        int id;
        String name;

        public CategoryItem(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {

            return name;

        }
    }

    public class BrandItem {

        int id;
        String name;

        public BrandItem(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {

            return name;

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtpro = new javax.swing.JTextField();
        txtstatus = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdesc = new javax.swing.JTextArea();
        txtbrand = new javax.swing.JComboBox();
        txtbarcode = new javax.swing.JTextField();
        txtretailp = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        txtcat = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txtcostp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(24, 52, 52));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 52, 52), 13));
        jPanel2.setPreferredSize(new java.awt.Dimension(1539, 867));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 36), new java.awt.Color(24, 52, 52))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(102, 0, 153));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(24, 52, 52));
        jLabel9.setText("Description");

        txtpro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 52, 52), 3));

        txtstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "In Stocks", "Out of Stocks" }));
        txtstatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 52, 52), 3));

        jButton1.setBackground(new java.awt.Color(3, 18, 21));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.setToolTipText("");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(3, 18, 21));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.setToolTipText("");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(3, 18, 21));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.setToolTipText("");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(24, 52, 52));
        jLabel11.setText("Status");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(24, 52, 52));
        jLabel10.setText("Product Code");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(24, 52, 52));
        jLabel12.setText("Brand");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(24, 52, 52));
        jLabel13.setText("Quantity");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(24, 52, 52));
        jLabel14.setText("Product");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(24, 52, 52));
        jLabel15.setText("Cost Price");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(24, 52, 52));
        jLabel16.setText("Retail Price");

        txtdesc.setColumns(20);
        txtdesc.setRows(5);
        txtdesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 52, 52), 3));
        jScrollPane2.setViewportView(txtdesc);

        txtbrand.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        txtbrand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 52, 52), 3));

        txtbarcode.setEditable(false);
        txtbarcode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtbarcode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 52, 52), 3));

        txtretailp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 52, 52), 3));
        txtretailp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtretailpKeyTyped(evt);
            }
        });

        txtqty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 52, 52), 3));
        txtqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtqtyKeyTyped(evt);
            }
        });

        txtcat.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(24, 52, 52)));
        txtcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcatActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(24, 52, 52));
        jLabel17.setText("Category");

        jButton4.setBackground(new java.awt.Color(3, 18, 21));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Generate");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtcostp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 52, 52), 3));
        txtcostp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcostpKeyTyped(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Product", "Description", "Category", "Brand", "Cost price", "Retail price", "Qty", "Product Code", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpro)
                    .addComponent(txtbrand, 0, 355, Short.MAX_VALUE)
                    .addComponent(txtcostp)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcat, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel13)))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(31, 31, 31)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(txtretailp)
                    .addComponent(txtqty)
                    .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtbarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addGap(160, 160, 160))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtpro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtretailp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtbrand, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtcostp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtbarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel9.setBackground(new java.awt.Color(24, 52, 52));
        jPanel9.setForeground(new java.awt.Color(0, 153, 204));
        jPanel9.setPreferredSize(new java.awt.Dimension(252, 492));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 56)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Inventory Management System");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(24, 52, 52));
        jPanel4.setForeground(new java.awt.Color(0, 153, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(252, 492));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/superpos/DicePics/pngegg.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jButton10.setText("CATEGORY");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jButton11.setText("POS");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jButton12.setText("PRODUCT");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jButton13.setText("USER");
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jButton14.setText("BRAND");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jButton15.setText("RETRIEVE");
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addGap(18, 18, 18)
                .addComponent(jButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 663, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/superpos/DicePics/Logo1.png"))); // NOI18N
        jLabel18.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1543, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // method let us display Items in the category Item box. 
    private void s(){
        try {
            PreparedStatement pst1 = con1.prepareStatement("update product set status = 'Out of Stocks' where qty = 0");
            pst1.execute();
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void ss(){
        try {
            PreparedStatement pst1 = con1.prepareStatement("update product set status = 'In Stocks' where qty != 0");
            pst1.execute();
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void category() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/superpos", "root", "your_password");
            pst = con1.prepareStatement("select * from category where status = 'In Stocks'");
            ResultSet rs = pst.executeQuery();
            //Remove all Items in the Item Box, if there are any
            txtcat.removeAllItems();

            //This is the loop that adds data from the class category to the table. 
            while (rs.next()) {
                //(ID, item)
                txtcat.addItem(new CategoryItem(rs.getInt(1), rs.getString(2)));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void brand() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/superpos", "root", "your_password");
            pst = con1.prepareStatement("select * from brand where status = 'In Stocks'");
            ResultSet rs = pst.executeQuery();
            //Remove all Items in the Item Box, if there are any
            txtbrand.removeAllItems();

            //This is the loop that adds data from the class category to the table. 
            while (rs.next()) {
                //(ID, item)
                txtbrand.addItem(new BrandItem(rs.getInt(1), rs.getString(2)));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void table_update() {
        try {
            int c;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/superpos", "root", "your_password");
                //"select p.id, p.product,p.description, c.category, b.brand, p.cost_price, p.retail_price, p.qty, p.bardoce, p.status from product p, category c, brand b where p.cat_id = c.id and p.brand_id = b.id"

                //this selects everything in the table
                //Merges three tables: brand, category, product
                pst = con1.prepareStatement("select * from product");
                
                //This counts the rows
                ResultSet rs = pst.executeQuery();
                

                //Query data about the table
                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();

                //contains all the data in the table
                DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
                d.setRowCount(0);

                while (rs.next()) {
                    // A vector is like a more flexible array. It can contain int, string, etc...
                    Vector v2 = new Vector();

                    for (int i = 1; i <= c; i++) {
                        //this gets the data in the rows and put it in the table
                        v2.add(rs.getString("id"));
                        v2.add(rs.getString("product"));
                        v2.add(rs.getString("description"));
                        v2.add(rs.getString("cat_id"));
                        v2.add(rs.getString("brand_id"));
                        v2.add(rs.getString("cost_price"));
                        v2.add(rs.getString("retail_price"));
                        v2.add(rs.getString("qty"));
                        v2.add(rs.getString("barcode"));
                        v2.add(rs.getString("status"));

                        //t (product, description, cat_id, brand_id, cost_price, retail_price, qty, barcode, status) values(?,?,?,?,?,?,?,?,?)"); 
                    }

//                      Enumeration v = v2.elements(); 
//                      while(v.hasMoreElements()) {
//                      System.out.println(v.nextElement());
//                      }
                    d.addRow(v2);

                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String product = txtpro.getText();
            String description = txtdesc.getText();
            String category = txtcat.getSelectedItem().toString();
            String brand = txtbrand.getSelectedItem().toString();
            int costp = Integer.parseInt(txtcostp.getText());
            int retailp = Integer.parseInt(txtretailp.getText());
            int qty = Integer.parseInt(txtqty.getText());
            int barcode = Integer.parseInt(txtbarcode.getText());
            String status = txtstatus.getSelectedItem().toString();
            if (txtpro.getText().trim().isEmpty() || txtdesc.getText().trim().isEmpty() || txtcostp.getText().trim().isEmpty() || txtretailp.getText().trim().isEmpty()
                    || txtqty.getText().trim().isEmpty() || txtbarcode.getText().trim().isEmpty() || txtcat.getSelectedItem().toString().trim().isEmpty() || txtbrand.getSelectedItem().toString().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "One of the boxes is empty!");
            } else {
                try {
                    productLogs();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/superpos", "root", "your_password");
                    pst = con1.prepareStatement("insert into product (product, description, cat_id, brand_id, cost_price, retail_price, qty, barcode, status) values(?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, product);
                    pst.setString(2, description);
                    pst.setString(3, category);
                    pst.setString(4, brand);
                    pst.setInt(5, costp);
                    pst.setInt(6, retailp);
                    pst.setInt(7, qty);
                    pst.setInt(8, barcode);
                    pst.setString(9, status);

                    //Enter the data in the table
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Product Added");
                    table_update();
                   

                    //this empties the textbox
                    txtpro.setText("");
                    txtdesc.setText("");
                    txtcostp.setText("");
                    txtretailp.setText("");
                    txtqty.setText("");
                    txtbarcode.setText("");

                    //this resets the combo box
                    txtcat.setSelectedIndex(-1);
                    txtbrand.setSelectedIndex(-1);
                    txtstatus.setSelectedIndex(-1);
                    //it makes the cursor auto select the text box
                    txtpro.requestFocus();
                } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, "You already have this Product!");
                    JOptionPane.showMessageDialog(null, "Generate a New Product Code and Change Product Name!");
                    Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (NumberFormatException | NullPointerException  ex) {
            JOptionPane.showMessageDialog(this, "One of the boxes is empty!");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        //contains all the data in the table
        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
        //Query the selected row
        int selectIndex = jTable1.getSelectedRow();

        //sets the text of category and status to (row, column_position)
        txtpro.setText(d1.getValueAt(selectIndex, 1).toString());
        txtdesc.setText(d1.getValueAt(selectIndex, 2).toString());
        jLabel1.setText(d1.getValueAt(selectIndex, 3).toString());
        jLabel2.setText(d1.getValueAt(selectIndex, 4).toString());
        jLabel3.setText(d1.getValueAt(selectIndex, 3).toString());
        jLabel4.setText(d1.getValueAt(selectIndex, 4).toString());
        txtcostp.setText(d1.getValueAt(selectIndex, 5).toString());
        txtretailp.setText(d1.getValueAt(selectIndex, 6).toString());
         txtbarcode.setText(d1.getValueAt(selectIndex, 8).toString());
        txtqty.setText(d1.getValueAt(selectIndex, 7).toString());
        txtstatus.setSelectedItem(d1.getValueAt(selectIndex, 9).toString());
       
        

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
            //Query the selected row
            int selectIndex = jTable1.getSelectedRow();
            //this contains the table id
            int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

            String product = txtpro.getText();
            String description = txtdesc.getText();
            String category = jLabel3.getText();
            String brand = jLabel4.getText();
            int costp = Integer.parseInt(txtcostp.getText());
            int retailp = Integer.parseInt(txtretailp.getText());
            int qty = Integer.parseInt(txtqty.getText());
            int barcode = Integer.parseInt(txtbarcode.getText());
            String status = txtstatus.getSelectedItem().toString();
            if (txtpro.getText().trim().isEmpty() || txtdesc.getText().trim().isEmpty() || txtcostp.getText().trim().isEmpty() || txtretailp.getText().trim().isEmpty()
                    || txtqty.getText().trim().isEmpty() || txtbarcode.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "One of the boxes is empty!");
            } else {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/superpos", "root", "your_password");
                    // ( category, status, id) Updates the table instead of creating a new one. 
                    pst = con1.prepareStatement("update product set product = ?, description = ? , cat_id = ? , brand_id = ? , cost_price = ? , retail_price = ? , qty = ? , barcode = ? , status = ?  where id = ?");
                    // product, description, cat_id, brand_id, cost_price, retail_price, qty, barcode, status)

                    //it gets the data in the boxes and puts it in the table (column, box data) 
                    //these codes contains the data according to the "pst" order. 
                    pst.setString(1, product);
                    pst.setString(2, description);
                    pst.setString(3, category);
                    pst.setString(4, brand);
                    pst.setInt(5, costp);
                    pst.setInt(6, retailp);
                    pst.setInt(7, qty);
                    pst.setInt(8, barcode);
                    pst.setString(9, status);
                    pst.setInt(10, id);

                    //Enter the data in the table
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Product Updated!");
                    table_update();
                    s();
                    ss();

                    txtpro.setText("");
                    txtdesc.setText("");
                    txtcostp.setText("");
                    txtretailp.setText("");
                    txtqty.setText("");
                    txtbarcode.setText("");

                    //this resets the combo box
                    txtcat.setSelectedIndex(-1);
                    txtbrand.setSelectedIndex(-1);
                    txtstatus.setSelectedIndex(-1);
                    //it makes the cursor auto select the text box
                    txtpro.requestFocus();
                    product p = new product();
        dispose();
        p.setVisible(true);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Select Row to Update");
        }
        
        


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
            //Query the selected row
            int selectIndex = jTable1.getSelectedRow();
            //this contains the table id
            int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the Reocrd? ", "Warning", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    productLogs2();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/superpos", "root", "your_password");
                    productBin();
                    pst = con1.prepareStatement("delete from product where id = ?");

                    pst.setInt(1, id);
                    JOptionPane.showMessageDialog(null, "Product Deleted");
                    pst.executeUpdate();
                    table_update();

                    txtpro.setText("");
                    txtdesc.setText("");
                    txtcostp.setText("");
                    txtretailp.setText("");
                    txtqty.setText("");
                    txtbarcode.setText("");

                    //this resets the combo box
                    txtcat.setSelectedIndex(-1);
                    txtstatus.setSelectedIndex(-1);
                    //it makes the cursor auto select the text box
                    txtpro.requestFocus();

                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Select a Row to Delete");
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        login log = new login();
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            log.setVisible(true);
            dispose();
        } else {

        }
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        category c = new category();
        dispose();
        c.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        pos c = new pos();
        dispose();
        c.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        JOptionPane.showMessageDialog(this, "You're already in PRODUCT window!");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        user b = new user();
        dispose();

        b.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        brand b = new brand();
        dispose();

        b.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        random_int = (int) Math.floor(Math.random() * (5000));
        txtbarcode.setText(Integer.toString(random_int));

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        retrieval p = new retrieval();
        dispose();

        p.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void txtcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcatActionPerformed

    private void txtcostpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcostpKeyTyped
       char c = evt.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
      }
    }//GEN-LAST:event_txtcostpKeyTyped

    private void txtretailpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtretailpKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
      }
    }//GEN-LAST:event_txtretailpKeyTyped

    private void txtqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqtyKeyTyped
        char c = evt.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
      }
    }//GEN-LAST:event_txtqtyKeyTyped

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
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtbarcode;
    private javax.swing.JComboBox txtbrand;
    private javax.swing.JComboBox txtcat;
    private javax.swing.JTextField txtcostp;
    private javax.swing.JTextArea txtdesc;
    private javax.swing.JTextField txtpro;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtretailp;
    private javax.swing.JComboBox<String> txtstatus;
    // End of variables declaration//GEN-END:variables
}
