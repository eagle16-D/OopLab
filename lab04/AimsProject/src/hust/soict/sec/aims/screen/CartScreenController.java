package hust.soict.sec.aims.screen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import hust.soict.sec.aims.store.*;
import hust.soict.sec.aims.cart.Cart;
import hust.soict.sec.aims.exception.PlayerException;
import hust.soict.sec.aims.media.Media;
import hust.soict.sec.aims.media.Playable;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	
	private Cart cart;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup FilterCategory;
    
    @FXML
    private MenuItem btnViewCart;
    
    @FXML
    private MenuItem btnAddCd;

    @FXML
    private MenuItem btnViewStore;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label totalCost;

    @SuppressWarnings("exports")
	public CartScreenController(Cart cart) {
    	super();
    	this.setCart(cart);
    }
    
	@FXML
    private void initialize() {
    	
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(Cart.getItemsOrdered());
    	totalCost.setText(" " + BigDecimal.valueOf(Cart.totalCost()).setScale(2, RoundingMode.HALF_UP) + " $");
    	
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	//change value of totalCost whenever a media to be added to Cart
    	Cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
    		Platform.runLater(() -> {
    		    totalCost.setText(" " + BigDecimal.valueOf(Cart.totalCost()).setScale(2, RoundingMode.HALF_UP) + " $");
    		});
    	});

    	//whenever a media is chosen, some button will appear
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

			@Override
			public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {

				// TODO Auto-generated method stub
				if(newValue != null) {
					updateButtonBar(newValue);
				}
			}
    		
    	});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			showFilteredMedia(newValue);
    		}
    	});
    }
	
	private void showFilteredMedia(String filterText) {
	    // Retrieve the currently selected radio button
	    RadioButton selectedRadioButton;
	    if (radioBtnFilterId.isSelected()) {
	        selectedRadioButton = radioBtnFilterId;
	    } else {
	        selectedRadioButton = radioBtnFilterTitle;
	    }

	    // Determine the filtering criteria based on the selected radio button
	    Predicate<Media> filterPredicate;
	    if (selectedRadioButton == radioBtnFilterId) {
	        filterPredicate = media -> String.valueOf(media.getId()).contains(filterText);
	    } else {
	        filterPredicate = media -> media.getTitle().toLowerCase().contains(filterText.toLowerCase());
	    }

	    // Wrap the existing ObservableList in a FilteredList and apply the filter predicate
	    FilteredList<Media> filteredList = new FilteredList<>(tblMedia.getItems());
	    // Add a listener to the filter text property to dynamically update the filtered results
	    tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
	        filteredList.setPredicate(filterPredicate);
	    });

	    // Update the TableView to display the filtered results
	    tblMedia.setItems(filteredList);
	}


	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	

    @FXML
    void btnAddCdPressed(ActionEvent event) {

		StoreScreen.getInstance().openAddCDScreen();
    }
	
	@FXML
	void btnViewStorePressed(ActionEvent event) {
		StoreScreen.getInstance().openStoreScreen();
	}
	
	@FXML
	void btnViewCartPressed(ActionEvent event) {
	    CartScreen cartScreen = CartScreen.getInstance(); // Get the instance of CartScreen
	    cartScreen.setVisible(true); // Set the visibility of the CartScreen to true
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		totalCost.setText(" " + BigDecimal.valueOf(Cart.totalCost()).setScale(2, RoundingMode.HALF_UP) + " $");
	}
	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		
		Dialog<String> dialog = new Dialog<String>();
		dialog.setTitle("Playing " + media.getTitle());
		dialog.setResizable(true);
			
		Label label = new Label(media.toString());
		dialog.getDialogPane().setContent(label);
			
			 // Add a close button to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

            // Show the dialog
        dialog.show();
         
		try {
			Aims.play(media);
		} catch (PlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@SuppressWarnings("exports")
	public Cart getCart() {
		return cart;
	}

	@SuppressWarnings("exports")
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
