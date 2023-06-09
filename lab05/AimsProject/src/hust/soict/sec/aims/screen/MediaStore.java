package hust.soict.sec.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.sec.aims.cart.Cart;
import hust.soict.sec.aims.media.Media;
import hust.soict.sec.aims.media.Playable;

@SuppressWarnings("serial")
public class MediaStore extends JPanel {
	private Media media;
	public MediaStore(Media media) {
		
		this.setMedia(media);
		this.setLayout(new BoxLayout(this,  BoxLayout.Y_AXIS));
		
		JLabel titleJLabel = new JLabel(media.getTitle());
		titleJLabel.setFont(new Font(titleJLabel.getFont().getName(), Font.PLAIN, 20));
		titleJLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel costJLabel = new JLabel("" + media.getCost() + " $");
		costJLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel containerJLabel = new JPanel();
		containerJLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		ButtonListener btnListener = new ButtonListener();
		JButton addToCartButton = new JButton("Add to cart");
		addToCartButton.addActionListener(btnListener);
		containerJLabel.add(addToCartButton);
		if(media instanceof Playable) {
			ButtonListener btnListener1 = new ButtonListener();
			JButton playButton = new JButton("Play");
			playButton.addActionListener(btnListener1);
			containerJLabel.add(playButton);

		}
		
		
		this.add(Box.createVerticalGlue());
		this.add(titleJLabel);
		this.add(costJLabel);
		this.add(Box.createVerticalGlue());
		this.add(containerJLabel);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		    String buttonString = e.getActionCommand();
		    if (buttonString.equals("Play")) {
		        JDialog dialog = new JDialog();
		        dialog.setTitle("Playing");
		        
		        JLabel label = new JLabel(media.toString());
		        label.setHorizontalAlignment(JLabel.CENTER);
		        
		        dialog.add(label, BorderLayout.CENTER);
		        
		        dialog.setBounds(200, 200, 400, 150);
		        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		        dialog.setVisible(true);
		        
		    }
		    else if(buttonString.equals("Add to cart")){
		    	Cart.getItemsOrdered().add(media);
		    	
		    	JDialog dialog = new JDialog();
		    	dialog.setTitle("notify");
		    	dialog.setSize(300, 300);
		    	
		    	JLabel label = new JLabel("The media " + media.getTitle() + " is added to Cart");
		    	label.setHorizontalAlignment(JLabel.CENTER);
		    	
		    	dialog.setBounds(200, 200, 300, 300);
		    	dialog.add(label, BorderLayout.CENTER);
		    	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		    	dialog.setVisible(true);
		    	Cart.printCart();
		    }
		}

	}
}
