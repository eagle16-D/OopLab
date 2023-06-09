package hust.soict.sec.aims.screen;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

@SuppressWarnings("serial")
public class AddBookToStoreScreen extends AddMediaToStoreScreen {
	private static AddBookToStoreScreen instance;
	
	public AddBookToStoreScreen() {
		super();
		
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/sec/aims/screen/updateStore.fxml"));
					controller = new AddMediaController();
					loader.setController(controller);
					Parent rootParent = loader.load();
					fJfxPanel.setScene(new Scene(rootParent));
					
			        controller.btnAddBookPressed(null);
			        controller.getBtnAddBook().setSelected(true);
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
    }
	
	public static AddBookToStoreScreen getInstance() {
		if(instance == null) {
			instance = new AddBookToStoreScreen();
		}
		return instance;
	}
}
