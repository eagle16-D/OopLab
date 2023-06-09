package hust.soict.sec.aims.screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import hust.soict.sec.aims.Store;

import hust.soict.sec.aims.media.DigitalVideoDisc;
import hust.soict.sec.aims.media.Media;



@SuppressWarnings("serial")
public class StoreScreen extends JFrame {

	private static StoreScreen instance = null;
	private static Store store;
	private ButtonListener btnListener = new ButtonListener();
	
	JPanel createNorth() {
		JPanel northJPanel = new JPanel();
		northJPanel.setLayout(new BoxLayout(northJPanel, BoxLayout.Y_AXIS));
		northJPanel.add(createMenuBar());
		northJPanel.add(createHeader());
		return northJPanel;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		
		JMenu smUpdateStoreJMenu = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		JMenuItem addCD = new JMenuItem("Add CD");
		JMenuItem addDVD = new JMenuItem("Add DVD");
		
		addBook.addActionListener(btnListener);
		addCD.addActionListener(btnListener);
		addDVD.addActionListener(btnListener);
		
		smUpdateStoreJMenu.add(addBook);
		smUpdateStoreJMenu.add(addCD);
		smUpdateStoreJMenu.add(addDVD);
		
		menu.add(smUpdateStoreJMenu);
		
		JMenuItem viewStore = new JMenuItem("View store");
		JMenuItem viewCart = new JMenuItem("View cart");
		viewCart.addActionListener(btnListener);
		viewStore.addActionListener(btnListener);
		menu.add(viewStore);
		menu.add(viewCart);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		
		JPanel headerJPanel = new JPanel();
		headerJPanel.setLayout(new BoxLayout(headerJPanel, BoxLayout.X_AXIS));
		
		JLabel titleJLabel = new JLabel("AIMS");
		titleJLabel.setFont(new Font(titleJLabel.getName(), Font.PLAIN, 50));
		titleJLabel.setForeground(Color.CYAN);
		

		JButton cartButton = new JButton("View Cart");
		cartButton.setPreferredSize(new Dimension(100, 50));
		cartButton.setMaximumSize(new Dimension(100, 50));
		cartButton.addActionListener(btnListener);
		
		headerJPanel.add((Box.createRigidArea(new Dimension(10, 10))));
		headerJPanel.add(titleJLabel);
		headerJPanel.add(Box.createHorizontalGlue());
		headerJPanel.add(cartButton);
		headerJPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return headerJPanel;	
	}
	
	JPanel createCenter() {
		
		JPanel centerJPanel = new JPanel();
		centerJPanel.setLayout(new GridLayout(0, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = Store.getItemsInStore();
		for(int i = 0; i < Store.getItemsInStore().size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			centerJPanel.add(cell);
		}
		return centerJPanel;
	}
	
	@SuppressWarnings("exports")
	public StoreScreen(Store store) {
		this.setStore(store);
		Container cpContainer = getContentPane();
		cpContainer.setLayout(new BorderLayout());
		
		cpContainer.add(createNorth(), BorderLayout.NORTH);
		cpContainer.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	private class ButtonListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String buttonString = e.getActionCommand();
	        
	        if (buttonString.equals("View Cart")) {
	        	openCartScreen();

	        } else if (buttonString.equals("Add Book")) {
	        	openAddBookScreen();
	        	

	            
	        } else if (buttonString.equals("Add CD")) {
	            openAddCDScreen();
	        	
	            
	        } else if (buttonString.equals("Add DVD")) {
	           openAddDVDScreen();
	        	

	            
	        } else if (buttonString.equals("View store")) {
	        	setVisible(true);

	        	
	        } else if (buttonString.equals("View cart")) {
	            openCartScreen();   
	            
	            }
	    }
	}
	
	public static StoreScreen getInstance() {
        if (instance == null) {
            instance = new StoreScreen(StoreScreen.getStore());
        }
        return instance;
    }
	
	public static void openCartScreen() {
		CartScreen cartScreen = CartScreen.getInstance(); 	
		cartScreen.setVisible(true);
	}
	
	public void openAddCDScreen() {
	    AddCDToStoreScreen screen = AddCDToStoreScreen.getInstance();
	    screen.setVisible(true);
	}

	public void openAddDVDScreen() {
	    AddMediaToStoreScreen screen = AddDVDToStoreScreen.getInstance();
	    screen.setVisible(true);
	}

	public void openAddBookScreen() {
	    AddMediaToStoreScreen screen = AddBookToStoreScreen.getInstance();
	    screen.setVisible(true);
	}


	
	
	public void openStoreScreen() {
		StoreScreen storeScreen = StoreScreen.getInstance(); 
        storeScreen.setVisible(true);
	}
	
	public void addMediaToStore(Media media) {
        store.addMedia(media);
        refreshMediaDisplay();
    }
	
	private void refreshMediaDisplay() {
        getContentPane().removeAll(); // Clear the existing media display
        getContentPane().add(createNorth(), BorderLayout.NORTH);
        getContentPane().add(createCenter(), BorderLayout.CENTER);
        revalidate(); // Refresh the layout
        repaint(); // Repaint the frame
    }

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		store = new Store();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(dvd3);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladi", "Animation", 18.99f);
		store.addMedia(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Alad", "Animation", 18.99f);
		store.addMedia(dvd5);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Ala", "Animation", 18.99f);
		store.addMedia(dvd6);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Al", "Animation", 18.99f);
		store.addMedia(dvd7);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("A", "Animation", 18.99f);
		store.addMedia(dvd8);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("ladin", "Animatio", 18.99f);
		store.addMedia(dvd9);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("lain", "Animatin", 18.99f);
		store.addMedia(dvd10);
		DigitalVideoDisc dvd11 = new DigitalVideoDisc("lain", "Animaton", 18.99f);
		store.addMedia(dvd11);
		DigitalVideoDisc dvd12 = new DigitalVideoDisc("lain", "Animaion", 18.99f);
		store.addMedia(dvd12);
		DigitalVideoDisc dvd13 = new DigitalVideoDisc("lain", "Animtion", 18.99f);
		store.addMedia(dvd13);
		DigitalVideoDisc dvd14 = new DigitalVideoDisc("lain", "Aniation", 18.99f);
		store.addMedia(dvd14);
		DigitalVideoDisc dvd15 = new DigitalVideoDisc("lain", "Anmation", 18.99f);
		store.addMedia(dvd15);
		DigitalVideoDisc dvd16 = new DigitalVideoDisc("lain", "Aimation", 18.99f);
		store.addMedia(dvd16);
		instance = new StoreScreen(StoreScreen.getStore());

	}

	@SuppressWarnings("exports")
	public static Store getStore() {
		return store;
	}

	@SuppressWarnings("exports")
	public void setStore(Store store) {
		StoreScreen.store = store;
	}

}
