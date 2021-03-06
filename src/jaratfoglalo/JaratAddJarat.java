/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaratfoglalo;

import static jaratfoglalo.JaratFoglalo.numberOfShips;
import static jaratfoglalo.JaratFoglalo.numberOfSystems;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bakcsányi Dominik
 */
public class JaratAddJarat extends javax.swing.JFrame {

    private String selectedFr = "";
    private String fromPort = "";
    private String toPort = "";
    private String selTo = "";
    private String selShip = "";
    private int fromD = 0;
    private int toD = 0;
    private int solD = 0;
    private int selFuel = 0;
    private int seco = 0;
    private int sebu = 0;
    private int sefi = 0;
    private String selectedDate = "";

    /**
     * Creates new form JaratAddJarat
     */
    public JaratAddJarat() {
        //Járatok kilistázása indításkor az elkészített funkciókkal
        initComponents();
        shutl();
        from();
        to();
        routeList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            String selectedShip = shipBox.getItemAt(shipBox.getSelectedIndex());

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM shuttles WHERE shipName LIKE '" + selectedShip + "'");

            while (rs.next()) {
                selShip = rs.getString("shipName");
                selFuel = rs.getInt("maxFuel");
                seco = rs.getInt("eSeats");
                sebu = rs.getInt("bSeats");
                sefi = rs.getInt("fSeats");
            }

            jLabel1.setText("Ship name: " + selShip);
            jLabel2.setText("Max fuel: " + String.valueOf(selFuel));
            jLabel3.setText("Economy Seats: " + String.valueOf(seco));
            jLabel4.setText("Business  Seats: " + String.valueOf(sebu));
            jLabel5.setText("First class Seats: " + String.valueOf(sefi));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeB.setOpaque(false);
        closeB.setContentAreaFilled(false);
        closeB.setBorderPainted(false);

        addSyst.setOpaque(false);
        addSyst.setContentAreaFilled(false);
        addSyst.setBorderPainted(false);

        manageUsers.setOpaque(false);
        manageUsers.setContentAreaFilled(false);
        manageUsers.setBorderPainted(false);

        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);

        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);

        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);

        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setBorderPainted(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        shipBox = new javax.swing.JComboBox<>();
        toBox = new javax.swing.JComboBox<>();
        fromBox = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        addSyst = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        manageUsers = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        closeB = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jPanel11 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Route ID", "Departure", "Destination", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setText("Max Fuel: ");

        jLabel3.setText("Economy Seats:");

        jLabel4.setText("Business Seats:");

        jLabel5.setText("First class Seats: ");

        shipBox.setBackground(new java.awt.Color(0, 0, 0));
        shipBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        shipBox.setForeground(new java.awt.Color(255, 255, 255));
        shipBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                shipBoxItemStateChanged(evt);
            }
        });
        shipBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shipBoxActionPerformed(evt);
            }
        });

        toBox.setBackground(new java.awt.Color(0, 0, 0));
        toBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        toBox.setForeground(new java.awt.Color(255, 255, 255));

        fromBox.setBackground(new java.awt.Color(0, 0, 0));
        fromBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fromBox.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Choosen ship details:");

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        addSyst.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addSyst.setForeground(new java.awt.Color(255, 255, 255));
        addSyst.setText("Add shuttle/system");
        addSyst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSystActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addSyst)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addSyst, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        manageUsers.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        manageUsers.setForeground(new java.awt.Color(255, 255, 255));
        manageUsers.setText("Manage Users");
        manageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manageUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jaratfoglalo/red.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(30, 30, 30))
        );

        jPanel8.setBackground(new java.awt.Color(204, 0, 0));
        jPanel8.setAlignmentX(0.0F);
        jPanel8.setAlignmentY(0.0F);

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));

        closeB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        closeB.setForeground(new java.awt.Color(255, 255, 255));
        closeB.setText("X");
        closeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closeB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closeB, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Route");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1)
        );

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Return");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 0, 23, 1));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jPanel11.setBackground(new java.awt.Color(255, 0, 0));

        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setText("Update launch Date");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(shipBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(toBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fromBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel1)))))
                .addContainerGap(143, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(shipBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(fromBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17)
                                        .addComponent(toBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       private int hour;
    private int minute;
    private int shipId;
    private int fromId;
    private int toId;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //Táblázat létrehozása (üres)
        jTable1.setModel(new DefaultTableModel(null, new String[]{"Route ID", "Departure", "Destination", "Date"}));
       //Táblázat feltöltéses
        routeList();

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");
            //Induli és cél pomntot kiveszi a kijelölt listából
            String selectedShip = shipBox.getItemAt(shipBox.getSelectedIndex());
            String selectedFrom = fromBox.getItemAt(fromBox.getSelectedIndex());
            String selectedTo = toBox.getItemAt(toBox.getSelectedIndex());
            //Átalakítja az aposzterófokat ha aposzrtrófos karakter van a rendszer nevében
            selectedFrom = selectedFrom.replaceAll("[']", "╗");
            selectedTo = selectedTo.replaceAll("[']", "╗");
            System.out.println("Selecteds ship is: " + selectedShip);
            System.out.println("Selecteds from is: " + selectedFrom);
            System.out.println("Selecteds to is: " + selectedTo);
            //Indulási dátum kijelölése
            selectedDate = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();
            //Dátum pontos elválasztását átalakítja kötöjelessé az sql működéséhez
            selectedDate = selectedDate.replaceAll("[.]", "-");
            //utolsó átalakított kötőjelet kitörli ami a pontoknál volt
            selectedDate = selectedDate.substring(0, selectedDate.length() - 1);
            System.out.println("Departure date: " + selectedDate);

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT systems.systemName , systems.starportName, systems.solDistance, shuttles.shipName, shuttles.maxFuel, shuttles.eSeats, shuttles.bSeats, shuttles.fSeats FROM shuttles , systems WHERE shuttles.shipName LIKE '" + selectedShip + "' AND systems.systemName LIKE '" + selectedFrom.replaceAll("[']", "╗") + "'");
            JOptionPane.showMessageDialog(this, "New route uploaded!");
            int segedc = 0;
            int currentUser;

            while (rs.next()) {

                selectedFr = rs.getString("systems.systemName");
                fromPort = rs.getString("systems.starportName");
                selShip = rs.getString("shuttles.shipName");
                selFuel = rs.getInt("shuttles.maxFuel");
                seco = rs.getInt("shuttles.eSeats");
                sebu = rs.getInt("shuttles.bSeats");
                sefi = rs.getInt("shuttles.fSeats");
                fromD = rs.getInt("systems.solDistance");
            }
            jTable1.setModel(new DefaultTableModel(null, new String[]{"Route ID", "Departure", "Destination", "Date"}));
            routeList();
            //Járat lista frisssítése
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //kijelölt járat adatok kiiratása
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            String selectedTo = toBox.getItemAt(toBox.getSelectedIndex());
            ResultSet rs = stm.executeQuery("SELECT `systemName` , `starportName` , `solDistance` FROM `systems` WHERE systemName LIKE '" + selectedTo.replaceAll("[']", "╗") + "'");
            int segedc = 0;
            int currentUser;

            while (rs.next()) {
                System.out.println(rs.getString("systemName") + " : " + rs.getString("starportName"));
                selTo = rs.getString("systemName");
                toPort = rs.getString("starportName");
                toD = rs.getInt("solDistance");

            }
            System.out.println("Selected items: " + selectedFr + " : " + fromPort + " : " + selTo + " : " + fromPort + " : " + selShip + " : " + selFuel
                    + " : " + seco + " : " + sebu + " : " + sefi);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        Két redszer közötti távolság kiszámítása a a naptól való távolságugtól
        Ha a cél közelebb van a anphoz mint az indulási pont akkor fordítva számolja,
        hogy ne minuszba mwnjwn a távolság és pontos távolságot kapjunk
        
        */
        if (toD > fromD) {
            solD = toD - fromD;
        } else {
            solD = fromD - toD;
        }
        //Távolsághoz szüksége üzemanyag ksizámolása
        System.out.println("Sol distance: " + solD);
        int segedsold = solD / 10;

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT `id` FROM `shuttles` WHERE shipName='" + selShip + "';");

            while (rs.next()) {
                shipId = rs.getInt("id");
            }
            System.out.println(selectedRouteId);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }//Hajó Id lekérése

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT `id` FROM `systems` WHERE systemName='" + selectedFr.replaceAll("[']", "╗") + "';");

            while (rs.next()) {
                fromId = rs.getInt("id");
            }
            System.out.println(selectedRouteId);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }//Kiindulási pont ID lekérdezés

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT `id` FROM `systems` WHERE systemName='" + selTo.replaceAll("[']", "╗") + "';");

            while (rs.next()) {
                toId = rs.getInt("id");
            }
            System.out.println(selectedRouteId);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }//Célpont pont ID lekérdezés

        try {
            hour = (Integer) jSpinner1.getValue();
            minute = (Integer) jSpinner2.getValue();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            if (selectedFr.matches(selTo)) {
                JOptionPane.showMessageDialog(this, "Departure and Arrival location can NOT be the same\n(Data not uploaded)");
            } else if (selFuel < segedsold) {
                JOptionPane.showMessageDialog(this, "Insuficient fuel for this distance\nPlease choose a ship with a fuel capacity above " + segedsold + " Tons!");

            } else {

                String sql = "INSERT INTO `routes` (`id`, `fromS`, `toS`, `ship`, `mfuel`, `date` ,`economy`, `business` , `first`, `distance`, `shuttle_id`, `from_id`, `to_id`) VALUES (NULL, '" + selectedFr.replaceAll("[']", "╗") + "', '" + selTo.replaceAll("[']", "╗") + "', '" + selShip + "', '" + selFuel + "', '" + selectedDate + " " + hour + ":" + minute + "', '" + seco + "', '" + sebu + "', '" + sefi + "', '" + solD + "', '" + shipId + "', '" + fromId + "','" + toId + "')";
                stm.executeUpdate(sql);

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void shipBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_shipBoxItemStateChanged
        try {
            //Beolvassa az éppen kijelölt játa adatait
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            String selectedShip = shipBox.getItemAt(shipBox.getSelectedIndex());

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM shuttles WHERE shipName LIKE '" + selectedShip + "'");

            while (rs.next()) {
                selShip = rs.getString("shipName");
                selFuel = rs.getInt("maxFuel");
                seco = rs.getInt("eSeats");
                sebu = rs.getInt("bSeats");
                sefi = rs.getInt("fSeats");
            }

            jLabel1.setText("Ship name: " + selShip);
            jLabel2.setText("Max fuel: " + String.valueOf(selFuel));
            jLabel3.setText("Economy Seats: " + String.valueOf(seco));
            jLabel4.setText("Business  Seats: " + String.valueOf(sebu));
            jLabel5.setText("First class Seats: " + String.valueOf(sefi));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_shipBoxItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JaratMegtekint jm = new JaratMegtekint();
        jm.setLocationRelativeTo(null);
        jm.show();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    private String selectedTicket;
    private int selectedRouteId;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int column = 0;
        int row = jTable1.getSelectedRow();
        selectedTicket = jTable1.getModel().getValueAt(row, column).toString();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT `id` FROM `routes` WHERE id='" + selectedTicket + "';");
            int dis = 0;

            while (rs.next()) {
                selectedRouteId = rs.getInt("id");
            }
            System.out.println(selectedRouteId);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Kijelölt járat törlése
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();

            stm.executeUpdate("DELETE FROM `routes` WHERE `id` = '" + selectedRouteId + "'");
            JOptionPane.showMessageDialog(this, "Route deleted successfully");
            jTable1.setModel(new DefaultTableModel(null, new String[]{"Route ID", "Departure", "Destination", "Date"}));
            routeList();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void shipBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shipBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shipBoxActionPerformed

    private void addSystActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSystActionPerformed
        JaratAddShuttle jaa = new JaratAddShuttle();
        jaa.setLocationRelativeTo(null);
        jaa.show();
        dispose();
    }//GEN-LAST:event_addSystActionPerformed

    private void manageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUsersActionPerformed
        JaratAddAdmin jaj = new JaratAddAdmin();
        jaj.setLocationRelativeTo(null);
        jaj.show();
        dispose();
    }//GEN-LAST:event_manageUsersActionPerformed

    private void closeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBActionPerformed
        dispose();
    }//GEN-LAST:event_closeBActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Átírja a kijelölt létező járat indulsi időpontját
        //Dátum átalakítása az SQL-nek érthető adatokká
        selectedDate = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();
        selectedDate = selectedDate.replaceAll("[.]", "-");
        selectedDate = selectedDate.substring(0, selectedDate.length() - 1);
        hour = (Integer) jSpinner1.getValue();
        minute = (Integer) jSpinner2.getValue();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();

            stm.executeUpdate("UPDATE `routes` SET `date` = '" + selectedDate + " " + hour + ":" + minute + "' WHERE `id` = '" + selectedRouteId + "'");
            JOptionPane.showMessageDialog(this, "Launch Date edited successfully");
            jTable1.setModel(new DefaultTableModel(null, new String[]{"Route ID", "Departure", "Destination", "Date"}));
            routeList();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();

            stm.executeUpdate("UPDATE `tickets` SET `date` = '" + selectedDate + " " + hour + ":" + minute + "' WHERE `route_id` = '" + selectedRouteId + "'");

            jTable1.setModel(new DefaultTableModel(null, new String[]{"Route ID", "Departure", "Destination", "Date"}));
            routeList();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(JaratAddJarat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JaratAddJarat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JaratAddJarat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JaratAddJarat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JaratAddJarat().setVisible(true);
            }
        });
    }

    private void shutl() {
        //Hajó lista feltöltése
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            String sql = "SELECT `shipname` FROM shuttles WHERE 1";
            ResultSet rs = stm.executeQuery(sql);
            String mezon = "shipname";
            String[] record = new String[numberOfShips];
            int index = 0;
            while (rs.next()) {
                record[index++] = rs.getString(mezon);

            }
            shipBox.setModel(new javax.swing.DefaultComboBoxModel<>(record));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void from() {
        //Kiindulsi pontok listájának feétöltése
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            String sql = "SELECT `systemName` FROM systems WHERE 1";
            ResultSet rs = stm.executeQuery(sql);
            String mezon = "systemName";
            String[] record = new String[numberOfSystems];
            int index = 0;
            while (rs.next()) {
                String sl = rs.getString("systemName");
                sl = sl.replaceAll("[╗]", "'");
                record[index++] = sl;

            }
            fromBox.setModel(new javax.swing.DefaultComboBoxModel<>(record));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void to() {
        //Célpont listájának feltöltése
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            String sql = "SELECT `systemName` FROM systems WHERE 1";
            ResultSet rs = stm.executeQuery(sql);
            String mezon = "systemName";
            String[] record = new String[numberOfSystems];
            int index = 0;
            while (rs.next()) {
                String sl = rs.getString("systemName");
                sl = sl.replaceAll("[╗]", "'");
                record[index++] = sl;

            }
            toBox.setModel(new javax.swing.DefaultComboBoxModel<>(record));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void routeList() {
        /*
        Táblázat feltöltése megfelelő adatokkal
        */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            String sql = "SELECT `id`,`fromS`,`toS`,`date` FROM `routes`";
            ResultSet rs = stm.executeQuery(sql);
            Object rowData[] = new Object[4];
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            String dep = "";
            String arr = "";
            while (rs.next()) {

                dep = rs.getString("fromS");
                dep = dep.replaceAll("[╗]", "'");

                arr = rs.getString("toS");
                arr = arr.replaceAll("[╗]", "'");

                rowData[0] = rs.getString("id");
                rowData[1] = dep;
                rowData[2] = arr;
                rowData[3] = rs.getString("date");

                model.addRow(rowData);

            }
            con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSyst;
    private javax.swing.JButton closeB;
    private javax.swing.JComboBox<String> fromBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton manageUsers;
    private javax.swing.JComboBox<String> shipBox;
    private javax.swing.JComboBox<String> toBox;
    // End of variables declaration//GEN-END:variables
}
