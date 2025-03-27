package com.example.view.login;

import com.example.controllers.EmployeeController;
import com.example.models.Employee;
// import com.example.view.room.Calculator_frame;
import com.example.view.default_main.MainDefault;

/**
 *
 * @author NGUYEN DUC HIEU
 */
public class Login_Form extends javax.swing.JFrame {

        /**
         * Creates new form Login_Form
         */
        public Login_Form() {
                initComponents();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                jLabel7 = new javax.swing.JLabel();
                jPanel3 = new javax.swing.JPanel();
                username = new javax.swing.JTextField();
                pass = new javax.swing.JPasswordField();
                jSeparator1 = new javax.swing.JSeparator();
                jSeparator2 = new javax.swing.JSeparator();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jPanel4 = new javax.swing.JPanel();
                buttonLogin = new javax.swing.JButton();
                jPanel5 = new javax.swing.JPanel();
                buttonSignUp = new javax.swing.JButton();
                jLabel6 = new javax.swing.JLabel();
                buttonForgotPassword = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setUndecorated(true);

                jPanel2.setBackground(new java.awt.Color(37, 150, 190));

                jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/images/anh3.jpg"))); // NOI18N

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                jPanel3.setBackground(new java.awt.Color(171, 219, 227));

                username.setBackground(new java.awt.Color(171, 219, 227));
                username.setForeground(new java.awt.Color(0, 102, 153));
                username.setBorder(null);
                username.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                usernameFocusGained(evt);
                        }
                });
                username.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                usernameActionPerformed(evt);
                        }
                });

                pass.setBackground(new java.awt.Color(171, 219, 227));
                pass.setForeground(new java.awt.Color(0, 102, 153));
                pass.setBorder(null);
                pass.setCaretColor(new java.awt.Color(0, 102, 153));
                pass.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                passFocusGained(evt);
                        }
                });

                jSeparator1.setForeground(new java.awt.Color(0, 102, 153));

                jSeparator2.setForeground(new java.awt.Color(0, 102, 153));

                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/images/user.png"))); // NOI18N

                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/images/padlock.png"))); // NOI18N

                jPanel4.setBackground(new java.awt.Color(171, 219, 227));
                jPanel4.setPreferredSize(new java.awt.Dimension(90, 0));

                buttonLogin.setBackground(new java.awt.Color(0, 102, 153));
                buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
                buttonLogin.setText("LOGIN");
                buttonLogin.setBorder(null);
                buttonLogin.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                buttonLoginActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(buttonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 90,
                                                                Short.MAX_VALUE));
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(buttonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 31,
                                                                Short.MAX_VALUE));

                jPanel5.setBackground(new java.awt.Color(171, 219, 227));
                jPanel5.setPreferredSize(new java.awt.Dimension(90, 0));

                buttonSignUp.setBackground(new java.awt.Color(0, 102, 153));
                buttonSignUp.setForeground(new java.awt.Color(255, 255, 255));
                buttonSignUp.setText("SIGNUP");
                buttonSignUp.setBorder(null);

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(buttonSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 89,
                                                                Short.MAX_VALUE));
                jPanel5Layout.setVerticalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(buttonSignUp, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE));

                jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
                jLabel6.setForeground(new java.awt.Color(0, 102, 153));
                jLabel6.setText("X");
                jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jLabel6MouseClicked(evt);
                        }
                });

                buttonForgotPassword.setBackground(new java.awt.Color(171, 219, 227));
                buttonForgotPassword.setForeground(new java.awt.Color(0, 102, 153));
                buttonForgotPassword.setText("Forgot password?");
                buttonForgotPassword.setBorder(null);
                buttonForgotPassword.setBorderPainted(false);
                buttonForgotPassword.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                buttonForgotPasswordActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap(50, Short.MAX_VALUE)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel3Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(jLabel2)
                                                                                                                                .addComponent(jLabel1))
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                .addComponent(username)
                                                                                                                                .addComponent(pass)
                                                                                                                                .addComponent(jSeparator1)
                                                                                                                                .addComponent(jSeparator2)
                                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(jPanel4,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                                .addComponent(jPanel5,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                89,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGap(52, 52, 52))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel3Layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel6)
                                                                                                                .addContainerGap())))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(112, 112, 112)
                                                                .addComponent(buttonForgotPassword,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                123,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel6,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                18,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(74, 74, 74)
                                                                .addGroup(jPanel3Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(jLabel1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                30,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(username))
                                                                .addGap(0, 0, 0)
                                                                .addComponent(jSeparator1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(8, 8, 8)
                                                                .addGroup(jPanel3Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(jLabel2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                30,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(pass))
                                                                .addGap(0, 0, 0)
                                                                .addComponent(jSeparator2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel3Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(jPanel4,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                31,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jPanel5,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                31,
                                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                76,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(buttonForgotPassword)
                                                                .addGap(23, 23, 23)));

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(jPanel3,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

        private void usernameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_usernameActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_usernameActionPerformed

        private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel6MouseClicked
                System.exit(0);
        }// GEN-LAST:event_jLabel6MouseClicked

        private void usernameFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_usernameFocusGained
                username.setText("");
        }// GEN-LAST:event_usernameFocusGained

        private void passFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_passFocusGained
                pass.setText("");
        }// GEN-LAST:event_passFocusGained

        private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonLoginActionPerformed
                String user = username.getText();
                char[] passArray = pass.getPassword();
                String passString = new String(passArray);
                EmployeeController employeeController = new EmployeeController();
                Boolean employee = employeeController.login(user, passString);
                if (employee) {
                        System.out.println("Đăng nhập thành công");

                        MainDefault mainDefault = new MainDefault();
                        mainDefault.setVisible(true);
                        dispose();

                }
        }// GEN-LAST:event_buttonLoginActionPerformed

        private void buttonForgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonForgotPasswordActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_buttonForgotPasswordActionPerformed

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
                // (optional) ">
                /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel.
                 * For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new Login_Form().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton buttonForgotPassword;
        private javax.swing.JButton buttonLogin;
        private javax.swing.JButton buttonSignUp;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JSeparator jSeparator2;
        private javax.swing.JPasswordField pass;
        private javax.swing.JTextField username;
        // End of variables declaration//GEN-END:variables
}
