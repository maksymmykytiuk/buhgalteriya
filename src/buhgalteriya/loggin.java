package buhgalteriya;
 
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Максим
 */

public class loggin extends javax.swing.JFrame { 
    public static int status=0;//ne admin
    /**
     * Creates new form loggin
     */
    public loggin() {
        initComponents();
        //conn=javaconnect.ConnectDb();
    }

    /**
     *
     * @throws java.sql.SQLException
     */
    public void eqpassword() throws SQLException
    {
        try {
            Vladeltsy v1=new Vladeltsy();
            Object passuser = null;
            Object nomer=setuser.getSelectedIndex()+1;
            String userName="root",password="";
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dom_buhgal",userName,password);
            System.out.println("Connected to database");
            Statement stmt;
            String query ="select password from vladeltsy where ID="+nomer;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                passuser = rs.getString("password");
            }
            if(!setpassword.getText().trim().equals(passuser))
            {
                JOptionPane.showMessageDialog(null, "       Невірний пароль","Помилка",JOptionPane.ERROR_MESSAGE);
                setpassword.setText("");
                stmt.executeUpdate("delete from vladeltsy where ID=(select max(ID) from vladeltsy)");
            }
            else
            {  
                if((setuser.getSelectedIndex()+1)==1)
                {
                    loggin.status=1;
                    mainDBadmin mdba=new mainDBadmin();
                    mdba.setVisible(true);
                    dispose();
                    stmt.executeUpdate("delete from vladeltsy where ID=(select max(ID) from vladeltsy)");
                }
                else
                {
                    loggin.status=0;
                    mainDB mdb=new mainDB();
                    mdb.setVisible(true);
                    dispose();
                    stmt.executeUpdate("delete from vladeltsy where ID=(select max(ID) from vladeltsy)");
                }
                
            }   EntityManagerFactory emf = Persistence.createEntityManagerFactory("buhgalteriyaPU");
            VladeltsyJpaController ajc = new VladeltsyJpaController(emf);
            ajc.create(v1);
        } catch (SQLException ex) {
            Logger.getLogger(loggin.class.getName()).log(Level.SEVERE, null, ex);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buhgalteriyaPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("buhgalteriyaPU").createEntityManager();
        vladeltsyQuery = java.beans.Beans.isDesignTime() ? null : buhgalteriyaPUEntityManager.createQuery("SELECT v FROM Vladeltsy v");
        vladeltsyList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : vladeltsyQuery.getResultList();
        vladeltsyQuery1 = java.beans.Beans.isDesignTime() ? null : buhgalteriyaPUEntityManager.createQuery("SELECT v FROM Vladeltsy v");
        vladeltsyList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : vladeltsyQuery1.getResultList();
        vladeltsyQuery2 = java.beans.Beans.isDesignTime() ? null : buhgalteriyaPUEntityManager.createQuery("SELECT v FROM Vladeltsy v");
        vladeltsyList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : vladeltsyQuery2.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        setpassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        setuser = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Вхід");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Користувач");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Пароль");

        setpassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setpassword.setToolTipText("");
        setpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setpasswordActionPerformed(evt);
            }
        });
        setpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setpasswordFocusGained(evt);
            }
        });
        setpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                setpasswordKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Увійти");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Вихід");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setuser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, vladeltsyList2, setuser);
        bindingGroup.addBinding(jComboBoxBinding);

        setuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setuserActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Пароль повинен містити 6 символів 0-9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(52, 52, 52)
                                .addComponent(setpassword))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel3)
                                        .addGap(0, 21, Short.MAX_VALUE))
                                    .addComponent(setuser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(setuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        setSize(new java.awt.Dimension(418, 182));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            eqpassword();
        } catch (SQLException ex) {
            Logger.getLogger(loggin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void setuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setuserActionPerformed
setpassword.setDocument(new PlainDocument() {
            String chars = "0123456789";
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.indexOf(str) != -1) {
                    jLabel3.setForeground(new Color(240,240,240));
                    if (getLength()< 6) {
                        super.insertString(offs, str, a);
                        jLabel3.setForeground(new Color(240,240,240));
                    }else{jLabel3.setForeground(Color.BLACK);}
                }else{jLabel3.setForeground(Color.BLACK);}
            }
        });        
    }//GEN-LAST:event_setuserActionPerformed

    
    private void setpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setpasswordActionPerformed
        
    }//GEN-LAST:event_setpasswordActionPerformed

    private void setpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setpasswordKeyPressed
    if (evt.getKeyCode()==KeyEvent.VK_ENTER){
        try {
            eqpassword();
        } catch (SQLException ex) {
            Logger.getLogger(loggin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_setpasswordKeyPressed

    private void setpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_setpasswordFocusGained
  
    }//GEN-LAST:event_setpasswordFocusGained

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
            java.util.logging.Logger.getLogger(loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new loggin().setVisible(true);
            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager buhgalteriyaPUEntityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField setpassword;
    private javax.swing.JComboBox setuser;
    private java.util.List<buhgalteriya.Vladeltsy> vladeltsyList;
    private java.util.List<buhgalteriya.Vladeltsy> vladeltsyList1;
    private java.util.List<buhgalteriya.Vladeltsy> vladeltsyList2;
    private javax.persistence.Query vladeltsyQuery;
    private javax.persistence.Query vladeltsyQuery1;
    private javax.persistence.Query vladeltsyQuery2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
