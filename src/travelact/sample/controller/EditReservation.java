
package travelact.sample.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import travelact.sample.model.*;

public class EditReservation extends javax.swing.JFrame {
    
     String filePath = "C:\\Users\\allyz\\OneDrive\\Documents\\NetBeansProjects\\Travelact Sample\\src\\InformationStorage\\book.txt";
        File file = new File (filePath);
    
    public void ShowDataFunction(){
        String titleLine = "Customer Name,Hotel Name, Arrival Date, Arrival Time,Departure Date, Departure Time, No. of Adults, No.of Kids,Rooms, Additional Request";
       
        
        try{
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                DefaultTableModel model = (DefaultTableModel) dataTable2.getModel();
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();
                String[] splitTitle = titleLine.trim().split(",");
                model.setColumnIdentifiers(splitTitle);
                
                Object[] object = reader.lines().toArray();
                
                for(int i =0; i < object.length; i++){
                    String[] dataSplit = object[i].toString().trim().split(",");
                    model.addRow(dataSplit);
                }
            }
        } catch(IOException ex){
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    
    
    public static void updateData(JTable dataTable2){
        int update = dataTable2.getSelectedRow();
        if(update >=0){
            try {
                File file1 = new File("C:\\Users\\allyz\\OneDrive\\Documents\\NetBeansProjects\\Travelact Sample\\src\\InformationStorage\\book.txt");
                File file2 = new File("C:\\Users\\allyz\\OneDrive\\Documents\\NetBeansProjects\\Travelact Sample\\src\\InformationStorage\\booktemp.txt");
                
                FileWriter fw = new FileWriter(file2.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                
                for(int i1 = 0; i1 < dataTable2.getRowCount(); i1++){
                    for(int j = 0; j <dataTable2.getColumnCount();j++){
                        bw.write(dataTable2.getModel().getValueAt(i1,j)+"");
                    }
                    bw.write(""+System.lineSeparator());
                }
                
                bw.close();
                fw.close();
                file1.delete();
                
                boolean ok = file2.renameTo(file1);
                JOptionPane.showMessageDialog(null,"Record has been Updated","Message!",JOptionPane.INFORMATION_MESSAGE);
                
            } catch(IOException ex){
                JOptionPane.showMessageDialog(null,"Please select a Record First!","Alert!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
 
   
    public EditReservation() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        requestTF = new javax.swing.JTextField();
        noAdults = new javax.swing.JComboBox<>();
        noKids = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jCmb_Hotels = new javax.swing.JComboBox<>();
        JcmbRooms = new javax.swing.JComboBox<>();
        arrivTime = new javax.swing.JComboBox<>();
        depTime = new javax.swing.JComboBox<>();
        nameTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Submit1 = new javax.swing.JButton();
        arrivDate = new com.toedter.calendar.JDateChooser();
        depDate = new com.toedter.calendar.JDateChooser();
        Show = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        dataTable2 = new javax.swing.JTable();

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dataTable.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(dataTable);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(7, 41, 62));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/logo-1.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Inter Medium", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Come and stay with us to feel even better than at home.");

        jLabel3.setFont(new java.awt.Font("Inter SemiBold", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(72, 181, 255));
        jLabel3.setText("< BACK");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        requestTF.setBackground(new java.awt.Color(223, 246, 255));
        requestTF.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        requestTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        requestTF.setToolTipText("");
        requestTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                requestTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                requestTFFocusLost(evt);
            }
        });

        noAdults.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " " }));

        noKids.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM ", "PM" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM ", "PM" }));

        jCmb_Hotels.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eurotel", "Crimson Hotel", "Dream Hotel", "Okada Manila", " " }));
        jCmb_Hotels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmb_HotelsActionPerformed(evt);
            }
        });

        JcmbRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcmbRoomsActionPerformed(evt);
            }
        });

        arrivTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1:00", "1:15", "1:30", "1:45", "2:00", "2:15", "2:30", "2:45", "3:00", "3:15", "3:30", "3:45", "4:00", "4:15", "4:30", "4:45", "5:00", "5:15", "5:30", "5:45", "6:00", "6:15", "6:30", "6:45", "7:00", "7:15", "7:30", "7:45", "8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45" }));

        depTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1:00", "1:15", "1:30", "1:45", "2:00", "2:15", "2:30", "2:45", "3:00", "3:15", "3:30", "3:45", "4:00", "4:15", "4:30", "4:45", "5:00", "5:15", "5:30", "5:45", "6:00", "6:15", "6:30", "6:45", "7:00", "7:15", "7:30", "7:45", "8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45" }));

        jLabel1.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer Name:");

        jLabel5.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hotel Names:");

        jLabel6.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Arrival Date and Time");

        jLabel7.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Departure Date and Time");

        jLabel8.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("No. of Adults");

        jLabel9.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("No. of Kids");

        jLabel10.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Rooms");

        jLabel11.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Additional Request");

        Submit1.setBackground(new java.awt.Color(72, 181, 255));
        Submit1.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        Submit1.setText("Update Reservation");
        Submit1.setBorderPainted(false);
        Submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submit1ActionPerformed(evt);
            }
        });

        Show.setBackground(new java.awt.Color(72, 181, 255));
        Show.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        Show.setText("View Entries");
        Show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShowMouseClicked(evt);
            }
        });
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowActionPerformed(evt);
            }
        });

        dataTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dataTable2.setSurrendersFocusOnKeystroke(true);
        dataTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dataTable2MousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(dataTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(562, 562, 562))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(614, 614, 614))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(arrivDate, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(depDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(depTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(arrivTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(requestTF, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(noAdults, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(noKids, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(JcmbRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jCmb_Hotels, javax.swing.GroupLayout.Alignment.TRAILING, 0, 345, Short.MAX_VALUE)
                                .addComponent(nameTF, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Show, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(Submit1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCmb_Hotels, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arrivDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(arrivTime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(depTime, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(depDate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noAdults, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noKids, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JcmbRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(requestTF, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(Show, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(Submit1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void requestTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_requestTFFocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_requestTFFocusLost

    private void requestTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_requestTFFocusGained
        // TODO add your handling code here:
      
    }//GEN-LAST:event_requestTFFocusGained

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new Menu().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jCmb_HotelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmb_HotelsActionPerformed
        // TODO add your handling code here:
        if(jCmb_Hotels.getSelectedItem().equals("Eurotel")){
           
           JcmbRooms.removeAllItems();
           JcmbRooms.setSelectedItem(null);
           JcmbRooms.addItem("Euro Suite 2 Room(P3290/night)");
           JcmbRooms.addItem("Euro Suite Room(P2490/night)");
           JcmbRooms.addItem("Standard Twin Room(P2905/night)");
           JcmbRooms.addItem("Standard Room(P2905/night)");
           JcmbRooms.addItem("Studio Room(P2715/night)");
           JcmbRooms.addItem("Family Room(P2715/night)");
           JcmbRooms.addItem("Euro Suite 2 Room(P3490/night)");
           JcmbRooms.addItem("Euro Suite Room(P2715/night)");
        }
        else if(jCmb_Hotels.getSelectedItem().equals("Crimson Hotel")){
           
           JcmbRooms.removeAllItems();
           JcmbRooms.setSelectedItem(null);
           JcmbRooms.addItem("Presidential Suite(P3290/night)");
           JcmbRooms.addItem("Deluxe Room(P2490/night)");
           JcmbRooms.addItem("Premiere Club(P2905/night)");
        }
        else if(jCmb_Hotels.getSelectedItem().equals("Dream Hotel")){
           
           JcmbRooms.removeAllItems();
           JcmbRooms.setSelectedItem(null);
           JcmbRooms.addItem("Family Room(P3290/night)");
           JcmbRooms.addItem("Triple Room(P2550/night)");
           JcmbRooms.addItem("Superior Queen Room(P2905/night)");
        }
        else if(jCmb_Hotels.getSelectedItem().equals("Okada Manila")){
           
           JcmbRooms.removeAllItems();
           JcmbRooms.setSelectedItem(null);
           JcmbRooms.addItem("Grand Deluxe Rooms(P3290/night)");
           JcmbRooms.addItem("Premium Suites(P2490/night)");
           JcmbRooms.addItem("Junior Suites(P2905/night)");
        }
       
    }//GEN-LAST:event_jCmb_HotelsActionPerformed

    private void Submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submit1ActionPerformed
        // TODO add your handling code here:
        updateData();
      
    }//GEN-LAST:event_Submit1ActionPerformed

    private void JcmbRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcmbRoomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcmbRoomsActionPerformed

    private void ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowActionPerformed
        ShowDataFunction();
    }//GEN-LAST:event_ShowActionPerformed

    private void ShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowMouseClicked
        // TODO add your handling code here:
        ShowDataFunction();
    }//GEN-LAST:event_ShowMouseClicked

    private void dataTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTable2MousePressed
        // TODO add your handling code here:
        /* int i = dataTable2.getSelectedRow();
         
         String name = (dataTable2.getModel().getValueAt(1, 0).toString());
         String hotel = (dataTable2.getModel().getValueAt(1, 1).toString());
         String arDate = (dataTable2.getModel().getValueAt(1, 2).toString());
         String arTime = (dataTable2.getModel().getValueAt(1,3).toString());
         String depDate = (dataTable2.getModel().getValueAt(1,4).toString());
         String departTime = (dataTable2.getModel().getValueAt(1,5).toString());
         String adults = (dataTable2.getModel().getValueAt(1,6).toString());
         String kids = (dataTable2.getModel().getValueAt(1,7).toString());
         String Rooms = (dataTable2.getModel().getValueAt(1, 8).toString());
         String request = (dataTable2.getModel().getValueAt(1, 9).toString());
         
         nameTF.setText(name);
         jCmb_Hotels.setSelectedItem(hotel);
         arrivDate.setDate(null);
         arrivTime.setSelectedItem(arTime);
         depTime.setSelectedItem(departTime);
         noAdults.setSelectedItem(adults);
         noKids.setSelectedItem(kids);
         JcmbRooms.setSelectedItem(Rooms);
         requestTF.setText(request);*/
    }//GEN-LAST:event_dataTable2MousePressed

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
            java.util.logging.Logger.getLogger(EditReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</edtor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</edtor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
       
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcmbRooms;
    private javax.swing.JButton Show;
    private javax.swing.JButton Submit1;
    private com.toedter.calendar.JDateChooser arrivDate;
    private javax.swing.JComboBox<String> arrivTime;
    private javax.swing.JTable dataTable;
    private javax.swing.JTable dataTable2;
    private com.toedter.calendar.JDateChooser depDate;
    private javax.swing.JComboBox<String> depTime;
    private javax.swing.JComboBox<String> jCmb_Hotels;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nameTF;
    private javax.swing.JComboBox<String> noAdults;
    private javax.swing.JComboBox<String> noKids;
    private javax.swing.JTextField requestTF;
    // End of variables declaration//GEN-END:variables

    private void updateData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
