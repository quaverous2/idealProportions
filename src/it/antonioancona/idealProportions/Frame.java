package it.antonioancona.idealProportions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Frame implements ActionListener{
	
	JFrame f;
	
	JMenuBar mb;
	JMenu profiles;
		JMenuItem createNew;
		JMenuItem importProfile;
	JMenu about;
		JMenuItem version;
		JMenuItem github;
		
	JButton newCreate;
	JButton profileImport;
		
		Frame(){
		
		// New frame and menu bar instance creation
		f = new JFrame("idealProportions");
		f.setSize(1024, 600);
		f.setLayout(null);
		
		
		
		mb = new JMenuBar();
		
		// Menu bar items and subitems instance creation
		profiles = new JMenu("Profiles");
			createNew = new JMenuItem("Create new Profile");
			importProfile = new JMenuItem("Import Profile");
			
		about = new JMenu("About");
			version = new JMenuItem("Version");
				version.addActionListener(this);
			github = new JMenuItem("Github Repository");
				github.addActionListener(this);
		
		// Menu bar item insertion into main Menu
		mb.add(profiles);
			profiles.add(importProfile);
			profiles.add(createNew);
		
		mb.add(about);
			about.add(version);
			about.add(github);
		
		// Startup Buttons
		newCreate = new JButton("Create new Profile");
			newCreate.setBounds(192, 220, 300, 30);
			newCreate.addActionListener(this);
		profileImport = new JButton("Import existing Profile");
			profileImport.setBounds(542, 220, 300, 30);
			profileImport.addActionListener(this);
		
		
		// Startup Buttons initiation
		f.add(newCreate);
		f.add(profileImport);
			
		// Menu bar initiation
		f.setJMenuBar(mb);
		
		

		f.setVisible(true);
	}
	
	// Web page opening method for github repository submenu action
	public static void openWebpage(String urlString) {
	    try {
	        Desktop.getDesktop().browse(new URL(urlString).toURI());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	// Menu Bar Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == version) {
			
			JFrame v = new JFrame("Version");
			v.setSize(300, 450);
			
			JTextArea versionText = new JTextArea("idealProportion Application, to push people to be their best selves."
					+ "\n Version = 0.0.1");
			versionText.setBounds(10, 20, 260, 360);
			
			v.add(versionText);
			v.setLayout(null);
			v.setLocationRelativeTo(f);  // Opens "Version" window centered in main frame
			v.setVisible(true);
			
		}
		
		if(e.getSource() == github) {
			
			openWebpage("https://github.com/quaverous2/idealProportions");
			
		}
		
		if(e.getSource() == newCreate) {
			new profileMaker();
		}
		
		if(e.getSource() == profileImport) {
			System.out.println("import profile button clicked");
		}
	}
}
