package hust.soict.sec.aims.screen;

import javax.swing.JFrame;

import javafx.embed.swing.JFXPanel;


@SuppressWarnings("serial")
public class AddMediaToStoreScreen extends JFrame {
	
	
	protected JFXPanel fJfxPanel;
	protected static AddMediaController controller;
    public AddMediaToStoreScreen() {
    	super();
    	
    	fJfxPanel = new JFXPanel();
    	this.add(fJfxPanel);
    	
    	this.setSize(800, 600);
    	this.setTitle("Add Media to Store");
    	this.setVisible(true);
    }

}
