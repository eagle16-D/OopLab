package hust.soict.sec.aims.screen;


import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.sec.aims.media.Book;
import hust.soict.sec.aims.media.CompactDisc;
import hust.soict.sec.aims.media.DigitalVideoDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class AddMediaController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox AddBookLayout;

    @FXML
    private VBox AddCDLayout;

    @FXML
    private VBox AddDVDLayout;

    @FXML
    private TextField IDFieldBook;

    @FXML
    private TextField IDFieldCD;

    @FXML
    private TextField IDFieldDVD;

    @FXML
    private TextField artistFieldCD;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnAdd1;

    @FXML
    private Button btnAdd2;

    @FXML
    private ToggleButton btnAddBook;

    @FXML
    private ToggleButton btnAddCD;

    @FXML
    private ToggleButton btnAddDVD;

    @FXML
    private MenuItem btnViewCart;

    @FXML
    private MenuItem btnViewStore;

    @FXML
    private TextField categoryFieldBook;

    @FXML
    private TextField categoryFieldCD;

    @FXML
    private TextField categoryFieldDVD;

    @FXML
    private TextField costFieldBook;

    @FXML
    private TextField costFieldCD;

    @FXML
    private TextField costFieldDVD;

    @FXML
    private TextField directoryFieldDVD;

    @FXML
    private ToggleGroup identical;

    @FXML
    private TextField lengthFieldBook;

    @FXML
    private TextField lengthFieldDVD;

    @FXML
    private TextField titleFieldBook;

    @FXML
    private TextField titleFieldCD;

    @FXML
    private TextField titleFieldDVD;

    @FXML
    void btnAddPressed(ActionEvent event) {
    	if(AddBookLayout.isVisible() == true) {
    		try {
    			int id = Integer.parseInt(IDFieldBook.getText());
    			String title = titleFieldBook.getText();
    			String category = categoryFieldBook.getText();
    			Float cost = Float.parseFloat(costFieldBook.getText());
    			int len = Integer.parseInt(lengthFieldBook.getText());
    			Book book= new Book(id, title, category, cost, len);
    			StoreScreen.getInstance().addMediaToStore(book);
    		}catch (NumberFormatException e) {
				e.printStackTrace();
			}
    		
    		
    	}
    	else if(AddCDLayout.isVisible() == true) {
    		try {
    			
    		int id = Integer.parseInt(IDFieldCD.getText());
    		String title = titleFieldCD.getText();
    		String category = categoryFieldCD.getText();
    		Float cost = Float.parseFloat(costFieldCD.getText());
    		String artist = artistFieldCD.getText();
    		
    		CompactDisc CD = new CompactDisc(id, title, category, cost, artist);
    		StoreScreen.getInstance().addMediaToStore(CD);
    		}catch (NumberFormatException e) {
				e.printStackTrace();
			}
    		
    	}
    	else if(AddDVDLayout.isVisible() == true) {
    		try {
    			
    		int id = Integer.parseInt(IDFieldDVD.getText());
    		String title = titleFieldDVD.getText();
    		String category = categoryFieldDVD.getText();
    		Float cost = Float.parseFloat(costFieldDVD.getText());
    		int len = Integer.parseInt(lengthFieldDVD.getText());
    		String directory = directoryFieldDVD.getText();
    		DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, directory, len);
    		StoreScreen.getInstance().addMediaToStore(dvd);
    		}catch (NumberFormatException e) {
				// TODO: handle exception
    			e.printStackTrace();
			}
    	}
    }

    @FXML
    void btnViewCartPressed(ActionEvent event) {
    	StoreScreen.openCartScreen();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	StoreScreen.getInstance().openStoreScreen();
    }


    @FXML
    void initialize() {
    	AddBookLayout.setVisible(false);
    }
    
    @FXML
    void btnAddBookPressed(ActionEvent event) {
    	AddBookLayout.setVisible(true);
    	AddCDLayout.setVisible(false);
    	AddDVDLayout.setVisible(false);
    }

    @FXML
    void btnAddCDPressed(ActionEvent event) {
    	AddBookLayout.setVisible(false);
    	AddCDLayout.setVisible(true);
    	AddDVDLayout.setVisible(false);
    }

    @FXML
    void btnAddDVDPressed(ActionEvent event) {
    	AddBookLayout.setVisible(false);
    	AddCDLayout.setVisible(false);
    	AddDVDLayout.setVisible(true);
    }

    
    @SuppressWarnings("exports")
	public VBox getAddCDLayout() {
    	return AddCDLayout;
    }
    
	@SuppressWarnings("exports")
	public VBox getAddDVDLayout() {
    	return AddDVDLayout;
    }
	
	@SuppressWarnings("exports")
	public VBox getAddBookLayout() {
    	return AddBookLayout;
    }

	@SuppressWarnings("exports")
	public ToggleButton getBtnAddBook() {
		return this.btnAddBook;
	}

	@SuppressWarnings("exports")
	public ToggleButton getBtnAddCD() {
		return this.btnAddCD;
	}

	@SuppressWarnings("exports")
	public ToggleButton getBtnAddDVD() {
		return this.btnAddDVD;
	}
	
	private static AddMediaController instance;
	public static AddMediaController getInstance() {
		if(instance == null) {
			instance = new AddMediaController();
		}
		return instance;
	}
}
