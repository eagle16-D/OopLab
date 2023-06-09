package hust.soict.sec.aims.screen;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

@SuppressWarnings("serial")
public class AddDVDToStoreScreen extends AddMediaToStoreScreen {
	private static AddDVDToStoreScreen instance;
	
	public AddDVDToStoreScreen() {
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
					
			        controller.btnAddDVDPressed(null);
			        controller.getBtnAddDVD().setSelected(true);
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
    }
	
	public static AddDVDToStoreScreen getInstance() {
		if(instance == null) {
			instance = new AddDVDToStoreScreen();
		}
		return instance;
	}
}
