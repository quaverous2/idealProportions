package it.antonioancona.idealProportions;

import javax.swing.*;

public class Frame {
	
	public Frame(){
		
		// Main frame and menu bar creation
		JFrame f = new JFrame("idealProportions");
			
			
		JMenuBar mb = new JMenuBar();
		
		// Menu bar items and subitems creation
		JMenu profiles = new JMenu("Profiles");
			JMenuItem createNew = new JMenuItem("Create new Profile");
			JMenuItem importProfile = new JMenuItem("Import Profile");
			
		JMenu about = new JMenu("About");
			JMenuItem version = new JMenuItem("Version");
			JMenuItem creator = new JMenuItem("Creator");
		
		// Menu bar item insertion into main Menu
		mb.add(profiles);
			profiles.add(createNew);
			profiles.add(importProfile);
		
		mb.add(about);
			about.add(version);
			about.add(creator);
		
		// Menu bar initiation
		f.setJMenuBar(mb);
		
		
		f.setSize(1024, 600);
		f.setLayout(null);
		f.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		
		new Frame();
		
	}
	
	
	
}
