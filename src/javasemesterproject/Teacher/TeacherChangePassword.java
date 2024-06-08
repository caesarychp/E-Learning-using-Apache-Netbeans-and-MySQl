package javasemesterproject.Teacher;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javasemesterproject.DBConnection;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class TeacherChangePassword extends JFrame implements ActionListener{
    private JLabel newPasswordlbl;
    private JPasswordField newPassword;
    private JButton updatePassbtn;
    
    // Default constructor
    public TeacherChangePassword(){
        initializeUI();
    }
    
    // Overloaded constructor that takes a boolean parameter to set visibility
    public TeacherChangePassword(boolean visible){
        initializeUI();
        setVisible(visible);
    }
    
    // Overloaded constructor that takes a title parameter
    public TeacherChangePassword(String title){
        initializeUI();
        setTitle(title);
    }
    
    // Helper method to initialize UI components
    private void initializeUI() {
        newPasswordlbl = new JLabel("New Password");
        newPasswordlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        newPasswordlbl.setBounds(10, 10, 150, 30);
        add(newPasswordlbl);

        newPassword = new JPasswordField();
        newPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
        newPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newPassword.setBounds(150, 10, 150, 40);
        add(newPassword);
        newPassword.setColumns(20);

        updatePassbtn = new JButton("Update");
        updatePassbtn.setBounds(80, 90, 150, 30);
        updatePassbtn.addActionListener((ActionListener) this);
        add(updatePassbtn);

        setLayout(null);
        setSize(320,220);
        setLocation(500,320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == updatePassbtn){
            String password = String.valueOf(newPassword.getPassword());
            try{
                DBConnection c1 = new DBConnection();

                String q = "update Teacher SET password = '"+ password +"'"
                        + "Where teacherID ='" + TeacherLogin.currentTeacherID + "'";

                int x = c1.s.executeUpdate(q);
                if(x == 0){
                    JOptionPane.showMessageDialog(null, "Got some error");
                }else{
                    JOptionPane.showMessageDialog(null, "Your Password Updated Successfully");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new TeacherChangePassword();
        new TeacherChangePassword(false);
        new TeacherChangePassword("Change Password");
    }
}