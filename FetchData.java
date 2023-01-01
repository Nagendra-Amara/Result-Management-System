import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
 
public class FetchData implements ActionListener 
{
 
    JFrame frame1;
    JLabel nameLabel;
    JTextField nameTextField;
    JButton internals;
    JButton externals;
    JButton semester;

    JFrame frame2;
    DefaultTableModel defaultTableModel;
    JTable table;
    Connection connection;
    Statement statement;

    JFrame frame3;
    int flag=0;
 
    JFrame frame4;
 
    public FetchData() 
    {

        frame1 = new JFrame();
        frame1.setTitle("Search Database");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout bagLayout = new GridBagLayout();
        GridBagConstraints bagConstraints = new GridBagConstraints();
        frame1.setSize(700, 400);
        frame1.setLayout(bagLayout);
        
        bagConstraints.insets = new Insets(15, 40, 0, 0);
 
      
        nameLabel = new JLabel("Enter Roll Num");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        frame1.add(nameLabel, bagConstraints);
 
      
        nameTextField = new JTextField(15);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        frame1.add(nameTextField, bagConstraints);
 
      
        internals = new JButton("Internals");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.ipadx = 60;
        frame1.add(internals, bagConstraints);
 
      
        externals = new JButton("Externals");
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 1;
        frame1.add(externals, bagConstraints);

        semester=new JButton("Semester");
        frame1.add(semester);
        

        internals.addActionListener(this);
        externals.addActionListener(this);
        semester.addActionListener(this);
 
        frame1.setVisible(true);
        frame1.validate();
 
 
    }
 
    public static void main(String[] args) {
        new FetchData();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == internals) 
        {
 
            String roll_num = nameTextField.getText().toString();
            frameSecond(roll_num);
 
        }
        if (e.getSource() == externals) 
        {
            String roll_num = nameTextField.getText().toString();
            frameThird(roll_num);
        }
        if (e.getSource() == semester) 
        {
            String roll_num = nameTextField.getText().toString();
            frameFourth(roll_num);
        }
    }
    public void frameSecond(String roll_num) 
    {
    
     
        frame2 = new JFrame("Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(600, 400);
 
        
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(600, 100));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        
        defaultTableModel.addColumn("Roll No");
        defaultTableModel.addColumn("Sub1");
        defaultTableModel.addColumn("Sub2");
        defaultTableModel.addColumn("Sub3");
        defaultTableModel.addColumn("Sub4");
        defaultTableModel.addColumn("Sub5");
 
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Collage", "root", "Naga@0987");
            statement = connection.createStatement();
            String query = "select * from Internals where roll_num = '" + roll_num + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) 
            {
                
                String roll = resultSet.getString("roll_num");
                String sub1 = resultSet.getString("Sub1");
                String sub2 = resultSet.getString("Sub2");
                String sub3 = resultSet.getString("Sub3");
                String sub4 = resultSet.getString("Sub4");
                String sub5 = resultSet.getString("Sub5");
                if (roll_num.equalsIgnoreCase(roll)) 
                {
                    flag = 1;
                    defaultTableModel.addRow(new Object[]{ roll,sub1,sub2,sub3,sub4,sub5});
                    frame2.setVisible(true);
                    frame2.validate();
                    break;
                }
                
            }
            if (flag == 0) 
            {
                JOptionPane.showMessageDialog(null, "No Such Username Found");
            }
        } 
        catch (SQLException throwables) 
        {
            throwables.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void frameThird(String roll_num) 
    {

    
        frame3 = new JFrame("Results");
        frame3.setLayout(new FlowLayout());
        frame3.setSize(600, 400);
    
        
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(600, 100));
        table.setFillsViewportHeight(true);
        frame3.add(new JScrollPane(table));
        
        defaultTableModel.addColumn("Roll No");
        defaultTableModel.addColumn("Sub1");
        defaultTableModel.addColumn("Sub2");
        defaultTableModel.addColumn("Sub3");
        defaultTableModel.addColumn("Sub4");
        defaultTableModel.addColumn("Sub5");
    
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Collage", "root", "Naga@0987");
            statement = connection.createStatement();
            String query = "select * from Externals where roll_num = '" + roll_num + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) 
            {
                
                String roll = resultSet.getString("roll_num");
                String sub1 = resultSet.getString("Sub1");
                String sub2 = resultSet.getString("Sub2");
                String sub3 = resultSet.getString("Sub3");
                String sub4 = resultSet.getString("Sub4");
                String sub5 = resultSet.getString("Sub5");
                if (roll_num.equalsIgnoreCase(roll)) 
                {
                    flag = 1;
                    defaultTableModel.addRow(new Object[]{ roll,sub1,sub2,sub3,sub4,sub5});
                    frame3.setVisible(true);
                    frame3.validate();
                    break;
                }
                
            }
            if (flag == 0) 
            {
                JOptionPane.showMessageDialog(null, "No Such Username Found");
            }
        } 
        catch (SQLException throwables) 
        {
            throwables.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public void frameFourth(String roll_num)
    {
        frame4 = new JFrame("Results");
        frame4.setLayout(new FlowLayout());
        frame4.setSize(600, 400);


        JLabel rolln=new JLabel("Roll number");
        JTextField num=new JTextField(roll_num);


        frame4.add(rolln);
        frame4.add(num);


        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);
        frame4.add(new JScrollPane(table));
        
        defaultTableModel.addColumn("Subjects");
        defaultTableModel.addColumn("Grade");
        frame4.setVisible(true);
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Collage", "root", "Naga@0987");
            statement = connection.createStatement();
            String query = "select * from SemResults where roll_num = '" + roll_num + "'";
           /*  String query1 = "update SemResults join Externals on SemResults.roll_num=Externals.roll_num join Internals on SemResults.roll_num=Internals.roll_num set grade1= case when Internals.sub1+Externals.sub1 between 90 and 100 then 'O'"
                                                +" when Internals.sub1+Externals.sub1 between 80 and 90 then 'A'"
                                                +" when Internals.sub1+Externals.sub1 between 70 and 80 then 'B'"
                                                +" when Internals.sub1+Externals.sub1 between 60 and 70 then 'C'"
                                                +" when Internals.sub1+Externals.sub1 between 50 and 60 then 'D'"
                                                +" when Internals.sub1+Externals.sub1 between 35 and 50 then 'P'"
                                                +" else 'F' end,"
                                                +" grade2= case when Internals.sub2+Externals.sub2 between 90 and 100 then 'O'"
                                                +" when Internals.sub2+Externals.sub2 between 80 and 90 then 'A'"
                                                +" when Internals.sub2+Externals.sub2 between 70 and 80 then 'B'"
                                                +" when Internals.sub2+Externals.sub2 between 60 and 70 then 'C'"
                                                +" when Internals.sub2+Externals.sub2 between 50 and 60 then 'D'"
                                                +" when Internals.sub2+Externals.sub2 between 35 and 50 then 'P'"
                                                +" else 'F' end,"
                                                +" grade3= case when Internals.sub3+Externals.sub3 between 90 and 100 then 'O'"
                                                +" when Internals.sub3+Externals.sub3 between 80 and 90 then 'A'"
                                                +" when Internals.sub3+Externals.sub3 between 70 and 80 then 'B'"
                                                +" when Internals.sub3+Externals.sub3 between 60 and 70 then 'C'"
                                                +" when Internals.sub3+Externals.sub3 between 50 and 60 then 'D'"
                                                +" when Internals.sub3+Externals.sub3 between 35 and 50 then 'P'"
                                                +" else 'F' end,"
                                                +" grade4= case when Internals.sub4+Externals.sub4 between 90 and 100 then 'O'"
                                                +" when Internals.sub4+Externals.sub4 between 80 and 90 then 'A'"
                                                +" when Internals.sub4+Externals.sub4 between 70 and 80 then 'B'"
                                                +" when Internals.sub4+Externals.sub4 between 60 and 70 then 'C'"
                                                +" when Internals.sub4+Externals.sub4 between 50 and 60 then 'D'"
                                                +" when Internals.sub4+Externals.sub4 between 35 and 50 then 'P'"
                                                +" else 'F'end,"
                                                +" grade5= case when Internals.sub5+Externals.sub5 between 90 and 100 then 'O'"
                                                +" when Internals.sub5+Externals.sub5 between 80 and 90 then 'A'"
                                                +" when Internals.sub5+Externals.sub5 between 70 and 80 then 'B'"
                                                +" when Internals.sub5+Externals.sub5 between 60 and 70 then 'C'"
                                                +" when Internals.sub5+Externals.sub5 between 50 and 60 then 'D'"
                                                +" when Internals.sub5+Externals.sub5 between 35 and 50 then 'P'"
                                                +" else 'F' end"
                                                +" where SemResults.roll_num=Externals.roll_num;";
            
            
            This may generate exception .So updation should be done manually
            statement.executeQuery(query1); */
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) 
            {
                String roll=resultSet.getString("roll_num");
                String sub1="Subject1";
                String sub2="Subject2";
                String sub3="Subject3";
                String sub4="Subject4";
                String sub5="Subject5";  
                String grade1 = resultSet.getString("grade1");
                String grade2 = resultSet.getString("grade2");
                String grade3 = resultSet.getString("grade3");
                String grade4 = resultSet.getString("grade4");
                String grade5 = resultSet.getString("grade5");
                if (roll_num.equalsIgnoreCase(roll)) 
                {
                    flag = 1;
                    defaultTableModel.addRow(new Object[]{ sub1,grade1});
                    defaultTableModel.addRow(new Object[]{ sub2,grade2});
                    defaultTableModel.addRow(new Object[]{ sub3,grade3});
                    defaultTableModel.addRow(new Object[]{ sub4,grade4});
                    defaultTableModel.addRow(new Object[]{ sub5,grade5});
                    
                    
                    break;
                }
                
            }
            if (flag == 0) 
            {
                JOptionPane.showMessageDialog(null, "No Such Username Found");
            }
        } 
       
        catch (SQLException throwables) 
        {
            throwables.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
