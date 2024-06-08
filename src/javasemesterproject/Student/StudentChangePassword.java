package javasemesterproject.Student;

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

public class StudentChangePassword extends JFrame implements ActionListener{
    private JLabel newPasswordlbl;
    private JPasswordField newPassword;
    private JButton updatePassbtn;

    // method overloading for changing the password with/without student id
    public StudentChangePassword(){
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
        updatePassbtn.setBounds(80,90, 150, 30);
        updatePassbtn.addActionListener((ActionListener) this);
        add(updatePassbtn);
        
        setLayout(null);
        setSize(320,220);
        setLocation(500,320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public StudentChangePassword(String stdID){
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
        updatePassbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(ae.getSource() == updatePassbtn){
                    String password = String.valueOf(newPassword.getPassword());
                    try{
                        DBConnection c1 = new DBConnection();

                        String q = "update Student SET password = '"+ password +"'"
                                + "Where stdID ='" + stdID + "'";

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
        });
        add(updatePassbtn);

        setLayout(null);
        setSize(320,220);
        setLocation(500,320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == updatePassbtn){
            String password = String.valueOf(newPassword.getPassword());
            try{
                DBConnection c1 = new DBConnection();

                String q = "update Student SET password = '"+ password +"'"
                        + "Where stdID ='" + StudentLogin.currentStudentID + "'";

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
        new StudentChangePassword();
    }

}