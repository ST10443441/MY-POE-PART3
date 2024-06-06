/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectp3;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Cameron Griffin ST10443441
 */
public class EasyKanBan extends javax.swing.JFrame {

    /**
     * Creates new form EasyKanBan
     */
    public EasyKanBan() {
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
        tblOutput = new javax.swing.JTable();
        pnlHeader = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        btnOptions = new javax.swing.JButton();
        JScrollPane1 = new javax.swing.JScrollPane();
        tpOutput = new javax.swing.JTextPane();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblOutput.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Status", "Developer", "Task Num ", "Task Name", "Description", "Task ID ", "Duration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOutput.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblOutput);
        if (tblOutput.getColumnModel().getColumnCount() > 0) {
            tblOutput.getColumnModel().getColumn(0).setMinWidth(5);
            tblOutput.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblOutput.getColumnModel().getColumn(0).setMaxWidth(40);
            tblOutput.getColumnModel().getColumn(1).setMinWidth(30);
            tblOutput.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblOutput.getColumnModel().getColumn(1).setMaxWidth(100);
            tblOutput.getColumnModel().getColumn(2).setMinWidth(60);
            tblOutput.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblOutput.getColumnModel().getColumn(2).setMaxWidth(60);
            tblOutput.getColumnModel().getColumn(3).setMinWidth(50);
            tblOutput.getColumnModel().getColumn(3).setMaxWidth(100);
            tblOutput.getColumnModel().getColumn(5).setMaxWidth(60);
            tblOutput.getColumnModel().getColumn(6).setMaxWidth(60);
        }

        pnlHeader.setName("pnlHeader"); // NOI18N

        lblHeader.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lblHeader.setText("Welcome to EasyKanBan");
        lblHeader.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
        );

        btnOptions.setText("Options");
        btnOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionsActionPerformed(evt);
            }
        });

        JScrollPane1.setViewportView(tpOutput);

        btnLogOut.setText("Logout");
        btnLogOut.setDoubleBuffered(true);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(JScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOptions)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLogOut)
                            .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Declare Variables
    ProjectP3 obj = new ProjectP3();
    
    int last = 0;
    //Options Button
    private void btnOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionsActionPerformed
        int choice;
        
        
        //Runs Till Users Selects Quit
        do
        {
        //Asks for users choice 
        choice = obj.options();
        //Sends Choice to Option Act to complete desired action
        obj.OptionAct(choice);
        }while (choice != 2);        
    }//GEN-LAST:event_btnOptionsActionPerformed
    //LogOut Button
    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        obj.changeForms(1);
    }//GEN-LAST:event_btnLogOutActionPerformed
    //Allows Main Class to Get the last ID of the Tasks
    public int getLastID()
    {
        return last;
    }
    
    //Allows Main class to set the TextPane Text
    public void setOutput(String out)
    {
        tpOutput.setText(out);        
    }
    //Add Tasks to Table
    public void setTable(String tName,String tDes,String devDetails,String tID,String tStatus,int tNum,int duration)
    {
        //Add Values to the Table
        String[] row = {tStatus,devDetails,String.valueOf(tNum),tName,tDes,tID,String.valueOf(duration)};   //Serplat (2024)
        DefaultTableModel model = (DefaultTableModel) tblOutput.getModel(); 
        model.addRow(row);
        last = tNum;
    }
    //Reset Table For Reports
    public void resetTable(int size)
    {
        //Get Model of table to manipulate Rows
        DefaultTableModel model = (DefaultTableModel) tblOutput.getModel();
        //Get row count 
        int rowCount = model.getRowCount();
        //Remove rows
        for (int i = rowCount - 1; i >= 0; i--) 
        {
            model.removeRow(i);
        }
         
    }
    
    
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
            java.util.logging.Logger.getLogger(EasyKanBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EasyKanBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EasyKanBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EasyKanBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EasyKanBan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane1;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnOptions;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JTable tblOutput;
    private javax.swing.JTextPane tpOutput;
    // End of variables declaration//GEN-END:variables
}
