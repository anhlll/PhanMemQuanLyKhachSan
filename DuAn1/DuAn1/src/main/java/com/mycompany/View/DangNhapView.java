/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Domainmodels.NguoiDung;
import com.mycompany.Service.NhanVienInterface;
import com.mycompany.Service.impl.NhanVienimpl;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author DANG HIEU
 */
public class DangNhapView extends javax.swing.JFrame {

    NhanVienInterface nvsr = new NhanVienimpl();
    
    public DangNhapView() {
        initComponents();
        this.setLocationRelativeTo(null);
        Icon backgroundIC = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\backGroud DangNhap.jpg");
        Icon logo = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\logohotel.png");
        this.LogoHotel.setIcon(logo);
        Icon anIcon = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\hidden.png");
        this.an.setIcon(anIcon);
        Icon hienIcon = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\eye.png");
        this.hien.setIcon(hienIcon);
        Icon Useravaar = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\manager.png");
        this.UserIcon.setIcon(Useravaar);
        Icon UserPass = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\padlock.png");
        this.PassIcon.setIcon(UserPass);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backGroud = new javax.swing.JPanel();
        jpane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPwd = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        hien = new javax.swing.JLabel();
        an = new javax.swing.JLabel();
        PassIcon = new javax.swing.JLabel();
        LogoHotel = new javax.swing.JLabel();
        UserIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jpane.setBackground(new java.awt.Color(204, 255, 255));
        jpane.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("ĐĂNG NHẬP");

        jPanel6.setBackground(new java.awt.Color(255, 255, 153));
        jPanel6.setPreferredSize(new java.awt.Dimension(236, 5));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        txtUsername.setText("Nhập tên tài khoản");
        txtUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tên tài khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        txtUsername.setMinimumSize(new java.awt.Dimension(65, 45));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtPwd.setText("        ");
        txtPwd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mật khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        txtPwd.setMinimumSize(new java.awt.Dimension(65, 45));
        txtPwd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPwdFocusGained(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Đăng nhập");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.gray, java.awt.Color.white));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Hủy");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.gray, java.awt.Color.white));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        hien.setText("1");
        hien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hienMousePressed(evt);
            }
        });

        an.setText("1");
        an.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                anMousePressed(evt);
            }
        });

        PassIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PassIconMousePressed(evt);
            }
        });

        LogoHotel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LogoHotelMousePressed(evt);
            }
        });

        UserIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UserIconMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpaneLayout = new javax.swing.GroupLayout(jpane);
        jpane.setLayout(jpaneLayout);
        jpaneLayout.setHorizontalGroup(
            jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaneLayout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaneLayout.createSequentialGroup()
                            .addGroup(jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LogoHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpaneLayout.createSequentialGroup()
                                    .addGroup(jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jpaneLayout.createSequentialGroup()
                                            .addComponent(UserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpaneLayout.createSequentialGroup()
                                            .addComponent(PassIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(an, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(14, 14, 14)))
                    .addGroup(jpaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaneLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(156, 156, 156))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaneLayout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118))))))
        );
        jpaneLayout.setVerticalGroup(
            jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpaneLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addComponent(LogoHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(an, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PassIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout backGroudLayout = new javax.swing.GroupLayout(backGroud);
        backGroud.setLayout(backGroudLayout);
        backGroudLayout.setHorizontalGroup(
            backGroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        backGroudLayout.setVerticalGroup(
            backGroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backGroud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backGroud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void loadAcc(List<NguoiDung> list) {
        for (NguoiDung nguoiDung : list) {
            String id = nguoiDung.getId();

        }
    }
    
    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        txtUsername.setText("");
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPwdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPwdFocusGained
        txtPwd.setText("");
    }//GEN-LAST:event_txtPwdFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String email = txtUsername.getText();
        String pass = txtPwd.getText();
        if(email.length() == 0 || pass.length() == 0){
            JOptionPane.showMessageDialog(this, "Khong de trong!");
            return;
        }
        if (nvsr.checkAcc(email, pass)) {
            loadAcc(nvsr.getAcc(email, pass));
            QLKS ks1 = new QLKS();
            ks1.setVisible(true);
            ks1.setLocationRelativeTo(null);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không đúng!", "???",JOptionPane.CANCEL_OPTION);
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void hienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hienMousePressed
        an.setVisible(true);
        hien.setVisible(false);
        txtPwd.setEchoChar((char) 0);
    }//GEN-LAST:event_hienMousePressed

    private void anMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anMousePressed
        hien.setVisible(true);
        an.setVisible(false);
        txtPwd.setEchoChar('*');
    }//GEN-LAST:event_anMousePressed

    private void PassIconMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassIconMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassIconMousePressed

    private void LogoHotelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoHotelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoHotelMousePressed

    private void UserIconMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserIconMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserIconMousePressed

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
            java.util.logging.Logger.getLogger(DangNhapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhapView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoHotel;
    private javax.swing.JLabel PassIcon;
    private javax.swing.JLabel UserIcon;
    private javax.swing.JLabel an;
    private javax.swing.JPanel backGroud;
    private javax.swing.JLabel hien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jpane;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
