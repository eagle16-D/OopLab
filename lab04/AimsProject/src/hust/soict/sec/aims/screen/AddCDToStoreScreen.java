package hust.soict.sec.aims.screen;

import java.io.IOException;


import javafx.application.Platform;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

@SuppressWarnings("serial")
public class AddCDToStoreScreen extends AddMediaToStoreScreen {
	private static AddCDToStoreScreen instance;
	
	public AddCDToStoreScreen() {
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
					
			        controller.btnAddCDPressed(null);
			        controller.getBtnAddCD().setSelected(true);
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
    }
	
	public static AddCDToStoreScreen getInstance() {
		if(instance == null) {
			instance = new AddCDToStoreScreen();
		}
		return instance;
	}
}
