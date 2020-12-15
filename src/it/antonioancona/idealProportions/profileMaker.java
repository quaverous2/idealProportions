package it.antonioancona.idealProportions;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class profileMaker implements ActionListener{
	JFrame f;
	JPanel p;
	
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancel) {
			f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
		}
		
		// TO BE FULLY DEVELOPED
		if(e.getSource() == create) {
			System.out.println("TEST CREATE");
			System.out.println(wrist_t.getText());
		}
		
	}
	
	
}
