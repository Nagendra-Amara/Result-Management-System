

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Name;
    private JTextField Roll_number;
    private JTextField email;
    private JTextField branch;
    private JTextField mob;
    private JTextField aadhar;
    private JButton btnNewButton;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public UserRegistration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewUserRegister = new JLabel("New Student Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lblNewUserRegister.setBounds(250, 80,500, 40);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Roll number");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        Name = new JTextField();
        Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Name.setBounds(214, 151, 228, 40);
        contentPane.add(Name);
        Name.setColumns(10);

        Roll_number = new JTextField();
        Roll_number.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Roll_number.setBounds(214, 235, 228, 40);
        contentPane.add(Roll_number);
        Roll_number.setColumns(10);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        email.setBounds(214, 320, 228, 40);
        contentPane.add(email);
        email.setColumns(10);

        branch = new JTextField();
        branch.setFont(new Font("Tahoma", Font.PLAIN, 20));
        branch.setBounds(600, 151, 228, 40);
        contentPane.add(branch);
        branch.setColumns(10);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblbranch.setBounds(450, 159, 99, 29);
        contentPane.add(lblbranch);

        JLabel lblaadhar = new JLabel("Aadhar number");
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblaadhar.setBounds(450, 245,329, 24);
        contentPane.add(lblaadhar);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(450, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 20));
        mob.setBounds(600, 320, 228, 40);
        contentPane.add(mob);
        mob.setColumns(10);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        aadhar.setBounds(600, 235, 228, 40);
        contentPane.add(aadhar);

        btnNewButton = new JButton("Register");
        btnNewButton.setBounds(100,100,50,10);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String SName = Name.getText();
                String srollnum = Roll_number.getText();
                String emailId = email.getText();
                String sbranch = branch.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String aadhar_num = aadhar.getText();

                String msg = "" + SName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Collage", "root", "Naga@0987");

                    String query = "INSERT INTO Students values('" +srollnum + "','" + SName  + "','" + sbranch + "','" +
                        aadhar_num+ "','" + mobileNumber + "','" + emailId + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        
                      JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Sucessfully registered");
                            query="INSERT INTO SemResults(roll_num) values('"+srollnum+"')";
                            sta.executeUpdate(query);
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
    }
}
