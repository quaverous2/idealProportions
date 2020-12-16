package it.antonioancona.idealProportions;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class profileMaker implements ActionListener{
	JFrame f;
	JPanel p;
	
	JTextField name_t;
	JTextField wrist_t;
	JTextField height_t;
	JTextField weight_t;
	JTextField chest_t;
	JTextField arm_t;
	JTextField forearm_t;
	JTextField thigh_t;
	JTextField calf_t;
	JTextField waist_t;
	JTextField neck_t;
	JTextField hips_t;
	
	JButton create;
	JButton cancel;
	
	profileMaker(){
		f = new JFrame("Create new Profile");
		p = new JPanel();
		
		// GridBagLayout setup 
		p.setLayout(new GridBagLayout());
		f.getContentPane().add(p);
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;    
         
        // Define body measurements labels (Format = body part name) and text fields (Format = body  part name _ t)
        
        // MANDATORY 
        JLabel name = new JLabel("Profile Name    ");
        name_t = new JTextField(7);
        
        JLabel wrist = new JLabel("Wrist Size    ");
        wrist_t = new JTextField(5);
        
        JLabel height = new JLabel("Height    ");
        height_t = new JTextField(5);
        
        JLabel weight = new JLabel("Weight    ");
        weight_t = new JTextField(5);
        
        // OPTIONAl
        JLabel chest = new JLabel("Chest Circumference    ");
        chest_t = new JTextField(5);
        
        JLabel arm = new JLabel("Arm Circumference    ");
        arm_t = new JTextField(5);
        
        JLabel forearm = new JLabel("Forearm Circumference    ");
        forearm_t = new JTextField(5);
        
        JLabel thigh = new JLabel("Thigh Circumference    ");
        thigh_t = new JTextField(5);
        
        JLabel calf = new JLabel("Calf Circumference    ");
        calf_t = new JTextField(5);
        
        JLabel waist = new JLabel("Waist Circumference    ");
        waist_t = new JTextField(5);
        
        JLabel neck = new JLabel("Neck Circumference    ");
        neck_t = new JTextField(5);
        
        JLabel hips = new JLabel("Hips Circumference    ");
        hips_t = new JTextField(5);
        
        // BUTTONS
        
        create = new JButton("Create");
        create.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        
         
        // Add mandatory labels to the frame
        p.add(name, left);
        p.add(name_t, right);
        
        p.add(wrist, left);
        p.add(wrist_t, right);
        //p.add(Box.createRigidArea(new Dimension(0, 5)));
        p.add(height, left);
        p.add(height_t, right);
        
        p.add(weight, left);
        p.add(weight_t, right);
        
        // Filler between mandatory measurements and non-mandatory
        //p.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // Add non-mandatory labels to the frame
        p.add(chest, left);
        p.add(chest_t, right);
        
        p.add(arm, left);
        p.add(arm_t, right);
        
        p.add(forearm, left);
        p.add(forearm_t, right);
        
        p.add(thigh, left);
        p.add(thigh_t, right);
        
        p.add(calf, left);
        p.add(calf_t, right);
        
        p.add(waist, left);
        p.add(waist_t, right);
        
        p.add(neck, left);
        p.add(neck_t, right);
        
        p.add(hips, left);
        p.add(hips_t, right);
        
        // Add Buttons (To frame and not to panel TEST)
        p.add(cancel, left);
        p.add(create, right);
         
        // Set the window to be visible as the default to be false
        p.setBorder(BorderFactory.createEmptyBorder(30, 10, 50, 10));
        f.pack();
        f.setVisible(true);
 
	}

	// Cancel and Create button functionalities
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == cancel) {
			f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
		}
		
		// TO BE FULLY DEVELOPED
		if(e.getSource() == create) {
			//System.out.println(wrist_t.getText());
			try {
				
				// TODO = Check if Text Field have appropriate values, if any value is invalid stop the execution
				
				// Check if profiles table exists in DB
				// If it does, create a new database entry with
				// the provided data
				if (profileTableExists()) {
					try {
						System.out.println("Profile table found, creating..");
						buildProfile();
						System.out.println("Profile Created");
						
					} catch (ClassNotFoundException e1) {
						
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
				// If it doesn't, create the profiles table and 
				// run this method again to have
				// profileTableExists() == true
				} else {
					System.out.println("Profile table not found inside database, creating.. ");
					profileTableCreate();
					System.out.println("profile Table created");
					actionPerformed(e);
				}
			} catch (ClassNotFoundException e1) {
				
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
		}
		
	}
	
	public void buildProfile() throws ClassNotFoundException{
		
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			
			connection = DriverManager.getConnection("jdbc:sqlite:profiles.db");
			
			Statement statement = connection.createStatement();
		    statement.setQueryTimeout(30);  // set timeout to 30 sec.
		    
		    // TODO = modify this to add correct values into profiles based
		    // on getText() functions;
		    String SQL = "INSERT INTO profile (name, wrist_circumference, height, weight, chest_circumference, arm_circumference, "
		    		+ "forearm_circumference, thigh_circumference, calf_circumference, waist_circumference, neck_circumference, hips_circumference) \n"
		    		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?)";
		    PreparedStatement pstmt = connection.prepareStatement(SQL);
		    
		    pstmt.setString(1, name_t.getText());
		    pstmt.setFloat(2, Float.parseFloat(wrist_t.getText()));
		    pstmt.setFloat(3, Float.parseFloat(height_t.getText()));
		    pstmt.setFloat(4, Float.parseFloat(weight_t.getText()));
		    pstmt.setFloat(5, Float.parseFloat(chest_t.getText()));
		    pstmt.setFloat(6, Float.parseFloat(arm_t.getText()));
		    pstmt.setFloat(7, Float.parseFloat(forearm_t.getText()));
		    pstmt.setFloat(8, Float.parseFloat(thigh_t.getText()));
		    pstmt.setFloat(9, Float.parseFloat(calf_t.getText()));
		    pstmt.setFloat(10, Float.parseFloat(waist_t.getText()));
		    pstmt.setFloat(11, Float.parseFloat(neck_t.getText()));
		    pstmt.setFloat(12, Float.parseFloat(hips_t.getText()));
		    
		    pstmt.executeUpdate(); 
			
		} catch(SQLException e) {
			
			 System.err.println(e.getMessage());
			 
		} finally {
			
			try {
				
				if (connection != null) {
					connection.close();
					
				}
			} catch (SQLException e) {
				
				System.err.println(e);
				
			}
		}
		
	}
	
	// Checks if table "profile" exists in profiles.db
	public boolean profileTableExists() throws ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			
			connection = DriverManager.getConnection("jdbc:sqlite:profiles.db");
			DatabaseMetaData dbm = connection.getMetaData();
			
			ResultSet tables = dbm.getTables(null, null, "profile", null);
			
			if (tables.next()) {
				return true;
			} else {
				return false;
			}
			
		} catch(SQLException e) {
			
			 System.err.println(e.getMessage());
			 
		} finally {
			
			try {
				
				if (connection != null) {
					connection.close();
				}
				
			} catch (SQLException e) {
				
				System.err.println(e);
			}
		}
		
		System.out.println("problem in profileTableExists(), this"
				+ "should never be printed.");
		return true;
	}
	
	// Creates table "profile" in profiles.db
	public void profileTableCreate() throws ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			
			connection = DriverManager.getConnection("jdbc:sqlite:profiles.db");
			
			Statement statement = connection.createStatement();
		    statement.setQueryTimeout(30);  // set timeout to 30 sec.
		    
		    String SQL = "CREATE TABLE profile (\n"
		    		+ "id INTEGER PRIMARY KEY AUTOINCREMENT, \n"
		    		+ "name tinytext, \n"
		    		+ "wrist_circumference FLOAT(2), \n"
		    		+ "height FLOAT(2), \n"
		    		+ "weight FLOAT(2), \n"
		    		+ "chest_circumference FLOAT(2), \n"
		    		+ "arm_circumference FLOAT(2), \n"
		    		+ "forearm_circumference FLOAT(2), \n"
		    		+ "thigh_circumference FLOAT(2), \n"
		    		+ "calf_circumference FLOAT(2), \n"
		    		+ "waist_circumference FLOAT(2), \n"
		    		+ "neck_circumference FLOAT(2), \n"
		    		+ "hips_circumference FLOAT(2))";
		    
		    statement.execute(SQL);

		} catch(SQLException e) {
			
			 System.err.println(e.getMessage());
			 
		} finally {
			
			try {
				
				if (connection != null) {
					connection.close();
				}
				
			} catch (SQLException e) {
				
				System.err.println(e);
			}
		}
	}
	
}
